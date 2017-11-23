
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
 *         &lt;element name="getLiveAccessSourceDetailsResult" type="{http://www.birst.com/}LiveAccessSourceSubClass" minOccurs="0"/>
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
    "getLiveAccessSourceDetailsResult"
})
@XmlRootElement(name = "getLiveAccessSourceDetailsResponse")
public class GetLiveAccessSourceDetailsResponse {

    protected LiveAccessSourceSubClass getLiveAccessSourceDetailsResult;

    /**
     * Gets the value of the getLiveAccessSourceDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link LiveAccessSourceSubClass }
     *     
     */
    public LiveAccessSourceSubClass getGetLiveAccessSourceDetailsResult() {
        return getLiveAccessSourceDetailsResult;
    }

    /**
     * Sets the value of the getLiveAccessSourceDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link LiveAccessSourceSubClass }
     *     
     */
    public void setGetLiveAccessSourceDetailsResult(LiveAccessSourceSubClass value) {
        this.getLiveAccessSourceDetailsResult = value;
    }

}
