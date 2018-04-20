package com.infor.util;

import com.birst.ArrayOfLevelMetadata;
import com.birst.HierarchyMetadata;
import com.birst.LevelMetadata;
import com.birst.StagingTableSubClass;
import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public  class XMLParser {

    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    private static DocumentBuilder db;

    private Document doc;

    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private static Transformer former;

    public XMLParser() throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException {

        db = documentBuilderFactory.newDocumentBuilder();
        former = transformerFactory.newTransformer();

    }

    public Document getDoc(String inputXmlPath) {
        try {
            return db.parse(inputXmlPath);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public  Map<SourceEntry, List<SourceColumnEntry>> getSourceList(String path,boolean isCube){
        URL url = XMLParser.class.getResource(path);
        File f = new File(url.getPath());
        Document doc = getDoc(f.getAbsolutePath());
        return getSourceList(doc, isCube);
    }

    public Map<SourceEntry, List<SourceColumnEntry>> getSourceList(Document doc, boolean isCube){
        Element rootElement = doc.getDocumentElement();
        String root = rootElement.getNodeName();
        Map<SourceEntry, List<SourceColumnEntry>> maps = new HashMap<>();
        NodeList nodes = rootElement.getChildNodes();
        for (int i=0; i < nodes.getLength(); i++)
        {

            Node node = nodes.item(i);
            String sourceName = node.getNodeName();
            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;
          //  if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element cube = (Element) node;
                sourceName = cube.getAttribute("name");


          //  }

            NodeList subNodes = node.getChildNodes();
            List<SourceColumnEntry> columns = new ArrayList<>();
            for(int j=0;j<subNodes.getLength();j++){
                Node entry = subNodes.item(j);

                if (entry.getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) entry;
                    String name = child.getAttribute("name");
                    String type = child.getAttribute("type");

                    Integer width = Integer.valueOf(child.getAttribute("width"));
                    String dimension = child.getAttribute("dimension");
                    boolean isKey = "Y".equalsIgnoreCase(child.getAttribute("key"));
                    SourceColumnEntry sce = new SourceColumnEntry(name,type,width);
                    sce.setKey(isKey);
                    sce.setAnalyzeByDate(type.equalsIgnoreCase("Date"));
                    sce.setMeasure(type.equalsIgnoreCase("Float"));
                    sce.setDimension(dimension);
                    columns.add(sce);

                }
            }

            maps.put(new SourceEntry(sourceName, isCube),columns);


        }
       return  maps;
    }

    public void WriteSource(StagingTableSubClass stagingTableSubClass){


    }

    public void WriteSourceList(String spaceID, List<StagingTableSubClass> list){
        File f = new File("/resources/xml/source/"+spaceID + "_Source.xml");



    }

    public void WriteHierarchy(){

    }

    public void WriteHierarchyList(String spaceName, List<HierarchyMetadata> hierarchies) throws TransformerException {
        File directory = new File( Paths.get("").toAbsolutePath().toString() + "/resources/" + spaceName);
        if(!directory.exists()){
            directory.mkdirs();
        }
        File file = new File(Paths.get("").toAbsolutePath().toString() +  "/resources/" + spaceName +  "/Hierarchhies.xml");
        if(file.exists()){
            file.delete();
        }

        doc = db.newDocument();
        Element root = doc.createElement("Hierarchies");
        doc.appendChild(root);

        for(HierarchyMetadata hm: hierarchies){
            Element hierarchyNode = doc.createElement("Hierarchy");
            root.appendChild(hierarchyNode);
            Attr attr = doc.createAttribute("name");
            attr.setValue(hm.getName());
            hierarchyNode.setAttributeNode(attr);
            List<LevelMetadata> metadatas = hm.getChildren().getLevelMetadata();
            //xml node for <level>
            for (LevelMetadata lm : metadatas){
                Element levelNode = doc.createElement("level");
                Attr levelNameNode = doc.createAttribute("name");
                levelNameNode.setValue(lm.getName());
                levelNode.setAttributeNode(levelNameNode);
                Attr cardinality = doc.createAttribute("Cardinality");
                cardinality.setValue(lm.getCardinality());
                levelNode.setAttributeNode(cardinality);
                //column
                List<String> columnList = lm.getColumnNames().getString();
                for (String colstr : columnList){
                    Element column = doc.createElement("Column");
                    column.appendChild(doc.createTextNode(colstr));
                    levelNode.appendChild(column);
                }
                hierarchyNode.appendChild(levelNode);

            }

        }

        //write to xml
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            file.createNewFile();
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
