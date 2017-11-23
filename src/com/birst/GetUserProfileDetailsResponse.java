
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
 *         &lt;element name="getUserProfileDetailsResult" type="{http://www.birst.com/}Profile" minOccurs="0"/>
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
    "getUserProfileDetailsResult"
})
@XmlRootElement(name = "getUserProfileDetailsResponse")
public class GetUserProfileDetailsResponse {

    protected Profile getUserProfileDetailsResult;

    /**
     * Gets the value of the getUserProfileDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link Profile }
     *     
     */
    public Profile getGetUserProfileDetailsResult() {
        return getUserProfileDetailsResult;
    }

    /**
     * Sets the value of the getUserProfileDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Profile }
     *     
     */
    public void setGetUserProfileDetailsResult(Profile value) {
        this.getUserProfileDetailsResult = value;
    }

}
