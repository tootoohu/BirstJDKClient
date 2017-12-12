package com.infor.model.webservice;

public class SourceEntry {

    private String name;

    private String type;

    private String width;

    private String hierarchy;

    private boolean isMeasure;

    private boolean analyzeByDate;

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

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public boolean isMeasure() {
        return isMeasure;
    }

    public void setMeasure(boolean measure) {
        isMeasure = measure;
    }

    public boolean isAnalyzeByDate() {
        return analyzeByDate;
    }

    public void setAnalyzeByDate(boolean analyzeByDate) {
        this.analyzeByDate = analyzeByDate;
    }
}
