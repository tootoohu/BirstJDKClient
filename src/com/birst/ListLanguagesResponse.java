
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
 *         &lt;element name="listLanguagesResult" type="{http://www.birst.com/}ArrayOfLanguage" minOccurs="0"/>
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
    "listLanguagesResult"
})
@XmlRootElement(name = "listLanguagesResponse")
public class ListLanguagesResponse {

    protected ArrayOfLanguage listLanguagesResult;

    /**
     * Gets the value of the listLanguagesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfLanguage }
     *     
     */
    public ArrayOfLanguage getListLanguagesResult() {
        return listLanguagesResult;
    }

    /**
     * Sets the value of the listLanguagesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfLanguage }
     *     
     */
    public void setListLanguagesResult(ArrayOfLanguage value) {
        this.listLanguagesResult = value;
    }

}
