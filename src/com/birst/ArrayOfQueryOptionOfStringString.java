
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfQueryOptionOfStringString complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfQueryOptionOfStringString">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="QueryOptionOfStringString" type="{http://www.birst.com/}QueryOptionOfStringString" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfQueryOptionOfStringString", propOrder = {
    "queryOptionOfStringString"
})
public class ArrayOfQueryOptionOfStringString {

    @XmlElement(name = "QueryOptionOfStringString", nillable = true)
    protected List<QueryOptionOfStringString> queryOptionOfStringString;

    /**
     * Gets the value of the queryOptionOfStringString property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the queryOptionOfStringString property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getQueryOptionOfStringString().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link QueryOptionOfStringString }
     * 
     * 
     */
    public List<QueryOptionOfStringString> getQueryOptionOfStringString() {
        if (queryOptionOfStringString == null) {
            queryOptionOfStringString = new ArrayList<QueryOptionOfStringString>();
        }
        return this.queryOptionOfStringString;
    }

}
