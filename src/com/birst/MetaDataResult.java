
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MetaDataResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MetaDataResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tables" type="{http://www.birst.com/}ArrayOfODBCTableResult" minOccurs="0"/>
 *         &lt;element name="relationships" type="{http://www.birst.com/}ArrayOfODBCRelationshipResult" minOccurs="0"/>
 *         &lt;element name="errorCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="errorMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MetaDataResult", propOrder = {
    "tables",
    "relationships",
    "errorCode",
    "errorMessage"
})
public class MetaDataResult {

    protected ArrayOfODBCTableResult tables;
    protected ArrayOfODBCRelationshipResult relationships;
    protected int errorCode;
    protected String errorMessage;

    /**
     * Gets the value of the tables property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfODBCTableResult }
     *     
     */
    public ArrayOfODBCTableResult getTables() {
        return tables;
    }

    /**
     * Sets the value of the tables property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfODBCTableResult }
     *     
     */
    public void setTables(ArrayOfODBCTableResult value) {
        this.tables = value;
    }

    /**
     * Gets the value of the relationships property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfODBCRelationshipResult }
     *     
     */
    public ArrayOfODBCRelationshipResult getRelationships() {
        return relationships;
    }

    /**
     * Sets the value of the relationships property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfODBCRelationshipResult }
     *     
     */
    public void setRelationships(ArrayOfODBCRelationshipResult value) {
        this.relationships = value;
    }

    /**
     * Gets the value of the errorCode property.
     * 
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Sets the value of the errorCode property.
     * 
     */
    public void setErrorCode(int value) {
        this.errorCode = value;
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

}
