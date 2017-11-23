
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
 *         &lt;element name="getDefaultProfileResult" type="{http://www.birst.com/}Profile" minOccurs="0"/>
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
    "getDefaultProfileResult"
})
@XmlRootElement(name = "getDefaultProfileResponse")
public class GetDefaultProfileResponse {

    protected Profile getDefaultProfileResult;

    /**
     * Gets the value of the getDefaultProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link Profile }
     *     
     */
    public Profile getGetDefaultProfileResult() {
        return getDefaultProfileResult;
    }

    /**
     * Sets the value of the getDefaultProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Profile }
     *     
     */
    public void setGetDefaultProfileResult(Profile value) {
        this.getDefaultProfileResult = value;
    }

}
