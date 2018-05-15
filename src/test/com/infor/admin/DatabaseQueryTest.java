package test.com.infor.admin;

import com.infor.connect.DatabaseQuery;
import com.infor.connect.DatabaseQueryWrapper;
import com.infor.util.DatabaseQueryXmlHelper;
import org.junit.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;


public class DatabaseQueryTest {


    @Test
    public void testXML(){
//        DatabaseQuery query = new DatabaseQuery();
//        query.setConnectString("connection string");
//        query.setDatabaseName("901");
//        query.setDatabaseType("MS SQL");
//        query.setPort(1033);
//        System.out.println(query.getXML());

    }
    @Test
    public void savetoFile() throws IOException {
        DatabaseQueryXmlHelper helper = new DatabaseQueryXmlHelper();
        DatabaseQueryWrapper wrapper = new DatabaseQueryWrapper();
        DatabaseQuery dq = new DatabaseQuery();
        dq.setPort(11);
        dq.setDatabaseType("Oracle");
        dq.setDatabaseName("901");
        dq.setServerName("server name");
        wrapper.getQueries().add(dq);
        String path = "e:/path/a.xml";
        File f = new File(path);
        File folder = new File(f.getParent());
        if(!folder.exists()){
            folder.mkdir();
        }
        System.out.println(f.getAbsolutePath());
        helper.saveToFile("e:/path/a.xml", wrapper);

    }

}
