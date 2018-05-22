package test.com.infor.admin;

import com.infor.admin.FileManagement;
import com.infor.connect.DatabaseQuery;
import com.infor.connect.DatabaseQueryWrapper;
import com.infor.util.DatabaseQueryXmlHelper;
import org.junit.*;

import java.io.*;


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
       // wrapper.getQueries().add(dq);
        String path = "e:/path/a.xml";
        File f = new File(path);
        File folder = new File(f.getParent());
        if(!folder.exists()){
            folder.mkdir();
        }
        System.out.println(f.getAbsolutePath());
        helper.saveToFile("e:/path/a.xml", wrapper);

    }

    @Test
    public void testRead(){
        FileManagement fileManagement = new FileManagement();
        File f = new File("C:\\Users\\shu\\AppData\\Local\\Temp\\shu_6803267988035913641.tmp\\Plan.txt");
        try {
            FileInputStream fileInputStream = new FileInputStream(f);
            DataInputStream dStream = new DataInputStream(fileInputStream);


            final int CHUNK_SIZE = 102400;
            System.out.println("File to upload -> " + f.getAbsolutePath() + " ->" + f.length());

            byte[] bytes = new byte[CHUNK_SIZE];
            int read = 0;
            do{
                read = dStream.read(bytes,0, CHUNK_SIZE);

                String readStr = new String(bytes);
                System.out.println("read -> " + readStr);
                if(bytes.length > 0){
                    // fileManagement.uploadData(birstProperties.getLoginToken(),uploadToken,bytes.length,bytes);
                }
            }while (read > 0);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //  String uploadToken = fileManagement.beginDataUpload(birstProperties.getLoginToken(),birstProperties.getCurrentSpace().getId(),f.getName());

    }
}
