package com.infor.test;

import com.infor.util.XMLParser;
import com.infor.util.XMLReader;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;

import java.io.File;
import java.util.List;
import java.util.Map;

public class XMLParserTest {

    private List<File> files;
    @Before
    public void setUp() throws Exception {
       XMLReader reader = new XMLReader();
       files = reader.loadXMLFiles("/resources/xml/Dimensions.xml");

    }

    @Test
    public void getSourceList() throws Exception {
        XMLParser parser = new XMLParser();
        for (File file: files ) {
            Document doc = parser.getDoc(file.getAbsolutePath());
            Map map =  parser.getSourceList(doc);
            System.out.println();
        }

    }

}