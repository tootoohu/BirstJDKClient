
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
 *         &lt;element name="extractConnectorDataResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "extractConnectorDataResult"
})
@XmlRootElement(name = "extractConnectorDataResponse")
public class ExtractConnectorDataResponse {

    protected String extractConnectorDataResult;

    /**
     * Gets the value of the extractConnectorDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtractConnectorDataResult() {
        return extractConnectorDataResult;
    }

    /**
     * Sets the value of the extractConnectorDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtractConnectorDataResult(String value) {
        this.extractConnectorDataResult = value;
    }

}
