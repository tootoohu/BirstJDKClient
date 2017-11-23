
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
 *         &lt;element name="loadStagingtableFromS3BucketResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "loadStagingtableFromS3BucketResult"
})
@XmlRootElement(name = "loadStagingtableFromS3BucketResponse")
public class LoadStagingtableFromS3BucketResponse {

    protected String loadStagingtableFromS3BucketResult;

    /**
     * Gets the value of the loadStagingtableFromS3BucketResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadStagingtableFromS3BucketResult() {
        return loadStagingtableFromS3BucketResult;
    }

    /**
     * Sets the value of the loadStagingtableFromS3BucketResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadStagingtableFromS3BucketResult(String value) {
        this.loadStagingtableFromS3BucketResult = value;
    }

}
