
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ODBCColumnResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ODBCColumnResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="columnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birstColumnName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="aggsSupported" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="key" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="isFact" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ODBCColumnResult", propOrder = {
    "columnName",
    "birstColumnName",
    "dataType",
    "width",
    "aggsSupported",
    "key",
    "isFact"
})
public class ODBCColumnResult {

    protected String columnName;
    protected String birstColumnName;
    protected int dataType;
    protected int width;
    protected ArrayOfString aggsSupported;
    protected int key;
    protected boolean isFact;

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
     * Gets the value of the birstColumnName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirstColumnName() {
        return birstColumnName;
    }

    /**
     * Sets the value of the birstColumnName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirstColumnName(String value) {
        this.birstColumnName = value;
    }

    /**
     * Gets the value of the dataType property.
     * 
     */
    public int getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     */
    public void setDataType(int value) {
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
     * Gets the value of the aggsSupported property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getAggsSupported() {
        return aggsSupported;
    }

    /**
     * Sets the value of the aggsSupported property.
     * 
     * @param value
     *     allowed object is`
     *     {@link ArrayOfString }
     *     
     */
    public void setAggsSupported(ArrayOfString value) {
        this.aggsSupported = value;
    }

    /**
     * Gets the value of the key property.
     * 
     */
    public int getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     */
    public void setKey(int value) {
        this.key = value;
    }

    /**
     * Gets the value of the isFact property.
     * 
     */
    public boolean isIsFact() {
        return isFact;
    }

    /**
     * Sets the value of the isFact property.
     * 
     */
    public void setIsFact(boolean value) {
        this.isFact = value;
    }

}
