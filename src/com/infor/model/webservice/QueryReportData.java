package com.infor.model.webservice;

import com.birst.ArrayOfArrayOfString;
import com.birst.ArrayOfInt;
import com.birst.ArrayOfString;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

public class QueryReportData {

    private List<String> rows;
    private List<String> columnNames;
    private List<String> displayNames;
    private List<String> dataTypes;
    private String errorMessage;

    private Integer errorCode;
    private int numRowsReturned;

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    public List<String> getColumnNames() {
        return columnNames;
    }

    public void setColumnNames(List<String> columnNames) {
        this.columnNames = columnNames;
    }

    public List<String> getDisplayNames() {
        return displayNames;
    }

    public void setDisplayNames(List<String> displayNames) {
        this.displayNames = displayNames;
    }

    public List<String> getDataTypes() {
        return dataTypes;
    }

    public void setDataTypes(List<String> dataTypes) {
        this.dataTypes = dataTypes;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public int getNumRowsReturned() {
        return numRowsReturned;
    }

    public void setNumRowsReturned(int numRowsReturned) {
        this.numRowsReturned = numRowsReturned;
    }
}
