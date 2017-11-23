
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
 *         &lt;element name="userProfileList" type="{http://www.birst.com/}ArrayOfUserProfileMapping" minOccurs="0"/>
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
    "userProfileList"
})
@XmlRootElement(name = "linkProfileToUsers")
public class LinkProfileToUsers {

    protected String token;
    protected ArrayOfUserProfileMapping userProfileList;

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
     * Gets the value of the userProfileList property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserProfileMapping }
     *     
     */
    public ArrayOfUserProfileMapping getUserProfileList() {
        return userProfileList;
    }

    /**
     * Sets the value of the userProfileList property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserProfileMapping }
     *     
     */
    public void setUserProfileList(ArrayOfUserProfileMapping value) {
        this.userProfileList = value;
    }

}
