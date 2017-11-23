
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
 *         &lt;element name="connectionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="databaseType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cubeName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importType" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cacheable" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "connectionName",
    "databaseType",
    "cubeName",
    "importType",
    "cacheable"
})
@XmlRootElement(name = "importCubeMetaDataIntoSpace")
public class ImportCubeMetaDataIntoSpace {

    protected String token;
    protected String spaceID;
    protected String connectionName;
    protected String databaseType;
    protected String cubeName;
    protected int importType;
    protected boolean cacheable;

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
     * Gets the value of the connectionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnectionName() {
        return connectionName;
    }

    /**
     * Sets the value of the connectionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnectionName(String value) {
        this.connectionName = value;
    }

    /**
     * Gets the value of the databaseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatabaseType() {
        return databaseType;
    }

    /**
     * Sets the value of the databaseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatabaseType(String value) {
        this.databaseType = value;
    }

    /**
     * Gets the value of the cubeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCubeName() {
        return cubeName;
    }

    /**
     * Sets the value of the cubeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCubeName(String value) {
        this.cubeName = value;
    }

    /**
     * Gets the value of the importType property.
     * 
     */
    public int getImportType() {
        return importType;
    }

    /**
     * Sets the value of the importType property.
     * 
     */
    public void setImportType(int value) {
        this.importType = value;
    }

    /**
     * Gets the value of the cacheable property.
     * 
     */
    public boolean isCacheable() {
        return cacheable;
    }

    /**
     * Sets the value of the cacheable property.
     * 
     */
    public void setCacheable(boolean value) {
        this.cacheable = value;
    }

}
