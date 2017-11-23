package com.infor.admin;

import com.birst.CommandWebServiceSoap;

public class ReportManagement {

    private CommandWebServiceSoap client = CommandWebServiceClient.getInstance();

    public void getReportData(String token, String spaceID, String reportName, String reportFilters){
        client.getReportData(token, spaceID, reportName,null);

    }
}
