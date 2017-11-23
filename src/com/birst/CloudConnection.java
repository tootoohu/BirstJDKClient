
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CloudConnection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CloudConnection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConnectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ExtractionGroups" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CloudConnection", propOrder = {
    "connectionName",
    "extractionGroups"
})
public class CloudConnection {

    @XmlElement(name = "ConnectionName")
    protected String connectionName;
    @XmlElement(name = "ExtractionGroups")
    protected ArrayOfString extractionGroups;

    /**
     * Gets the value of the connectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectionName() {
        return connectionName;
    }

    /**
     * Sets the value of the connectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectionName(String value) {
        this.connectionName = value;
    }

    /**
     * Gets the value of the extractionGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getExtractionGroups() {
        return extractionGroups;
    }

    /**
     * Sets the value of the extractionGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setExtractionGroups(ArrayOfString value) {
        this.extractionGroups = value;
    }

}
