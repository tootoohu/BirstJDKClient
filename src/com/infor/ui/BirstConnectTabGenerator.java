package com.infor.ui;

import com.infor.connect.DatabaseQuery;
import com.infor.model.webservice.BirstProperties;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.concurrent.Callable;

public class BirstConnectTabGenerator implements TabGeneratorInterface{

    private static BirstProperties birstProperties = BirstProperties.getInstance();

    private TreeItem rootTreeItem = new TreeItem<>("All");

    public Tab loadTab(){
        Tab connectTab = new Tab("Data Source");
        StackPane treePane = new StackPane();
        TreeView treeView = loadTree();
        treePane.getChildren().add(treeView);

        //
        final ContextMenu contextMenu = new ContextMenu();
        MenuItem addMenu = new MenuItem("Add");
        addMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                TreeItem item = new TreeItem("New Item");
                rootTreeItem.getChildren().add(item);
            }
        });

        contextMenu.getItems().addAll(addMenu);
        treeView.setContextMenu(contextMenu);

        SplitPane rightPane = new SplitPane();
        rightPane.setDividerPositions(0.05f,0.95f);
        rightPane.setOrientation(Orientation.VERTICAL);

        rightPane.getItems().add(loadDatasourcePane());

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(treePane,rightPane);
        sp.setDividerPositions(0.2f, 0.8f);
        connectTab.setContent(sp);

        return connectTab;
    }

    private TreeView loadTree(){
        TreeView treeView = new TreeView(rootTreeItem);
        rootTreeItem.setExpanded(true);
        System.out.println();
        return treeView;
    }

    private Control loadDatasourcePane(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10,10,10,20));


        Label queryLable = new Label("Query Name:");
        GridPane.setConstraints(queryLable, 0,0);

        gridPane.getChildren().add(queryLable);

        TextField queryField = new TextField();
      //  GridPane.setColumnSpan(queryField,2);
        GridPane.setConstraints(queryField, 1,0);
        gridPane.getChildren().add(queryField);

        Label typeLable = new Label("Database Type:");
        GridPane.setConstraints(typeLable, 2,0);
        gridPane.getChildren().add(typeLable);

        ObservableList<String> options = FXCollections.observableArrayList(
                DatabaseQuery.MSSQL, DatabaseQuery.ORACLE, DatabaseQuery.MYSQL);
        ComboBox typeBox = new ComboBox(options);
        GridPane.setConstraints(typeBox, 3,0);
        gridPane.getChildren().add(typeBox);

        Button saveBtn = new Button("Save");
        saveBtn.setPrefWidth(80);
        GridPane.setConstraints(saveBtn, 4,0);
        gridPane.getChildren().add(saveBtn);

        Label serverLable = new Label("Server Name:");
        GridPane.setConstraints(serverLable, 0,1);
        gridPane.getChildren().add(serverLable);

        TextField serverField = new TextField();
        GridPane.setConstraints(serverField, 1,1);
        gridPane.getChildren().add(serverField);

        Label portLable = new Label("Port (blank=default):");
        GridPane.setConstraints(portLable, 2,1);

        gridPane.getChildren().add(portLable);

        TextField portField = new TextField();
        GridPane.setColumnSpan(portField,1);
        GridPane.setConstraints(portField, 3,1);
        gridPane.getChildren().add(portField);

        Button runTaskBtn = new Button("Run Task");
        runTaskBtn.setPrefWidth(80);
        GridPane.setConstraints(runTaskBtn, 4,1);
        gridPane.getChildren().add(runTaskBtn);

        Label dbNameLable = new Label("Database Name:");
        GridPane.setConstraints(dbNameLable, 0,2);
        gridPane.getChildren().add(dbNameLable);

        TextField dbNameField = new TextField();
        GridPane.setConstraints(dbNameField, 1,2);
        gridPane.getChildren().add(dbNameField);

        Label userNameLable = new Label("Username:");
        GridPane.setConstraints(userNameLable, 2,2);
        gridPane.getChildren().add(userNameLable);

        TextField userNameField = new TextField();
        GridPane.setConstraints(userNameField, 3,2);
        gridPane.getChildren().add(userNameField);

        Label pwdLable = new Label("Password:");
        GridPane.setConstraints(pwdLable, 0,3);
        gridPane.getChildren().add(pwdLable);

        TextField pwdField = new TextField();
        GridPane.setConstraints(pwdField, 1,3);
        gridPane.getChildren().add(pwdField);

        Label replaceLable = new Label("Replacements:");
        GridPane.setConstraints(replaceLable, 2,3);
        gridPane.getChildren().add(replaceLable);

        TextField replaceField = new TextField();
        GridPane.setConstraints(replaceField, 3,3);
        gridPane.getChildren().add(replaceField);

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(gridPane,loadQueryPane());
        sp.setOrientation(Orientation.VERTICAL);
        sp.setDividerPositions(0.2f, 0.8f);

        return sp;
    }

    private GridPane loadQueryPane(){
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10,10,10,20));

        Label queryLable = new Label("Query:");
        GridPane.setConstraints(queryLable, 1,0);
        pane.getChildren().add(queryLable);

        TextArea query = new TextArea();
        query.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick; -fx-font-size: 12px;");
        query.setPrefColumnCount(50);
        query.setPrefRowCount(20);
        GridPane.setConstraints(query, 1,2);
        pane.getChildren().add(query);

        return pane;
    }
}
