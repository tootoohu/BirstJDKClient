
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for QueryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="QueryResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="rows" type="{http://www.birst.com/}ArrayOfArrayOfString" minOccurs="0"/>
 *         &lt;element name="columnNames" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="displayNames" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="dataTypes" type="{http://www.birst.com/}ArrayOfInt" minOccurs="0"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "QueryResult", propOrder = {
    "rows",
    "columnNames",
    "displayNames",
    "dataTypes",
    "errorMessage",
    "errorCode"
})
@XmlSeeAlso({
    CommandQueryResult.class
})
public class QueryResult {

    protected ArrayOfArrayOfString rows;
    protected ArrayOfString columnNames;
    protected ArrayOfString displayNames;
    protected ArrayOfInt dataTypes;
    protected String errorMessage;
    @XmlElement(defaultValue = "0")
    protected Integer errorCode;

    /**
     * Gets the value of the rows property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public ArrayOfArrayOfString getRows() {
        return rows;
    }

    /**
     * Sets the value of the rows property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public void setRows(ArrayOfArrayOfString value) {
        this.rows = value;
    }

    /**
     * Gets the value of the columnNames property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getColumnNames() {
        return columnNames;
    }

    /**
     * Sets the value of the columnNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setColumnNames(ArrayOfString value) {
        this.columnNames = value;
    }

    /**
     * Gets the value of the displayNames property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getDisplayNames() {
        return displayNames;
    }

    /**
     * Sets the value of the displayNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setDisplayNames(ArrayOfString value) {
        this.displayNames = value;
    }

    /**
     * Gets the value of the dataTypes property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfInt }
     *     
     */
    public ArrayOfInt getDataTypes() {
        return dataTypes;
    }

    /**
     * Sets the value of the dataTypes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfInt }
     *     
     */
    public void setDataTypes(ArrayOfInt value) {
        this.dataTypes = value;
    }

    /**
     * Gets the value of the errorMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets the value of the errorMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setErrorMessage(String value) {
        this.errorMessage = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setErrorCode(Integer value) {
        this.errorCode = value;
    }

}
