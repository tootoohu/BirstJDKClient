
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
 *         &lt;element name="copyCatalogDirectoryResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "copyCatalogDirectoryResult"
})
@XmlRootElement(name = "copyCatalogDirectoryResponse")
public class CopyCatalogDirectoryResponse {

    protected String copyCatalogDirectoryResult;

    /**
     * Gets the value of the copyCatalogDirectoryResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyCatalogDirectoryResult() {
        return copyCatalogDirectoryResult;
    }

    /**
     * Sets the value of the copyCatalogDirectoryResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyCatalogDirectoryResult(String value) {
        this.copyCatalogDirectoryResult = value;
    }

}
