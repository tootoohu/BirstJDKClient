
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
 *         &lt;element name="getJobStatusResult" type="{http://www.birst.com/}StatusResult" minOccurs="0"/>
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
    "getJobStatusResult"
})
@XmlRootElement(name = "getJobStatusResponse")
public class GetJobStatusResponse {

    protected StatusResult getJobStatusResult;

    /**
     * Gets the value of the getJobStatusResult property.
     * 
     * @return
     *     possible object is
     *     {@link StatusResult }
     *     
     */
    public StatusResult getGetJobStatusResult() {
        return getJobStatusResult;
    }

    /**
     * Sets the value of the getJobStatusResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusResult }
     *     
     */
    public void setGetJobStatusResult(StatusResult value) {
        this.getJobStatusResult = value;
    }

}
