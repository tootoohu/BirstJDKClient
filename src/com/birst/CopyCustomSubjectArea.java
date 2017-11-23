
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
 *         &lt;element name="fromSpaceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customSubjectAreaName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toSpaceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fromSpaceId",
    "customSubjectAreaName",
    "toSpaceId"
})
@XmlRootElement(name = "copyCustomSubjectArea")
public class CopyCustomSubjectArea {

    protected String token;
    protected String fromSpaceId;
    protected String customSubjectAreaName;
    protected String toSpaceId;

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
     * Gets the value of the fromSpaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromSpaceId() {
        return fromSpaceId;
    }

    /**
     * Sets the value of the fromSpaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromSpaceId(String value) {
        this.fromSpaceId = value;
    }

    /**
     * Gets the value of the customSubjectAreaName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomSubjectAreaName() {
        return customSubjectAreaName;
    }

    /**
     * Sets the value of the customSubjectAreaName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomSubjectAreaName(String value) {
        this.customSubjectAreaName = value;
    }

    /**
     * Gets the value of the toSpaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSpaceId() {
        return toSpaceId;
    }

    /**
     * Sets the value of the toSpaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSpaceId(String value) {
        this.toSpaceId = value;
    }

}
