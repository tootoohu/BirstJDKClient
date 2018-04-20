package com.infor.model.webservice;

import com.birst.ArrayOfArrayOfString;
import com.birst.ArrayOfString;

import java.util.Date;
import java.util.List;
@Deprecated
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

    public static class SourceColumn{
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

        public Boolean getAnalyzeMeasure() {
            return analyzeMeasure;
        }

        public void setAnalyzeMeasure(Boolean analyzeMeasure) {
            this.analyzeMeasure = analyzeMeasure;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getFormat() {
            return format;
        }

        public void setFormat(String format) {
            this.format = format;
        }

        public boolean isEnableSecutityFilter() {
            return enableSecutityFilter;
        }

        public void setEnableSecutityFilter(boolean enableSecutityFilter) {
            this.enableSecutityFilter = enableSecutityFilter;
        }

        public String getSourceFileColumn() {
            return sourceFileColumn;
        }

        public void setSourceFileColumn(String sourceFileColumn) {
            this.sourceFileColumn = sourceFileColumn;
        }

        public List<String> getTargetAggregations() {
            return targetAggregations;
        }

        public void setTargetAggregations(List<String> targetAggregations) {
            this.targetAggregations = targetAggregations;
        }

        public List<String> getTargetTypes() {
            return targetTypes;
        }

        public void setTargetTypes(List<String> targetTypes) {
            this.targetTypes = targetTypes;
        }

        public String getUnknownValue() {
            return unknownValue;
        }

        public void setUnknownValue(String unknownValue) {
            this.unknownValue = unknownValue;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public String getHierarchyName() {
            return hierarchyName;
        }

        public void setHierarchyName(String hierarchyName) {
            this.hierarchyName = hierarchyName;
        }

        public String getLevelName() {
            return levelName;
        }

        public void setLevelName(String levelName) {
            this.levelName = levelName;
        }

        public List<List<String>> getLevels() {
            return levels;
        }

        public void setLevels(List<List<String>> levels) {
            this.levels = levels;
        }

        public boolean isAnalyzeByDate() {
            return analyzeByDate;
        }

        public void setAnalyzeByDate(boolean analyzeByDate) {
            this.analyzeByDate = analyzeByDate;
        }

        public boolean isMeasure() {
            return measure;
        }

        public void setMeasure(boolean measure) {
            this.measure = measure;
        }

        public boolean isLockType() {
            return lockType;
        }

        public void setLockType(boolean lockType) {
            this.lockType = lockType;
        }
    }

     public static class ScriptDetail{
        protected String inputQuery;
        protected String output;
        protected String script;

        public String getInputQuery() {
            return inputQuery;
        }

        public void setInputQuery(String inputQuery) {
            this.inputQuery = inputQuery;
        }

        public String getOutput() {
            return output;
        }

        public void setOutput(String output) {
            this.output = output;
        }

        public String getScript() {
            return script;
        }

        public void setScript(String script) {
            this.script = script;
        }
    }

}
