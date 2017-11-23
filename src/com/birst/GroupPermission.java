
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GroupPermission complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GroupPermission">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="groupName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="canView" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="canModify" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GroupPermission", propOrder = {
    "groupName",
    "canView",
    "canModify"
})
public class GroupPermission {

    protected String groupName;
    protected boolean canView;
    protected boolean canModify;

    /**
     * Gets the value of the groupName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * Sets the value of the groupName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupName(String value) {
        this.groupName = value;
    }

    /**
     * Gets the value of the canView property.
     * 
     */
    public boolean isCanView() {
        return canView;
    }

    /**
     * Sets the value of the canView property.
     * 
     */
    public void setCanView(boolean value) {
        this.canView = value;
    }

    /**
     * Gets the value of the canModify property.
     * 
     */
    public boolean isCanModify() {
        return canModify;
    }

    /**
     * Sets the value of the canModify property.
     * 
     */
    public void setCanModify(boolean value) {
        this.canModify = value;
    }

}
