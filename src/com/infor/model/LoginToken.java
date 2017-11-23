package com.infor.model;

import com.infor.admin.CommandWebServiceClient;

public class LoginToken {

    private String token;


    public void LoginToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void Login(String userName, String pwd){
        this.token = CommandWebServiceClient.getInstance().login(userName,pwd);
    }
}
