package com.infor.model.webservice;

public class SourceEntry {

    private String name;

    private String tableName;

    private boolean isCube;

    public SourceEntry(String name,boolean isCube){
        this.name = name;
        this.isCube = isCube;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public boolean isCube() {
        return isCube;
    }

    public void setCube(boolean cube) {
        isCube = cube;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SourceEntry that = (SourceEntry) o;

        if (isCube != that.isCube) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return tableName != null ? tableName.equals(that.tableName) : that.tableName == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (tableName != null ? tableName.hashCode() : 0);
        result = 31 * result + (isCube ? 1 : 0);
        return result;
    }
}
