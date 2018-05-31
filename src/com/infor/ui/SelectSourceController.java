package com.infor.ui;

import com.infor.model.ui.LevelColumn;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class SelectSourceController {

    @FXML
    private ComboBox sourceCombox;

    @FXML
    private TableView<LevelColumn> columnTableView;
    @FXML
    private TableColumn nameColumn;
    @FXML
    private TableColumn<LevelColumn,CheckBox> selectColumn;
    @FXML
    private Button runButton;

    @FXML
    private TextArea queryArea;
    @FXML
    private void initialize(){
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        selectColumn.setEditable(true);
        //  selectColumn.setCellValueFactory(new PropertyValueFactory<LevelColumn,Boolean>("Select"));

        selectColumn.setCellValueFactory(cellData ->cellData.getValue().select.getCheckBox());

        List<LevelColumn> list = new ArrayList<>();
        list.add(new LevelColumn("Account"));
        list.add(new LevelColumn("Unit Code 1"));
        list.add(new LevelColumn("Unit Code 2"));
        list.add(new LevelColumn("Unit Code 3"));
        list.add(new LevelColumn("Unit Code 4"));
        list.add(new LevelColumn("Date"));
        list.add(new LevelColumn("Fiscal Period"));
        list.add(new LevelColumn("Actual Amount"));
        list.add(new LevelColumn("Budget Amount"));
        list.add(new LevelColumn("Plan Amount"));
        list.add(new LevelColumn("Actual Revenue"));
        list.add(new LevelColumn("Actual Amount Average"));
        list.add(new LevelColumn("Actual Amount End"));
        list.add(new LevelColumn("Actual Amount Origin"));
        list.add(new LevelColumn("Actual Assets"));
        columnTableView.setItems(FXCollections.observableArrayList(list));
    }


}
