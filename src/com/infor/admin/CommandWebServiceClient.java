package com.infor.admin;

import com.birst.CommandWebService;
import com.birst.CommandWebServiceSoap;

import javax.xml.ws.BindingProvider;
import java.util.Map;

public final class CommandWebServiceClient {

   private static CommandWebServiceSoap soap;

   public static final String ENDPOINT_ADDRESS = "https://login.bws.birst.com/CommandWebService.asmx";

    public static synchronized CommandWebServiceSoap getInstance(){
        if(soap == null){
            CommandWebService service = new CommandWebService();
            soap = service.getCommandWebServiceSoap();
            BindingProvider bindingProvider = (BindingProvider) soap;
            Map<String,Object> requestContext = bindingProvider.getRequestContext();
            requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY,ENDPOINT_ADDRESS);
            requestContext.put(BindingProvider.SESSION_MAINTAIN_PROPERTY, true);
            //   requestContext.put("com.sun.xml.ws.connect.timeout", 1100 * 60 * 1000);
            //   requestContext.put("com.sun.xml.ws.request.timeout", 1300 * 60 * 1000);
        }
        return soap;
    }

    static {
        System.setProperty("soapui.https.protocols", "TLSv1.2");
    }
}
