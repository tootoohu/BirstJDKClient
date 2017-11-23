
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="spaceID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dashName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newPageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "token",
    "spaceID",
    "dashName",
    "pageName",
    "newPageName"
})
@XmlRootElement(name = "renameDashboardPage")
public class RenameDashboardPage {

    protected String token;
    protected String spaceID;
    protected String dashName;
    protected String pageName;
    protected String newPageName;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the spaceID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceID() {
        return spaceID;
    }

    /**
     * Sets the value of the spaceID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceID(String value) {
        this.spaceID = value;
    }

    /**
     * Gets the value of the dashName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDashName() {
        return dashName;
    }

    /**
     * Sets the value of the dashName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDashName(String value) {
        this.dashName = value;
    }

    /**
     * Gets the value of the pageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageName() {
        return pageName;
    }

    /**
     * Sets the value of the pageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageName(String value) {
        this.pageName = value;
    }

    /**
     * Gets the value of the newPageName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPageName() {
        return newPageName;
    }

    /**
     * Sets the value of the newPageName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPageName(String value) {
        this.newPageName = value;
    }

}
