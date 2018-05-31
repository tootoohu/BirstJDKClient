package com.infor.ui;

import com.birst.UserSpace;
import com.infor.admin.DataSourceManagement;
import com.infor.admin.ExportManager;
import com.infor.admin.SpaceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.ui.UserSpaceConverter;
import com.infor.util.DataSourceContainer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class MainForm {

    private DataSourceContainer dataSourceContainer;
    //  private TableView<SourceColumnEntry> table = new TableView<>();
    private BirstProperties birstProperties;

    private static final Logger logger = Logger.getLogger(MainForm.class);
    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();
    private ExportManager exportManagement;
    private SpaceManagement spaceManagement = new SpaceManagement();

    private ObservableList<UserSpace> options;
    @FXML
    private MenuBar menuBar;
    @FXML
    private MenuItem newSourceWizardMenu;
    @FXML
    private ComboBox<UserSpace> comboBox;
    @FXML
    private Button downloadBtn;
    @FXML
    private  Tab manageSourceTab;
    @FXML
    private Tab hierarchiesTab;
    @FXML
    private Tab dataSourceTab;
    @FXML
    private Tab reportTab;


    private void loadManageSourceTab(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginForm.class.getResource("ManageSourceTab.fxml"));
        try {
            SplitPane sp = (SplitPane) loader.load();
            manageSourceTab.setContent(sp);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void loadHierarchiesTab(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginForm.class.getResource("HierarchiesTab.fxml"));
        try {
            SplitPane sp = (SplitPane) loader.load();
            hierarchiesTab.setContent(sp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDataSourceTab(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginForm.class.getResource("DataSourceTab.fxml"));
        try {
            SplitPane sp = (SplitPane) loader.load();
            dataSourceTab.setContent(sp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadReportTab(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginForm.class.getResource("ReportTab.fxml"));
        try {
            SplitPane sp = (SplitPane) loader.load();
            reportTab.setContent(sp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadNewSourceWizard(){
        FXMLLoader loader = new FXMLLoader();
       // loader.setLocation(LoginForm.class.getResource("SelectSourceWizard.fxml"));
        loader.setLocation(LoginForm.class.getResource("SourceDetailWizard.fxml"));
        try {
            AnchorPane sp = (AnchorPane) loader.load();
            Scene scene = new Scene(sp);
            Stage secondStage = new Stage();
            secondStage.setTitle("New Source Wizard");
            Image image = new Image(LoginForm.class.getResourceAsStream("/resources/images/Icon.png"));
            secondStage.getIcons().add(image);
            secondStage.setScene(scene);
            secondStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize(){
        birstProperties = BirstProperties.getInstance();
        dataSourceContainer = new DataSourceContainer();
        dataSourceContainer.loadXmlDocument();
        exportManagement = new ExportManager(dataSourceManagement);
        List<UserSpace> spaces = spaceManagement.listSpaces(birstProperties.getLoginToken());
        options = FXCollections.observableArrayList(spaces);
        comboBox.setItems(options);
        comboBox.setConverter(new UserSpaceConverter());
        comboBox.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                UserSpace currentSpace = (UserSpace) newValue;
                if(currentSpace != null){
                    birstProperties.setCurrentSpace(currentSpace);
                    logger.info("space changed to ->" + currentSpace.getName());

                }
            }
        });
        comboBox.getSelectionModel().select(0);
        birstProperties.setCurrentSpace(spaces.get(0));

        loadManageSourceTab();
        loadHierarchiesTab();
        loadDataSourceTab();
        loadReportTab();

        //munu event
        newSourceWizardMenu.setOnAction( event -> loadNewSourceWizard());
    }

    @FXML
    private void onDownloadBtnAction(){
        UserSpace us = birstProperties.getCurrentSpace();
        exportManagement.Export(birstProperties.getLoginToken(),us.getId(),us.getName());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Download succeed!");
        Optional<ButtonType> result = alert.showAndWait();
    }

}
