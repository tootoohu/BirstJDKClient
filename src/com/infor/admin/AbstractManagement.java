package com.infor.admin;

import com.birst.CommandWebServiceSoap;

public abstract class AbstractManagement implements WebServiceManagement {

    private CommandWebServiceSoap client = CommandWebServiceClient.getInstance();

    public CommandWebServiceSoap getClient(){
        return client;
    }

}
