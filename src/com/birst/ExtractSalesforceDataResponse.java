
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
 *         &lt;element name="extractSalesforceDataResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "extractSalesforceDataResult"
})
@XmlRootElement(name = "extractSalesforceDataResponse")
public class ExtractSalesforceDataResponse {

    protected String extractSalesforceDataResult;

    /**
     * Gets the value of the extractSalesforceDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtractSalesforceDataResult() {
        return extractSalesforceDataResult;
    }

    /**
     * Sets the value of the extractSalesforceDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtractSalesforceDataResult(String value) {
        this.extractSalesforceDataResult = value;
    }

}
