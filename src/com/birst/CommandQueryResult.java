
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CommandQueryResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CommandQueryResult">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.birst.com/}QueryResult">
 *       &lt;sequence>
 *         &lt;element name="queryToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numRowsReturned" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="hasMoreRows" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CommandQueryResult", propOrder = {
    "queryToken",
    "numRowsReturned",
    "hasMoreRows"
})
public class CommandQueryResult
    extends QueryResult
{

    protected String queryToken;
    protected int numRowsReturned;
    protected boolean hasMoreRows;

    /**
     * Gets the value of the queryToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueryToken() {
        return queryToken;
    }

    /**
     * Sets the value of the queryToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueryToken(String value) {
        this.queryToken = value;
    }

    /**
     * Gets the value of the numRowsReturned property.
     * 
     */
    public int getNumRowsReturned() {
        return numRowsReturned;
    }

    /**
     * Sets the value of the numRowsReturned property.
     * 
     */
    public void setNumRowsReturned(int value) {
        this.numRowsReturned = value;
    }

    /**
     * Gets the value of the hasMoreRows property.
     * 
     */
    public boolean isHasMoreRows() {
        return hasMoreRows;
    }

    /**
     * Sets the value of the hasMoreRows property.
     * 
     */
    public void setHasMoreRows(boolean value) {
        this.hasMoreRows = value;
    }

}
