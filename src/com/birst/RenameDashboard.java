
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
 *         &lt;element name="dashName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newDashName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "dashName",
    "newDashName"
})
@XmlRootElement(name = "renameDashboard")
public class RenameDashboard {

    protected String token;
    protected String spaceID;
    protected String dashName;
    protected String newDashName;

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
     * Gets the value of the dashName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDashName() {
        return dashName;
    }

    /**
     * Sets the value of the dashName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDashName(String value) {
        this.dashName = value;
    }

    /**
     * Gets the value of the newDashName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDashName() {
        return newDashName;
    }

    /**
     * Sets the value of the newDashName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDashName(String value) {
        this.newDashName = value;
    }

}
