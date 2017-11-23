
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
 *         &lt;element name="sp1Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sp2Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="syncImportedPackages" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sp1Name",
    "sp2Name",
    "syncImportedPackages"
})
@XmlRootElement(name = "swapSpaceForPackages")
public class SwapSpaceForPackages {

    protected String token;
    protected String sp1Name;
    protected String sp2Name;
    protected boolean syncImportedPackages;

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
     * Gets the value of the sp1Name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSp1Name() {
        return sp1Name;
    }

    /**
     * Sets the value of the sp1Name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSp1Name(String value) {
        this.sp1Name = value;
    }

    /**
     * Gets the value of the sp2Name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSp2Name() {
        return sp2Name;
    }

    /**
     * Sets the value of the sp2Name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSp2Name(String value) {
        this.sp2Name = value;
    }

    /**
     * Gets the value of the syncImportedPackages property.
     * 
     */
    public boolean isSyncImportedPackages() {
        return syncImportedPackages;
    }

    /**
     * Sets the value of the syncImportedPackages property.
     * 
     */
    public void setSyncImportedPackages(boolean value) {
        this.syncImportedPackages = value;
    }

}
