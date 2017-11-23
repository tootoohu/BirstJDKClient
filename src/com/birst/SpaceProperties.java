
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SpaceProperties complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SpaceProperties">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SpaceName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="SpaceTimeZone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UsageTracking" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="IsDocumentRepository" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="AlwaysOn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="UseNewDashboards" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpaceProperties", propOrder = {
    "spaceName",
    "spaceTimeZone",
    "usageTracking",
    "isDocumentRepository",
    "alwaysOn",
    "useNewDashboards"
})
public class SpaceProperties {

    @XmlElement(name = "SpaceName")
    protected String spaceName;
    @XmlElement(name = "SpaceTimeZone")
    protected String spaceTimeZone;
    @XmlElement(name = "UsageTracking")
    protected boolean usageTracking;
    @XmlElement(name = "IsDocumentRepository")
    protected boolean isDocumentRepository;
    @XmlElement(name = "AlwaysOn")
    protected boolean alwaysOn;
    @XmlElement(name = "UseNewDashboards")
    protected boolean useNewDashboards;

    /**
     * Gets the value of the spaceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceName() {
        return spaceName;
    }

    /**
     * Sets the value of the spaceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceName(String value) {
        this.spaceName = value;
    }

    /**
     * Gets the value of the spaceTimeZone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceTimeZone() {
        return spaceTimeZone;
    }

    /**
     * Sets the value of the spaceTimeZone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceTimeZone(String value) {
        this.spaceTimeZone = value;
    }

    /**
     * Gets the value of the usageTracking property.
     * 
     */
    public boolean isUsageTracking() {
        return usageTracking;
    }

    /**
     * Sets the value of the usageTracking property.
     * 
     */
    public void setUsageTracking(boolean value) {
        this.usageTracking = value;
    }

    /**
     * Gets the value of the isDocumentRepository property.
     * 
     */
    public boolean isIsDocumentRepository() {
        return isDocumentRepository;
    }

    /**
     * Sets the value of the isDocumentRepository property.
     * 
     */
    public void setIsDocumentRepository(boolean value) {
        this.isDocumentRepository = value;
    }

    /**
     * Gets the value of the alwaysOn property.
     * 
     */
    public boolean isAlwaysOn() {
        return alwaysOn;
    }

    /**
     * Sets the value of the alwaysOn property.
     * 
     */
    public void setAlwaysOn(boolean value) {
        this.alwaysOn = value;
    }

    /**
     * Gets the value of the useNewDashboards property.
     * 
     */
    public boolean isUseNewDashboards() {
        return useNewDashboards;
    }

    /**
     * Sets the value of the useNewDashboards property.
     * 
     */
    public void setUseNewDashboards(boolean value) {
        this.useNewDashboards = value;
    }

}
