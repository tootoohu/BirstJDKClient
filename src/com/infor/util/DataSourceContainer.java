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

    private  Map<SourceEntry, List<SourceColumnEntry>> cubeMap;
    private  Map<SourceEntry, List<SourceColumnEntry>> dimensionMap;

    private List<HierarchyMetadata> hierarchies = new ArrayList<>();

    private List<StagingTableSubClass> sources = new ArrayList<>();

    //    public static synchronized DataSourceContainer getInstance(){
//        if(container == null){
//            loadXmlDocument();
//            container = new DataSourceContainer();
//        }
//        return container;
//    }

    public Map<SourceEntry, List<SourceColumnEntry>> getCubeMap() {
        return cubeMap;
    }


    public Map<SourceEntry, List<SourceColumnEntry>> getDimensionMap() {
        return dimensionMap;
    }

    public void loadXmlDocument(){
        PlainXmlReader reader = null;
        if(cubeMap != null)
            return;
        cubeMap = new HashMap();
        dimensionMap = new HashMap();

        try {
            reader = new PlainXmlReader();
            cubeMap =  reader.getSourceMap("/resources/xml/Cubes.xml", true);
            dimensionMap =  reader.getSourceMap("/resources/xml/Dimensions.xml", false);
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
            ret = cubeMap.get(se);
        }else {
            ret = dimensionMap.get(se);
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
