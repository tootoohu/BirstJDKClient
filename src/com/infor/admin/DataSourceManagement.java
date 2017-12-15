package com.infor.admin;

import com.birst.*;
import com.infor.model.webservice.CustomSubjectArea;
import com.infor.model.webservice.SourceDetail;

import java.util.ArrayList;
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

    public SourceDetail getSourceDetails(String token, String spaceId, String sourceName){
        StagingTableSubClass stagingTableSubClass = CommandWebServiceClient.getInstance().getSourceDetails(token,spaceId,sourceName);
        return SourceDetailConverter.Convert2SourceDetail(stagingTableSubClass);
    }

    public void setSourceDetails(String token, String spaceId, String sourceName){
        StagingTableSubClass tableSubClass;
        CommandWebServiceClient.getInstance().setSourceDetails(token,spaceId,null);
    }

    public List<CustomSubjectArea> getODBCTableResult(String token, String spaceId){
        MetaDataResult result = CommandWebServiceClient.getInstance().getODBCMetaDataSubjectAreas(token,spaceId);
        List<ODBCTableResult> tables = result.getTables().getODBCTableResult();

        List<CustomSubjectArea> rets = new ArrayList<>();
        tables.forEach(k -> rets.add(CustomSubjectAreaConverter.Convert2CustomSubjectArea(k)));

        return rets;
    }

    public void getODBCMetaData(String token,String spaceId){


    }
    public void createHierarchy(String token, String spaceId, HierarchyMetadata hierarchyMetadata){
        CommandWebServiceClient.getInstance().createHierarchy(token,spaceId,hierarchyMetadata);

    }

}
