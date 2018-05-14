package com.infor;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.birst.UserSpace;
import com.infor.admin.ExportManagement;
import com.infor.admin.DataSourceManagement;
import com.infor.admin.SpaceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import com.infor.ui.BirstConnectTabGenerator;
import com.infor.ui.BirstHierarchiesTabGenerator;
import com.infor.ui.BirstSourcesTabGenerator;
import com.infor.ui.LocalTabGenerator;
import com.infor.util.BirstXmlReader;
import com.infor.util.DataSourceContainer;
import javafx.application.Application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.List;
import java.util.stream.Collectors;


public class Main extends Application {

    private DataSourceContainer dataSourceContainer;
  //  private TableView<SourceColumnEntry> table = new TableView<>();
    private SourceEntry currentSourceEntry;
    private BirstProperties birstProperties;

    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();
    private ExportManagement exportManagement;
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
        mainPane.getTabs().add(tabGenerator.loadTab());
        mainPane.getTabs().add(new BirstHierarchiesTabGenerator().loadTab());
        mainPane.getTabs().add(new BirstConnectTabGenerator().loadTab());

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(new Label("Space:"),loadComboxForSpaces());
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
        exportManagement = new ExportManagement(dataSourceManagement);
        }

    private ComboBox loadComboxForSpaces(){
        List<UserSpace> spaces = spaceManagement.listSpaces(birstProperties.getLoginToken());

        List<String> names = spaces.stream().map(  e ->{ return e.getName();}).collect(Collectors.toList());
        ObservableList<String> options = FXCollections.observableArrayList(names);
        final ComboBox comboBox = new ComboBox(options);
        return comboBox;
    }

    public static void main(String[] args) {

        launch(args);
    }


}
