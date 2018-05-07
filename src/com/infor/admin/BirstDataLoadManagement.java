package com.infor.admin;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.infor.util.BirstXmlReader;
import com.infor.util.DataSourceContainer;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.Map;

public class BirstDataLoadManagement {


    public static DataSourceContainer loadFromFile(String path){
        DataSourceContainer container = null;
        try {
            BirstXmlReader reader = new BirstXmlReader();
            Map<String, StagingTableSubClass> sourceMap = reader.readSources(path + "Sources.xml");
            Map<String, HierarchyMetadata> hierarchyMap = reader.readHierarchies(path + "Hierarchhies.xml");

            container = new DataSourceContainer();
            container.setBirstXmlHierarchyMap(hierarchyMap);
            container.setBirstXmlSourceMap(sourceMap);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return container;
    }
}
