package com.infor;

import com.birst.UserSpace;
import com.infor.admin.ExportManager;
import com.infor.admin.DataSourceManagement;
import com.infor.admin.SpaceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.SourceEntry;
import com.infor.model.webservice.UserSpaceConverter;
import com.infor.ui.BirstConnectTabGenerator;
import com.infor.ui.BirstHierarchiesTabGenerator;
import com.infor.ui.BirstSourcesTabGenerator;
import com.infor.ui.LocalTabGenerator;
import com.infor.util.DataSourceContainer;
import javafx.application.Application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private DataSourceContainer dataSourceContainer;
  //  private TableView<SourceColumnEntry> table = new TableView<>();
    private SourceEntry currentSourceEntry;
    private BirstProperties birstProperties;

    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();
    private ExportManager exportManagement;
    private SpaceManagement spaceManagement = new SpaceManagement();

    @Override
    public void start(Stage primaryStage) throws Exception{
        initialize();
        TabPane mainPane = new TabPane();
        mainPane.setPrefSize(1000, 1000);

        Tab localTab = new LocalTabGenerator().loadTab(dataSourceContainer);
       // mainPane.getTabs().add(loadAdminTab());
      //  mainPane.getTabs().add(localTab);  it's for local xml read to construct cube and dimension
        BirstSourcesTabGenerator tabGenerator = new BirstSourcesTabGenerator();
        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(new Label("Space:"),loadComboxForSpaces());

        mainPane.getTabs().add(tabGenerator.loadTab());
        mainPane.getTabs().add(new BirstHierarchiesTabGenerator().loadTab());
        mainPane.getTabs().add(new BirstConnectTabGenerator().loadTab());


        StackPane stackPane = new StackPane();
        stackPane.setPadding(new Insets(5,10,3,10));
        stackPane.getChildren().addAll(hbox);
        stackPane.setAlignment(Pos.CENTER);

        SplitPane sp = new SplitPane();
        sp.setOrientation(Orientation.VERTICAL);
        sp.getItems().addAll(stackPane,mainPane);
        sp.setDividerPositions(0.05f, 0.95f);

        primaryStage.setTitle("Birst Desktop Client");
        primaryStage.setScene(new Scene(sp, 1000, 650));
        primaryStage.show();

    }


    private void initialize(){
        birstProperties = BirstProperties.getInstance();
        dataSourceContainer = new DataSourceContainer();
        dataSourceContainer.loadXmlDocument();
        exportManagement = new ExportManager(dataSourceManagement);
        }

    private ComboBox loadComboxForSpaces(){
        List<UserSpace> spaces = spaceManagement.listSpaces(birstProperties.getLoginToken());

      //  List<String> names = spaces.stream().map(  e ->{ return e.getName();}).collect(Collectors.toList());
        ObservableList<UserSpace> options = FXCollections.observableArrayList(spaces);
        final ComboBox<UserSpace> comboBox = new ComboBox(options);
        comboBox.setConverter(new UserSpaceConverter());

        comboBox.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                UserSpace currentSpace = (UserSpace) newValue;
                if(currentSpace != null){
                    birstProperties.setCurrentSpace(currentSpace);
                }

            }
        });

        comboBox.getSelectionModel().select(0);
        birstProperties.setCurrentSpace(spaces.get(0));
        return comboBox;
    }

    public static void main(String[] args) {

        launch(args);
    }


}
