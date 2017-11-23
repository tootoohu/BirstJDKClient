package com.infor.test;

import com.birst.UserSpace;
import com.infor.admin.SpaceManagement;
import com.infor.model.BirstProperties;
import com.infor.model.LoginToken;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runners.Suite;

import java.util.List;

import static org.junit.Assert.*;

public class SpaceManagementTest {

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
        spaceId = properties.getSpaceId();
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


    @Test
    public void listAllSpaces() throws Exception{
        List<UserSpace> list = sm.listAllSpaces(token);
        System.out.println(list);
    }

}
