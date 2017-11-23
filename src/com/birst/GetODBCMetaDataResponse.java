
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
 *         &lt;element name="getODBCMetaDataResult" type="{http://www.birst.com/}MetaDataResult" minOccurs="0"/>
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
    "getODBCMetaDataResult"
})
@XmlRootElement(name = "getODBCMetaDataResponse")
public class GetODBCMetaDataResponse {

    protected MetaDataResult getODBCMetaDataResult;

    /**
     * Gets the value of the getODBCMetaDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link MetaDataResult }
     *     
     */
    public MetaDataResult getGetODBCMetaDataResult() {
        return getODBCMetaDataResult;
    }

    /**
     * Sets the value of the getODBCMetaDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaDataResult }
     *     
     */
    public void setGetODBCMetaDataResult(MetaDataResult value) {
        this.getODBCMetaDataResult = value;
    }

}
