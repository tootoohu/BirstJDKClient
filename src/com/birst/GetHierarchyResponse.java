
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
 *         &lt;element name="getHierarchyResult" type="{http://www.birst.com/}HierarchyMetadata" minOccurs="0"/>
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
    "getHierarchyResult"
})
@XmlRootElement(name = "getHierarchyResponse")
public class GetHierarchyResponse {

    protected HierarchyMetadata getHierarchyResult;

    /**
     * Gets the value of the getHierarchyResult property.
     * 
     * @return
     *     possible object is
     *     {@link HierarchyMetadata }
     *     
     */
    public HierarchyMetadata getGetHierarchyResult() {
        return getHierarchyResult;
    }

    /**
     * Sets the value of the getHierarchyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link HierarchyMetadata }
     *     
     */
    public void setGetHierarchyResult(HierarchyMetadata value) {
        this.getHierarchyResult = value;
    }

}
