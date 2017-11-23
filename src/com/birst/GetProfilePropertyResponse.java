
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
 *         &lt;element name="getProfilePropertyResult" type="{http://www.birst.com/}ArrayOfProfileProperty" minOccurs="0"/>
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
    "getProfilePropertyResult"
})
@XmlRootElement(name = "getProfilePropertyResponse")
public class GetProfilePropertyResponse {

    protected ArrayOfProfileProperty getProfilePropertyResult;

    /**
     * Gets the value of the getProfilePropertyResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfProfileProperty }
     *     
     */
    public ArrayOfProfileProperty getGetProfilePropertyResult() {
        return getProfilePropertyResult;
    }

    /**
     * Sets the value of the getProfilePropertyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfProfileProperty }
     *     
     */
    public void setGetProfilePropertyResult(ArrayOfProfileProperty value) {
        this.getProfilePropertyResult = value;
    }

}
