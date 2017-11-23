
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connectorName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extractGroups" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "token",
    "spaceID",
    "connectorName",
    "extractGroups"
})
@XmlRootElement(name = "extractConnectorData")
public class ExtractConnectorData {

    protected String token;
    protected String spaceID;
    protected String connectorName;
    protected ArrayOfString extractGroups;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the spaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceID() {
        return spaceID;
    }

    /**
     * Sets the value of the spaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceID(String value) {
        this.spaceID = value;
    }

    /**
     * Gets the value of the connectorName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectorName() {
        return connectorName;
    }

    /**
     * Sets the value of the connectorName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectorName(String value) {
        this.connectorName = value;
    }

    /**
     * Gets the value of the extractGroups property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getExtractGroups() {
        return extractGroups;
    }

    /**
     * Sets the value of the extractGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setExtractGroups(ArrayOfString value) {
        this.extractGroups = value;
    }

}
