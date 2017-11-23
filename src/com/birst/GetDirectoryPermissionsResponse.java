
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
 *         &lt;element name="getDirectoryPermissionsResult" type="{http://www.birst.com/}ArrayOfGroupPermission" minOccurs="0"/>
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
    "getDirectoryPermissionsResult"
})
@XmlRootElement(name = "getDirectoryPermissionsResponse")
public class GetDirectoryPermissionsResponse {

    protected ArrayOfGroupPermission getDirectoryPermissionsResult;

    /**
     * Gets the value of the getDirectoryPermissionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfGroupPermission }
     *     
     */
    public ArrayOfGroupPermission getGetDirectoryPermissionsResult() {
        return getDirectoryPermissionsResult;
    }

    /**
     * Sets the value of the getDirectoryPermissionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfGroupPermission }
     *     
     */
    public void setGetDirectoryPermissionsResult(ArrayOfGroupPermission value) {
        this.getDirectoryPermissionsResult = value;
    }

}
