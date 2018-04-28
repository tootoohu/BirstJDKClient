package com.infor.util;

import com.birst.HierarchyMetadata;
import com.birst.StagingTableSubClass;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.List;

public interface XmlWriterInterface extends XmlInterface{

    default void addElementWithText(Document doc, String elementName, String textNode, Element father){
        Element element = doc.createElement(elementName);
        element.appendChild(doc.createTextNode(textNode));
        father.appendChild(element);
    }

    default void addAttributeNode(Document doc, String attrName, String value, Element element){
        Attr attr = doc.createAttribute(attrName);
        attr.setValue(value);
        element.setAttributeNode(attr);
    }

    void writeSourceList(String spaceName, List<StagingTableSubClass> list);

    void writeHierarchyList(String spaceName, List<HierarchyMetadata> hierarchies);
}
