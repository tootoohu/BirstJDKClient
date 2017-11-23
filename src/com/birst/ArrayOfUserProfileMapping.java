
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUserProfileMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUserProfileMapping">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UserProfileMapping" type="{http://www.birst.com/}UserProfileMapping" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUserProfileMapping", propOrder = {
    "userProfileMapping"
})
public class ArrayOfUserProfileMapping {

    @XmlElement(name = "UserProfileMapping", nillable = true)
    protected List<UserProfileMapping> userProfileMapping;

    /**
     * Gets the value of the userProfileMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userProfileMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserProfileMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserProfileMapping }
     * 
     * 
     */
    public List<UserProfileMapping> getUserProfileMapping() {
        if (userProfileMapping == null) {
            userProfileMapping = new ArrayList<UserProfileMapping>();
        }
        return this.userProfileMapping;
    }

}
