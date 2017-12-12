package com.infor.admin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLReader {

    public List<File> loadXMLFiles(){
        return this.loadXMLFiles("resources");
    }

    public List<File> loadXMLFiles(String path){
        File f = new File(path);
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


