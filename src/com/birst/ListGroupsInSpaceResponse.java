
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
 *         &lt;element name="listGroupsInSpaceResult" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
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
    "listGroupsInSpaceResult"
})
@XmlRootElement(name = "listGroupsInSpaceResponse")
public class ListGroupsInSpaceResponse {

    protected ArrayOfString listGroupsInSpaceResult;

    /**
     * Gets the value of the listGroupsInSpaceResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getListGroupsInSpaceResult() {
        return listGroupsInSpaceResult;
    }

    /**
     * Sets the value of the listGroupsInSpaceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setListGroupsInSpaceResult(ArrayOfString value) {
        this.listGroupsInSpaceResult = value;
    }

}
