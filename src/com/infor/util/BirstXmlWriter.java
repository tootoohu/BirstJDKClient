package com.infor.util;

import com.birst.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BirstXmlWriter implements XmlWriterInterface {

    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder db;
    private Document doc;
    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private static Transformer former;
    public BirstXmlWriter(){
        try {
            init();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void init() throws ParserConfigurationException, TransformerConfigurationException {
        db = documentBuilderFactory.newDocumentBuilder();
        former = transformerFactory.newTransformer();
    }

    public void writeSourceList(String spaceName, List<StagingTableSubClass> list){
        File file = PrepareFile(spaceName,  SOURCES_FILE_NAME);

        doc = db.newDocument();
        Element root = doc.createElement(SOURCES_NODE);
        doc.appendChild(root);

        for(StagingTableSubClass subClass : list){
            Element sourceNode = doc.createElement(SOURCE_NODE);
            addAttributeNode(doc, NAME_NODE, subClass.getName(), sourceNode);
            addAttributeNode(doc, ORIGINAL_NAME_NODE, subClass.getName(), sourceNode);
            addAttributeNode(doc, DISABLED_NODE, Boolean.toString(subClass.isDisabled()), sourceNode);
            addAttributeNode(doc, LAST_MODIFIED_DATE_NODE,String.valueOf(subClass.getLastModifiedDate()), sourceNode);

            //<Script>
            Element scriptsNode = doc.createElement(SCRIPTS_NODE);
            ScriptDefinition sd = subClass.getScript();
            Element inputNode = doc.createElement(INPUT_QUERY_NODE);
            Element outputNode = doc.createElement(OUTPUT_NODE);
            Element scriptNode = doc.createElement(SCRIPT_NODE);
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
            Element columns = doc.createElement(COLUMNS_NODE);
            List<SourceColumnSubClass> columnList = subClass.getColumns().getSourceColumnSubClass();
            for(SourceColumnSubClass sub : columnList){

                Element column = doc.createElement(COLUMN_NODE);
                addAttributeNode(doc, NAME_NODE,sub.getName(), column);
                addAttributeNode(doc, ORIGINAL_NAME_NODE,sub.getOriginalName(), column);
                addElementWithText(doc, ANALYZE_MEASURE_NODE, sub.isAnalyzeMeasure() != null? sub.isAnalyzeMeasure().toString(): "", column);
                addElementWithText(doc, DATA_TYPE_NODE,sub.getDataType(), column);
                addElementWithText(doc, FORMAT_NODE,sub.getFormat() != null ? sub.getFormat(): "", column);
                addElementWithText(doc, ENABLE_SECURITY_FILTER_NODE,Boolean.toString(sub.isEnableSecutityFilter()), column);
                addElementWithText(doc, SOURCE_FILE_COLUMN_NODE,sub.getSourceFileColumn() != null ? sub.getSourceFileColumn() : "", column);

                Element targetAggregations = doc.createElement(TARGET_AGGREGATIONS_NODE);
                if(sub.getTargetAggregations() != null){
                    String aggrStr = sub.getTargetAggregations().getString().stream().collect(Collectors.joining(","));
                    targetAggregations.appendChild(doc.createTextNode(aggrStr));
                }

                column.appendChild(targetAggregations);

                Element targetTypes = doc.createElement(TARGET_TYPES_NODE);
                if(sub.getTargetTypes()!= null){
                    String typeStr = sub.getTargetTypes().getString().stream().collect(Collectors.joining(","));
                    targetTypes.appendChild(doc.createTextNode(typeStr));
                }

                column.appendChild(targetTypes);

                addElementWithText(doc, UNKNOWN_VALUE_NODE,sub.getUnknownValue() != null? sub.getUnknownValue() :"", column);
                addElementWithText(doc, WIDTH_NODE,String.valueOf(sub.getWidth()), column);
                addElementWithText(doc, HIERARCHY_NAME_NODE,sub.getHierarchyName() != null ? sub.getHierarchyName() : "", column);
                addElementWithText(doc, LEVEL_NAME_NODE,sub.getLevelName() != null ? sub.getLevelName():"", column);
                Element levels = doc.createElement(LEVELS_NODE);

                List<ArrayOfString> levelStrs = sub.getLevels().getArrayOfString();
                for (ArrayOfString aos : levelStrs){
                    Element level = doc.createElement(LEVEL_NODE);
                    String levelText = aos.getString().stream().collect(Collectors.joining(","));
                    level.appendChild(doc.createTextNode(levelText));
                    levels.appendChild(level);
                }

                column.appendChild(levels);

                addElementWithText(doc, ANALYZE_BY_DATE_NODE,Boolean.toString(sub.isAnalyzeByDate()), column);
                addElementWithText(doc, MEASURE_NODE,Boolean.toString(sub.isMeasure()), column);
                addElementWithText(doc, LOCK_TYPE_NODE,Boolean.toString(sub.isLockType()), column);

                columns.appendChild(column);
            } // end of for columns

            sourceNode.appendChild(columns);

            root.appendChild(sourceNode);


        }
        WriteToFile(doc, file);
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

    public void writeHierarchyList(String spaceName, List<HierarchyMetadata> hierarchies){

        File file = PrepareFile(spaceName, HIERARCHIES_FILE_NAME);

        doc = db.newDocument();
        Element root = doc.createElement(HIERARCHIES_NODE);
        doc.appendChild(root);

        for(HierarchyMetadata hm: hierarchies){
            Element hierarchyNode = doc.createElement(HIERARCHY_NODE);
            root.appendChild(hierarchyNode);
            addAttributeNode(doc, NAME_NODE, hm.getName(), hierarchyNode);
            List<LevelMetadata> metadatas = hm.getChildren().getLevelMetadata();
            //xml node for <level>
            for (LevelMetadata lm : metadatas){
                Element levelNode = doc.createElement(LEVEL_NODE);

                addAttributeNode(doc, NAME_NODE, lm.getName(), levelNode);
                addAttributeNode(doc, CARDINALITY_NODE, lm.getCardinality(), levelNode);
                //column
                List<String> columnList = lm.getColumnNames().getString();
                for (String colstr : columnList){
                   addElementWithText(doc, COLUMN_NODE,colstr, levelNode );
                }
                hierarchyNode.appendChild(levelNode);

            }

        }
          WriteToFile(doc, file);
    }


    private void WriteToFile(Document doc, File file){
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            file.createNewFile();
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
