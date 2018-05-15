package com.infor.ui;

import com.birst.*;
import com.infor.admin.BirstDataLoadManagement;
import com.infor.admin.SpaceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.BirstXmlReader;
import com.infor.util.DataSourceContainer;
import com.infor.util.XmlInterface;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import javafx.util.converter.NumberStringConverter;
import org.xml.sax.SAXException;
import sun.reflect.generics.tree.Tree;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BirstSourcesTabGenerator<T> implements XmlInterface{

    private BirstXmlReader reader = new BirstXmlReader();

    private String currentNode;

    private TableView<SourceColumnSubClass>  columnTableView = new TableView<>();

    private SpaceManagement spaceManagement = new SpaceManagement();

    private static BirstProperties birstProperties = BirstProperties.getInstance();

    public BirstSourcesTabGenerator() throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
    }

    public  Tab loadTab(){
        Tab sourcesTab = new Tab();
        sourcesTab.setText("Sources");

        StackPane treePane = new StackPane();
        TreeItem rootTreeItem = new TreeItem<>("All");

        DataSourceContainer container = BirstDataLoadManagement.loadFromFile("src/resources/Infor-CSI-Suite-10_0_0_0-Parent-Dev-Master/");

        treePane.getChildren().add(loadTree(rootTreeItem,container.getBirstXmlSourceMap()));


        SplitPane rightPane = new SplitPane();
        rightPane.setDividerPositions(0.05f,0.95f);
        rightPane.setOrientation(Orientation.VERTICAL);

        TabPane tabPane = new TabPane();
        FlowPane buttonMenuPane = new FlowPane();
        buttonMenuPane.setVgap(4);
        buttonMenuPane.setHgap(6);
        buttonMenuPane.setAlignment(Pos.BASELINE_LEFT);

        Button updatebtn = new Button("Update");
        updatebtn.setPrefSize(110,30);
        updatebtn.setLayoutX(10);
        buttonMenuPane.getChildren().addAll(updatebtn);

        updatebtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                StagingTableSubClass sts = container.getBirstXmlSourceMap().get(currentNode);
                ObservableList<TableColumn<SourceColumnSubClass,?>> columnObservableList =  columnTableView.getColumns();
                for(TableColumn<SourceColumnSubClass,?> tableColumn: columnObservableList){
                    System.out.println(tableColumn.isVisible());
                    //tableColumn
                }
            }
        });

        Tab columnsTab = new Tab();
        loadColumnTableView(columnTableView);
        columnsTab.setText("Columns");
        columnsTab.setContent(columnTableView);

        //script tab

        tabPane.getTabs().add(columnsTab);
        tabPane.getTabs().add(loadScriptTab());

        rightPane.getItems().addAll(buttonMenuPane, tabPane);
        columnTableView.setEditable(true);

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(treePane,rightPane);
        sp.setDividerPositions(0.2f, 0.8f);
        sourcesTab.setContent(sp);

        return sourcesTab;
    }

    private void addNewTreeNode(){

    }
    private void refreshScript(TreeItem treeItem, Map<String, StagingTableSubClass> subClassMap,TextArea input, TextArea script){
        if(treeItem.getValue() instanceof String){
            String se = (String) treeItem.getValue();
            ScriptDefinition sd = subClassMap.get(se).getScript();
            input.setText(sd.getInputQuery());
            script.setText(sd.getScript());
        }
    }

    private Tab loadScriptTab(){
        Tab scriptTab = new Tab();
        scriptTab.setText("Script");
        GridPane scriptPane = new GridPane() ;

        scriptPane.setAlignment(Pos.TOP_LEFT);

        Label inLable = new Label("Input Query");
        GridPane.setConstraints(inLable, 0,0);
        TextArea input = new TextArea();
        TextArea script = new TextArea();
        scriptPane.getChildren().add(inLable);
        GridPane.setConstraints(input, 1,0);
        scriptPane.getChildren().add(input);

        Label sLable = new Label("Script");
        GridPane.setConstraints(sLable, 0,1);
        scriptPane.getChildren().add(sLable);
        GridPane.setConstraints(script, 1,1);
        scriptPane.getChildren().add(script);

        scriptPane.setAlignment(Pos.BOTTOM_LEFT);

        scriptTab.setContent(scriptPane);
        return scriptTab;
    }

    private TreeView loadTree(TreeItem treeItem, Map<String, StagingTableSubClass> map){
        loadTreeItems(treeItem,map);
        treeItem.setExpanded(true);
        TreeView treeView = new TreeView(treeItem);
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

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem item = (TreeItem) newValue;
            refreshTableData(map,item, columnTableView);
            //   refreshScript(treeItem,container.getBirstXmlSourceMap(),input, script);
        });

        treeView.setEditable(true);
        treeView.setCellFactory(new Callback<TreeView<String>,TreeCell<String>>(){
            @Override
            public TreeCell<String> call(TreeView<String> p) {
                return new TextFieldTreeCellImpl();
            }
        });

        return treeView;
    }
    private void loadTreeItems(TreeItem treeItem, Map<String, StagingTableSubClass> sourcemap){
        for(String key: sourcemap.keySet()){
            TreeItem item = new TreeItem(key);

            treeItem.getChildren().add(item);
        }
    }

    private  void refreshTableData( Map<String, StagingTableSubClass> subClassMap,TreeItem treeItem,TableView<SourceColumnSubClass> table){
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

    private void loadColumnTableView(TableView<SourceColumnSubClass> table){
        table.getColumns().add(createTableColumn(NAME_NODE));
        table.getColumns().add(createTableColumn(DATA_TYPE_NODE));
        table.getColumns().add(createTableColumn(WIDTH_NODE));
        table.getColumns().add(createTableColumn(LOCK_TYPE_NODE));
        table.getColumns().add(createTableColumn(HIERARCHY_NAME_NODE));
        table.getColumns().add(createTableColumn(LEVEL_NAME_NODE));
      //  table.getColumns().add(createTableColumn(LEVELS_NODE));
        table.getColumns().add(createTableColumn(MEASURE_NODE));
        table.getColumns().add(createTableColumn(ANALYZE_MEASURE_NODE));
        table.getColumns().add(createTableColumn(ANALYZE_BY_DATE_NODE));
        table.getColumns().add(createTableColumn(FORMAT_NODE));
        table.getColumns().add(createTableColumn(UNKNOWN_VALUE_NODE));
        table.getColumns().add(createTableColumn(ENABLE_SECURITY_FILTER_NODE));

    }

    private TableColumn createTableColumn(String colName)  {
        TableColumn col = new TableColumn(colName);
        col.setMinWidth(100);
        col.setEditable(true);

        col.setCellValueFactory(new PropertyValueFactory<>(colName));
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

                    switch (colName){
                        case WIDTH_NODE:
                            m = SourceColumnSubClass.class.getDeclaredMethod("set" + colName, int.class);
                            m.invoke(object, Integer.valueOf(event.getNewValue().toString()));
                            break;
                        case ANALYZE_MEASURE_NODE:
                            m = SourceColumnSubClass.class.getDeclaredMethod("set" + colName, Boolean.class);
                            m.invoke(object, Boolean.valueOf(event.getNewValue().toString()));
                            break;
                        case ANALYZE_BY_DATE_NODE: case ENABLE_SECURITY_FILTER_NODE:
                            m = SourceColumnSubClass.class.getDeclaredMethod("set" + colName, Boolean.class);
                            m.invoke(object, Boolean.valueOf(event.getNewValue().toString()));
                            break;
                        default:
                            m = SourceColumnSubClass.class.getDeclaredMethod("set" + colName, String.class);
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


        return col;
    }

    private void loadColumnsTableView(){

    }

    private class EditingCell extends TableCell<SourceColumnSubClass, Object> {

        private TextField textField;

        private EditingCell() {
        }

        @Override
        public void startEdit() {
            super.startEdit();
            if (textField == null) {
                createTextField();
            }
            setGraphic(textField);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    textField.selectAll();
                    textField.requestFocus();
                }
            });
            System.out.println("start edit" + textField.getText());
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(String.valueOf(getItem()));
            setContentDisplay(ContentDisplay.TEXT_ONLY);
            System.out.println("cancel edit " + getItem());
        }

        @Override
        public void updateItem(Object item, boolean empty) {
            super.updateItem(item, empty);
            System.out.println("update item " + item);
            if (item != null) {
                if (item instanceof String) {
                    setText((String) item);
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.TEXT_ONLY);
                } else if (item instanceof Integer) {
                    setText(Integer.toString((Integer) item));
                    setGraphic(textField);
                    setContentDisplay(ContentDisplay.TEXT_ONLY);

                } else if (item instanceof Boolean) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setSelected((boolean) item);
                    setGraphic(checkBox);
                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                } else if (item instanceof Image) {
                    setText(null);
                    ImageView imageView = new ImageView((Image) item);
                    imageView.setFitWidth(100);
                    imageView.setPreserveRatio(true);
                    imageView.setSmooth(true);
                    setGraphic(imageView);
                } else {
                    setText("N/A");
                    setGraphic(null);
                }
            } else {
                setText(null);
                setGraphic(null);
            }
        }

        private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap() * 2);
           // textField.setOnAction((e) -> commitEdit(textField.getText()));
            textField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent t) {
                    if (t.getCode() == KeyCode.ENTER) {
                        commitEdit(textField.getText());
                    } else if (t.getCode() == KeyCode.ESCAPE) {
                        cancelEdit();
                    } else if (t.getCode() == KeyCode.TAB) {
                        commitEdit(textField.getText());
                        TableColumn nextColumn = getNextColumn(!t.isShiftDown());
                        if (nextColumn != null) {
                            getTableView().edit(getTableRow().getIndex(), nextColumn);
                        }
                    }
                }
            });

            textField.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
                if (!newValue && textField != null) {
                    System.out.println("Commiting " + textField.getText());
                    commitEdit(textField.getText());
                }
            });
        }

        private TableColumn<SourceColumnSubClass, ?> getNextColumn(boolean forward) {
            List<TableColumn<SourceColumnSubClass, ?>> columns = new ArrayList<>();
            for (TableColumn<SourceColumnSubClass, ?> column : getTableView().getColumns()) {
                columns.addAll(getLeaves(column));
            }
            //There is no other column that supports editing.
            if (columns.size() < 2) {
                return null;
            }

            int currentIndex = columns.indexOf(getTableColumn());
            int nextIndex = currentIndex;
            if (forward) {
                nextIndex++;
                if (nextIndex > columns.size() - 1) {
                    nextIndex = 0;
                }
            } else {
                nextIndex--;
                if (nextIndex < 0) {
                    nextIndex = columns.size() - 1;
                }
            }
            return columns.get(nextIndex);
        }

        private List<TableColumn<SourceColumnSubClass, ?>> getLeaves(TableColumn<SourceColumnSubClass, ?> root) {
            List<TableColumn<SourceColumnSubClass, ?>> columns = new ArrayList<>();
            if (root.getColumns().isEmpty()) {
                //We only want the leaves that are editable.
                if (root.isEditable()) {
                    columns.add(root);
                }
                return columns;
            } else {
                for (TableColumn<SourceColumnSubClass, ?> column : root.getColumns()) {
                    columns.addAll(getLeaves(column));
                }
                return columns;
            }
        }

        private String getString() {
            return getItem() == null ? "" : String.valueOf(getItem());
        }
    }

}
