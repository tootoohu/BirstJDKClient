
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="GetSpacePropertiesResult" type="{http://www.birst.com/}SpaceProperties" minOccurs="0"/>
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
    "getSpacePropertiesResult"
})
@XmlRootElement(name = "GetSpacePropertiesResponse")
public class GetSpacePropertiesResponse {

    @XmlElement(name = "GetSpacePropertiesResult")
    protected SpaceProperties getSpacePropertiesResult;

    /**
     * Gets the value of the getSpacePropertiesResult property.
     * 
     * @return
     *     possible object is
     *     {@link SpaceProperties }
     *     
     */
    public SpaceProperties getGetSpacePropertiesResult() {
        return getSpacePropertiesResult;
    }

    /**
     * Sets the value of the getSpacePropertiesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpaceProperties }
     *     
     */
    public void setGetSpacePropertiesResult(SpaceProperties value) {
        this.getSpacePropertiesResult = value;
    }

}
