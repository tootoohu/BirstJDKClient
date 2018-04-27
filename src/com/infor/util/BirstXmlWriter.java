package com.infor.util;

import com.birst.*;
import org.w3c.dom.Attr;
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

public class BirstXmlWriter implements XmlWriterInterface{

    private static DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    private static DocumentBuilder db;
    private Document doc;
    private static TransformerFactory transformerFactory = TransformerFactory.newInstance();

    private static Transformer former;
    public BirstXmlWriter(){
    }

    public void init() throws ParserConfigurationException, TransformerConfigurationException {
        db = documentBuilderFactory.newDocumentBuilder();
        former = transformerFactory.newTransformer();
    }

    public void WriteSourceList(String spaceName, List<StagingTableSubClass> list){
        File file = PrepareFile(spaceName,  SOURCES_FILE_NAME);

        doc = db.newDocument();
        Element root = doc.createElement(SOURCES_NODE);
        doc.appendChild(root);

        for(StagingTableSubClass subClass : list){
            Element sourceNode = doc.createElement(SOURCE_NODE);
            AddAttributeNode(doc, NAME_NODE, subClass.getName(), sourceNode);
//            Attr nameAttr = doc.createAttribute(NAME_NODE);
//            nameAttr.setValue(subClass.getName());
//            sourceNode.setAttributeNode(nameAttr);

//            Attr origAttr = doc.createAttribute(ORIGINAL_NAME_NODE);
//            origAttr.setValue(subClass.getName());
//            sourceNode.setAttributeNode(origAttr);
            AddAttributeNode(doc, ORIGINAL_NAME_NODE, subClass.getName(), sourceNode);

//            Attr disAttr = doc.createAttribute(DISABLED_NODE);
//            disAttr.setValue(Boolean.toString(subClass.isDisabled()));
//            sourceNode.setAttributeNode(disAttr);
            AddAttributeNode(doc, DISABLED_NODE, Boolean.toString(subClass.isDisabled()), sourceNode);

//            Attr lastAttr = doc.createAttribute(LAST_MODIFIED_DATE_NODE);
//            lastAttr.setValue(String.valueOf(subClass.getLastModifiedDate()));
//            sourceNode.setAttributeNode(lastAttr);
            AddAttributeNode(doc, LAST_MODIFIED_DATE_NODE,String.valueOf(subClass.getLastModifiedDate()), sourceNode);

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
//                Attr name = doc.createAttribute(NAME_NODE);
//                name.setValue(sub.getName());
//                column.setAttributeNode(name);
                AddAttributeNode(doc, NAME_NODE,sub.getName(), column);

//                Attr origName = doc.createAttribute(ORIGINAL_NAME_NODE);
//                origName.setValue(sub.getOriginalName());
//                column.setAttributeNode(origName);
                AddAttributeNode(doc, ORIGINAL_NAME_NODE,sub.getOriginalName(), column);

//                Element analyzeMeasure = doc.createElement(ANALYZE_MEASURE_NODE);
//                analyzeMeasure.appendChild(doc.createTextNode(sub.isAnalyzeMeasure() != null? sub.isAnalyzeMeasure().toString(): ""));
//                column.appendChild(analyzeMeasure);
                AddElementWithText(doc, ANALYZE_MEASURE_NODE, sub.isAnalyzeMeasure() != null? sub.isAnalyzeMeasure().toString(): "", column);

//                Element dataType = doc.createElement(DATA_TYPE_NODE);
//                dataType.appendChild(doc.createTextNode(sub.getDataType()));
//                column.appendChild(dataType);
                AddElementWithText(doc, DATA_TYPE_NODE,sub.getDataType(), column);

//                Element format = doc.createElement(FORMAT_NODE);
//                format.appendChild(doc.createTextNode(sub.getFormat() != null ? sub.getFormat(): ""));
//                column.appendChild(format);
                AddElementWithText(doc, FORMAT_NODE,sub.getFormat() != null ? sub.getFormat(): "", column);

//                Element enableSecutityFilter = doc.createElement(ENABLE_SECURITY_FILTER_NODE);
//                enableSecutityFilter.appendChild(doc.createTextNode(Boolean.toString(sub.isEnableSecutityFilter())));
//                column.appendChild(enableSecutityFilter);
                AddElementWithText(doc, ENABLE_SECURITY_FILTER_NODE,Boolean.toString(sub.isEnableSecutityFilter()), column);

//                Element sourceFileColumn = doc.createElement(SOURCE_FILE_COLUMN_NODE);
//                sourceFileColumn.appendChild(doc.createTextNode(sub.getSourceFileColumn() != null ? sub.getSourceFileColumn() : ""));
//                column.appendChild(sourceFileColumn);
                AddElementWithText(doc, SOURCE_FILE_COLUMN_NODE,sub.getSourceFileColumn() != null ? sub.getSourceFileColumn() : "", column);

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

//                Element unknownValue = doc.createElement(UNKNOWN_VALUE_NODE);
//                unknownValue.appendChild(doc.createTextNode(sub.getUnknownValue() != null? sub.getUnknownValue() :""));
//                column.appendChild(unknownValue);
                AddElementWithText(doc, UNKNOWN_VALUE_NODE,sub.getUnknownValue() != null? sub.getUnknownValue() :"", column);

//                Element width = doc.createElement(WIDTH_NODE);
//                width.appendChild(doc.createTextNode(String.valueOf(sub.getWidth())));
//                column.appendChild(width);
                AddElementWithText(doc, WIDTH_NODE,String.valueOf(sub.getWidth()), column);

//                Element hierarchyName = doc.createElement(HIERARCHY_NAME_NODE);
//                hierarchyName.appendChild(doc.createTextNode(sub.getHierarchyName() != null ? sub.getHierarchyName() : ""));
//                column.appendChild(hierarchyName);
                AddElementWithText(doc, HIERARCHY_NAME_NODE,sub.getHierarchyName() != null ? sub.getHierarchyName() : "", column);

//                Element levelName = doc.createElement(LEVEL_NAME_NODE);
//                levelName.appendChild(doc.createTextNode(sub.getLevelName() != null ? sub.getLevelName() : ""));
//                column.appendChild(levelName);
                AddElementWithText(doc, LEVEL_NAME_NODE,sub.getLevelName() != null ? sub.getLevelName():"", column);

                Element levels = doc.createElement(LEVELS_NODE);

                List<ArrayOfString> levelStrs = sub.getLevels().getArrayOfString();
                for (ArrayOfString aos : levelStrs){
                    Element level = doc.createElement(LEVEL_NODE);
                    String levelText = aos.getString().stream().collect(Collectors.joining(","));
                    level.appendChild(doc.createTextNode(levelText));
                    levels.appendChild(level);
                }

                column.appendChild(levels);

//                Element analyzeByDate = doc.createElement(ANALYZE_BY_DATE_NODE);
//                analyzeByDate.appendChild(doc.createTextNode(Boolean.toString(sub.isAnalyzeByDate())));
//                column.appendChild(analyzeByDate);
                AddElementWithText(doc, ANALYZE_BY_DATE_NODE,Boolean.toString(sub.isAnalyzeByDate()), column);

//                Element measure = doc.createElement(MEASURE_NODE);
//                measure.appendChild(doc.createTextNode(Boolean.toString(sub.isMeasure())));
//                column.appendChild(measure);
                AddElementWithText(doc, MEASURE_NODE,Boolean.toString(sub.isMeasure()), column);

//                Element lockType = doc.createElement(LOCK_TYPE_NODE);
//                lockType.appendChild(doc.createTextNode(Boolean.toString(sub.isLockType())));
//                column.appendChild(lockType);
                AddElementWithText(doc, LOCK_TYPE_NODE,Boolean.toString(sub.isLockType()), column);

                columns.appendChild(column);
            } // end of for columns

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
            System.out.println("write xml done");
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

        File file = PrepareFile(spaceName, HIERARCHIES_FILE_NAME);

        doc = db.newDocument();
        Element root = doc.createElement(HIERARCHIES_NODE);
        doc.appendChild(root);

        for(HierarchyMetadata hm: hierarchies){
            Element hierarchyNode = doc.createElement(HIERARCHY_NODE);
            root.appendChild(hierarchyNode);
            Attr attr = doc.createAttribute(NAME_NODE);
            attr.setValue(hm.getName());
            hierarchyNode.setAttributeNode(attr);
            List<LevelMetadata> metadatas = hm.getChildren().getLevelMetadata();
            //xml node for <level>
            for (LevelMetadata lm : metadatas){
                Element levelNode = doc.createElement(LEVEL_NODE);
                Attr levelNameNode = doc.createAttribute(NAME_NODE);
                levelNameNode.setValue(lm.getName());
                levelNode.setAttributeNode(levelNameNode);
                Attr cardinality = doc.createAttribute(CARDINALITY_NODE);
                cardinality.setValue(lm.getCardinality());
                levelNode.setAttributeNode(cardinality);
                //column
                List<String> columnList = lm.getColumnNames().getString();
                for (String colstr : columnList){
                    Element column = doc.createElement(COLUMN_NODE);
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
