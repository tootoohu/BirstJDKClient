package com.infor.ui;

import com.birst.HierarchyMetadata;
import com.birst.LevelMetadata;
import com.infor.admin.BirstDataLoadManagement;
import com.infor.util.BirstXmlReader;
import com.infor.util.DataSourceContainer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BirstHierarchiesTabGenerator {

    private BirstXmlReader reader = new BirstXmlReader();

    private String currentNode;

    TreeItem rootTreeItem = new TreeItem<>("All");

    public BirstHierarchiesTabGenerator() throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
    }

    public Tab loadTab(){
        Tab hierarchiesTab = new Tab();
        hierarchiesTab.setText("Hierarchies");
        //
        StackPane treePane = new StackPane();

        rootTreeItem.setExpanded(true);
        DataSourceContainer container = BirstDataLoadManagement.loadFromFile("src/resources/Infor-CSI-Suite-10_0_0_0-Parent-Dev-Master/");

        TreeItem levelTreeItem = new TreeItem<>();
       // loadTreeItems(rootTreeItem, container.getBirstXmlHierarchyMap());
     //   TreeView treeView = new TreeView(rootTreeItem);
        treePane.getChildren().add(loadTree(rootTreeItem,container.getBirstXmlHierarchyMap(),levelTreeItem));

//        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
//            TreeItem treeItem = (TreeItem) newValue;
//            refreshLevelTree(treeItem,container.getBirstXmlHierarchyMap(),levelTreeItem);
//        });

        TreeView leveltreeView = new TreeView(levelTreeItem);

        //right panel
        SplitPane rightPane = new SplitPane();
        rightPane.setDividerPositions(0.05f,0.95f);
        rightPane.setOrientation(Orientation.VERTICAL);

        FlowPane buttonMenuPane = new FlowPane();
        buttonMenuPane.setVgap(4);
        buttonMenuPane.setHgap(6);
        buttonMenuPane.setAlignment(Pos.BASELINE_LEFT);

        Button updatebtn = new Button("Update");
        updatebtn.setPrefSize(110,30);
        updatebtn.setLayoutX(10);
        buttonMenuPane.getChildren().addAll(updatebtn);

        rightPane.getItems().addAll(buttonMenuPane,leveltreeView);

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(treePane,rightPane);
        sp.setDividerPositions(0.2f, 0.8f);
        hierarchiesTab.setContent(sp);

        return hierarchiesTab;
    }


    private TreeView loadTree(TreeItem treeItem, Map<String, HierarchyMetadata> hmap, TreeItem levelTreeItem){
        TreeView treeView = new TreeView(treeItem);
        loadTreeItems(treeItem, hmap);
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem item = (TreeItem) newValue;
            refreshLevelTree(item, hmap,levelTreeItem);
        });

        treeView.setEditable(true);
        treeView.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
            }
        });

        final ContextMenu contextMenu = new ContextMenu();
        MenuItem addMenu = new MenuItem("Add");
        addMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("add item");
                TreeItem item = new TreeItem("New Item");
                treeItem.getChildren().add(item);
            }
        });

        MenuItem deleteMenu = new MenuItem("Delete");
        deleteMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TreeItem c = (TreeItem)treeView.getSelectionModel().getSelectedItem();
                boolean remove = c.getParent().getChildren().remove(c);
                System.out.println("Remove");

            }
        });

        contextMenu.getItems().addAll(addMenu, deleteMenu);
        treeView.setContextMenu(contextMenu);
        return treeView;
    }

    private void loadTreeItems(TreeItem treeItem, Map<String, HierarchyMetadata> hmap){
        for(String key: hmap.keySet()){
            TreeItem item = new TreeItem(key);
            treeItem.getChildren().add(item);
        }
    }

    private void refreshLevelTree(TreeItem treeItem,Map<String, HierarchyMetadata> hmap,TreeItem levelTreeItem){
        ObservableList<TreeItem> children = levelTreeItem.getChildren();
        if(children != null){
            children.remove(0,children.size());
        }

        if(treeItem.getValue() instanceof String){
            String se = (String) treeItem.getValue();
            currentNode = se;
           HierarchyMetadata hm = hmap.get(se);
           levelTreeItem.setValue(hm.getName());
           List<LevelMetadata> columns = hm.getChildren().getLevelMetadata();
           for(LevelMetadata lm : columns){
                List<String> colStrs = lm.getColumnNames().getString();
                for(String colStr : colStrs){
                    TreeItem item = new TreeItem(colStr);
                    levelTreeItem.getChildren().add(item);
                }
            }
        }
    }

}
