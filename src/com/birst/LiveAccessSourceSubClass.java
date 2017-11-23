
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LiveAccessSourceSubClass complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiveAccessSourceSubClass">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="UnCached" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TTL" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Cardinality" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="SourceKeys" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="ForeignKeys" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="SourceFilterCondition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiveAccessSourceSubClass", propOrder = {
    "name",
    "unCached",
    "ttl",
    "cardinality",
    "sourceKeys",
    "foreignKeys",
    "sourceFilterCondition"
})
public class LiveAccessSourceSubClass {

    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "UnCached")
    protected boolean unCached;
    @XmlElement(name = "TTL")
    protected int ttl;
    @XmlElement(name = "Cardinality")
    protected int cardinality;
    @XmlElement(name = "SourceKeys")
    protected ArrayOfString sourceKeys;
    @XmlElement(name = "ForeignKeys")
    protected ArrayOfString foreignKeys;
    @XmlElement(name = "SourceFilterCondition")
    protected String sourceFilterCondition;

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
     * Gets the value of the unCached property.
     * 
     */
    public boolean isUnCached() {
        return unCached;
    }

    /**
     * Sets the value of the unCached property.
     * 
     */
    public void setUnCached(boolean value) {
        this.unCached = value;
    }

    /**
     * Gets the value of the ttl property.
     * 
     */
    public int getTTL() {
        return ttl;
    }

    /**
     * Sets the value of the ttl property.
     * 
     */
    public void setTTL(int value) {
        this.ttl = value;
    }

    /**
     * Gets the value of the cardinality property.
     * 
     */
    public int getCardinality() {
        return cardinality;
    }

    /**
     * Sets the value of the cardinality property.
     * 
     */
    public void setCardinality(int value) {
        this.cardinality = value;
    }

    /**
     * Gets the value of the sourceKeys property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getSourceKeys() {
        return sourceKeys;
    }

    /**
     * Sets the value of the sourceKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setSourceKeys(ArrayOfString value) {
        this.sourceKeys = value;
    }

    /**
     * Gets the value of the foreignKeys property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getForeignKeys() {
        return foreignKeys;
    }

    /**
     * Sets the value of the foreignKeys property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setForeignKeys(ArrayOfString value) {
        this.foreignKeys = value;
    }

    /**
     * Gets the value of the sourceFilterCondition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceFilterCondition() {
        return sourceFilterCondition;
    }

    /**
     * Sets the value of the sourceFilterCondition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceFilterCondition(String value) {
        this.sourceFilterCondition = value;
    }

}
