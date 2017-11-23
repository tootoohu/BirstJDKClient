
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
 *         &lt;element name="fileOrDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toSpaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="toDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "fileOrDir",
    "toSpaceID",
    "toDir"
})
@XmlRootElement(name = "copyFileOrDirectory")
public class CopyFileOrDirectory {

    protected String token;
    protected String fromSpaceID;
    protected String fileOrDir;
    protected String toSpaceID;
    protected String toDir;

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
     * Gets the value of the fileOrDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileOrDir() {
        return fileOrDir;
    }

    /**
     * Sets the value of the fileOrDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileOrDir(String value) {
        this.fileOrDir = value;
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
     * Gets the value of the toDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToDir() {
        return toDir;
    }

    /**
     * Sets the value of the toDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToDir(String value) {
        this.toDir = value;
    }

}
