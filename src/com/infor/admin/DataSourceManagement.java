package com.infor.admin;

import com.birst.*;
import com.infor.model.webservice.CustomSubjectArea;
import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceDetail;
import com.infor.model.webservice.SourceEntry;
import com.infor.util.DataSourceContainer;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class DataSourceManagement extends AbstractManagement{

    public List<String> getSourcesList(String token, String spaceId){
        ArrayOfString sources = getClient().getSourcesList(token,spaceId);
        List<String> ret = sources.getString();
        return ret;
    }

    public List<String> getAllHierarchies(String token, String spaceId){
        List<String> ret = getClient().getAllHierarchies(token,spaceId).getString();
        return ret;
    }

    public void deleteHierarchy(String token, String spaceId, String hName){
        getClient().deleteHierarchy(token,spaceId,hName);
    }

    public List<String> getSubjectAreaPermissions(String token, String spaceId, String name){
        return getClient().getSubjectAreaPermissions(token,spaceId,name).getString();
    }

    public StagingTableSubClass getSourceDetails(String token, String spaceId, String sourceName){
        StagingTableSubClass stagingTableSubClass = getClient().getSourceDetails(token,spaceId,sourceName);
        return stagingTableSubClass;
    }

    public void setSourceDetails(String token, String spaceId, SourceEntry sourceEntry, List<SourceColumnEntry> columns){
        if(token == null || spaceId == null || sourceEntry == null || columns == null)
            return;

        StagingTableSubClass tableSubClass = new StagingTableSubClass();
        tableSubClass.setName(sourceEntry.getName());
        ArrayOfSourceColumnSubClass columnSubClass = new ArrayOfSourceColumnSubClass();
        //add level for grain
        ArrayOfArrayOfString levels = new ArrayOfArrayOfString();
        ArrayOfString timeLevel = new ArrayOfString();

        timeLevel.getString().add("Time");
        timeLevel.getString().add("Day");

        ArrayOfString selfLevel = new ArrayOfString();

        selfLevel.getString().add(sourceEntry.getName());
        selfLevel.getString().add(sourceEntry.getName());


        levels.getArrayOfString().add(timeLevel);
        levels.getArrayOfString().add(selfLevel);

        for (SourceColumnEntry entry: columns){
            if (entry.isKey()){
                ArrayOfString keylevel = new ArrayOfString();
                keylevel.getString().add(entry.getName());
                keylevel.getString().add(entry.getName());
                levels.getArrayOfString().add(keylevel);
            }

        }

        for (SourceColumnEntry entry: columns){
            SourceColumnSubClass scs = new SourceColumnSubClass();
            scs.setName(entry.getName());
            scs.setDataType(entry.getType());
            scs.setWidth(entry.getWidth());
            scs.setMeasure(entry.isMeasure());
            scs.setAnalyzeByDate(entry.isAnalyzeByDate());
            scs.setAnalyzeMeasure(entry.isMeasure());
            scs.setHierarchyName(entry.getHierarchyName(sourceEntry.getName()));
            scs.setAnalyzeMeasure(entry.isMeasure());
            scs.setFormat("");
            scs.setLevelName(entry.getHierarchyName(sourceEntry.getName()));
            scs.setOriginalName(entry.getName());
            scs.setUnknownValue("Unknown Value");
            scs.setSourceFileColumn(null);
            ArrayOfString targetTypes = new ArrayOfString();
            targetTypes.getString().add(entry.getDimension());
            scs.setTargetTypes(targetTypes);
            scs.setEnableSecutityFilter(false);
            scs.setLockType(false);

            scs.setLevels(levels);
            columnSubClass.getSourceColumnSubClass().add(scs);
        }

        tableSubClass.setColumns(columnSubClass);
        tableSubClass.setOriginalName(sourceEntry.getName());
        tableSubClass.setDisabled(false);


        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(new Date().getTime());
        try {
            tableSubClass.setLastModifiedDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(gc));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

//        ScriptDefinition sd = new ScriptDefinition();
//        sd.setInputQuery("SELECT Site FROM BI_Fact_Financial_Income_Analysis_Full_QA_View");
//        sd.setOutput("Site");
//        sd.setScript("SELECT Site FROM BI_Fact_Financial_Income_Analysis_Full_QA_View");
        tableSubClass.setScript(null);
        ArrayOfString as = new ArrayOfString();
        as.getString().add("All Cubes");
        tableSubClass.setSubGroups(as);

        getClient().setSourceDetails(token,spaceId,tableSubClass);
    }

    public void updateHierarchy(String token, String spaceId,SourceEntry sourceEntry, List<SourceColumnEntry> columns){
        HierarchyMetadata hierarchyMetadata = getHierarchyMetadata(sourceEntry,columns);
        getClient().updateHierarchy(token,spaceId,sourceEntry.getName(), hierarchyMetadata);
    }


    public List<CustomSubjectArea> getODBCTableResult(String token, String spaceId){
        MetaDataResult result = getClient().getODBCMetaDataSubjectAreas(token,spaceId);
        List<ODBCTableResult> tables = result.getTables().getODBCTableResult();

        List<CustomSubjectArea> rets = new ArrayList<>();
        tables.forEach(k -> rets.add(CustomSubjectAreaConverter.Convert2CustomSubjectArea(k)));

        return rets;
    }

    public void getODBCMetaData(String token,String spaceId){


    }
    public void createHierarchy(String token, String spaceId,SourceEntry sourceEntry, List<SourceColumnEntry> columns ){
        if(token == null || spaceId == null || sourceEntry == null || columns == null)
            return;
        HierarchyMetadata hierarchyMetadata = getHierarchyMetadata(sourceEntry,columns);
        getClient().createHierarchy(token,spaceId,hierarchyMetadata);

    }

    public HierarchyMetadata getHierarchy(String token, String spaceId, String hName){
        HierarchyMetadata hierarchyMetadata = getClient().getHierarchy(token,spaceId,hName);
        return hierarchyMetadata;
    }

    private HierarchyMetadata getHierarchyMetadata(SourceEntry sourceEntry, List<SourceColumnEntry> columns){
        HierarchyMetadata hierarchyMetadata = new HierarchyMetadata();
        hierarchyMetadata.setName(sourceEntry.getName());
        ArrayOfLevelMetadata metadata = new ArrayOfLevelMetadata();
        LevelMetadata levelMetadata = new LevelMetadata();
        levelMetadata.setName(sourceEntry.getName());
        levelMetadata.setCardinality("1");
        ArrayOfString keyColumns = new ArrayOfString();
        columns.forEach(k -> {
            if(k.isKey())
                keyColumns.getString().add(k.getName()) ;
        });

        levelMetadata.setColumnNames(keyColumns);
        metadata.getLevelMetadata().add(levelMetadata);
        hierarchyMetadata.setChildren(metadata);
        return hierarchyMetadata;
    }

    public void createHierarchies(String token, String spaceId, String name){
        HierarchyMetadata hierarchyMetadata = new HierarchyMetadata();
        hierarchyMetadata.setName(name);

        getClient().createHierarchy(token,spaceId,hierarchyMetadata);

    }

    public DataSourceContainer ReadFromSpace(String tokenId, String spaceId ){
        DataSourceContainer dataSourceContainer = new DataSourceContainer();

        List<String> hierarchyList = getAllHierarchies(tokenId,spaceId);
        for (String hName : hierarchyList){

            HierarchyMetadata hm = getHierarchy(tokenId,spaceId,hName);
            dataSourceContainer.getHierarchies().add(hm);

        }
        List<String> sourceList = getSourcesList(tokenId,spaceId);

        for(String sName : sourceList){
            StagingTableSubClass sts = getSourceDetails(tokenId,spaceId,sName);
            dataSourceContainer.getSources().add(sts);
        }
        return dataSourceContainer;
    }

}
