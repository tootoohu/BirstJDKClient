
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SourceColumnSubClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceColumnSubClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OriginalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="AnalyzeMeasure" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DataType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Format" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EnableSecutityFilter" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="SourceFileColumn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="TargetAggregations" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="TargetTypes" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="UnknownValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="HierarchyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LevelName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Levels" type="{http://www.birst.com/}ArrayOfArrayOfString" minOccurs="0"/>
 *         &lt;element name="AnalyzeByDate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Measure" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="LockType" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceColumnSubClass", propOrder = {
    "name",
    "originalName",
    "analyzeMeasure",
    "dataType",
    "format",
    "enableSecutityFilter",
    "sourceFileColumn",
    "targetAggregations",
    "targetTypes",
    "unknownValue",
    "width",
    "hierarchyName",
    "levelName",
    "levels",
    "analyzeByDate",
    "measure",
    "lockType"
})
public class SourceColumnSubClass {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "OriginalName")
    protected String originalName;
    @XmlElement(name = "AnalyzeMeasure", defaultValue = "false")
    protected Boolean analyzeMeasure;
    @XmlElement(name = "DataType")
    protected String dataType;
    @XmlElement(name = "Format")
    protected String format;
    @XmlElement(name = "EnableSecutityFilter")
    protected boolean enableSecutityFilter;
    @XmlElement(name = "SourceFileColumn")
    protected String sourceFileColumn;
    @XmlElement(name = "TargetAggregations")
    protected ArrayOfString targetAggregations;
    @XmlElement(name = "TargetTypes")
    protected ArrayOfString targetTypes;
    @XmlElement(name = "UnknownValue")
    protected String unknownValue;
    @XmlElement(name = "Width")
    protected int width;
    @XmlElement(name = "HierarchyName")
    protected String hierarchyName;
    @XmlElement(name = "LevelName")
    protected String levelName;
    @XmlElement(name = "Levels")
    protected ArrayOfArrayOfString levels;
    @XmlElement(name = "AnalyzeByDate")
    protected boolean analyzeByDate;
    @XmlElement(name = "Measure")
    protected boolean measure;
    @XmlElement(name = "LockType")
    protected boolean lockType;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the originalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOriginalName() {
        return originalName;
    }

    /**
     * Sets the value of the originalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOriginalName(String value) {
        this.originalName = value;
    }

    /**
     * Gets the value of the analyzeMeasure property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnalyzeMeasure() {
        return analyzeMeasure;
    }

    /**
     * Sets the value of the analyzeMeasure property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnalyzeMeasure(Boolean value) {
        this.analyzeMeasure = value;
    }

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataType(String value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Gets the value of the enableSecutityFilter property.
     * 
     */
    public boolean isEnableSecutityFilter() {
        return enableSecutityFilter;
    }

    /**
     * Sets the value of the enableSecutityFilter property.
     * 
     */
    public void setEnableSecutityFilter(boolean value) {
        this.enableSecutityFilter = value;
    }

    /**
     * Gets the value of the sourceFileColumn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceFileColumn() {
        return sourceFileColumn;
    }

    /**
     * Sets the value of the sourceFileColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceFileColumn(String value) {
        this.sourceFileColumn = value;
    }

    /**
     * Gets the value of the targetAggregations property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getTargetAggregations() {
        return targetAggregations;
    }

    /**
     * Sets the value of the targetAggregations property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setTargetAggregations(ArrayOfString value) {
        this.targetAggregations = value;
    }

    /**
     * Gets the value of the targetTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getTargetTypes() {
        return targetTypes;
    }

    /**
     * Sets the value of the targetTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setTargetTypes(ArrayOfString value) {
        this.targetTypes = value;
    }

    /**
     * Gets the value of the unknownValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnknownValue() {
        return unknownValue;
    }

    /**
     * Sets the value of the unknownValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnknownValue(String value) {
        this.unknownValue = value;
    }

    /**
     * Gets the value of the width property.
     * 
     */
    public int getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     */
    public void setWidth(int value) {
        this.width = value;
    }

    /**
     * Gets the value of the hierarchyName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHierarchyName() {
        return hierarchyName;
    }

    /**
     * Sets the value of the hierarchyName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHierarchyName(String value) {
        this.hierarchyName = value;
    }

    /**
     * Gets the value of the levelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * Sets the value of the levelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLevelName(String value) {
        this.levelName = value;
    }

    /**
     * Gets the value of the levels property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public ArrayOfArrayOfString getLevels() {
        return levels;
    }

    /**
     * Sets the value of the levels property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public void setLevels(ArrayOfArrayOfString value) {
        this.levels = value;
    }

    /**
     * Gets the value of the analyzeByDate property.
     * 
     */
    public boolean isAnalyzeByDate() {
        return analyzeByDate;
    }

    /**
     * Sets the value of the analyzeByDate property.
     * 
     */
    public void setAnalyzeByDate(boolean value) {
        this.analyzeByDate = value;
    }

    /**
     * Gets the value of the measure property.
     * 
     */
    public boolean isMeasure() {
        return measure;
    }

    /**
     * Sets the value of the measure property.
     * 
     */
    public void setMeasure(boolean value) {
        this.measure = value;
    }

    /**
     * Gets the value of the lockType property.
     * 
     */
    public boolean isLockType() {
        return lockType;
    }

    /**
     * Sets the value of the lockType property.
     * 
     */
    public void setLockType(boolean value) {
        this.lockType = value;
    }

}
