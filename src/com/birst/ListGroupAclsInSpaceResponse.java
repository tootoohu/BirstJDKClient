
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
 *         &lt;element name="listGroupAclsInSpaceResult" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
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
    "listGroupAclsInSpaceResult"
})
@XmlRootElement(name = "listGroupAclsInSpaceResponse")
public class ListGroupAclsInSpaceResponse {

    protected ArrayOfString listGroupAclsInSpaceResult;

    /**
     * Gets the value of the listGroupAclsInSpaceResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getListGroupAclsInSpaceResult() {
        return listGroupAclsInSpaceResult;
    }

    /**
     * Sets the value of the listGroupAclsInSpaceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setListGroupAclsInSpaceResult(ArrayOfString value) {
        this.listGroupAclsInSpaceResult = value;
    }

}
