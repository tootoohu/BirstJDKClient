
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
 *         &lt;element name="listAllSpacesResult" type="{http://www.birst.com/}ArrayOfUserSpace" minOccurs="0"/>
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
    "listAllSpacesResult"
})
@XmlRootElement(name = "listAllSpacesResponse")
public class ListAllSpacesResponse {

    protected ArrayOfUserSpace listAllSpacesResult;

    /**
     * Gets the value of the listAllSpacesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserSpace }
     *     
     */
    public ArrayOfUserSpace getListAllSpacesResult() {
        return listAllSpacesResult;
    }

    /**
     * Sets the value of the listAllSpacesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserSpace }
     *     
     */
    public void setListAllSpacesResult(ArrayOfUserSpace value) {
        this.listAllSpacesResult = value;
    }

}
