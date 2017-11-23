
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
 *         &lt;element name="isJobCompleteResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isJobCompleteResult"
})
@XmlRootElement(name = "isJobCompleteResponse")
public class IsJobCompleteResponse {

    protected boolean isJobCompleteResult;

    /**
     * Gets the value of the isJobCompleteResult property.
     * 
     */
    public boolean isIsJobCompleteResult() {
        return isJobCompleteResult;
    }

    /**
     * Sets the value of the isJobCompleteResult property.
     * 
     */
    public void setIsJobCompleteResult(boolean value) {
        this.isJobCompleteResult = value;
    }

}
