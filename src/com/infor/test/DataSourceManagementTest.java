package com.infor.test;

import com.birst.ArrayOfLevelMetadata;
import com.birst.HierarchyMetadata;
import com.infor.admin.CustomSubjectAreaConverter;
import com.infor.admin.DataSourceManagement;
import com.infor.model.webservice.CustomSubjectArea;
import org.junit.After;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DataSourceManagementTest extends AbstractTest{
    @Test
    public void setSourceDetails() throws Exception {
    }

    @Test
    public void getODBCMetaData() throws Exception {
    }

    @Test
    public void createHierarchy() throws Exception {
        HierarchyMetadata hierarchyMetadata = new HierarchyMetadata();
        hierarchyMetadata.setName("Financial Income QA Analysis");

        dataSourceManagement.createHierarchy(getToken(),getSpaceId(),hierarchyMetadata);
    }

    DataSourceManagement dataSourceManagement = new DataSourceManagement();
    
    @Test
    public void getODBCTableResult() throws Exception {
        List<CustomSubjectArea> odbcTableResult = dataSourceManagement.getODBCTableResult(getToken(), getSpaceId());

        CustomSubjectAreaConverter.Output2File("test.xls", odbcTableResult);
    }

    
    @After
    public void tearDown() throws Exception {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("itcast");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(new Object());
        em.getTransaction().commit();
        em.close();
        factory.close();
    }

    @Test
    public void getSourcesList() throws Exception {

    }

    @Test
    public void getAllHierarchies() throws Exception {

    }

    @Test
    public void deleteHierarchy() throws Exception {

    }

    @Test
    public void getSubjectAreaPermissions() throws Exception {

    }


    @Test
    public void getSourceDetails() throws Exception {
    }

}