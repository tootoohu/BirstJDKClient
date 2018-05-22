package com.infor.ui;

import com.birst.*;
import com.infor.admin.BirstDataLoadManager;
import com.infor.admin.DataSourceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.DataSourceContainer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HierarchiesTab {

    private String currentNode;
    private static BirstProperties birstProperties = BirstProperties.getInstance();
    private TreeItem rootTreeItem = new TreeItem<>("All");
    private TreeItem levelTreeItem = new TreeItem("All");
    private Map<String, HierarchyMetadata> currentHierarchyMap;
    private Map<String, StagingTableSubClass> currentSourceMap;
    @FXML
    private TreeView treeView;

    @FXML
    private TableView<LevelColumn> levelTableView;
    @FXML
    private TableColumn<LevelColumn,CheckBox> selectColumn;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private ComboBox<String> sourceCombox;
    @FXML
    private Button saveBtn;

    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();

    @FXML
    private void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        selectColumn.setEditable(true);
      //  selectColumn.setCellValueFactory(new PropertyValueFactory<LevelColumn,Boolean>("Select"));

        selectColumn.setCellValueFactory(cellData ->cellData.getValue().select.getCheckBox());

        loadTree();
        loadSourceListFromFile();
    }




    private Map<String,HierarchyMetadata> getCurrentHierarchyMap(){
        return currentHierarchyMap;
    }

    private TreeView loadTree(){

       // loadTreeItems(rootTreeItem, hmap);
        loadTreeItemFromFile();
        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem item = (TreeItem) newValue;
            currentNode = (String) item.getValue();
          //  refreshLevelTree(item, getCurrentHierarchyMap(),levelTreeItem);
            refreshLevelTableView(item);
        });

        rootTreeItem.setExpanded(true);
        levelTreeItem.setExpanded(true);
        treeView.setRoot(rootTreeItem);
//        levelTreeView.setRoot(levelTreeItem);

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
                rootTreeItem.getChildren().add(item);
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

        MenuItem loadMenu = new MenuItem("Load");
        loadMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadTreeItemFromFile();
                loadSourceListFromFile();
            }
        });

        MenuItem syncMenu = new MenuItem("Synchronize");
        syncMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                StagingTableSubClass sts = container.getBirstXmlSourceMap().get(currentNode);
//                ObservableList<TableColumn<SourceColumnSubClass,?>> columnObservableList =  columnTableView.getColumns();
//                for(TableColumn<SourceColumnSubClass,?> tableColumn: columnObservableList){
//                    System.out.println(tableColumn.isVisible());
//                    //tableColumn
//                }
            }
        });

        contextMenu.getItems().addAll(addMenu, deleteMenu, loadMenu,syncMenu);
        treeView.setContextMenu(contextMenu);
        return treeView;
    }

    private void loadTreeItemFromFile(){
        String path = "src/resources/" + birstProperties.getCurrentSpace().getName() + "/";
        DataSourceContainer container = BirstDataLoadManager.loadFromFile(path);
        currentHierarchyMap = container.getBirstXmlHierarchyMap();
        rootTreeItem.getChildren().remove(0,rootTreeItem.getChildren().size());
        loadTreeItems(rootTreeItem, currentHierarchyMap);

    }

    @FXML
    private void onSaveButtonAction(){
        System.out.println(selectColumn.getText());
        if(currentNode == null || currentNode.equals("All")){
            return;
        }

        ObservableList<LevelColumn> list = this.levelTableView.getItems();

        HierarchyMetadata hm = getCurrentHierarchyMap().get(currentNode);
        if(hm == null)
            return;

        ArrayOfString keyColumns = new ArrayOfString();
        list.forEach(k -> {
            if(k.select.isSelected())
                keyColumns.getString().add(k.getName()) ;
        });

        ArrayOfLevelMetadata arrayOfLevelMetadata = hm.getChildren();
        List<LevelMetadata> levelMetadataList = arrayOfLevelMetadata.getLevelMetadata();
        if(levelMetadataList != null && levelMetadataList.get(0) != null){
            LevelMetadata levelMetadata = levelMetadataList.get(0);
            levelMetadata.setColumnNames(keyColumns);
        }

        dataSourceManagement.updateHierarchy( birstProperties.getLoginToken(),birstProperties.getCurrentSpace().getId(),currentNode, hm);
    }


    private void refreshLevelTableView(TreeItem treeItem){
        if(currentHierarchyMap == null)
            return;
        if(treeItem.getValue() instanceof String){
            String se = (String) treeItem.getValue();

            HierarchyMetadata hm = currentHierarchyMap.get(se);
            StagingTableSubClass sts = currentSourceMap.get(se);
            if(hm != null && sts != null){

                List<LevelMetadata> columns = hm.getChildren().getLevelMetadata();
                for(LevelMetadata lm : columns){
                    List<String> colStrs = lm.getColumnNames().getString();
                    loadLevelTableView(colStrs, sts.getColumns().getSourceColumnSubClass());
                }
            }

        }
    }

    private void loadSourceListFromFile(){
        String path = "src/resources/" + birstProperties.getCurrentSpace().getName() + "/";
        DataSourceContainer container = BirstDataLoadManager.loadFromFile(path);
        currentSourceMap = container.getBirstXmlSourceMap();
        if(currentSourceMap == null)
            return;
        ObservableList<String> options = FXCollections.observableArrayList(currentSourceMap.keySet());
        sourceCombox.setItems(options);
        sourceCombox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                StagingTableSubClass sts = currentSourceMap.get(newValue);
                if(sts != null){
                    loadLevelTableView(null,sts.getColumns().getSourceColumnSubClass());
                }

            }
        });
    }

    private void loadLevelTableView(List<String> selected, List<SourceColumnSubClass> columns){
        List<LevelColumn> nameList = new ArrayList<>();
        for(SourceColumnSubClass scs : columns){
            LevelColumn lc = new LevelColumn();
            Checkbox checkBox = new Checkbox();
//            checkBox.selectedProperty().addListener(new ChangeListener<Boolean>() {
//                @Override
//                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                    checkBox.setSelected(newValue);
//                }
//            });
            if(selected!= null){
                checkBox.setSelected(false);
                lc.select = checkBox;

             //   lc.select.setSelect(false);
                for(String sel : selected){
                    if(sel.equals(scs.getName())){
                        checkBox.setSelected(true);
                        lc.select = checkBox;
                    //    lc.setSelect(true);
                        break;
                    }
                }
            }else {
                checkBox.setSelected(false);
                 lc.select = checkBox;

            }

            lc.setName(scs.getName());
            nameList.add(lc);
        }

        if(levelTableView.getItems() != null && levelTableView.getItems().size()>0){
            levelTableView.getItems().remove(0,levelTableView.getItems().size());
        }

        levelTableView.setItems(FXCollections.observableArrayList(nameList));
    }


    private void loadTreeItems(TreeItem treeItem, Map<String, HierarchyMetadata> hmap){
        if(hmap == null)
            return;
        for(String key: hmap.keySet()){
            TreeItem item = new TreeItem(key);
            treeItem.getChildren().add(item);
        }
    }



    public class LevelColumn{
        public Checkbox select = new Checkbox();
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
