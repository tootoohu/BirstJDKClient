package com.infor;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.infor.admin.ExportManagement;
import com.infor.admin.DataSourceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import com.infor.ui.BirstHierarchiesTabGenerator;
import com.infor.ui.BirstSourcesTabGenerator;
import com.infor.ui.LocalTabGenerator;
import com.infor.util.BirstXmlReader;
import com.infor.util.DataSourceContainer;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class Main extends Application {

    private DataSourceContainer dataSourceContainer;
  //  private TableView<SourceColumnEntry> table = new TableView<>();
    private SourceEntry currentSourceEntry;
    private BirstProperties birstProperties;

    private DataSourceManagement dataSourceManagement =  new DataSourceManagement();
    private ExportManagement exportManagement;
    @Override
    public void start(Stage primaryStage) throws Exception{
        initialize();
        TabPane mainPane = new TabPane();
        mainPane.setPrefSize(1000, 1000);

        Tab localTab = new LocalTabGenerator().loadTab(dataSourceContainer);
       // mainPane.getTabs().add(loadAdminTab());
        mainPane.getTabs().add(localTab);
        BirstSourcesTabGenerator tabGenerator = new BirstSourcesTabGenerator();
        mainPane.getTabs().add(tabGenerator.loadTab());
        mainPane.getTabs().add(new BirstHierarchiesTabGenerator().loadTab());

        primaryStage.setTitle("Birst Desktop Client");
        primaryStage.setScene(new Scene(mainPane, 1000, 600));
        primaryStage.show();

    }

    private void initialize(){
        birstProperties = BirstProperties.getInstance();
        dataSourceContainer = new DataSourceContainer();
        dataSourceContainer.loadXmlDocument();
        exportManagement = new ExportManagement(dataSourceManagement);
        }

    public static void main(String[] args) {

        launch(args);
    }


}
