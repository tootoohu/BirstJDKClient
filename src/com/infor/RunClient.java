package com.infor;

import com.birst.*;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.XMLReader;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.ws.BindingProvider;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class RunClient {


    public static void main(String[] args) throws IOException {

      //  test();
       // init();
        testConnect();
//        File df = File.createTempFile("birst", (String)null);
//        String dir = df.getAbsolutePath();
//        df.delete();
//        File dirFile = new File(dir);
//        dirFile.mkdir();
    }

    public interface  Counter{

       void accept(String t);



    }
    public static void init(){

        BirstProperties bp = BirstProperties.getInstance();
        System.out.println(bp.getAddress());

    }

    public static void testConnect(){
        CommandWebService webservice = new CommandWebService();

        BindingProvider bindingProvider = (BindingProvider) webservice.getCommandWebServiceSoap();

        Map<String,Object> requestContext = bindingProvider.getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"https://login.bws.birst.com/CommandWebService.asmx");
        requestContext.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);

        String token = webservice.getCommandWebServiceSoap().login("","");
        System.out.println(token);
        String jnlp = webservice.getCommandWebServiceSoap().getSpaceJNLPFile(token,"57baa258-f10c-44c2-9d19-3aa4ec89da6f","dcconfig.xml");
        System.out.println(jnlp);

        FileNode fileNode = webservice.getCommandWebServiceSoap().getDirectoryContents(token,"9c89a600-cc29-47a5-9fea-ab0d5bcd3bf2","shared");
        System.out.println(fileNode.getName());
        System.out.println(fileNode.getChildren().getFileNode().size());

        String path = "shared/Reports/Sales/Profit Over Time.viz";
       CommandQueryResult result =  webservice.getCommandWebServiceSoap().getReportData(token,"9c89a600-cc29-47a5-9fea-ab0d5bcd3bf2",path, new ArrayOfFilter());
       int count = result.getNumRowsReturned();
        List<ArrayOfString> rows = result.getRows().getArrayOfString();
        for(ArrayOfString aos : rows){
            System.out.println(aos.getString());
        }


    }
    public static void test(){

        CommandWebService webservice = new CommandWebService();

        BindingProvider bindingProvider = (BindingProvider) webservice.getCommandWebServiceSoap();

        Map<String,Object> requestContext = bindingProvider.getRequestContext();


        /*
        Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();
        List<String> cookies = new ArrayList<String>();
        cookies.add("SMSESSION=testCookie");
        requestHeaders.put("Cookie", cookies);
        requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);
       */

        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,"https://login.bws.birst.com/CommandWebService.asmx");
        requestContext.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);


     //   requestContext.put("com.sun.xml.ws.connect.timeout", 1100 * 60 * 1000);
    //    requestContext.put("com.sun.xml.ws.request.timeout", 1300 * 60 * 1000);


        System.out.println("call!");
        String token = webservice.getCommandWebServiceSoap().login("shelley.hu@infor.com","");

        System.out.println(token);
        String spaceId = "e93f6408-a7bb-4c54-81bd-6826521d30e4";

       // ArrayOfString hierachies = webservice.getCommandWebServiceSoap().getAllHierarchies(token, "e93f6408-a7bb-4c54-81bd-6826521d30e4");
       // System.out.println(hierachies.getString());

        //Profile str = webservice.getCommandWebServiceSoap().getProfileForUser(token,"shelley.hu@infor.com");
    //    ArrayOfString acls = webservice.getCommandWebServiceSoap().getSubjectAreaPermissions(token,"e93f6408-a7bb-4c54-81bd-6826521d30e4", "CEO");
     //   System.out.println(acls.getString());

     //   HierarchyMetadata metadata = webservice.getCommandWebServiceSoap().getHierarchy(token,"e93f6408-a7bb-4c54-81bd-6826521d30e4", "Cash Account H");
     //   System.out.println(metadata.getName());
     //   System.out.println(metadata.getChildren().getLevelMetadata().get(0).getColumnNames().getString());

     //   StagingTableSubClass source = webservice.getCommandWebServiceSoap().getSourceDetails(token,"e93f6408-a7bb-4c54-81bd-6826521d30e4", "Account");
     //   System.out.println(source.isDisabled());
      //  System.out.println(source.getColumns().getSourceColumnSubClass());

       // -- webservice.getCommandWebServiceSoap().listAllSpaces(token);


        List<String> subjects = webservice.getCommandWebServiceSoap().listCustomSubjectAreas(token,"e93f6408-a7bb-4c54-81bd-6826521d30e4").getString();
        subjects.forEach(k -> System.out.println(k));

     //   MetaDataResult result = webservice.getCommandWebServiceSoap().getODBCMetaDataSubjectAreas(token,"e93f6408-a7bb-4c54-81bd-6826521d30e4");
      //  System.out.println(result.getTables().getODBCTableResult());

       // MetaDataResult result = webservice.getCommandWebServiceSoap().getODBCMetaData(token,"e93f6408-a7bb-4c54-81bd-6826521d30e4");
       // System.out.println(result.getTables());


        FileNode pro = webservice.getCommandWebServiceSoap().getDirectoryContents(token,spaceId,"shared/Dashboard/Sales/Booking Analysis");
        System.out.println(pro.getName());

        ExecutorService X;
        Executors y;
        Collections.synchronizedMap(new HashMap<>()) ;

    }


}
