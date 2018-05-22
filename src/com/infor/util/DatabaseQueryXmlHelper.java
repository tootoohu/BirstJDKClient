package com.infor.util;

import com.infor.connect.DatabaseQuery;
import com.infor.connect.DatabaseQueryWrapper;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class DatabaseQueryXmlHelper {

    public static Map<String,DatabaseQuery> loadDataFromFile(String path) {
        try {
            File file = new File(path);
            if(file.exists()){
                JAXBContext context = JAXBContext
                        .newInstance(DatabaseQueryWrapper.class);
                Unmarshaller um = context.createUnmarshaller();

                // Reading XML from the file and unmarshalling.
                DatabaseQueryWrapper wrapper = (DatabaseQueryWrapper) um.unmarshal(file);

                return wrapper.getQueries();
            }

        } catch (Exception e) { // catches ANY exception

        }
        return null;
    }


    public static void saveToFile(String path, DatabaseQueryWrapper wrapper){
        File file = new File(path);
        File folder = new File(file.getParent());
        if(!folder.exists()){
            folder.mkdir();
        }
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(DatabaseQueryWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(wrapper,file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
