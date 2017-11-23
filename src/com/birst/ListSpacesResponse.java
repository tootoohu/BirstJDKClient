
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
 *         &lt;element name="listSpacesResult" type="{http://www.birst.com/}ArrayOfUserSpace" minOccurs="0"/>
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
    "listSpacesResult"
})
@XmlRootElement(name = "listSpacesResponse")
public class ListSpacesResponse {

    protected ArrayOfUserSpace listSpacesResult;

    /**
     * Gets the value of the listSpacesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfUserSpace }
     *     
     */
    public ArrayOfUserSpace getListSpacesResult() {
        return listSpacesResult;
    }

    /**
     * Sets the value of the listSpacesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfUserSpace }
     *     
     */
    public void setListSpacesResult(ArrayOfUserSpace value) {
        this.listSpacesResult = value;
    }

}
