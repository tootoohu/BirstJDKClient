package com.infor.model.webservice;

import java.util.List;

public class DataSource {

    private String name;

    private List<SourceColumnEntry> sourceEntryList;

    private boolean isDimension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SourceColumnEntry> getSourceEntryList() {
        return sourceEntryList;
    }

    public void setSourceEntryList(List<SourceColumnEntry> sourceEntryList) {
        this.sourceEntryList = sourceEntryList;
    }

    public boolean isDimension() {
        return isDimension;
    }

    public void setDimension(boolean dimension) {
        isDimension = dimension;
    }
}
