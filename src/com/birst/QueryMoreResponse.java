
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
 *         &lt;element name="queryMoreResult" type="{http://www.birst.com/}CommandQueryResult" minOccurs="0"/>
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
    "queryMoreResult"
})
@XmlRootElement(name = "queryMoreResponse")
public class QueryMoreResponse {

    protected CommandQueryResult queryMoreResult;

    /**
     * Gets the value of the queryMoreResult property.
     * 
     * @return
     *     possible object is
     *     {@link CommandQueryResult }
     *     
     */
    public CommandQueryResult getQueryMoreResult() {
        return queryMoreResult;
    }

    /**
     * Sets the value of the queryMoreResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommandQueryResult }
     *     
     */
    public void setQueryMoreResult(CommandQueryResult value) {
        this.queryMoreResult = value;
    }

}
