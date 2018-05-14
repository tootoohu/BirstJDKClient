package com.infor.util;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSourceContainer {

    private static DataSourceContainer container;

    private  Map<SourceEntry, List<SourceColumnEntry>> localCubeMap;
    private  Map<SourceEntry, List<SourceColumnEntry>> localDimensionMap;

    private List<HierarchyMetadata> hierarchies = new ArrayList<>();

    private List<StagingTableSubClass> sources = new ArrayList<>();

    private  Map<String, StagingTableSubClass> birstXmlSourceMap;

    private  Map<String, HierarchyMetadata> birstXmlHierarchyMap;

    private Map<String, String> spaceMap;

    public Map<String, String> getSpaceMap() {
        return spaceMap;
    }

    public void setSpaceMap(Map<String, String> spaceMap) {
        this.spaceMap = spaceMap;
    }

    public static DataSourceContainer getContainer() {
        return container;
    }

    public static void setContainer(DataSourceContainer container) {
        DataSourceContainer.container = container;
    }

    public Map<String, StagingTableSubClass> getBirstXmlSourceMap() {
        return birstXmlSourceMap;
    }

    public void setBirstXmlSourceMap(Map<String, StagingTableSubClass> birstXmlSourceMap) {
        this.birstXmlSourceMap = birstXmlSourceMap;
    }

    public Map<String, HierarchyMetadata> getBirstXmlHierarchyMap() {
        return birstXmlHierarchyMap;
    }

    public void setBirstXmlHierarchyMap(Map<String, HierarchyMetadata> birstXmlHierarchyMap) {
        this.birstXmlHierarchyMap = birstXmlHierarchyMap;
    }

    //    public static synchronized DataSourceContainer getInstance(){
//        if(container == null){
//            loadXmlDocument();
//            container = new DataSourceContainer();
//        }
//        return container;
//    }

    public Map<SourceEntry, List<SourceColumnEntry>> getLocalCubeMap() {
        return localCubeMap;
    }


    public Map<SourceEntry, List<SourceColumnEntry>> getLocalDimensionMap() {
        return localDimensionMap;
    }

    public void loadXmlDocument(){
        PlainXmlReader reader = null;
        if(localCubeMap != null)
            return;
        localCubeMap = new HashMap();
        localDimensionMap = new HashMap();

        try {
            reader = new PlainXmlReader();
            localCubeMap =  reader.getSourceMap("/resources/xml/Cubes.xml", true);
            localDimensionMap =  reader.getSourceMap("/resources/xml/Dimensions.xml", false);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }

    }

    public void loadBirstXmlDocument(){

    }

    public List<SourceColumnEntry> getByKey(SourceEntry se){
        List<SourceColumnEntry> ret;
        if(se.isCube()){
            ret = localCubeMap.get(se);
        }else {
            ret = localDimensionMap.get(se);
        }
        return ret;

    }

    public List<HierarchyMetadata> getHierarchies() {
        return hierarchies;
    }

    public void setHierarchies(List<HierarchyMetadata> hierarchies) {
        this.hierarchies = hierarchies;
    }

    public List<StagingTableSubClass> getSources() {
        return sources;
    }

    public void setSources(List<StagingTableSubClass> sources) {
        this.sources = sources;
    }
}
