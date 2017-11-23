
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUserSpace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUserSpace">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserSpace" type="{http://www.birst.com/}UserSpace" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUserSpace", propOrder = {
    "userSpace"
})
public class ArrayOfUserSpace {

    @XmlElement(name = "UserSpace", nillable = true)
    protected List<UserSpace> userSpace;

    /**
     * Gets the value of the userSpace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userSpace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserSpace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserSpace }
     * 
     * 
     */
    public List<UserSpace> getUserSpace() {
        if (userSpace == null) {
            userSpace = new ArrayList<UserSpace>();
        }
        return this.userSpace;
    }

}
