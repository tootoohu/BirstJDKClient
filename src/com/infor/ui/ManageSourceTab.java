package com.infor.ui;

import com.birst.StagingTableSubClass;
import com.birst.UserSpace;
import com.infor.admin.BirstDataLoadManager;
import com.infor.admin.DataSourceManagement;
import com.infor.admin.ExportManager;
import com.infor.admin.SpaceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.DataSourceContainer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.apache.log4j.Logger;

import java.util.Map;

public class ManageSourceTab {
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn dataTypeColumn;
    @FXML
    private TableColumn widthColumn;
    @FXML
    private TableColumn lockTypeColumn;
    @FXML
    private TableColumn hierarchyNameColumn;
    @FXML
    private TableColumn levelNameColumn;
    @FXML
    private TableColumn measureColumn;
    @FXML
    private TableColumn analyzeMeasureColumn;
    @FXML
    private TableColumn analyzeByDateColumn;
    @FXML
    private TableColumn formatColumn;
    @FXML
    private TableColumn unknownValueColumn;
    @FXML
    private TableColumn enableSecFilterColumn;


    private DataSourceContainer dataSourceContainer;
    //  private TableView<SourceColumnEntry> table = new TableView<>();
    private BirstProperties birstProperties;

    private static final Logger logger = Logger.getLogger(MainForm.class);
    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();


    @FXML
    private TreeView sourceTreeview;

    @FXML
    private TableView sourceColumnTableView;

    @FXML
    private void initialize(){
        load();
    }

    private void load(){
        TreeItem rootTreeItem = new TreeItem<>("All");
        DataSourceContainer container = BirstDataLoadManager.loadFromFile("src/resources/Infor-CSI-Suite-10_0_0_0-Parent-Dev-Master/");
        loadTree(rootTreeItem,container.getBirstXmlSourceMap());
    }

    private void loadTree(TreeItem treeItem, Map<String, StagingTableSubClass> map){
        loadTreeItems(treeItem,map);
        treeItem.setExpanded(true);
        sourceTreeview.setRoot(treeItem);

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
                TreeItem c = (TreeItem)sourceTreeview.getSelectionModel().getSelectedItem();
                boolean remove = c.getParent().getChildren().remove(c);
                System.out.println("Remove");

            }
        });

        contextMenu.getItems().addAll(addMenu, deleteMenu);
        sourceTreeview.setContextMenu(contextMenu);

        sourceTreeview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem item = (TreeItem) newValue;
            // refreshTableData(map,item, columnTableView);
            //   refreshScript(treeItem,container.getBirstXmlSourceMap(),input, script);
        });

        // treeView.setEditable(true);
        sourceTreeview.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
            }
        });


    }
    private void loadTreeItems(TreeItem treeItem, Map<String, StagingTableSubClass> sourcemap){
        for(String key: sourcemap.keySet()){
            TreeItem item = new TreeItem(key);
            treeItem.getChildren().add(item);
        }
    }


}
