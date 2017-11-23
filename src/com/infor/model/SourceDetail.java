package com.infor.model;

import com.birst.ArrayOfArrayOfString;
import com.birst.ArrayOfString;

import java.util.Date;
import java.util.List;

public class SourceDetail {

    private String name;

    private String originalName;

    private boolean disabled;

    private ScriptDetail script;

    private Date lastModifiedDate;

    private List<String> subGroups;

    private List<SourceColumn> columns;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public ScriptDetail getScript() {
        return script;
    }

    public void setScript(ScriptDetail script) {
        this.script = script;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public List<String> getSubGroups() {
        return subGroups;
    }

    public void setSubGroups(List<String> subGroups) {
        this.subGroups = subGroups;
    }

    public List<SourceColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<SourceColumn> columns) {
        this.columns = columns;
    }

    class SourceColumn{
        protected String name;

        protected String originalName;

        protected Boolean analyzeMeasure;

        protected String dataType;

        protected String format;

        protected boolean enableSecutityFilter;

        protected String sourceFileColumn;

        protected List<String> targetAggregations;

        protected List<String> targetTypes;

        protected String unknownValue;

        protected int width;

        protected String hierarchyName;

        protected String levelName;

        protected List<List<String>> levels;

        protected boolean analyzeByDate;

        protected boolean measure;

        protected boolean lockType;
    }

    class ScriptDetail{
        protected String inputQuery;
        protected String output;
        protected String script;
    }

}
