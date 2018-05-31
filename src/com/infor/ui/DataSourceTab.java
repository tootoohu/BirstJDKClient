package com.infor.ui;

import com.infor.admin.FileManagement;
import com.infor.connect.DataConductorUtil;
import com.infor.connect.DatabaseQuery;
import com.infor.connect.DatabaseQueryWrapper;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.DatabaseQueryXmlHelper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.util.Callback;
import org.apache.log4j.Logger;

import javax.swing.event.DocumentEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static javafx.scene.control.TreeItem.valueChangedEvent;

public class DataSourceTab {
    private static final Logger logger = Logger.getLogger(HierarchiesTab.class);
    private static BirstProperties birstProperties = BirstProperties.getInstance();

    private FileManagement fileManagement = new FileManagement();
    private TreeItem<String> rootTreeItem;

    private Map<String,DatabaseQuery> tasks = new HashMap<>();
    @FXML
    private TreeView<String> treeView;
    private String currentQuery;
    @FXML
    private TextArea queryArea;
    @FXML
    private TextField queryNameField;
    @FXML
    private ComboBox typeBox;
    @FXML
    private TextField serverField;
    @FXML
    private TextField portField;
    @FXML
    private TextField dbNameField;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField pwdField;
    @FXML
    private Button saveBtn;
    @FXML
    private Button runTaskBtn;

    private static final String DATA_SOURCE_FILE = "DataSource.xml";
    private static final String ALL_NODE = "All";

    @FXML
    private void initialize() {
        load();
    }

    private void load() {
       ObservableList<String> options = FXCollections.observableArrayList(
                DatabaseQuery.MSSQL,DatabaseQuery.MYSQL, DatabaseQuery.ORACLE, DatabaseQuery.ODBC);
        typeBox.setItems(options);
        rootTreeItem = new TreeItem(ALL_NODE);
        rootTreeItem.setExpanded(true);
        loadTree();
    }

    private TreeView loadTree() {
       // treeView = new TreeView(rootTreeItem);
        treeView.setRoot(rootTreeItem);
        treeView.setEditable(true);

        //return new DatabaseQueryTreeCellImple();
        treeView.setCellFactory(new Callback<TreeView<String>, TreeCell<String>>() {
            @Override
            public TreeCell<String> call(TreeView<String> param) {
                return new TextFieldTreeCellImpl();
            }
        });

        treeView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            TreeItem item =  newValue;
            currentQuery = (String) item.getValue();
            refreshQueryPane(item);

        });


        loadTreeItemFromFile();

        final ContextMenu contextMenu = new ContextMenu();
        MenuItem addMenu = new MenuItem("Add");
        addMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TreeItem item = new TreeItem("New Query");
                item.addEventHandler(TreeItem.valueChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<Object>>() {
                    @Override
                    public void handle(TreeItem.TreeModificationEvent<Object> event) {

                        logger.info("Add New Query ");
                        refreshQueryPane(event.getTreeItem());
                    }
                });
                rootTreeItem.getChildren().add(item);

            }
        });

        MenuItem deleteMenu = new MenuItem("Delete");
        deleteMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TreeItem c = (TreeItem) treeView.getSelectionModel().getSelectedItem();
                boolean remove = c.getParent().getChildren().remove(c);
            }
        });


        MenuItem importMenu = new MenuItem("Import");
        importMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                loadTreeItemFromFile();

            }
        });

        contextMenu.getItems().addAll(addMenu, deleteMenu,importMenu);
        treeView.setContextMenu(contextMenu);
        return treeView;
    }


    @FXML
    private void onTreeViewEditCommit(){

        TreeItem item = this.treeView.getSelectionModel().getSelectedItem();
        if(item != null){
            queryNameField.setText(item.getValue().toString());
        }

    }
    private void loadTreeItemFromFile(){

        String path = "src/resources/" + birstProperties.getCurrentSpace().getName() + "/" + DATA_SOURCE_FILE;
        logger.info("load Tree Item from file " + path);

        rootTreeItem.getChildren().remove(0, rootTreeItem.getChildren().size());
        tasks = DatabaseQueryXmlHelper.loadDataFromFile(path);

        if (tasks != null) {
            for (String query : tasks.keySet()) {
                TreeItem<String> treeItem = new TreeItem<>(query);

                treeItem.addEventHandler(TreeItem.valueChangedEvent(), new EventHandler<TreeItem.TreeModificationEvent<Object>>() {
                    @Override
                    public void handle(TreeItem.TreeModificationEvent<Object> event) {

                        System.out.println(event.getTreeItem().getValue());
                        refreshQueryPane(event.getTreeItem());
                    }
                });

                rootTreeItem.getChildren().add(treeItem);
            }
        }
    }


    private void refreshQueryPane(TreeItem item) {
        logger.info("Refresh Query Pane ");
        currentQuery = treeView.getSelectionModel().getSelectedItem().getValue();
        if (currentQuery == null) {
            return;
        }
        if(currentQuery.equals(ALL_NODE)){
            clearQueryPane();
        }else {
            if(tasks != null){
                DatabaseQuery databaseQuery = tasks.get(currentQuery);
                if(databaseQuery != null){
                    queryNameField.setText(databaseQuery.getQueryName());
                    queryNameField.setEditable(false);
                    typeBox.setValue(databaseQuery.getDatabaseType());
                    serverField.setText(databaseQuery.getServerName());
                    portField.setText(String.valueOf(databaseQuery.getPort()));
                    dbNameField.setText(databaseQuery.getDatabaseName());
                    userNameField.setText(databaseQuery.getUsername());
                    pwdField.setText(databaseQuery.getPassword());
                    queryArea.setText(databaseQuery.getQuery());
                }else {
                    queryNameField.setText(currentQuery);
                    queryNameField.setEditable(false);
                    queryArea.setText("");
                }
            }
        }

    }

    private void clearQueryPane(){
        queryNameField.setText("");
        queryNameField.setEditable(false);
        typeBox.setValue("");
        serverField.setText("");
        portField.setText("0");
        dbNameField.setText("");
        userNameField.setText("");
        pwdField.setText("");
        queryArea.setText("");
    }
    private void saveCurrentQuery() {
        if(tasks == null){
            tasks = new HashMap<>();
        }

        DatabaseQuery databaseQuery = tasks.get(currentQuery);
        if(databaseQuery == null){
            databaseQuery = new DatabaseQuery();
        }
            databaseQuery.setServerName(serverField.getText());
            databaseQuery.setQueryName(queryNameField.getText());
            databaseQuery.setDatabaseType(typeBox.getValue().toString());
            databaseQuery.setPort(Integer.valueOf(portField.getText()));
            databaseQuery.setDatabaseName(dbNameField.getText());
            databaseQuery.setUsername(userNameField.getText());
            databaseQuery.setPassword(pwdField.getText());
            databaseQuery.setQuery(queryArea.getText());

        tasks.put(databaseQuery.getQueryName(),databaseQuery);
    }

    @FXML
    private void onSaveBtnAction() {
        logger.info("Save current Query to file");
        saveCurrentQuery();

        DatabaseQueryWrapper wrapper = new DatabaseQueryWrapper();
        wrapper.setQueries(tasks);
        String path = Paths.get("").toAbsolutePath().toString() + "/src/resources/" + birstProperties.getCurrentSpace().getName() + "/" + DATA_SOURCE_FILE;
        DatabaseQueryXmlHelper.saveToFile(path, wrapper);
    }


    @FXML
    private void onRunTaskBtnAction() {
        logger.info("Run Task Action");
        saveCurrentQuery();
        DatabaseQuery dq = tasks.get(currentQuery);
        if(dq == null)
            return;
        try {
            File f = DataConductorUtil.getTable(dq);
            FileInputStream fileInputStream = new FileInputStream(f);
            DataInputStream dStream = new DataInputStream(fileInputStream);

            final int CHUNK_SIZE = 102400;
            System.out.println("File to upload -> " + f.getAbsolutePath() + " ->" + f.length());

            String uploadToken = fileManagement.beginDataUpload(birstProperties.getLoginToken(), birstProperties.getCurrentSpace().getId(), f.getName());
            byte[] bytes = new byte[CHUNK_SIZE];
            int read;
            do {
                read = dStream.read(bytes, 0, CHUNK_SIZE);
                String readed = new String(bytes);
                System.out.println("read -> " + readed);
                if (read > 0) {
                    fileManagement.uploadData(birstProperties.getLoginToken(), uploadToken, read, bytes);
                }
            } while (read > 0);


            fileManagement.finishDataUpload(birstProperties.getLoginToken(), uploadToken);

            while (fileManagement.isDataUploadComplete(birstProperties.getLoginToken(), uploadToken) == false) {
                Thread.sleep(1000);
            }
            boolean result = fileManagement.isDataUploadComplete(birstProperties.getLoginToken(), uploadToken);
            DialogHelper.showResultDialog("Run task ",result);

//                    String url = System.getProperty("jnlp.url");
//                    if(url == null)
//                        url = "https://pronto.beta.birst.com:443";
//                    String result;
            //  WebUploader uploader = new WebUploader(birstProperties.getUser(),birstProperties.getPassword(),birstProperties.getCurrentSpace().getId(),url);
            //    uploader.uploadFile(f.getParent(),f.getName(),false,false);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
