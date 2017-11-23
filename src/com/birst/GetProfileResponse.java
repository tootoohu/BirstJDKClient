
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
 *         &lt;element name="getProfileResult" type="{http://www.birst.com/}Profile" minOccurs="0"/>
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
    "getProfileResult"
})
@XmlRootElement(name = "getProfileResponse")
public class GetProfileResponse {

    protected Profile getProfileResult;

    /**
     * Gets the value of the getProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link Profile }
     *     
     */
    public Profile getGetProfileResult() {
        return getProfileResult;
    }

    /**
     * Sets the value of the getProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Profile }
     *     
     */
    public void setGetProfileResult(Profile value) {
        this.getProfileResult = value;
    }

}
