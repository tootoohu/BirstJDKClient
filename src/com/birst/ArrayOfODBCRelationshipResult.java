
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfODBCRelationshipResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfODBCRelationshipResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ODBCRelationshipResult" type="{http://www.birst.com/}ODBCRelationshipResult" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfODBCRelationshipResult", propOrder = {
    "odbcRelationshipResult"
})
public class ArrayOfODBCRelationshipResult {

    @XmlElement(name = "ODBCRelationshipResult", nillable = true)
    protected List<ODBCRelationshipResult> odbcRelationshipResult;

    /**
     * Gets the value of the odbcRelationshipResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the odbcRelationshipResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getODBCRelationshipResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ODBCRelationshipResult }
     * 
     * 
     */
    public List<ODBCRelationshipResult> getODBCRelationshipResult() {
        if (odbcRelationshipResult == null) {
            odbcRelationshipResult = new ArrayList<ODBCRelationshipResult>();
        }
        return this.odbcRelationshipResult;
    }

}
