
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
 *         &lt;element name="getVariablesForSpaceResult" type="{http://www.birst.com/}ArrayOfArrayOfString" minOccurs="0"/>
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
    "getVariablesForSpaceResult"
})
@XmlRootElement(name = "getVariablesForSpaceResponse")
public class GetVariablesForSpaceResponse {

    protected ArrayOfArrayOfString getVariablesForSpaceResult;

    /**
     * Gets the value of the getVariablesForSpaceResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public ArrayOfArrayOfString getGetVariablesForSpaceResult() {
        return getVariablesForSpaceResult;
    }

    /**
     * Sets the value of the getVariablesForSpaceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfArrayOfString }
     *     
     */
    public void setGetVariablesForSpaceResult(ArrayOfArrayOfString value) {
        this.getVariablesForSpaceResult = value;
    }

}
