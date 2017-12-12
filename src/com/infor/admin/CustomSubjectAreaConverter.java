package com.infor.admin;


import com.birst.ODBCColumnResult;
import com.birst.ODBCTableResult;
import com.infor.model.webservice.CustomSubjectArea;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


public class CustomSubjectAreaConverter {

    public static CustomSubjectArea Convert2CustomSubjectArea(ODBCTableResult metaDataResult){
        CustomSubjectArea customSubjectArea = new CustomSubjectArea();
        customSubjectArea.setTableName(metaDataResult.getTableName());
        customSubjectArea.setFact(metaDataResult.isIsFact());
        List<ODBCColumnResult> list = metaDataResult.getColumns().getODBCColumnResult();
        List<CustomSubjectArea.CustomColumn> columns = new ArrayList<>();
        for (ODBCColumnResult result : list){
            if(result.getBirstColumnName().indexOf("Time.") == 0 || result.getColumnName().indexOf("Time Series/") == 0){
                continue;
            }
            columns.add(new CustomSubjectArea.CustomColumn(result.getColumnName(),result.getBirstColumnName(),result.getDataType(),
                    result.getWidth(),result.getAggsSupported().getString(),result.getKey(),result.isIsFact()));

        }
        customSubjectArea.setColumns(columns);
        return customSubjectArea;
    }



    public static void Output2File(String name, List<CustomSubjectArea> subjectAreas) throws IOException, WriteException {

       if(subjectAreas == null || subjectAreas.size() == 0){
           return;
       }

       File file = new File(name);
       WritableWorkbook wwb =  wwb = Workbook.createWorkbook(file);  ;
        WritableSheet ws = wwb.createSheet("Subject Areas", 0);

        ws.addCell(new Label(0, 0, "Subject"));
        ws.addCell(new Label(1, 0, "Attribute Name"));
        ws.addCell(new Label(2, 0, "Attribute Birst Name"));
        ws.addCell(new Label(3, 0, "FullyQualifiedObjectName"));
        int  row = 1;

        final String prefix = "Subject Area: ";
        final String default_prefix = "Subject Area: Default Subject Area";

        for(CustomSubjectArea customSubjectArea: subjectAreas){
            ws.addCell(new Label(0, row, customSubjectArea.getTableName()));
            List<CustomSubjectArea.CustomColumn> customColumns = customSubjectArea.getColumns();

            Iterator ite = customColumns.iterator();
            while (ite.hasNext()){
                CustomSubjectArea.CustomColumn column = (CustomSubjectArea.CustomColumn)ite.next();
                ws.addCell(new Label(1, row, column.getColumnName()));
                ws.addCell(new Label(2, row, column.getBirstColumnName()));
                String temp = customSubjectArea.getTableName().replace(default_prefix,"");
                if (temp.length() > 0){
                    temp = temp.replace(prefix,"") + '.';

                }
                ws.addCell(new Label(3, row++, temp +column.getColumnName().replace('/','.')));
            }
        }
        wwb.write();
        wwb.close();


    }
}
