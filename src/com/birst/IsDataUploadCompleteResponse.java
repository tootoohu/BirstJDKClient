
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
 *         &lt;element name="isDataUploadCompleteResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "isDataUploadCompleteResult"
})
@XmlRootElement(name = "isDataUploadCompleteResponse")
public class IsDataUploadCompleteResponse {

    protected boolean isDataUploadCompleteResult;

    /**
     * Gets the value of the isDataUploadCompleteResult property.
     * 
     */
    public boolean isIsDataUploadCompleteResult() {
        return isDataUploadCompleteResult;
    }

    /**
     * Sets the value of the isDataUploadCompleteResult property.
     * 
     */
    public void setIsDataUploadCompleteResult(boolean value) {
        this.isDataUploadCompleteResult = value;
    }

}
