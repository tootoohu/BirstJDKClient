package com.infor.admin;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.infor.util.BirstXmlReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.IOException;
import java.util.Map;

public class BirstDataLoadManagement {

    public void loadFromFile(String path){
        try {
            BirstXmlReader reader = new BirstXmlReader();
            Map<String, StagingTableSubClass> sourceMap = reader.readSources(path);
            Map<String, HierarchyMetadata> hierarchyMap = reader.readHierarchies(path);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
