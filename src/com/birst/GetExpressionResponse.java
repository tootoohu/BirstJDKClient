
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
 *         &lt;element name="getExpressionResult" type="{http://www.birst.com/}SavedExpression" minOccurs="0"/>
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
    "getExpressionResult"
})
@XmlRootElement(name = "getExpressionResponse")
public class GetExpressionResponse {

    protected SavedExpression getExpressionResult;

    /**
     * Gets the value of the getExpressionResult property.
     * 
     * @return
     *     possible object is
     *     {@link SavedExpression }
     *     
     */
    public SavedExpression getGetExpressionResult() {
        return getExpressionResult;
    }

    /**
     * Sets the value of the getExpressionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SavedExpression }
     *     
     */
    public void setGetExpressionResult(SavedExpression value) {
        this.getExpressionResult = value;
    }

}
