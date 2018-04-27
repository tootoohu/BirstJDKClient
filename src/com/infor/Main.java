package com.infor;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.infor.admin.ExportManagement;
import com.infor.admin.DataSourceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import com.infor.util.DataSourceContainer;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.Map;

public class Main extends Application {


    private DataSourceContainer dataSourceContainer;
    private TableView<SourceColumnEntry> table = new TableView<>();
    private SourceEntry currentSourceEntry;
    private BirstProperties birstProperties;

    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();
    private ExportManagement exportManagement;
    @Override
    public void start(Stage primaryStage) throws Exception{
        initialize();
        TabPane mainPane = new TabPane();
        mainPane.setPrefSize(1000, 1000);

        mainPane.getTabs().add(loadAdminTab());

        primaryStage.setTitle("Birst Desktop Client");
        primaryStage.setScene(new Scene(mainPane, 1000, 600));
        primaryStage.show();

    }

    private void initialize(){
        birstProperties = new BirstProperties("/resources/birst.properties");
        dataSourceContainer = new DataSourceContainer();
        dataSourceContainer.loadXmlDocument();
         exportManagement = new ExportManagement(dataSourceManagement);
        }

    private Tab loadAdminTab(){

        Tab adminTab = new Tab();
        adminTab.setText("Admin");

        StackPane treePane = new StackPane();
        TreeItem rootTreeItem = new TreeItem<>("SL");

        rootTreeItem.setExpanded(true);
        TreeItem cubeRoot = new TreeItem("Cubes");
        TreeView treeView = new TreeView<>(rootTreeItem);
        rootTreeItem.getChildren().add(cubeRoot);
        loadTreeItems(cubeRoot, dataSourceContainer.getCubeMap());
        TreeItem dimensionRoot = new TreeItem("Dimensions");
        rootTreeItem.getChildren().add(dimensionRoot);
        loadTreeItems(dimensionRoot, dataSourceContainer.getDimensionMap());

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem treeItem = (TreeItem) newValue;
            refreshTableData(treeItem);

        });

        treePane.getChildren().add(treeView);

        SplitPane rightPane = new SplitPane();
        loadTableView();
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
                   dataSourceManagement.setSourceDetails(birstProperties.getLoginToken(),birstProperties.getTargetSpaceId(),currentSourceEntry,dataSourceContainer.getByKey(currentSourceEntry));
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
        exportBtn.setOnAction(event -> exportManagement.Export(birstProperties.getLoginToken(),
                birstProperties.getSourceSpaceId(),birstProperties.getSourceSpaceName()));

        Button importBtn = new Button("Import");
        exportBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
             //   backupManagement.Bakup(birstProperties.getLoginToken(),birstProperties.getSourceSpaceId(),birstProperties.getSourceSpaceName());
            }
        });

        exportBtn.setPrefSize(110,30);
        exportBtn.setLayoutX(100);
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


    private void loadTableView(){
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

    private void refreshTableData(TreeItem treeItem){

        if(treeItem.getValue() instanceof SourceEntry){
            SourceEntry se = (SourceEntry) treeItem.getValue();
            currentSourceEntry = se;
            table.setItems(FXCollections.observableArrayList(dataSourceContainer.getByKey(se)));
        }
    }

    private void loadTreeItems(TreeItem treeItem, Map<SourceEntry, List<SourceColumnEntry>> map){

        for(Map.Entry<SourceEntry, List<SourceColumnEntry>> entry: map.entrySet()){
            TreeItem item = new TreeItem(entry.getKey());
            treeItem.getChildren().add(item);
        }
    }


    public static void main(String[] args) {

        launch(args);
    }


}
