package com.infor.ui;

import com.infor.Main;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.LoginToken;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;


public class LoginForm extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(10,10,10,20));

        Label nameLable = new Label("Name:");

        TextField nameField = new TextField("shelley.hu@infor.com");
        GridPane.setConstraints(nameLable,0,0);
        pane.getChildren().add(nameLable);
        GridPane.setConstraints(nameField,1,0);
        pane.getChildren().add(nameField);

        //password
        Label pwdLable = new Label("Password:");

        PasswordField pwdField = new PasswordField();
        GridPane.setConstraints(pwdLable,0,1);
        pane.getChildren().add(pwdLable);
        GridPane.setConstraints(pwdField,1,1);
        pane.getChildren().add(pwdField);


        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(100);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String name = nameField.getText();
                String pwd = pwdField.getText();
                LoginToken loginToken = new LoginToken();
                loginToken.Login(name,pwd);
                if(loginToken.getToken() != null){
                    BirstProperties.getInstance().setLoginToken(loginToken.getToken());
                    Main main = new Main();
                    try {
                        main.start(primaryStage);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        GridPane.setConstraints(loginButton,1,2);

        pane.getChildren().add(loginButton);
      //  BackgroundImage img = new BackgroundImage(new Image("file:resources/images/birst_login_logo.svg"));
      //  pane.setBackground(new Background(img));
        //loginButton.

        primaryStage.setScene(new Scene(pane, 300, 150));
        primaryStage.getIcons().add(new Image("file:resources/images/birst_login_logo.svg"));
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
