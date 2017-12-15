package com.infor;

import com.infor.model.webservice.SourceColumnEntry;
import com.infor.util.XMLParser;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeSelectionModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.swing.tree.TreeSelectionModel.SINGLE_TREE_SELECTION;

public class Main extends Application {


    private Map<String, List<SourceColumnEntry>> cubeMap;
    private Map<String, List<SourceColumnEntry>> dimensionMap;


    @Override
    public void start(Stage primaryStage) throws Exception{
        loadXmlDocument();
        TabPane mainPane = new TabPane();
        mainPane.setPrefSize(1000, 1000);

        mainPane.getTabs().add(loadAdminTab());



        primaryStage.setTitle("Birst Desktop Client");
        primaryStage.setScene(new Scene(mainPane, 600, 475));
        primaryStage.show();

    }

    private Tab loadAdminTab(){

        Tab adminTab = new Tab();
        adminTab.setText("Admin");

        StackPane treePane = new StackPane();
        TreeItem treeItem = new TreeItem<>("SL");

        treeItem.setExpanded(true);
        TreeView treeView = new TreeView<>(treeItem);
        loadTreeItems(treeItem, cubeMap);
        loadTreeItems(treeItem,dimensionMap);

        treePane.getChildren().add(treeView);


        StackPane rightPane = new StackPane();
        Button button = new Button();
        button.setLayoutX(15.0);
        button.setLayoutY(6.0);

        Label label = new Label("Name");
        label.setLayoutX(15);
        label.setLayoutY(10);
        TextField textField = new TextField("Type Something");
        textField.setLayoutX(15.0);
        textField.setLayoutY(15.0);
        button.setText("Click");
        rightPane.getChildren().add(button);
        rightPane.getChildren().add(textField);
        rightPane.getChildren().add(label);
        SplitPane sp = new SplitPane();



        sp.getItems().addAll(treePane,rightPane);
        sp.setDividerPositions(0.3f, 0.7f);
        adminTab.setContent(sp);
        return  adminTab;
    }

    private void loadXmlDocument(){
        XMLParser parser = null;
        if(cubeMap != null)
            return;
        cubeMap = new HashMap();
        dimensionMap = new HashMap();

        try {
            parser = new XMLParser();
            cubeMap =  parser.getSourceList("/resources/xml/Cubes.xml");
            dimensionMap =  parser.getSourceList("/resources/xml/Dimensions.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

    }


    private void loadTreeItems(TreeItem treeItem, Map<String, List<SourceColumnEntry>> map){


        for(Map.Entry<String, List<SourceColumnEntry>> entry: map.entrySet()){

            TreeItem item = new TreeItem(entry.getKey());
            treeItem.getChildren().add(item);
            for(SourceColumnEntry sce : entry.getValue()){
                TreeItem subItem = new TreeItem( sce.getName());
                //subItem.addEventHandler();
                item.getChildren().add(subItem);
            }
        }

    }


    public static void main(String[] args) {


        launch(args);
    }



}
