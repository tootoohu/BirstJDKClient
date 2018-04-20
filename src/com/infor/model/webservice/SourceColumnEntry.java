package com.infor.model.webservice;

public class SourceColumnEntry {

    private String name;

    private String type;

    private int width;

    private String dimension;

    private boolean isMeasure;

    private boolean analyzeByDate;

    private boolean isKey;

    public SourceColumnEntry(String name, String type, int width) {
        this.name = name;
        this.type = type;
        this.width = width;
    }

    public boolean isKey() {
        return isKey;
    }

    public void setKey(boolean key) {
        isKey = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public boolean isMeasure() {
        return this.type.equalsIgnoreCase("Float") || type.equalsIgnoreCase("Integer");
    }

    public void setMeasure(boolean measure) {
        isMeasure = measure;
    }

    public boolean isAnalyzeByDate() {
        return getType().equalsIgnoreCase("Date") ||getType().equalsIgnoreCase("DateTime");
    }

    public String getHierarchyName(String mainSourceName){
        if(isMeasure || isAnalyzeByDate())
            return mainSourceName;
        return this.name;
    }
    public void setAnalyzeByDate(boolean analyzeByDate) {
        this.analyzeByDate = analyzeByDate;
    }
}
