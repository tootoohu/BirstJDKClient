
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
 *         &lt;element name="getLiveAccessColumnPropertiesResult" type="{http://www.birst.com/}LiveAccessSourceColumnSubClass" minOccurs="0"/>
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
    "getLiveAccessColumnPropertiesResult"
})
@XmlRootElement(name = "getLiveAccessColumnPropertiesResponse")
public class GetLiveAccessColumnPropertiesResponse {

    protected LiveAccessSourceColumnSubClass getLiveAccessColumnPropertiesResult;

    /**
     * Gets the value of the getLiveAccessColumnPropertiesResult property.
     * 
     * @return
     *     possible object is
     *     {@link LiveAccessSourceColumnSubClass }
     *     
     */
    public LiveAccessSourceColumnSubClass getGetLiveAccessColumnPropertiesResult() {
        return getLiveAccessColumnPropertiesResult;
    }

    /**
     * Sets the value of the getLiveAccessColumnPropertiesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiveAccessSourceColumnSubClass }
     *     
     */
    public void setGetLiveAccessColumnPropertiesResult(LiveAccessSourceColumnSubClass value) {
        this.getLiveAccessColumnPropertiesResult = value;
    }

}
