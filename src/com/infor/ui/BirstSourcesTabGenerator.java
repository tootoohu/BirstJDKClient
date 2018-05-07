package com.infor.ui;

import com.birst.ArrayOfString;
import com.birst.ScriptDefinition;
import com.birst.SourceColumnSubClass;
import com.birst.StagingTableSubClass;
import com.infor.admin.BirstDataLoadManagement;
import com.infor.util.BirstXmlReader;
import com.infor.util.DataSourceContainer;
import com.infor.util.XmlInterface;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.Map;

public class BirstSourcesTabGenerator implements XmlInterface{

    private BirstXmlReader reader = new BirstXmlReader();

    private String currentNode;

    public BirstSourcesTabGenerator() throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
    }

    public  Tab loadTab(){
        Tab sourcesTab = new Tab();
        sourcesTab.setText("Sources");

        StackPane treePane = new StackPane();
        TreeItem rootTreeItem = new TreeItem<>("All");
        rootTreeItem.setExpanded(true);
        DataSourceContainer container = BirstDataLoadManagement.loadFromFile("src/resources/Infor-CSI-Suite-10_0_0_0-Parent-Dev-Master/");

        loadTreeItems(rootTreeItem, container.getBirstXmlSourceMap());
        TreeView treeView = new TreeView(rootTreeItem);
        treePane.getChildren().add(treeView);

        SplitPane rightPane = new SplitPane();
        rightPane.setDividerPositions(0.05f,0.95f);
        rightPane.setOrientation(Orientation.VERTICAL);

      //  StackPane tablePane = new StackPane();
        TabPane tabPane = new TabPane();
        FlowPane buttonMenuPane = new FlowPane();
        buttonMenuPane.setVgap(4);
        buttonMenuPane.setHgap(6);
        buttonMenuPane.setAlignment(Pos.BASELINE_LEFT);

        Button updatebtn = new Button("Update");
        updatebtn.setPrefSize(110,30);
        updatebtn.setLayoutX(10);
        buttonMenuPane.getChildren().addAll(updatebtn);
        Tab columnsTab = new Tab();
        TableView<SourceColumnSubClass>  columnTableView = new TableView<>();

        loadColumnTableView(columnTableView);
        columnsTab.setText("Columns");
        columnsTab.setContent(columnTableView);

        //script tab
        Tab scriptTab = new Tab();
        scriptTab.setText("Script");
        GridPane scriptPane = new GridPane() ;
  //      scriptPane.setPadding(new Insets(2, 2, 2, 2));
//        scriptPane.setVgap(5);
//        scriptPane.setHgap(5);
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
        tabPane.getTabs().add(columnsTab);
        tabPane.getTabs().add(scriptTab);

        rightPane.getItems().addAll(buttonMenuPane, tabPane);

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem treeItem = (TreeItem) newValue;
            refreshTableData(container.getBirstXmlSourceMap(),treeItem, columnTableView);
            refreshScript(treeItem,container.getBirstXmlSourceMap(),input, script);
        });

        columnTableView.setEditable(true);

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(treePane,rightPane);
        sp.setDividerPositions(0.3f, 0.7f);
        sourcesTab.setContent(sp);

        return sourcesTab;
    }

//    private Tab loadScriptTab(String text){
//        Tab scriptTab = new Tab();
//        scriptTab.setText("Script");
//        TextArea ta = new TextArea();
//        ta.appendText(text);
//        scriptTab.setContent(ta);
//        return scriptTab;
//    }

    private void refreshScript(TreeItem treeItem, Map<String, StagingTableSubClass> subClassMap,TextArea input, TextArea script){
        if(treeItem.getValue() instanceof String){
            String se = (String) treeItem.getValue();
            ScriptDefinition sd = subClassMap.get(se).getScript();
            input.setText(sd.getInputQuery());
            script.setText(sd.getScript());
        }
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
            table.setItems(FXCollections.observableArrayList(subClassMap.get(se).getColumns().getSourceColumnSubClass()));
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

    private TableColumn createTableColumn(String colName){
        TableColumn col = new TableColumn(colName);
        col.setMinWidth(100);
        col.setEditable(true);

        col.setCellValueFactory(new PropertyValueFactory<SourceColumnSubClass,String>(colName));
        col.setCellFactory(new Callback<TableColumn, TableCell>() {
            public TableCell call(TableColumn p) {
                return new TextFieldTableCell();
               // return new CheckBoxTableCell();
            }
        });
        return col;
    }

    private void loadColumnsTableView(){

    }

}
