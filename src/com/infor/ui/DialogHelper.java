package com.infor.ui;

import javafx.scene.control.Alert;

public class DialogHelper {

    public static void showResultDialog(String replace, boolean succeed){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        String result = succeed ? " Succeed!": " Fail!";
        alert.setContentText(replace +  result);
        alert.showAndWait();


    }
}
