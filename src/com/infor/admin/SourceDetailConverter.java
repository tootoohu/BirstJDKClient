package com.infor.admin;

import com.birst.SourceColumnSubClass;
import com.birst.StagingTableSubClass;
import com.infor.model.webservice.SourceDetail;

import java.util.ArrayList;
import java.util.List;

public class SourceDetailConverter {


    public static SourceDetail Convert2SourceDetail(StagingTableSubClass tableSubClass){

        SourceDetail sd = new SourceDetail();
        sd.setDisabled(tableSubClass.isDisabled());
        sd.setName(tableSubClass.getName());
        sd.setLastModifiedDate(tableSubClass.getLastModifiedDate().toGregorianCalendar().getTime());

        SourceDetail.ScriptDetail scriptDetail = new SourceDetail.ScriptDetail();
       // scriptDetail.setInputQuery(tableSubClass.getScript().getInputQuery());
//        scriptDetail.setOutput(tableSubClass.getScript().getOutput());
    //    scriptDetail.setScript(tableSubClass.getScript().getScript());
        sd.setScript(scriptDetail);

        List<SourceDetail.SourceColumn> sourceColumns = new ArrayList<>();
        SourceDetail.SourceColumn sourceColumn = new SourceDetail.SourceColumn();
        List<SourceColumnSubClass> columns = tableSubClass.getColumns().getSourceColumnSubClass();
        for (SourceColumnSubClass scb:columns) {
            sourceColumn.setAnalyzeByDate(scb.isAnalyzeByDate());
            sourceColumn.setDataType(scb.getDataType());
            sourceColumn.setEnableSecutityFilter(scb.isEnableSecutityFilter());
            sourceColumn.setFormat(scb.getFormat());
            sourceColumn.setHierarchyName(scb.getHierarchyName());
            sourceColumn.setLevelName(scb.getLevelName());
         //   sourceColumn.setLockType(scb);
            sourceColumns.add(sourceColumn);

        }
        sd.setColumns(sourceColumns);
        return sd;
    }

}
