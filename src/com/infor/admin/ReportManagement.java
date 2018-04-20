package com.infor.admin;

import com.birst.CommandQueryResult;
import com.birst.CommandWebServiceSoap;

public class ReportManagement extends AbstractManagement{


    public CommandQueryResult getReportData(String token, String spaceID, String reportName, String reportFilters){
        return getClient().getReportData(token, spaceID, reportName,null);

    }

    public void saveQueryReport(String token, String spaceId, String path, String name,String query){

        getClient().saveQueryReport(token,spaceId,path,name,query);
    }
}
