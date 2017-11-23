package com.infor.model;

import java.io.IOException;
import java.util.Properties;

public class BirstProperties {

    private  Properties properties = new Properties();

    private  String addressKey = "birst.address";

    private  String userKey = "birst.username";

    private  String pwdKey = "birst.password";

    private  String spaceKey = "birst.spaceid";

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

    public  String getUser(){
        return properties.getProperty(userKey);
    }

    public  String getPassword(){
        return properties.getProperty(pwdKey);
    }

    public  String getSpaceId(){
        return properties.getProperty(spaceKey);
    }


}
