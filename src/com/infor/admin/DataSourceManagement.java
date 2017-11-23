package com.infor.admin;

import com.birst.ArrayOfString;
import com.birst.StagingTableSubClass;
import com.infor.admin.CommandWebServiceClient;

import java.util.List;

public class DataSourceManagement {

    public List<String> getSourcesList(String token, String spaceId){
        ArrayOfString sources = CommandWebServiceClient.getInstance().getSourcesList(token,spaceId);
        List<String> ret = sources.getString();
        return ret;
    }

    public List<String> getAllHierarchies(String token, String spaceId){
        List<String> ret = CommandWebServiceClient.getInstance().getAllHierarchies(token,spaceId).getString();
        return ret;
    }

    public void deleteHierarchy(String token, String spaceId, String hName){
        CommandWebServiceClient.getInstance().deleteHierarchy(token,spaceId,hName);
    }

    public List<String> getSubjectAreaPermissions(String token, String spaceId, String name){
        return CommandWebServiceClient.getInstance().getSubjectAreaPermissions(token,spaceId,name).getString();
    }

    public StagingTableSubClass getSourceDetails(String token, String spaceId, String sourceName){
        return CommandWebServiceClient.getInstance().getSourceDetails(token,spaceId,sourceName);
    }
}
