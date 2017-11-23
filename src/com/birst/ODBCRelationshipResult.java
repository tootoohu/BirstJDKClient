
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ODBCRelationshipResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ODBCRelationshipResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="primaryTable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foreignTable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="primaryTableColumn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="foreignTableColumn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ODBCRelationshipResult", propOrder = {
    "primaryTable",
    "foreignTable",
    "primaryTableColumn",
    "foreignTableColumn"
})
public class ODBCRelationshipResult {

    protected String primaryTable;
    protected String foreignTable;
    protected String primaryTableColumn;
    protected String foreignTableColumn;

    /**
     * Gets the value of the primaryTable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryTable() {
        return primaryTable;
    }

    /**
     * Sets the value of the primaryTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryTable(String value) {
        this.primaryTable = value;
    }

    /**
     * Gets the value of the foreignTable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignTable() {
        return foreignTable;
    }

    /**
     * Sets the value of the foreignTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignTable(String value) {
        this.foreignTable = value;
    }

    /**
     * Gets the value of the primaryTableColumn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryTableColumn() {
        return primaryTableColumn;
    }

    /**
     * Sets the value of the primaryTableColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryTableColumn(String value) {
        this.primaryTableColumn = value;
    }

    /**
     * Gets the value of the foreignTableColumn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForeignTableColumn() {
        return foreignTableColumn;
    }

    /**
     * Sets the value of the foreignTableColumn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForeignTableColumn(String value) {
        this.foreignTableColumn = value;
    }

}
