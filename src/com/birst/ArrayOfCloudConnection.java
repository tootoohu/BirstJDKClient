
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfCloudConnection complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfCloudConnection">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CloudConnection" type="{http://www.birst.com/}CloudConnection" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfCloudConnection", propOrder = {
    "cloudConnection"
})
public class ArrayOfCloudConnection {

    @XmlElement(name = "CloudConnection", nillable = true)
    protected List<CloudConnection> cloudConnection;

    /**
     * Gets the value of the cloudConnection property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cloudConnection property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCloudConnection().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CloudConnection }
     * 
     * 
     */
    public List<CloudConnection> getCloudConnection() {
        if (cloudConnection == null) {
            cloudConnection = new ArrayList<CloudConnection>();
        }
        return this.cloudConnection;
    }

}
