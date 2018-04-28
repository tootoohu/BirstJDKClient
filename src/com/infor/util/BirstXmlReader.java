package com.infor.util;

import com.birst.*;
import com.sun.javafx.scene.shape.PathUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class BirstXmlReader extends XMLReader {

    public BirstXmlReader() throws ParserConfigurationException, SAXException, TransformerConfigurationException, IOException {
        super();
    }

    public Map<String, StagingTableSubClass> readSources(String path){
        Document doc = getDoc(path);
        Element rootElement = doc.getDocumentElement();

        Map<String, StagingTableSubClass> map = new HashMap<>();
        NodeList nodes = rootElement.getChildNodes();
        for(int i=0; i< nodes.getLength(); i++){
            StagingTableSubClass stsc = new StagingTableSubClass();
            Node node = nodes.item(i);
            String sourceName = node.getNodeName();

            if (node.getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element sourceElement = (Element) node;
            String nameAttr = sourceElement.getAttributeNode(NAME_NODE).getValue();
            String origAttr = sourceElement.getAttributeNode(ORIGINAL_NAME_NODE).getValue();
            String lastMDate = sourceElement.getAttributeNode(LAST_MODIFIED_DATE_NODE).getValue();
            stsc.setName(nameAttr);
            stsc.setOriginalName(origAttr);
            try {
                XMLGregorianCalendar result = DatatypeFactory.newInstance().newXMLGregorianCalendar(lastMDate);
                stsc.setLastModifiedDate(result);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }
            NodeList scriptsList = sourceElement.getElementsByTagName(SCRIPTS_NODE);
            for (int n = 0; n < scriptsList.getLength(); n++) {
                if( scriptsList.item(n).getNodeType() !=  Node.ELEMENT_NODE)
                    continue;
                Element scriptElement = (Element) scriptsList.item(n);
                String inputQuery = scriptElement.getElementsByTagName(INPUT_QUERY_NODE).item(0).getTextContent();
                String output = scriptElement.getElementsByTagName(OUTPUT_NODE).item(0).getTextContent();
                String script = scriptElement.getElementsByTagName(SCRIPT_NODE).item(0).getTextContent();
                ScriptDefinition sd = new ScriptDefinition();
                sd.setInputQuery(inputQuery);
                sd.setOutput(output);
                sd.setScript(script);
                stsc.setScript(sd);
            }

            List<SourceColumnSubClass> columns = new ArrayList<>();
            Element columnsElement = (Element) sourceElement.getElementsByTagName(COLUMNS_NODE).item(0);
            NodeList columnList = columnsElement.getElementsByTagName(COLUMN_NODE);
            for(int j = 0; j< columnList.getLength();j++){
                if(columnList.item(j).getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element columnElement = (Element) columnList.item(j);
                SourceColumnSubClass scs = new SourceColumnSubClass();
                scs.setOriginalName(columnElement.getAttributeNode(ORIGINAL_NAME_NODE).getValue());
                scs.setName(columnElement.getAttributeNode(NAME_NODE).getValue());
                Element analyzeMeaElement = (Element) columnElement.getElementsByTagName(ANALYZE_MEASURE_NODE).item(0);
                scs.setAnalyzeMeasure(Boolean.valueOf(analyzeMeaElement.getTextContent()));
                Element dataTypeElement = (Element) columnElement.getElementsByTagName(DATA_TYPE_NODE).item(0);
                scs.setDataType(dataTypeElement.getTextContent());
                Element formatElement = (Element) columnElement.getElementsByTagName(FORMAT_NODE).item(0);
                scs.setFormat(formatElement.getTextContent());
                Element enableSecFilterElement = (Element) columnElement.getElementsByTagName(ENABLE_SECURITY_FILTER_NODE).item(0);
                scs.setEnableSecutityFilter(Boolean.valueOf(enableSecFilterElement.getTextContent()));
                Element sourceFileColElement = (Element) columnElement.getElementsByTagName(SOURCE_FILE_COLUMN_NODE).item(0);
                scs.setSourceFileColumn(sourceFileColElement.getTextContent());
               //target aggregation
                Element targetAggreElement = (Element) columnElement.getElementsByTagName(TARGET_AGGREGATIONS_NODE).item(0);
                ArrayOfString aggres = new ArrayOfString();
                aggres.getString().addAll(Arrays.asList(targetAggreElement.getTextContent().split(",")));
                scs.setTargetAggregations(aggres);

                //targetTypes
                Element tgtTypesElement = (Element) columnElement.getElementsByTagName(TARGET_TYPES_NODE).item(0);
                ArrayOfString tgtTypes = new ArrayOfString();
                tgtTypes.getString().addAll(Arrays.asList(tgtTypesElement.getTextContent().split(",")));
                scs.setTargetTypes(tgtTypes);

                //unknownvalue
                Element unknownElement = (Element) columnElement.getElementsByTagName(UNKNOWN_VALUE_NODE).item(0);
                scs.setUnknownValue(unknownElement.getTextContent());

                //width
                Element widthElement = (Element) columnElement.getElementsByTagName(WIDTH_NODE).item(0);
                scs.setWidth(Integer.valueOf(widthElement.getTextContent()));

                //hierarchy
                Element hrchyElement = (Element) columnElement.getElementsByTagName(HIERARCHY_NAME_NODE).item(0);
                scs.setHierarchyName(hrchyElement.getTextContent());

                //level name
                Element levelElement =(Element) columnElement.getElementsByTagName(LEVEL_NAME_NODE).item(0);
                scs.setLevelName(levelElement.getTextContent());

                //levels
                Element levelsElement = (Element) columnElement.getElementsByTagName(LEVELS_NODE).item(0);
                NodeList levelList = levelsElement.getChildNodes();
                ArrayOfArrayOfString levels = new ArrayOfArrayOfString();
                for(int k=0; k<levelList.getLength(); k++){
                    if(levelList.item(k).getNodeType() != Node.ELEMENT_NODE)
                        continue;
                    Element subLevelElement = (Element) levelList.item(k);
                    ArrayOfString levelStr = new ArrayOfString();
                    levelStr.getString().addAll(Arrays.asList(subLevelElement.getTextContent().split(",")));
                    levels.getArrayOfString().add(levelStr);

                }
                scs.setLevels(levels);

                Element analyElement = (Element) columnElement.getElementsByTagName(ANALYZE_BY_DATE_NODE).item(0);
                scs.setAnalyzeByDate(Boolean.valueOf(analyElement.getTextContent()));

                Element measureElement = (Element) columnElement.getElementsByTagName(MEASURE_NODE).item(0);
                scs.setMeasure(Boolean.valueOf(measureElement.getTextContent()));

                Element lockTypeElement = (Element) columnElement.getElementsByTagName(LOCK_TYPE_NODE).item(0);
                scs.setLockType(Boolean.valueOf(lockTypeElement.getTextContent()));

                columns.add(scs);

            }

            ArrayOfSourceColumnSubClass arrayColumns = new ArrayOfSourceColumnSubClass();
            arrayColumns.getSourceColumnSubClass().addAll(columns);
            stsc.setColumns(arrayColumns);
            map.put( nameAttr, stsc);
        }
        return map;

    }

    public Map<String, HierarchyMetadata> readHierarchies(String path){
        Document doc = getDoc(path);

       // List<HierarchyMetadata> hierarchies = new ArrayList<>();
        Element rootElement = doc.getDocumentElement();
        Map<String, HierarchyMetadata> map = new HashMap<>();
        NodeList nodes = rootElement.getChildNodes();
        for(int i=0;i< nodes.getLength();i++){
            HierarchyMetadata hm = new HierarchyMetadata();
            if(nodes.item(i).getNodeType() != Node.ELEMENT_NODE)
                continue;
            Element hryElement = (Element) nodes.item(i);
            String name = hryElement.getAttributeNode(NAME_NODE).getValue();
            hm.setName(name);

            //level
            NodeList levelsList = hryElement.getChildNodes();
            for(int j=0;j<levelsList.getLength();j++){
                if(levelsList.item(j).getNodeType() != Node.ELEMENT_NODE)
                    continue;
                Element levelElement = (Element)levelsList.item(j);
                LevelMetadata lm = new LevelMetadata();
                lm.setName(levelElement.getAttributeNode(NAME_NODE).getValue());
                lm.setCardinality(levelElement.getAttributeNode(CARDINALITY_NODE).getValue());

                NodeList columnList = levelElement.getChildNodes();

                for(int k = 0; k< columnList.getLength();k++){
                    if(columnList.item(k).getNodeType() != Node.ELEMENT_NODE)
                        continue;
                    Element columnElement = (Element) columnList.item(k);
                    lm.getColumnNames().getString().add(columnElement.getTextContent());
                }
                hm.getChildren().getLevelMetadata().add(lm);
            }
            map.put(hm.getName(), hm);
            //hierarchies.add(hm);
        }
        return map;
    }



}
