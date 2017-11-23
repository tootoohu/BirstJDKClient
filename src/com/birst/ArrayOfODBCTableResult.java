
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfODBCTableResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfODBCTableResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ODBCTableResult" type="{http://www.birst.com/}ODBCTableResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfODBCTableResult", propOrder = {
    "odbcTableResult"
})
public class ArrayOfODBCTableResult {

    @XmlElement(name = "ODBCTableResult", nillable = true)
    protected List<ODBCTableResult> odbcTableResult;

    /**
     * Gets the value of the odbcTableResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the odbcTableResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getODBCTableResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ODBCTableResult }
     * 
     * 
     */
    public List<ODBCTableResult> getODBCTableResult() {
        if (odbcTableResult == null) {
            odbcTableResult = new ArrayList<ODBCTableResult>();
        }
        return this.odbcTableResult;
    }

}
