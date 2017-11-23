
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfODBCColumnResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfODBCColumnResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ODBCColumnResult" type="{http://www.birst.com/}ODBCColumnResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfODBCColumnResult", propOrder = {
    "odbcColumnResult"
})
public class ArrayOfODBCColumnResult {

    @XmlElement(name = "ODBCColumnResult", nillable = true)
    protected List<ODBCColumnResult> odbcColumnResult;

    /**
     * Gets the value of the odbcColumnResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the odbcColumnResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getODBCColumnResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ODBCColumnResult }
     * 
     * 
     */
    public List<ODBCColumnResult> getODBCColumnResult() {
        if (odbcColumnResult == null) {
            odbcColumnResult = new ArrayList<ODBCColumnResult>();
        }
        return this.odbcColumnResult;
    }

}
