
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
 *         &lt;element name="getDefaultProfileDetailsResult" type="{http://www.birst.com/}Profile" minOccurs="0"/>
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
    "getDefaultProfileDetailsResult"
})
@XmlRootElement(name = "getDefaultProfileDetailsResponse")
public class GetDefaultProfileDetailsResponse {

    protected Profile getDefaultProfileDetailsResult;

    /**
     * Gets the value of the getDefaultProfileDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link Profile }
     *     
     */
    public Profile getGetDefaultProfileDetailsResult() {
        return getDefaultProfileDetailsResult;
    }

    /**
     * Sets the value of the getDefaultProfileDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Profile }
     *     
     */
    public void setGetDefaultProfileDetailsResult(Profile value) {
        this.getDefaultProfileDetailsResult = value;
    }

}
