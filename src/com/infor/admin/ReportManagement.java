package com.infor.admin;

import com.birst.CommandQueryResult;
import com.birst.CommandWebServiceSoap;

public class ReportManagement {

    private CommandWebServiceSoap client = CommandWebServiceClient.getInstance();

    public CommandQueryResult getReportData(String token, String spaceID, String reportName, String reportFilters){
        return client.getReportData(token, spaceID, reportName,null);

    }

    public void saveQueryReport(String token, String spaceId, String path, String name,String query){

        client.saveQueryReport(token,spaceId,path,name,query);
    }
}
