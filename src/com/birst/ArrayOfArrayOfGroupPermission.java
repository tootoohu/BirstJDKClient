
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfArrayOfGroupPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfArrayOfGroupPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ArrayOfGroupPermission" type="{http://www.birst.com/}ArrayOfGroupPermission" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfArrayOfGroupPermission", propOrder = {
    "arrayOfGroupPermission"
})
public class ArrayOfArrayOfGroupPermission {

    @XmlElement(name = "ArrayOfGroupPermission", nillable = true)
    protected List<ArrayOfGroupPermission> arrayOfGroupPermission;

    /**
     * Gets the value of the arrayOfGroupPermission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arrayOfGroupPermission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArrayOfGroupPermission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArrayOfGroupPermission }
     * 
     * 
     */
    public List<ArrayOfGroupPermission> getArrayOfGroupPermission() {
        if (arrayOfGroupPermission == null) {
            arrayOfGroupPermission = new ArrayList<ArrayOfGroupPermission>();
        }
        return this.arrayOfGroupPermission;
    }

}
