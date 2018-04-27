package com.infor.admin;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import com.infor.util.DataSourceContainer;
import com.infor.util.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

public class ExportManagement {


    private DataSourceManagement dataSourceManagement;


    public ExportManagement(DataSourceManagement dsm){

        this.dataSourceManagement = dsm;
    }


    public void Export(String tokenId, String spaceId, String spaceName){
        DataSourceContainer dsc = dataSourceManagement.ReadFromSpace(tokenId, spaceId);
        try {
            XMLParser xmlParser = new XMLParser();
          //  xmlParser.WriteHierarchyList(spaceName, dsc.getHierarchies());
            xmlParser.WriteSourceList(spaceName,dsc.getSources());
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

}
