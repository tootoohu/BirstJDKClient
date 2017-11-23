
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfProfileProperty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProfileProperty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProfileProperty" type="{http://www.birst.com/}ProfileProperty" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProfileProperty", propOrder = {
    "profileProperty"
})
public class ArrayOfProfileProperty {

    @XmlElement(name = "ProfileProperty", nillable = true)
    protected List<ProfileProperty> profileProperty;

    /**
     * Gets the value of the profileProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the profileProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProfileProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProfileProperty }
     * 
     * 
     */
    public List<ProfileProperty> getProfileProperty() {
        if (profileProperty == null) {
            profileProperty = new ArrayList<ProfileProperty>();
        }
        return this.profileProperty;
    }

}
