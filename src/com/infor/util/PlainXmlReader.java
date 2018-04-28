package com.infor.util;

import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlainXmlReader extends XMLReader {

    public PlainXmlReader() throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException {
        super();
    }

    public Map<SourceEntry, List<SourceColumnEntry>> getSourceMap(String path, boolean isCube){
        URL url = XMLReader.class.getResource(path);
        File f = new File(url.getPath());
        Document doc = getDoc(f.getAbsolutePath());
        return getSourceList(doc, isCube);
    }

    private Map<SourceEntry, List<SourceColumnEntry>> getSourceList(Document doc, boolean isCube){
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
}
