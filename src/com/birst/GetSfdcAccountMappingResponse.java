
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
 *         &lt;element name="getSfdcAccountMappingResult" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
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
    "getSfdcAccountMappingResult"
})
@XmlRootElement(name = "getSfdcAccountMappingResponse")
public class GetSfdcAccountMappingResponse {

    protected ArrayOfString getSfdcAccountMappingResult;

    /**
     * Gets the value of the getSfdcAccountMappingResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetSfdcAccountMappingResult() {
        return getSfdcAccountMappingResult;
    }

    /**
     * Sets the value of the getSfdcAccountMappingResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetSfdcAccountMappingResult(ArrayOfString value) {
        this.getSfdcAccountMappingResult = value;
    }

}
