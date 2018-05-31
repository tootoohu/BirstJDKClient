package com.infor.test;

import com.birst.ArrayOfString;
import com.birst.CommandQueryResult;
import com.infor.admin.ReportManagement;
import org.junit.Test;

import java.util.List;

public class ReportManagementTest extends AbstractTest{
    @Test
    public void saveQueryReport() throws Exception {

       // String query = "SELECT TOP 10 USING OUTER JOIN [Incident Date: Sum: Incident Count] 'COL0' , [Unit.Unit] 'COL1' FROM [ALL] ORDER BY [Incident Date: Sum: Incident Count] DESC";
        String query = "SELECT USING OUTER JOIN [Close Date: Sum: SRO Count] 'COL0' , [Time.Year] 'COL1' FROM [ALL] ";
        String path = "/shared/Dashboard/Service/Service and Incident Analysis";
       // String name = "Open Incident Analysis-auto";
        String name = "Service Order Closed - auto1.viz";
        reportManagement.saveQueryReport(getToken(),getSpaceId(),path,name,query);

    }

    private static ReportManagement reportManagement = new ReportManagement();

    @Test
    public void getReportData() throws Exception {
        String path = "/shared/Dashboard/CEO/Cash Flow/Cash Flow by Fiscal Period.viz";

        CommandQueryResult result = reportManagement.getReportData(getToken(),getSpaceId(),path,"");
        List<ArrayOfString> rows = result.getRows().getArrayOfString();
        rows.forEach(k -> System.out.println(k.getString()));

        System.out.println(result.getNumRowsReturned());
    }

}