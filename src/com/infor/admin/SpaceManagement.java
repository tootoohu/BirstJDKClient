package com.infor.admin;

import com.birst.ArrayOfCloudConnection;
import com.birst.CloudConnection;
import com.birst.CommandWebServiceSoap;
import com.birst.UserSpace;

import java.util.List;

public class SpaceManagement extends AbstractManagement{

    public void setLanguageForUser(String token, String user, String locale){
        this.getClient().setLanguageForUser(token,user,locale);
    }

    public void deleteSpace(String token, String spaceId){
        getClient().deleteSpace(token,spaceId);
    }

    public void deleteSubjectArea(String token, String spaceId, String name){
        getClient().deleteSubjectArea(token,spaceId,name);

    }

    public void executeQueryInSpace(String token, String query, String spaceId){
        getClient().executeQueryInSpace(token,query,spaceId);
    }

    public void extractCloudConnectorData(String token, String spaceId, String connectionName){
        ArrayOfCloudConnection cloudConnections = new  ArrayOfCloudConnection();
        CloudConnection cc = new CloudConnection();
        cc.setConnectionName(connectionName);
        cloudConnections.getCloudConnection().add(cc);
        getClient().extractCloudConnectorData(token,spaceId,cloudConnections);
    }

    public void clearCacheInSpace(String token, String spaceId){
        getClient().clearCacheInSpace(token,spaceId);
    }

    public List<UserSpace> listSpaces(String token){

        List<UserSpace> list = getClient().listSpaces(token).getUserSpace();
        return list;
    }
}
