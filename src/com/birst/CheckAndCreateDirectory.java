
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
 *         &lt;element name="parentDir" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newDirectoryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "parentDir",
    "newDirectoryName"
})
@XmlRootElement(name = "checkAndCreateDirectory")
public class CheckAndCreateDirectory {

    protected String token;
    protected String spaceID;
    protected String parentDir;
    protected String newDirectoryName;

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
     * Gets the value of the parentDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentDir() {
        return parentDir;
    }

    /**
     * Sets the value of the parentDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentDir(String value) {
        this.parentDir = value;
    }

    /**
     * Gets the value of the newDirectoryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewDirectoryName() {
        return newDirectoryName;
    }

    /**
     * Sets the value of the newDirectoryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewDirectoryName(String value) {
        this.newDirectoryName = value;
    }

}
