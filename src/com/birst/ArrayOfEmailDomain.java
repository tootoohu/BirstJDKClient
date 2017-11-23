
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfEmailDomain complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfEmailDomain">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="EmailDomain" type="{http://www.birst.com/}EmailDomain" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfEmailDomain", propOrder = {
    "emailDomain"
})
public class ArrayOfEmailDomain {

    @XmlElement(name = "EmailDomain", nillable = true)
    protected List<EmailDomain> emailDomain;

    /**
     * Gets the value of the emailDomain property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the emailDomain property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEmailDomain().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EmailDomain }
     * 
     * 
     */
    public List<EmailDomain> getEmailDomain() {
        if (emailDomain == null) {
            emailDomain = new ArrayList<EmailDomain>();
        }
        return this.emailDomain;
    }

}
