package com.infor.util;

import com.infor.model.webservice.DataSource;
import com.infor.model.webservice.SourceColumnEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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


    public  Map<String, List<SourceColumnEntry>> getSourceList(String path){
        URL url = XMLParser.class.getResource(path);
        File f = new File(url.getPath());
        Document doc = getDoc(f.getAbsolutePath());
        return getSourceList(doc);
    }

    public Map<String, List<SourceColumnEntry>> getSourceList(Document doc){
        Element rootElement = doc.getDocumentElement();
        String root = rootElement.getNodeName();
        Map<String, List<SourceColumnEntry>> maps = new HashMap<>();
        NodeList nodes = rootElement.getChildNodes();
        for (int i=0; i < nodes.getLength(); i++)
        {

            Node node = nodes.item(i);
            String sourceName = node.getNodeName();
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element cube = (Element) node;
                sourceName = cube.getAttribute("name");
            }

            NodeList subNodes = node.getChildNodes();
            List<SourceColumnEntry> columns = new ArrayList<>();
            for(int j=0;j<subNodes.getLength();j++){
                Node entry = subNodes.item(j);
                SourceColumnEntry sce = new SourceColumnEntry();
                if (entry.getNodeType() == Node.ELEMENT_NODE) {
                    Element child = (Element) entry;
                    String name = child.getAttribute("name");
                    String type = child.getAttribute("type");
                    String width = child.getAttribute("width");
                    String dimension = child.getAttribute("dimension");
                    sce.setName(name);
                    sce.setType(type);
                    sce.setWidth(width);
                    sce.setAnalyzeByDate(type.equalsIgnoreCase("Date"));
                    sce.setMeasure(type.equalsIgnoreCase("Float"));
                    sce.setDimension(dimension);
                    columns.add(sce);

                }
            }

            maps.put(sourceName,columns);


        }
       return  maps;
    }



}
