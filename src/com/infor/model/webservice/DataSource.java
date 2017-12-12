package com.infor.model.webservice;

import java.util.List;

public class DataSource {

    private String name;

    private List<SourceEntry> sourceEntryList;

    private boolean isDimension;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SourceEntry> getSourceEntryList() {
        return sourceEntryList;
    }

    public void setSourceEntryList(List<SourceEntry> sourceEntryList) {
        this.sourceEntryList = sourceEntryList;
    }

    public boolean isDimension() {
        return isDimension;
    }

    public void setDimension(boolean dimension) {
        isDimension = dimension;
    }
}
