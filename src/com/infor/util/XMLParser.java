package com.infor.util;

import com.birst.*;
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
import java.util.stream.Collectors;

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

    public void WriteSourceList(String spaceName, List<StagingTableSubClass> list){
        File file = PrepareFile(spaceName, "Sources.xml");

        doc = db.newDocument();
        Element root = doc.createElement("Sources");
        doc.appendChild(root);

        for(StagingTableSubClass subClass : list){
           Element sourceNode = doc.createElement("Source");
            Attr nameAttr = doc.createAttribute("Name");
            nameAttr.setValue(subClass.getName());
            sourceNode.setAttributeNode(nameAttr);

            Attr origAttr = doc.createAttribute("OriginalName");
            origAttr.setValue(subClass.getName());
            sourceNode.setAttributeNode(origAttr);

            Attr disAttr = doc.createAttribute("Disabled");
            disAttr.setValue(subClass.getName());
            sourceNode.setAttributeNode(disAttr);

            Attr lastAttr = doc.createAttribute("LastModifiedDate");
            lastAttr.setValue(subClass.getName());
            sourceNode.setAttributeNode(lastAttr);

            //<Script>
            Element scriptsNode = doc.createElement("Scripts");
            ScriptDefinition sd = subClass.getScript();
            Element inputNode = doc.createElement("InputQuery");
            Element outputNode = doc.createElement("Output");
            Element scriptNode = doc.createElement("Script");
            if(sd != null){
                inputNode.appendChild(doc.createTextNode(sd.getInputQuery()));
                outputNode.appendChild(doc.createTextNode(sd.getOutput()));
                scriptNode.appendChild(doc.createTextNode(sd.getScript()));
            }

            scriptsNode.appendChild(inputNode);
            scriptsNode.appendChild(outputNode);
            scriptsNode.appendChild(scriptNode);

            sourceNode.appendChild(scriptsNode);

            //<Columns>
            Element columns = doc.createElement("Columns");
            List<SourceColumnSubClass> columnList = subClass.getColumns().getSourceColumnSubClass();
           /* for(SourceColumnSubClass sub : columnList){

                Element column = doc.createElement("Column");
                Attr name = doc.createAttribute("Name");
                name.setValue(sub.getName());
                column.setAttributeNode(name);

                Attr origName = doc.createAttribute("OriginalName");
                origName.setValue(sub.getOriginalName());
                column.setAttributeNode(origName);

                Element analyzeMeasure = doc.createElement("AnalyzeMeasure");
                analyzeMeasure.appendChild(doc.createTextNode(sub.isAnalyzeMeasure() != null? sub.isAnalyzeMeasure().toString(): ""));
                column.appendChild(analyzeMeasure);

                Element dataType = doc.createElement("DataType");
                dataType.appendChild(doc.createTextNode(sub.getDataType()));
                column.appendChild(dataType);

                Element format = doc.createElement("Format");
                format.appendChild(doc.createTextNode(sub.getFormat()));
                column.appendChild(format);


                Element enableSecutityFilter = doc.createElement("EnableSecutityFilter");
                enableSecutityFilter.appendChild(doc.createTextNode(Boolean.toString(sub.isEnableSecutityFilter())));
                column.appendChild(enableSecutityFilter);

                Element sourceFileColumn = doc.createElement("SourceFileColumn");
                sourceFileColumn.appendChild(doc.createTextNode(sub.getSourceFileColumn()));
                column.appendChild(sourceFileColumn);

                Element targetAggregations = doc.createElement("TargetAggregations");
                if(sub.getTargetAggregations() != null){
                    String aggrStr = sub.getTargetAggregations().getString().stream().collect(Collectors.joining(","));
                    targetAggregations.appendChild(doc.createTextNode(aggrStr));
                }

                column.appendChild(targetAggregations);

                Element targetTypes = doc.createElement("TargetTypes");
                if(sub.getTargetTypes()!= null){
                    String typeStr = sub.getTargetTypes().getString().stream().collect(Collectors.joining(","));
                    targetTypes.appendChild(doc.createTextNode(typeStr));
                }

                column.appendChild(targetTypes);

                Element unknownValue = doc.createElement("UnknownValue");
                unknownValue.appendChild(doc.createTextNode(sub.getUnknownValue()));
                column.appendChild(unknownValue);

                Element width = doc.createElement("Width");
                width.appendChild(doc.createTextNode(String.valueOf(sub.getWidth())));
                column.appendChild(width);

                Element hierarchyName = doc.createElement("HierarchyName");
                hierarchyName.appendChild(doc.createTextNode(sub.getHierarchyName()));
                column.appendChild(hierarchyName);

                Element levelName = doc.createElement("LevelName");
                levelName.appendChild(doc.createTextNode(sub.getLevelName()));
                column.appendChild(levelName);

                Element levels = doc.createElement("Levels");

                List<ArrayOfString> levelStrs = sub.getLevels().getArrayOfString();
                for (ArrayOfString aos : levelStrs){
                    Element level = doc.createElement("Level");
                    String levelText = aos.getString().stream().collect(Collectors.joining(","));
                    level.appendChild(doc.createTextNode(levelText));
                    levels.appendChild(level);
                }

                column.appendChild(levels);

                Element analyzeByDate = doc.createElement("AnalyzeByDate");
                analyzeByDate.appendChild(doc.createTextNode(Boolean.toString(sub.isAnalyzeByDate())));
                column.appendChild(analyzeByDate);

                Element measure = doc.createElement("Measure");
                measure.appendChild(doc.createTextNode(Boolean.toString(sub.isMeasure())));
                column.appendChild(measure);

                Element lockType = doc.createElement("LockType");
                lockType.appendChild(doc.createTextNode(Boolean.toString(sub.isLockType())));
                column.appendChild(lockType);

                columns.appendChild(column);
            } // end of for columns
            */
            sourceNode.appendChild(columns);

           root.appendChild(sourceNode);


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
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }


    private File PrepareFile(String path, String name){
        File directory = new File( Paths.get("").toAbsolutePath().toString() + "/src/resources/" + path);
        if(!directory.exists()){
            directory.mkdirs();
        }
        File file = new File(Paths.get("").toAbsolutePath().toString() +  "/src/resources/" + path +  "/" + name);
        if(file.exists()){
            file.delete();
        }
        return file;
    }

    public void WriteHierarchyList(String spaceName, List<HierarchyMetadata> hierarchies){

        File file = PrepareFile(spaceName, "Hierarchhies.xml");

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
        } catch (TransformerException e) {
            e.printStackTrace();
        }


    }

}
