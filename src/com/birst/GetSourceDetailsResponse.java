
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
 *         &lt;element name="getSourceDetailsResult" type="{http://www.birst.com/}StagingTableSubClass" minOccurs="0"/>
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
    "getSourceDetailsResult"
})
@XmlRootElement(name = "getSourceDetailsResponse")
public class GetSourceDetailsResponse {

    protected StagingTableSubClass getSourceDetailsResult;

    /**
     * Gets the value of the getSourceDetailsResult property.
     * 
     * @return
     *     possible object is
     *     {@link StagingTableSubClass }
     *     
     */
    public StagingTableSubClass getGetSourceDetailsResult() {
        return getSourceDetailsResult;
    }

    /**
     * Sets the value of the getSourceDetailsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link StagingTableSubClass }
     *     
     */
    public void setGetSourceDetailsResult(StagingTableSubClass value) {
        this.getSourceDetailsResult = value;
    }

}
