package com.infor.admin;

import com.birst.ArrayOfCloudConnection;
import com.birst.CloudConnection;
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

    public void extractCloudConnectorData(String token, String spaceId, String connectionName){
        ArrayOfCloudConnection cloudConnections = new  ArrayOfCloudConnection();
        CloudConnection cc = new CloudConnection();
        cc.setConnectionName(connectionName);
        cloudConnections.getCloudConnection().add(cc);
        client.extractCloudConnectorData(token,spaceId,cloudConnections);
    }

    public void clearCacheInSpace(String token, String spaceId){
        client.clearCacheInSpace(token,spaceId);
    }

}
