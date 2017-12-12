package com.infor.model.webservice;

import com.birst.ArrayOfODBCColumnResult;
import com.birst.ArrayOfString;

import java.util.List;

public class CustomSubjectArea {

    protected String tableName;
    protected boolean isFact;
    protected List<CustomColumn> columns;

    public static class CustomColumn {

        protected String columnName;
        protected String birstColumnName;
        protected int dataType;
        protected int width;
        protected List<String> aggsSupported;
        protected int key;
        protected boolean isFact;

        public CustomColumn(String columnName, String birstColumnName, int dataType, int width, List<String> aggsSupported, int key, boolean isFact) {
            this.columnName = columnName;
            this.birstColumnName = birstColumnName;
            this.dataType = dataType;
            this.width = width;
            this.aggsSupported = aggsSupported;
            this.key = key;
            this.isFact = isFact;
        }

        public String getColumnName() {
            return columnName;
        }

        public void setColumnName(String columnName) {
            this.columnName = columnName;
        }

        public String getBirstColumnName() {
            return birstColumnName;
        }

        public void setBirstColumnName(String birstColumnName) {
            this.birstColumnName = birstColumnName;
        }

        public int getDataType() {
            return dataType;
        }

        public void setDataType(int dataType) {
            this.dataType = dataType;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<String> getAggsSupported() {
            return aggsSupported;
        }

        public void setAggsSupported(List<String> aggsSupported) {
            this.aggsSupported = aggsSupported;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public boolean isFact() {
            return isFact;
        }

        public void setFact(boolean fact) {
            isFact = fact;
        }
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isFact() {
        return isFact;
    }

    public void setFact(boolean fact) {
        isFact = fact;
    }

    public List<CustomColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<CustomColumn> columns) {
        this.columns = columns;
    }
}
