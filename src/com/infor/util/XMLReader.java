package com.infor.util;

import com.infor.model.webservice.SourceColumnEntry;
import com.infor.model.webservice.SourceEntry;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public  class XMLReader implements XmlInterface{

    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    private static DocumentBuilder db;

    private Document doc;

    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private static Transformer former;

    public XMLReader() throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException {
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




}
