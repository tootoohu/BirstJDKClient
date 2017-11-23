
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
 *         &lt;element name="getSubjectAreaPermissionsResult" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
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
    "getSubjectAreaPermissionsResult"
})
@XmlRootElement(name = "getSubjectAreaPermissionsResponse")
public class GetSubjectAreaPermissionsResponse {

    protected ArrayOfString getSubjectAreaPermissionsResult;

    /**
     * Gets the value of the getSubjectAreaPermissionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetSubjectAreaPermissionsResult() {
        return getSubjectAreaPermissionsResult;
    }

    /**
     * Sets the value of the getSubjectAreaPermissionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetSubjectAreaPermissionsResult(ArrayOfString value) {
        this.getSubjectAreaPermissionsResult = value;
    }

}
