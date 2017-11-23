
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
 *         &lt;element name="clearCacheInSpaceResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "clearCacheInSpaceResult"
})
@XmlRootElement(name = "clearCacheInSpaceResponse")
public class ClearCacheInSpaceResponse {

    protected boolean clearCacheInSpaceResult;

    /**
     * Gets the value of the clearCacheInSpaceResult property.
     * 
     */
    public boolean isClearCacheInSpaceResult() {
        return clearCacheInSpaceResult;
    }

    /**
     * Sets the value of the clearCacheInSpaceResult property.
     * 
     */
    public void setClearCacheInSpaceResult(boolean value) {
        this.clearCacheInSpaceResult = value;
    }

}
