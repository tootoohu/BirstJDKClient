
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpaceStatistics complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpaceStatistics">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpaceSize" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UserCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpaceStatistics", propOrder = {
    "spaceSize",
    "userCount"
})
public class SpaceStatistics {

    @XmlElement(name = "SpaceSize")
    protected String spaceSize;
    @XmlElement(name = "UserCount")
    protected int userCount;

    /**
     * Gets the value of the spaceSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceSize() {
        return spaceSize;
    }

    /**
     * Sets the value of the spaceSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceSize(String value) {
        this.spaceSize = value;
    }

    /**
     * Gets the value of the userCount property.
     * 
     */
    public int getUserCount() {
        return userCount;
    }

    /**
     * Sets the value of the userCount property.
     * 
     */
    public void setUserCount(int value) {
        this.userCount = value;
    }

}
