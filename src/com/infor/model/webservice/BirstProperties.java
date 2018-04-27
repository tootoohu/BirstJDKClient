package com.infor.model.webservice;

import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

public class BirstProperties {

    private Properties properties = new Properties();

    private static String addressKey = "birst.address";

    private static String userKey = "birst.username";

    private static String pwdKey = "birst.password";

    private static String targetSpaceKey = "birst.target.spaceid";

    private static String targetSpaceName = "birst.target.spaceName";

    private static String sourceSpaceKey = "birst.source.spaceid";

    private static String sourceSpaceName = "birst.source.spaceName";


    private String loginToken;

    public BirstProperties(String propertyFile){
        try {
            properties.load(BirstProperties.class.getResourceAsStream(propertyFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  String getAddress(){
        return  properties.getProperty(addressKey);
    }

    public  String getUser() throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String( decoder.decode(properties.getProperty(userKey)));

    }

    public  String getPassword() throws IOException {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(properties.getProperty(pwdKey)));
    }

    public  String getSourceSpaceName(){
        return properties.getProperty(sourceSpaceName);
    }

    public  String getTargetSpaceId(){
        return properties.getProperty(targetSpaceKey);
    }

    public String getSourceSpaceId(){ return  properties.getProperty(sourceSpaceKey);}

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
