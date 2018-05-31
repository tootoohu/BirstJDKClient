package com.infor.model.ui;

import javafx.scene.control.CheckBox;

import javax.xml.transform.Source;

public class SourceDetail {
    private String name;
    private String hierarchy;
    private int width;
    private String type;
    private Checkbox measure = new Checkbox();;
    private Checkbox analyzeMeasure = new Checkbox();;
    private Checkbox analyzeByDate = new Checkbox();;
    private Checkbox keyColumn = new Checkbox();;

    public SourceDetail(String name, String hierarchy,int width,String type){
        this.name = name;
        this.hierarchy = hierarchy;
        this.width = width;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Checkbox getMeasure() {
        return measure;
    }

    public void setMeasure(Checkbox measure) {
        this.measure = measure;
    }

    public Checkbox getAnalyzeMeasure() {
        return analyzeMeasure;
    }

    public void setAnalyzeMeasure(Checkbox analyzeMeasure) {
        this.analyzeMeasure = analyzeMeasure;
    }

    public Checkbox getAnalyzeByDate() {
        return analyzeByDate;
    }

    public void setAnalyzeByDate(Checkbox analyzeByDate) {
        this.analyzeByDate = analyzeByDate;
    }

    public Checkbox getKeyColumn() {
        return keyColumn;
    }

    public void setKeyColumn(Checkbox keyColumn) {
        this.keyColumn = keyColumn;
    }
}
