
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
 *         &lt;element name="getProfilePropertyWithLocaleResult" type="{http://www.birst.com/}ProfileProperty" minOccurs="0"/>
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
    "getProfilePropertyWithLocaleResult"
})
@XmlRootElement(name = "getProfilePropertyWithLocaleResponse")
public class GetProfilePropertyWithLocaleResponse {

    protected ProfileProperty getProfilePropertyWithLocaleResult;

    /**
     * Gets the value of the getProfilePropertyWithLocaleResult property.
     * 
     * @return
     *     possible object is
     *     {@link ProfileProperty }
     *     
     */
    public ProfileProperty getGetProfilePropertyWithLocaleResult() {
        return getProfilePropertyWithLocaleResult;
    }

    /**
     * Sets the value of the getProfilePropertyWithLocaleResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProfileProperty }
     *     
     */
    public void setGetProfilePropertyWithLocaleResult(ProfileProperty value) {
        this.getProfilePropertyWithLocaleResult = value;
    }

}
