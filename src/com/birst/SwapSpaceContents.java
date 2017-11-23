
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
 *         &lt;element name="sp1ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp2ID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sp1ID",
    "sp2ID"
})
@XmlRootElement(name = "swapSpaceContents")
public class SwapSpaceContents {

    protected String token;
    protected String sp1ID;
    protected String sp2ID;

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
     * Gets the value of the sp1ID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSp1ID() {
        return sp1ID;
    }

    /**
     * Sets the value of the sp1ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSp1ID(String value) {
        this.sp1ID = value;
    }

    /**
     * Gets the value of the sp2ID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSp2ID() {
        return sp2ID;
    }

    /**
     * Sets the value of the sp2ID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSp2ID(String value) {
        this.sp2ID = value;
    }

}
