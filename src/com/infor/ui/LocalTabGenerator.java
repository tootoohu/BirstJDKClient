package com.infor.ui;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.infor.admin.DataSourceManagement;
import com.infor.admin.ExportManager;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import com.infor.util.BirstXmlReader;
import com.infor.util.DataSourceContainer;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class LocalTabGenerator {

    private static BirstProperties birstProperties = BirstProperties.getInstance();

    private   DataSourceManagement dataSourceManagement =  new DataSourceManagement();

    private ExportManager exportManagement = new ExportManager(dataSourceManagement);;

    static SourceEntry currentSourceEntry;

   // private static SourceEntry currentSourceEntry;

    private static void loadTreeItems(TreeItem treeItem, Map<SourceEntry, List<SourceColumnEntry>> map){
        for(Map.Entry<SourceEntry, List<SourceColumnEntry>> entry: map.entrySet()){
            TreeItem item = new TreeItem(entry.getKey());
            treeItem.getChildren().add(item);
        }
    }

    public  Tab loadTab(DataSourceContainer dataSourceContainer){
        TableView<SourceColumnEntry> table = new TableView<>();
        Tab adminTab = new Tab();
        adminTab.setText("Admin");

        StackPane treePane = new StackPane();
        TreeItem rootTreeItem = new TreeItem<>("SL");

        rootTreeItem.setExpanded(true);
        TreeItem cubeRoot = new TreeItem("Cubes");
        TreeView treeView = new TreeView<>(rootTreeItem);
        rootTreeItem.getChildren().add(cubeRoot);
        loadTreeItems(cubeRoot, dataSourceContainer.getLocalCubeMap());
        TreeItem dimensionRoot = new TreeItem("Dimensions");
        rootTreeItem.getChildren().add(dimensionRoot);
        loadTreeItems(dimensionRoot, dataSourceContainer.getLocalDimensionMap());

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem treeItem = (TreeItem) newValue;
            refreshTableData(dataSourceContainer,treeItem, table);
        });

        treePane.getChildren().add(treeView);

        SplitPane rightPane = new SplitPane();
        loadTableView(table);
        Button updatebtn = new Button("Update");
        updatebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HierarchyMetadata hm = dataSourceManagement.getHierarchy(birstProperties.getLoginToken(),birstProperties.getTargetSpaceId(),currentSourceEntry.getName());

                if(hm != null && hm.getChildren().getLevelMetadata() != null){
                    dataSourceManagement.updateHierarchy(birstProperties.getLoginToken(),birstProperties.getTargetSpaceId(),currentSourceEntry,dataSourceContainer.getByKey(currentSourceEntry));
                }else {
                    dataSourceManagement.createHierarchy(birstProperties.getLoginToken(),birstProperties.getTargetSpaceId(),currentSourceEntry,dataSourceContainer.getByKey(currentSourceEntry));
                }

                StagingTableSubClass tableSubClass = dataSourceManagement.getSourceDetails(birstProperties.getLoginToken(),birstProperties.getTargetSpaceId(),currentSourceEntry.getName());
                if (tableSubClass != null){
                    dataSourceManagement.setSourceDetails(birstProperties.getLoginToken(),birstProperties.getTargetSpaceId(),currentSourceEntry.getName(),dataSourceContainer.getByKey(currentSourceEntry));
                }
            }
        });

        updatebtn.setPrefSize(110,30);
        updatebtn.setLayoutX(10);
        FlowPane buttonMenuPane = new FlowPane ();
        buttonMenuPane.setVgap(4);
        buttonMenuPane.setHgap(6);
        buttonMenuPane.setAlignment(Pos.BASELINE_LEFT);

        Button exportBtn = new Button("Export");
        exportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                exportManagement.Export(birstProperties.getLoginToken(),birstProperties.getSourceSpaceId(),birstProperties.getSourceSpaceName());
            }
        });

        Button importBtn = new Button("Import");
        importBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    BirstXmlReader bxr = new BirstXmlReader();
                    String path = new File("src/resources/Infor-CSI-Suite-10_0_0_0-Parent-Dev-Master/Sources.xml").getAbsolutePath();
                    bxr.readSources(path);
                } catch (ParserConfigurationException e) {
                    e.printStackTrace();
                } catch (SAXException e) {
                    e.printStackTrace();
                } catch (TransformerConfigurationException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //   backupManagement.Bakup(birstProperties.getLoginToken(),birstProperties.getSourceSpaceId(),birstProperties.getSourceSpaceName());
            }
        });

        importBtn.setPrefSize(110,30);
        importBtn.setLayoutX(100);
        buttonMenuPane.getChildren().addAll(updatebtn,exportBtn,importBtn);

        StackPane tablePane = new StackPane();
        tablePane.getChildren().add(table);
        rightPane.setDividerPositions(0.05f,0.95f);
        rightPane.setOrientation(Orientation.VERTICAL);

        rightPane.getItems().addAll(buttonMenuPane,tablePane);

        SplitPane sp = new SplitPane();

        sp.getItems().addAll(treePane,rightPane);
        sp.setDividerPositions(0.3f, 0.7f);
        adminTab.setContent(sp);
        return  adminTab;
    }

    private  void refreshTableData(DataSourceContainer dataSourceContainer,TreeItem treeItem,TableView<SourceColumnEntry> table){
        if(treeItem.getValue() instanceof SourceEntry){
            SourceEntry se = (SourceEntry) treeItem.getValue();
            currentSourceEntry = se;
            table.setItems(FXCollections.observableArrayList(dataSourceContainer.getByKey(se)));
        }
    }

    private  void loadTableView(TableView<SourceColumnEntry> table){
        TableColumn nameCol = new TableColumn("Name");
        nameCol.setMinWidth(100);
        nameCol.setCellValueFactory(
                new PropertyValueFactory<SourceColumnEntry, String>("Name"));

        TableColumn typeCol = new TableColumn("Type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(
                new PropertyValueFactory<SourceColumnEntry, String>("Type"));

        TableColumn widthCol = new TableColumn("Width");
        widthCol.setMinWidth(100);
        widthCol.setCellValueFactory(
                new PropertyValueFactory<SourceColumnEntry, Integer>("Width"));

        table.getColumns().addAll(nameCol, typeCol, widthCol);
    }
}
