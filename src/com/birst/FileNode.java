
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDirectory" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="isWriteable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="lastModified" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isDashboard" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="createdBy" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="children" type="{http://www.birst.com/}ArrayOfFileNode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileNode", propOrder = {
    "name",
    "label",
    "isDirectory",
    "isWriteable",
    "lastModified",
    "isDashboard",
    "createdBy",
    "children"
})
public class FileNode {

    protected String name;
    protected String label;
    protected boolean isDirectory;
    protected boolean isWriteable;
    protected String lastModified;
    protected boolean isDashboard;
    protected String createdBy;
    protected ArrayOfFileNode children;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the isDirectory property.
     * 
     */
    public boolean isIsDirectory() {
        return isDirectory;
    }

    /**
     * Sets the value of the isDirectory property.
     * 
     */
    public void setIsDirectory(boolean value) {
        this.isDirectory = value;
    }

    /**
     * Gets the value of the isWriteable property.
     * 
     */
    public boolean isIsWriteable() {
        return isWriteable;
    }

    /**
     * Sets the value of the isWriteable property.
     * 
     */
    public void setIsWriteable(boolean value) {
        this.isWriteable = value;
    }

    /**
     * Gets the value of the lastModified property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastModified() {
        return lastModified;
    }

    /**
     * Sets the value of the lastModified property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastModified(String value) {
        this.lastModified = value;
    }

    /**
     * Gets the value of the isDashboard property.
     * 
     */
    public boolean isIsDashboard() {
        return isDashboard;
    }

    /**
     * Sets the value of the isDashboard property.
     * 
     */
    public void setIsDashboard(boolean value) {
        this.isDashboard = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedBy(String value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the children property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFileNode }
     *     
     */
    public ArrayOfFileNode getChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFileNode }
     *     
     */
    public void setChildren(ArrayOfFileNode value) {
        this.children = value;
    }

}
