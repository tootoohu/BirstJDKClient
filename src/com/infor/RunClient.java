package com.infor;

import com.birst.*;
import com.infor.model.webservice.BirstProperties;
import com.infor.util.XMLReader;
import org.xml.sax.SAXException;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.ws.BindingProvider;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunClient {


    public static void main(String[] args) throws IOException {

      //  test();
       // init();
        System.out.printf(String.valueOf(Boolean.valueOf(null)));

    }

    public static void init(){

        BirstProperties bp = BirstProperties.getInstance();
        System.out.println(bp.getAddress());

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
        String token = webservice.getCommandWebServiceSoap().login("shelley.hu@infor.com","Hello123");

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
