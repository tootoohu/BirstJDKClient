package com.infor.ui;

import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.LoginToken;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginForm extends Application {

    @FXML
    private Label nameLable;
    @FXML
    private Label pwdLable;
    @FXML
    private TextField nameField;
    @FXML
    private PasswordField pwdField;
    @FXML
    private Button loginButton;
    @FXML
    private GridPane rootPane;
    private static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        initPane();
    }

    private void initPane(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginForm.class.getResource("LoginForm.fxml"));
        try {
            rootPane = (GridPane) loader.load();

            Scene scene = new Scene(rootPane);
            rootPane.setStyle("-fx-background-color: white;");
            scene.getStylesheets().add("Style.css");
            primaryStage.setTitle("Birst Desktop Client");

            Image image = new Image(LoginForm.class.getResourceAsStream("/resources/images/Icon.png"));
            primaryStage.getIcons().add(image);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void login(){
        String name = nameField.getText();
        String pwd = pwdField.getText();
        LoginToken loginToken = new LoginToken();
        loginToken.Login(name,pwd);
        if(loginToken.getToken() != null){
            BirstProperties.getInstance().setLoginToken(loginToken.getToken());
            BirstProperties.getInstance().setUser(name);
            BirstProperties.getInstance().setPassword(pwd);
     //       Main main = new Main();
            //Obsolete former form
//            try {
//                main.start(primaryStage);
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            showMainForm();
        }
    }

    private void showMainForm(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(LoginForm.class.getResource("MainForm.fxml"));
        try {
            SplitPane sp = (SplitPane) loader.load();
            Scene scene = new Scene(sp);
            this.primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        launch(args);
    }


}
