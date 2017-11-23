
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfGroupPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfGroupPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GroupPermission" type="{http://www.birst.com/}GroupPermission" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfGroupPermission", propOrder = {
    "groupPermission"
})
public class ArrayOfGroupPermission {

    @XmlElement(name = "GroupPermission", nillable = true)
    protected List<GroupPermission> groupPermission;

    /**
     * Gets the value of the groupPermission property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the groupPermission property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGroupPermission().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GroupPermission }
     * 
     * 
     */
    public List<GroupPermission> getGroupPermission() {
        if (groupPermission == null) {
            groupPermission = new ArrayList<GroupPermission>();
        }
        return this.groupPermission;
    }

}
