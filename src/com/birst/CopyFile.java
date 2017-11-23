
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
 *         &lt;element name="fromSpaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fromFileOrDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toSpaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toFileOrDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="overwrite" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "fromSpaceID",
    "fromFileOrDir",
    "toSpaceID",
    "toFileOrDir",
    "overwrite"
})
@XmlRootElement(name = "copyFile")
public class CopyFile {

    protected String token;
    protected String fromSpaceID;
    protected String fromFileOrDir;
    protected String toSpaceID;
    protected String toFileOrDir;
    protected boolean overwrite;

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
     * Gets the value of the fromSpaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromSpaceID() {
        return fromSpaceID;
    }

    /**
     * Sets the value of the fromSpaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromSpaceID(String value) {
        this.fromSpaceID = value;
    }

    /**
     * Gets the value of the fromFileOrDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromFileOrDir() {
        return fromFileOrDir;
    }

    /**
     * Sets the value of the fromFileOrDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromFileOrDir(String value) {
        this.fromFileOrDir = value;
    }

    /**
     * Gets the value of the toSpaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSpaceID() {
        return toSpaceID;
    }

    /**
     * Sets the value of the toSpaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSpaceID(String value) {
        this.toSpaceID = value;
    }

    /**
     * Gets the value of the toFileOrDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToFileOrDir() {
        return toFileOrDir;
    }

    /**
     * Sets the value of the toFileOrDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToFileOrDir(String value) {
        this.toFileOrDir = value;
    }

    /**
     * Gets the value of the overwrite property.
     * 
     */
    public boolean isOverwrite() {
        return overwrite;
    }

    /**
     * Sets the value of the overwrite property.
     * 
     */
    public void setOverwrite(boolean value) {
        this.overwrite = value;
    }

}
