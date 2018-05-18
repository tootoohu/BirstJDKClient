package com.infor.ui;

import com.infor.admin.FileManagement;
import com.infor.connect.DataConductorUtil;
import com.infor.connect.DatabaseQuery;
import com.infor.connect.DatabaseQueryWrapper;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.DatabaseQueryXmlHelper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;


public class BirstConnectTabGenerator implements TabGeneratorInterface{

    private static BirstProperties birstProperties = BirstProperties.getInstance();

    private FileManagement fileManagement =  new FileManagement();
    private TreeItem<DatabaseQuery> rootTreeItem;

    private List<DatabaseQuery> tasks;
    TreeView<DatabaseQuery> treeView;
    private DatabaseQuery currentQuery = new DatabaseQuery();
    private TextArea queryArea;

    private TextField queryNameField;
    private ComboBox typeBox;
    private TextField serverField;
    private TextField portField;
    private TextField dbNameField;
    private TextField userNameField;
    private PasswordField pwdField;


    private static final String DATA_SOURCE_FILE = "DataSource.xml";

    public Tab loadTab(){
        Tab connectTab = new Tab("Data Source");
        StackPane treePane = new StackPane();
        TreeView treeView = loadTree();
        treePane.getChildren().add(treeView);

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
        DatabaseQuery allQuery = new DatabaseQuery();
        allQuery.setQueryName("All");
        rootTreeItem = new TreeItem<>(allQuery);
        treeView = new TreeView(rootTreeItem);
        treeView.setEditable(true);
        treeView.setCellFactory(new Callback<TreeView<DatabaseQuery>,TreeCell<DatabaseQuery>>(){
            @Override
            public TreeCell<DatabaseQuery> call(TreeView<DatabaseQuery> p) {
                return new DatabaseQueryTreeCellImple();
            }
        });

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem item = (TreeItem) newValue;
            refreshQueryPane(item);

        });

        rootTreeItem.setExpanded(true);
        String path = "resources/" + birstProperties.getCurrentSpace().getName() + "/" + DATA_SOURCE_FILE;
        System.out.println(" data source file " + path);

        tasks = DatabaseQueryXmlHelper.loadDataFromFile(path);

        if(tasks != null){
            for (DatabaseQuery query: tasks) {
                TreeItem<DatabaseQuery> treeItem = new TreeItem<>(query);
                rootTreeItem.getChildren().add(treeItem);
            }
        }

        final ContextMenu contextMenu = new ContextMenu();
        MenuItem addMenu = new MenuItem("Add");
        addMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DatabaseQuery databaseQuery = new DatabaseQuery();
                databaseQuery.setQueryName("New Query");
                TreeItem item = new TreeItem(databaseQuery);
                rootTreeItem.getChildren().add(item);
            }
        });

        MenuItem deleteMenu = new MenuItem("Delete");
        deleteMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TreeItem c = (TreeItem)treeView.getSelectionModel().getSelectedItem();
                boolean remove = c.getParent().getChildren().remove(c);
              }
        });

        contextMenu.getItems().addAll(addMenu, deleteMenu);
        treeView.setContextMenu(contextMenu);
        return treeView;
    }

    private void refreshQueryPane(TreeItem item){
        currentQuery = treeView.getSelectionModel().getSelectedItem().getValue();
        if(currentQuery == null){
            currentQuery = new DatabaseQuery();
            tasks.add(currentQuery);
        }

        DatabaseQuery databaseQuery = (DatabaseQuery) item.getValue();
        queryNameField.setText(databaseQuery.getQueryName());
        typeBox.setValue(databaseQuery.getDatabaseType());
        serverField.setText(databaseQuery.getServerName());
        portField.setText(String.valueOf(databaseQuery.getPort()));
        dbNameField.setText(databaseQuery.getDatabaseName());
        userNameField.setText(databaseQuery.getUsername());
        pwdField.setText(databaseQuery.getPassword());
        queryArea.setText(databaseQuery.getQuery());
    }


    private Control loadDatasourcePane(){
        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setPadding(new Insets(10,10,10,20));

        Label queryLable = new Label("Query Name:");
        GridPane.setConstraints(queryLable, 0,0);

        gridPane.getChildren().add(queryLable);

        queryNameField = new TextField();
      //  GridPane.setColumnSpan(queryField,2);
        GridPane.setConstraints(queryNameField, 1,0);
        gridPane.getChildren().add(queryNameField);

        Label typeLable = new Label("Database Type:");
        GridPane.setConstraints(typeLable, 2,0);
        gridPane.getChildren().add(typeLable);

        ObservableList<String> options = FXCollections.observableArrayList(
                DatabaseQuery.MSSQL,DatabaseQuery.MYSQL, DatabaseQuery.ORACLE, DatabaseQuery.ODBC);
        typeBox = new ComboBox(options);
        GridPane.setConstraints(typeBox, 3,0);
        gridPane.getChildren().add(typeBox);

        Button saveBtn = new Button("Save");
        saveBtn.setPrefWidth(80);
        GridPane.setConstraints(saveBtn, 4,0);
        gridPane.getChildren().add(saveBtn);

        Label serverLable = new Label("Server Name:");
        GridPane.setConstraints(serverLable, 0,1);
        gridPane.getChildren().add(serverLable);

        serverField = new TextField();
        GridPane.setConstraints(serverField, 1,1);
        gridPane.getChildren().add(serverField);

        Label portLable = new Label("Port (blank=default):");
        GridPane.setConstraints(portLable, 2,1);

        gridPane.getChildren().add(portLable);

        portField = new TextField();
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

        dbNameField = new TextField();
        GridPane.setConstraints(dbNameField, 1,2);
        gridPane.getChildren().add(dbNameField);

        Label userNameLable = new Label("Username:");
        GridPane.setConstraints(userNameLable, 2,2);
        gridPane.getChildren().add(userNameLable);

        userNameField = new TextField();
        GridPane.setConstraints(userNameField, 3,2);
        gridPane.getChildren().add(userNameField);

        Label pwdLable = new Label("Password:");
        GridPane.setConstraints(pwdLable, 0,3);
        gridPane.getChildren().add(pwdLable);

        pwdField = new PasswordField();
        GridPane.setConstraints(pwdField, 1,3);
        gridPane.getChildren().add(pwdField);

        Label replaceLable = new Label("Replacements:");
        GridPane.setConstraints(replaceLable, 2,3);
        gridPane.getChildren().add(replaceLable);

        TextField replaceField = new TextField();
        GridPane.setConstraints(replaceField, 3,3);
        gridPane.getChildren().add(replaceField);

        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveCurrentQuery();
                DatabaseQueryWrapper wrapper = new DatabaseQueryWrapper();
                wrapper.setQueries(tasks);
                String path = Paths.get("").toAbsolutePath().toString()  + "/src/resources/" + birstProperties.getCurrentSpace().getName() + "/" + DATA_SOURCE_FILE;
                        DatabaseQueryXmlHelper.saveToFile(path, wrapper );
            }
        });

        runTaskBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                saveCurrentQuery();

                try {
                    File f = DataConductorUtil.getTable(currentQuery);
                    FileInputStream fileInputStream = new FileInputStream(f);
                    DataInputStream dStream = new DataInputStream(fileInputStream);

                    final int CHUNK_SIZE = 102400;
                    System.out.println("File to upload -> " + f.getAbsolutePath() + " ->" + f.length());

                    String uploadToken = fileManagement.beginDataUpload(birstProperties.getLoginToken(),birstProperties.getCurrentSpace().getId(),f.getName());
                    byte[] bytes = new byte[CHUNK_SIZE];
                    int read;
                    do{
                        read = dStream.read(bytes, 0,CHUNK_SIZE);
                        String readed = new String(bytes);
                        System.out.println("read -> " + readed);
                        if(read > 0){
                            fileManagement.uploadData(birstProperties.getLoginToken(),uploadToken,read,bytes);
                        }
                    }while (read > 0);


                    fileManagement.finishDataUpload(birstProperties.getLoginToken(),uploadToken);

                    while (fileManagement.isDataUploadComplete(birstProperties.getLoginToken(),uploadToken) == false){
                        Thread.sleep(1000);
                    }
//                    String url = System.getProperty("jnlp.url");
//                    if(url == null)
//                        url = "https://pronto.beta.birst.com:443";
//                    String result;
                  //  WebUploader uploader = new WebUploader(birstProperties.getUser(),birstProperties.getPassword(),birstProperties.getCurrentSpace().getId(),url);
                //    uploader.uploadFile(f.getParent(),f.getName(),false,false);

                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        SplitPane sp = new SplitPane();
        sp.getItems().addAll(gridPane,loadQueryPane());
        sp.setOrientation(Orientation.VERTICAL);
        sp.setDividerPositions(0.2f, 0.8f);

        return sp;
    }

    private void saveCurrentQuery(){
        currentQuery.setServerName(serverField.getText());
        currentQuery.setQueryName(queryNameField.getText());
        currentQuery.setDatabaseType(typeBox.getValue().toString());
        currentQuery.setPort(Integer.valueOf(portField.getText()));
        currentQuery.setDatabaseName(dbNameField.getText());
        currentQuery.setUsername(userNameField.getText());
        currentQuery.setPassword(pwdField.getText());
        currentQuery.setQuery(queryArea.getText());
    }

    private GridPane loadQueryPane(){
        GridPane pane = new GridPane();
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setPadding(new Insets(10,10,10,20));

        Label queryLable = new Label("Query:");
        GridPane.setConstraints(queryLable, 1,0);
        pane.getChildren().add(queryLable);

        queryArea = new TextArea();
        queryArea.setStyle("-fx-highlight-fill: lightgray; -fx-highlight-text-fill: firebrick; -fx-font-size: 12px;");
        queryArea.setPrefColumnCount(50);
        queryArea.setPrefRowCount(20);
        GridPane.setConstraints(queryArea, 1,2);
        pane.getChildren().add(queryArea);

        return pane;
    }

    private void refresh(){

    }


}
