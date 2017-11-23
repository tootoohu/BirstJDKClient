
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LiveAccessSourceColumnSubClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiveAccessSourceColumnSubClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ColumnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Formula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="DataType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Attribute" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Measure" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AnalyzeByDate" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiveAccessSourceColumnSubClass", propOrder = {
    "sourceName",
    "columnName",
    "formula",
    "dataType",
    "width",
    "attribute",
    "measure",
    "analyzeByDate"
})
public class LiveAccessSourceColumnSubClass {

    @XmlElement(name = "SourceName")
    protected String sourceName;
    @XmlElement(name = "ColumnName")
    protected String columnName;
    @XmlElement(name = "Formula")
    protected String formula;
    @XmlElement(name = "DataType")
    protected String dataType;
    @XmlElement(name = "Width")
    protected int width;
    @XmlElement(name = "Attribute")
    protected boolean attribute;
    @XmlElement(name = "Measure")
    protected boolean measure;
    @XmlElement(name = "AnalyzeByDate")
    protected boolean analyzeByDate;

    /**
     * Gets the value of the sourceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceName() {
        return sourceName;
    }

    /**
     * Sets the value of the sourceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceName(String value) {
        this.sourceName = value;
    }

    /**
     * Gets the value of the columnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getColumnName() {
        return columnName;
    }

    /**
     * Sets the value of the columnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setColumnName(String value) {
        this.columnName = value;
    }

    /**
     * Gets the value of the formula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormula() {
        return formula;
    }

    /**
     * Sets the value of the formula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormula(String value) {
        this.formula = value;
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
     * Gets the value of the attribute property.
     * 
     */
    public boolean isAttribute() {
        return attribute;
    }

    /**
     * Sets the value of the attribute property.
     * 
     */
    public void setAttribute(boolean value) {
        this.attribute = value;
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

}
