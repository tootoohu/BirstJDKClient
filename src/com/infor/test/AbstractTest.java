package com.infor.test;

import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.LoginToken;
import org.junit.Before;

public abstract class AbstractTest {

    private static String token;

    private static String spaceId;

    @Before
    public void setUp() throws Exception {

        BirstProperties properties = BirstProperties.getInstance();
        String address = properties.getAddress();
        String userName = properties.getUser();
        String pwd = properties.getPassword();

        spaceId = properties.getTargetSpaceId();
        LoginToken loginToken = new LoginToken();
        loginToken.Login(userName,pwd);
        token = loginToken.getToken();
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        AbstractTest.token = token;
    }

    public static String getSpaceId() {
        return spaceId;
    }

    public static void setSpaceId(String spaceId) {
        AbstractTest.spaceId = spaceId;
    }
}
