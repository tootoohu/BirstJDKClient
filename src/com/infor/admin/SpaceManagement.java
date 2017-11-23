package com.infor.admin;

import com.birst.CommandWebServiceSoap;
import com.birst.UserSpace;

import java.util.List;

public class SpaceManagement {

    private CommandWebServiceSoap client = CommandWebServiceClient.getInstance();

    public void setLanguageForUser(String token, String user, String locale){
        this.client.setLanguageForUser(token,user,locale);
    }

    public void deleteSpace(String token, String spaceId){
        client.deleteSpace(token,spaceId);
    }

    public void deleteSubjectArea(String token, String spaceId, String name){
        client.deleteSubjectArea(token,spaceId,name);
    }

    public void executeQueryInSpace(String token, String query, String spaceId){
        client.executeQueryInSpace(token,query,spaceId);
    }

    public List<UserSpace> listAllSpaces(String token){
        return client.listAllSpaces(token).getUserSpace();
    }
}
