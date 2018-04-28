package com.infor.admin;

import com.infor.util.BirstXmlWriter;
import com.infor.util.DataSourceContainer;
import com.infor.util.XmlWriterInterface;

public class ExportManagement {


    private DataSourceManagement dataSourceManagement;


    public ExportManagement(DataSourceManagement dsm){

        this.dataSourceManagement = dsm;
    }

    public void Export(String tokenId, String spaceId, String spaceName){
        DataSourceContainer dsc = dataSourceManagement.ReadFromSpace(tokenId, spaceId);
        XmlWriterInterface writer = new BirstXmlWriter();
        writer.writeSourceList(spaceName,dsc.getSources());
        writer.writeHierarchyList(spaceName, dsc.getHierarchies());

    }

}
