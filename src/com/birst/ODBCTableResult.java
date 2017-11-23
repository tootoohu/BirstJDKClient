
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ODBCTableResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ODBCTableResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isFact" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="columns" type="{http://www.birst.com/}ArrayOfODBCColumnResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ODBCTableResult", propOrder = {
    "tableName",
    "isFact",
    "columns"
})
public class ODBCTableResult {

    protected String tableName;
    protected boolean isFact;
    protected ArrayOfODBCColumnResult columns;

    /**
     * Gets the value of the tableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * Sets the value of the tableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTableName(String value) {
        this.tableName = value;
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

    /**
     * Gets the value of the columns property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfODBCColumnResult }
     *     
     */
    public ArrayOfODBCColumnResult getColumns() {
        return columns;
    }

    /**
     * Sets the value of the columns property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfODBCColumnResult }
     *     
     */
    public void setColumns(ArrayOfODBCColumnResult value) {
        this.columns = value;
    }

}
