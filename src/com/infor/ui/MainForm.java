package com.infor.ui;

import com.birst.StagingTableSubClass;
import com.birst.UserSpace;
import com.infor.admin.BirstDataLoadManager;
import com.infor.admin.DataSourceManagement;
import com.infor.admin.ExportManager;
import com.infor.admin.SpaceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.SourceEntry;
import com.infor.model.webservice.UserSpaceConverter;
import com.infor.util.DataSourceContainer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
    private ComboBox<UserSpace> comboBox;

    @FXML
    private  Tab manageSourceTab;
    @FXML
    private Tab hierarchiesTab;
    @FXML
    private Tab DataSourceTab;

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

        loadManageSourceTab();
    }



}
