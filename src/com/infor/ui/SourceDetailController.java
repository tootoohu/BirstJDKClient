package com.infor.ui;

import com.infor.model.ui.LevelColumn;
import com.infor.model.ui.SourceDetail;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;


public class SourceDetailController {

    @FXML
    private TableView<SourceDetail> tableView;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn hierarchyColumn;
    @FXML
    private TableColumn widthColumn;
    @FXML
    private TableColumn typeColumn;
    @FXML
    private TableColumn<SourceDetail,CheckBox> measureColumn;
    @FXML
    private TableColumn<SourceDetail,CheckBox> analyzeMeasureColumn;
    @FXML
    private TableColumn<SourceDetail,CheckBox> analyzeByDateColumn;
    @FXML
    private TableColumn<SourceDetail,CheckBox> keyColumn;

    @FXML
    private void initialize(){

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        hierarchyColumn.setCellValueFactory(new PropertyValueFactory<>("Hierarchy"));
        widthColumn.setCellValueFactory(new PropertyValueFactory<>("Width"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));

        measureColumn.setEditable(true);
        measureColumn.setCellValueFactory(cellData ->cellData.getValue().getMeasure().getCheckBox());

        analyzeMeasureColumn.setEditable(true);
        analyzeMeasureColumn.setCellValueFactory(cellData ->cellData.getValue().getAnalyzeMeasure().getCheckBox());

        analyzeByDateColumn.setEditable(true);
        analyzeByDateColumn.setCellValueFactory(cellData ->cellData.getValue().getAnalyzeByDate().getCheckBox());

        keyColumn.setEditable(true);
        keyColumn.setCellValueFactory(cellData ->cellData.getValue().getKeyColumn().getCheckBox());

        List<SourceDetail> list = new ArrayList<>();
        list.add(new SourceDetail("Account", "Account",21,"Varchar"));
        list.add(new SourceDetail("Unit Code 1","Unit Code 1",16,"Varchar"));
        list.add(new SourceDetail("Unit Code 2","Unit Code 2",16,"Varchar"));
        list.add(new SourceDetail("Unit Code 3","Unit Code 3",16,"Varchar"));
        list.add(new SourceDetail("Unit Code 4", "Unit Code 4",16,"Varchar"));
        list.add(new SourceDetail("Actual Amount","Financial Income Analysis",25,"Float"));
        list.add(new SourceDetail("Budget Amount","Financial Income Analysis",16,"Varchar"));
        list.add(new SourceDetail("Fiscal Period","Financial Income Analysis",7,"Date"));
        list.add(new SourceDetail("Actual Revenue","Financial Income Analysis",24,"Float"));
        list.add(new SourceDetail("Budget Revenue","Financial Income Analysis",24,"Float"));
        list.add(new SourceDetail("Plan Amount","Financial Income Analysis",24,"Float"));
        list.add(new SourceDetail("Actual Amount Average","Financial Income Analysis",24,"Float"));
        list.add(new SourceDetail("Actual Amount End","Financial Income Analysis",24,"Float"));
        list.add(new SourceDetail("Actual Amount Origin","Financial Income Analysis",24,"Float"));
        list.add(new SourceDetail("Actual Assets","Financial Income Analysis",24,"Float"));
        tableView.setItems(FXCollections.observableArrayList(list));

    }
}
