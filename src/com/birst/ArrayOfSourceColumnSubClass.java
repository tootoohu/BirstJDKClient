
package com.birst;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfSourceColumnSubClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfSourceColumnSubClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SourceColumnSubClass" type="{http://www.birst.com/}SourceColumnSubClass" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfSourceColumnSubClass", propOrder = {
    "sourceColumnSubClass"
})
public class ArrayOfSourceColumnSubClass {

    @XmlElement(name = "SourceColumnSubClass", nillable = true)
    protected List<SourceColumnSubClass> sourceColumnSubClass;

    /**
     * Gets the value of the sourceColumnSubClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceColumnSubClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceColumnSubClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceColumnSubClass }
     * 
     * 
     */
    public List<SourceColumnSubClass> getSourceColumnSubClass() {
        if (sourceColumnSubClass == null) {
            sourceColumnSubClass = new ArrayList<SourceColumnSubClass>();
        }
        return this.sourceColumnSubClass;
    }

}
