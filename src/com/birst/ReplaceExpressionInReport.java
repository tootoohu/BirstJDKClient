
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
 *         &lt;element name="reportPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="existingGlobalExpressionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="newGlobalExpressionName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "reportPath",
    "reportName",
    "existingGlobalExpressionName",
    "newGlobalExpressionName"
})
@XmlRootElement(name = "replaceExpressionInReport")
public class ReplaceExpressionInReport {

    protected String token;
    protected String spaceID;
    protected String reportPath;
    protected String reportName;
    protected String existingGlobalExpressionName;
    protected String newGlobalExpressionName;

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
     * Gets the value of the reportPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPath() {
        return reportPath;
    }

    /**
     * Sets the value of the reportPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPath(String value) {
        this.reportPath = value;
    }

    /**
     * Gets the value of the reportName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the existingGlobalExpressionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExistingGlobalExpressionName() {
        return existingGlobalExpressionName;
    }

    /**
     * Sets the value of the existingGlobalExpressionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExistingGlobalExpressionName(String value) {
        this.existingGlobalExpressionName = value;
    }

    /**
     * Gets the value of the newGlobalExpressionName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewGlobalExpressionName() {
        return newGlobalExpressionName;
    }

    /**
     * Sets the value of the newGlobalExpressionName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewGlobalExpressionName(String value) {
        this.newGlobalExpressionName = value;
    }

}
