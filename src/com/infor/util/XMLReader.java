package com.infor.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Deprecated
public class XMLReader {

    public List<File> loadXMLFiles(){
        return this.loadXMLFiles("/resources/xml");
    }

    public List<File> loadXMLFiles(String path){
        URL url = XMLReader.class.getResource(path);
        File f = new File(url.getPath());
        List<File> files = new ArrayList<>();
        if(!f.exists())
            return null;
        if(f.isDirectory()){
            File[] fileArray = f.listFiles();

            files = Arrays.asList(fileArray);

        }else{
            files.add(f);

        }
        return files;
    }
}


