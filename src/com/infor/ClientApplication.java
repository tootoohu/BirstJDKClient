package com.infor;

import com.birst.ArrayOfSourceColumnSubClass;
import com.birst.SourceColumnSubClass;
import com.birst.StagingTableSubClass;
import com.infor.admin.DataSourceManagement;
import com.infor.model.webservice.BirstProperties;
import com.infor.model.webservice.LoginToken;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ClientApplication {


    private static DataSourceManagement dataSourceManagement = new DataSourceManagement();

    private static String token;

    private static String spaceId;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println("which task would you take to execute?");
        System.out.println("1: Retrieve all hierarchies");
        System.out.println("2: Retrieve all Data Sources");
        System.out.println("3: Retrieve Data Source Detail");
        Scanner scan = new Scanner(System.in);
      //  String read = scan.nextLine();
        String read;
        while((read = scan.nextLine()) != " "){
            switch (read){
                case "1": getAllHierarchies(); break;
                case "2": getSourcesList(); break;
                case "3":  System.out.println("please enter the source name:"); read = scan.nextLine(); getSourceDetail(read);break;
                default:
                    System.out.println("Please enter the correct number!");
            }
        }

    }

    private static void init(){
        BirstProperties properties = new BirstProperties("/resources/birst.properties");
        String address = properties.getAddress();
        String userName = null;
        String pwd = null;
        try {
            userName = properties.getUser();
             pwd = properties.getPassword();
        } catch (IOException e) {
            e.printStackTrace();
        }

        spaceId = properties.getTargetSpaceId();
        LoginToken loginToken = new LoginToken();
        loginToken.Login(userName,pwd);
        token = loginToken.getToken();
    }

    private static void getAllHierarchies(){
        List<String> hierarchies = dataSourceManagement.getAllHierarchies(token,spaceId);
        System.out.println("Retrieve all hierarchies");

        Collections.sort(hierarchies);
        hierarchies.forEach(k -> System.out.println(k));
        System.out.println("Total " + hierarchies.size() + " hierarchies");

    }

    private static void getSourcesList(){
        List<String> sourceList = dataSourceManagement.getSourcesList(token,spaceId);
        Collections.sort(sourceList);
        System.out.println("Retrieve all Sources");
        sourceList.forEach(v -> System.out.println(v));
        System.out.println("Total " + sourceList.size() + " data sources");
    }

    private static void getSourceDetail(String name){

        StagingTableSubClass detail = dataSourceManagement.getSourceDetails(token,spaceId,name);

        ArrayOfSourceColumnSubClass columns = detail.getColumns();

        for (SourceColumnSubClass column: columns.getSourceColumnSubClass() ) {
            System.out.print(column.getName() + "       ");
            System.out.print(" Data Type: " + column.getDataType() + " ");
            System.out.print(" Width: " + column.getWidth());
            System.out.println(" Measure: " + column.isMeasure());
        }

    }
}
