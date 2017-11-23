
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
 *         &lt;element name="checkAndCreateDirectoryResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "checkAndCreateDirectoryResult"
})
@XmlRootElement(name = "checkAndCreateDirectoryResponse")
public class CheckAndCreateDirectoryResponse {

    protected boolean checkAndCreateDirectoryResult;

    /**
     * Gets the value of the checkAndCreateDirectoryResult property.
     * 
     */
    public boolean isCheckAndCreateDirectoryResult() {
        return checkAndCreateDirectoryResult;
    }

    /**
     * Sets the value of the checkAndCreateDirectoryResult property.
     * 
     */
    public void setCheckAndCreateDirectoryResult(boolean value) {
        this.checkAndCreateDirectoryResult = value;
    }

}
