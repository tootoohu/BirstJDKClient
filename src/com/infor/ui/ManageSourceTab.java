package com.infor.ui;

import com.birst.ArrayOfSourceColumnSubClass;
import com.birst.HierarchyMetadata;
import com.birst.SourceColumnSubClass;
import com.birst.StagingTableSubClass;
import com.infor.admin.BirstDataLoadManager;
import com.infor.admin.DataSourceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.DataSourceContainer;
import com.infor.util.XmlInterface;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.apache.log4j.Logger;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
public class ManageSourceTab implements XmlInterface {
    private static final Logger logger = Logger.getLogger(ManageSourceTab.class);
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
    @FXML
    private Label sourceLabel;
    @FXML
    private Button uploadButton;

    private DataSourceContainer dataSourceContainer;

    private BirstProperties birstProperties = BirstProperties.getInstance();

    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();
    private String currentNode;
    private TreeItem rootTreeItem = new TreeItem<>("All");

    @FXML
    private TreeView<String> sourceTreeview;

    @FXML
    private TableView<SourceColumnSubClass> sourceColumnTableView;

    @FXML
    private void initialize() {
        loadFromFileByCurrentSpace();
        loadTableView();
    }

    private void loadTableView(){
        logger.info("loadTableview");
        ObservableList<TableColumn<SourceColumnSubClass, ?>> list = sourceColumnTableView.getColumns();
        for(TableColumn col : list){
            col.setCellValueFactory(new PropertyValueFactory<>(col.getText()));
            col.setCellFactory(new Callback<TableColumn, TableCell>() {
                @Override
                public TableCell call(TableColumn param) {
                    return new EditingCell();

                }
            });


            col.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent>() {
                @Override
                public void handle(TableColumn.CellEditEvent event) {
                    SourceColumnSubClass object = (SourceColumnSubClass) event.getTableView().getItems().get(event.getTablePosition().getRow());
                    Method m = null;
                    try {

                        switch (col.getText()){
                            case WIDTH_NODE:
                                m = SourceColumnSubClass.class.getDeclaredMethod("set" + col.getText(), int.class);
                                m.invoke(object, Integer.valueOf(event.getNewValue().toString()));
                                break;
                            case ANALYZE_MEASURE_NODE:
                                m = SourceColumnSubClass.class.getDeclaredMethod("set" +col.getText(), Boolean.class);
                                m.invoke(object, Boolean.valueOf(event.getNewValue().toString()));
                                break;
                            case ANALYZE_BY_DATE_NODE: case ENABLE_SECURITY_FILTER_NODE:
                                m = SourceColumnSubClass.class.getDeclaredMethod("set" +col.getText(), Boolean.class);
                                m.invoke(object, Boolean.valueOf(event.getNewValue().toString()));
                                break;
                            default:
                                m = SourceColumnSubClass.class.getDeclaredMethod("set" + col.getText(), String.class);
                                m.invoke(object, event.getNewValue());
                        }

                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            });
        }

    }


    private void loadTree(TreeItem treeItem, Map<String, StagingTableSubClass> map){
        logger.info("loadTree");
        sourceTreeview.setRoot(treeItem);
        if(treeItem.getChildren() != null && treeItem.getChildren().size() >0){
            treeItem.getChildren().remove(0, treeItem.getChildren().size());
        }

        treeItem.setExpanded(true);

        loadTreeItems(treeItem,map);


        final ContextMenu contextMenu = new ContextMenu();
        MenuItem addMenu = new MenuItem("Add");
        addMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                logger.info("Add New Item");
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
                logger.info("Remove " + c.getValue());

            }
        });

        MenuItem updateMenu = new MenuItem("Upload");
        updateMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StagingTableSubClass sts = map.get(currentNode);
                if(sts == null){
                    return;
                }
                ObservableList<SourceColumnSubClass> list = sourceColumnTableView.getItems();
                ArrayOfSourceColumnSubClass asc = null;
                if(list != null && list.size() >0){
                     asc = new ArrayOfSourceColumnSubClass();
                    for(SourceColumnSubClass s: list) {
                        asc.getSourceColumnSubClass().add(s);
                    }

                }
                sts.setColumns(asc);
                logger.info("setSourceDetails to " + birstProperties.getCurrentSpace().getId());
                dataSourceManagement.setSourceDetails(birstProperties.getLoginToken(),birstProperties.getCurrentSpace().getId(),
                        sts);

            }
        });

        MenuItem importMenu = new MenuItem("Import");
        importMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadFromFileByCurrentSpace();
            }
        });

        MenuItem loadMenu = new MenuItem("Load");
        loadMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                synchronizeFromCurrentSpace();
            }
        });

      //  contextMenu.getItems().addAll(addMenu, deleteMenu, loadMenu, updateMenu, syncMenu);
        contextMenu.getItems().addAll( deleteMenu, importMenu, loadMenu);
        sourceTreeview.setContextMenu(contextMenu);

        sourceTreeview.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem item = (TreeItem) newValue;
            refreshTableData(map,item, sourceColumnTableView);
            if(!item.getValue().equals("All")){
                sourceLabel.setText((String)item.getValue());
            }

            //   refreshScript(treeItem,container.getBirstXmlSourceMap(),input, script);
        });

        sourceTreeview.setEditable(true);
        sourceTreeview.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
            }
        });


    }

    private void loadFromFileByCurrentSpace(){
        logger.info("load Tree item From File By Current Space");
        String path = "src/resources/" + birstProperties.getCurrentSpace().getName() + "/";
        File f = new File(path);
        if(!f.exists())
            f.mkdir();
        if(rootTreeItem!=null && rootTreeItem.getChildren().size() > 0){
            rootTreeItem.getChildren().remove(0,rootTreeItem.getChildren().size());
        }

        dataSourceContainer = BirstDataLoadManager.loadFromFile(path);
        Map sourceMap = dataSourceContainer.getBirstXmlSourceMap();
        loadTree(rootTreeItem,sourceMap);

    }

    private void synchronizeFromCurrentSpace(){
        DataSourceContainer container = dataSourceManagement.readFromSpace(birstProperties.getLoginToken(),birstProperties.getCurrentSpace().getId());
        List<HierarchyMetadata> hierarchyMetadata = container.getHierarchies();
        List<StagingTableSubClass> stagingTableSubClasses = container.getSources();
        Map<String,HierarchyMetadata> hierarchyMetadataMap = new HashMap<>();
        Map<String, StagingTableSubClass> stringStagingTableSubClassMap = new HashMap<>();
        for(HierarchyMetadata hm: hierarchyMetadata){
            hierarchyMetadataMap.put(hm.getName(),hm);
        }

        for(StagingTableSubClass sts: stagingTableSubClasses){
            stringStagingTableSubClassMap.put(sts.getName(),sts);
        }
        this.dataSourceContainer.setBirstXmlSourceMap(stringStagingTableSubClassMap);
        loadTree(rootTreeItem,stringStagingTableSubClassMap);
        DialogHelper.showResultDialog("Synchronize from " + birstProperties.getCurrentSpace().getName(), true);
    }

    private  void refreshTableData( Map<String, StagingTableSubClass> subClassMap,TreeItem treeItem,
                                    TableView<SourceColumnSubClass> table){
        if(subClassMap == null || table == null) {
            return;

        }
        logger.info("refresh Table Data");
        if(treeItem.getValue() instanceof String){
            String se = (String) treeItem.getValue();
            currentNode = se;
            StagingTableSubClass dataMap = subClassMap.get(se);
            if(dataMap != null){
                table.setItems(FXCollections.observableArrayList(dataMap.getColumns().getSourceColumnSubClass()));
            }else {
                table.setItems(FXCollections.observableArrayList());
            }
        }
    }

    private void loadTreeItems(TreeItem treeItem, Map<String, StagingTableSubClass> sourcemap){
        if(sourcemap == null)
            return;
        for(String key: sourcemap.keySet()){
            TreeItem item = new TreeItem(key);
            treeItem.getChildren().add(item);
        }
    }

    @FXML
    private void onUploadButtonAction(){

        StagingTableSubClass sts = dataSourceContainer.getBirstXmlSourceMap().get(currentNode);
        if(sts == null){
            return;
        }
        ObservableList<SourceColumnSubClass> list = sourceColumnTableView.getItems();
        ArrayOfSourceColumnSubClass asc = null;
        if(list != null && list.size() >0){
            asc = new ArrayOfSourceColumnSubClass();
            for(SourceColumnSubClass s: list) {
                logger.info("Unknown Value ->");
                if(s.getUnknownValue() == null || s.getUnknownValue().equals("")){
                    s.setUnknownValue("Unknown Value");
                }
                asc.getSourceColumnSubClass().add(s);
            }

        }

        sts.setColumns(asc);
        logger.info("setSourceDetails to " + birstProperties.getCurrentSpace().getId());
        dataSourceManagement.setSourceDetails(birstProperties.getLoginToken(),birstProperties.getCurrentSpace().getId(),
                sts);
        DialogHelper.showResultDialog("Upload for " + sts.getName(), true);
    }

}
