package com.infor.admin;

import com.infor.model.webservice.DataSource;
import org.w3c.dom.Document;
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
import java.util.List;

public class XMLParser {

    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

    private static DocumentBuilder db;

    private Document doc;

    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private static Transformer former;

    public XMLParser() throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException {

        db = documentBuilderFactory.newDocumentBuilder();
        former = transformerFactory.newTransformer();

    }

    private Document getDoc(String inputXmlPath) {
        try {
            return db.parse(inputXmlPath);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    private NodeList getNodeList(Document doc, String nodeName){

        return  doc.getElementsByTagName(nodeName);
    }

    public List<DataSource> getSourceList(){
      return null;
    }

    public Document Edit(String inputXmlPath, String nodeName){
        Document doc = getDoc(inputXmlPath);
        NodeList nodeList = getNodeList(doc, nodeName);
        for (int i = 0; i < nodeList.getLength();i++){
            Node node = (Node)nodeList.item(i);
            String columnName = node.getFirstChild().getNodeValue();
            node.getFirstChild().setNodeValue(columnName.toLowerCase());
            System.out.println("write " + inputXmlPath);

        }

        return doc;


    }

    public void Save(Document doc, String outputPath){
        File f = new File(outputPath);

        try {
            if(f.exists()){
                f.delete();
            }
            f.createNewFile();
            former.transform(new DOMSource(doc), new StreamResult(f));
            System.out.println("save to " + f.getAbsolutePath());
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
