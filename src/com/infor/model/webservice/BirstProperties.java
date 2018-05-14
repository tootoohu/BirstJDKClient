package com.infor.model.webservice;

import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class BirstProperties {
    private static Properties properties = new Properties();
    private static BirstProperties birstProperties;
    private static final String PROPERTY_FILE = "/resources/birst.properties";
    private static final String ADDRESS_KEY = "birst.address";

    private final static String USER_KEY = "birst.username";

    private final static String PWD_KEY = "birst.password";

    private final static String TARGET_SPACE_KEY = "birst.target.spaceid";

    private final static String TARGET_SPACE_NAME = "birst.target.spaceName";

    private final static String SOURCE_SPACE_KEY = "birst.source.spaceid";

    private final static String SOURCE_SPACE_NAME = "birst.source.spaceName";

    private String loginToken;

    public synchronized static BirstProperties getInstance(){
       if(birstProperties == null){
           try {
               properties.load(BirstProperties.class.getResourceAsStream(PROPERTY_FILE));
           } catch (IOException e) {
               e.printStackTrace();
           }
           birstProperties = new BirstProperties();
       }
       return birstProperties;
    }

    private BirstProperties(){
    }

    public  String getAddress(){
        return  properties.getProperty(ADDRESS_KEY);
    }

    public  String getUser() throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String( decoder.decode(properties.getProperty(USER_KEY)));
    }

    public  String getPassword() throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(properties.getProperty(PWD_KEY)));
    }

    public  String getSourceSpaceName(){
        return properties.getProperty(SOURCE_SPACE_NAME);
    }

    public  String getTargetSpaceId(){
        return properties.getProperty(TARGET_SPACE_KEY);
    }

    public String getSourceSpaceId(){ return  properties.getProperty(SOURCE_SPACE_KEY);}

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getLoginToken()  {
        if(this.loginToken == null){
            LoginToken loginToken = new LoginToken();
            try {
               loginToken.Login(getUser(),getPassword());
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.loginToken = loginToken.getToken();
        }
       return loginToken;
    }


}
