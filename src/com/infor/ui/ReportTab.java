package com.infor.ui;

import com.infor.admin.ReportManagement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.List;

public class ReportTab {

    @FXML
    private TreeView<String> reportTreeView;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn baseColumn;
    @FXML
    private TableColumn result1Column;
    @FXML
    private TableColumn result2Column;

    private ReportManagement reportManagement = new ReportManagement();

    @FXML
    private void initialize(){

        loadTree();
        loadTableView();
    }

    private void loadTree(){

        TreeItem<String> root = new TreeItem<>("All");
        root.setExpanded(true);
        TreeItem<String> ceo = new TreeItem<>("CEO");
        root.getChildren().add(ceo);
        ceo.getChildren().add(new TreeItem<>("Profit Over Time"));
        ceo.getChildren().add(new TreeItem<>("Cash Flow by Fiscal Period"));
        reportTreeView.setRoot(root);

    }

    private void loadTableView(){
        List<Result> list = new ArrayList<>();
        list.add(new Result("2016/01", "25209.256","74487.482"));
        list.add(new Result("2016/02", "30546.248","73487.542"));
        list.add(new Result("2016/03", "85781.156","78987.154"));
        baseColumn.setCellValueFactory(new PropertyValueFactory<>("Base"));
        result1Column.setCellValueFactory(new PropertyValueFactory<>("Result1"));
        result2Column.setCellValueFactory(new PropertyValueFactory<>("Result2"));
        tableView.setItems(FXCollections.observableArrayList(list));

    }

    public class Result{
        private String base;
        private String result1;
        private String result2;

        public Result(String base,String result1,String result2){
            this.base = base;
            this.result1 = result1;
            this.result2 = result2;
        }

        public String getBase() {
            return base;
        }

        public void setBase(String base) {
            this.base = base;
        }

        public String getResult1() {
            return result1;
        }

        public void setResult1(String result1) {
            this.result1 = result1;
        }

        public String getResult2() {
            return result2;
        }

        public void setResult2(String result2) {
            this.result2 = result2;
        }
    }
}
