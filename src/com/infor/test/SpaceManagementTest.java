package com.infor.test;

import com.infor.admin.SpaceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.LoginToken;
import org.junit.Before;
import org.junit.Test;

public class SpaceManagementTest {
    @Test
    public void extractCloudConnectorData() throws Exception {
        sm.extractCloudConnectorData(token,spaceId,"CSI");
    }

    private SpaceManagement sm = new SpaceManagement();
    private static String token;
    private static String spaceId;
    private static String userName;

    @Before
    public void setUp() throws Exception {
        BirstProperties properties = new BirstProperties("/resources/birst.properties");
        String address = properties.getAddress();
        userName = properties.getUser();
        String pwd = properties.getPassword();
        spaceId = properties.getTargetSpaceId();
        LoginToken loginToken = new LoginToken();
        loginToken.Login(userName,pwd);
        token = loginToken.getToken();
    }

    @Test
    public void setLanguageForUser() throws Exception {
        sm.setLanguageForUser(token,userName, "FR-fr");
    }

    @Test
    public void deleteSpace() throws Exception {

    }

    @Test
    public void deleteSubjectArea() throws Exception {
    }

    @Test
    public void executeQueryInSpace() throws Exception {
    }






}
