
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
 *         &lt;element name="spaceId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reportFilters" type="{http://www.birst.com/}ArrayOfFilter" minOccurs="0"/>
 *         &lt;element name="zoomFactor" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="page" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "spaceId",
    "reportPath",
    "reportFilters",
    "zoomFactor",
    "page"
})
@XmlRootElement(name = "exportReportToPNG")
public class ExportReportToPNG {

    protected String token;
    protected String spaceId;
    protected String reportPath;
    protected ArrayOfFilter reportFilters;
    protected int zoomFactor;
    protected int page;

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
     * Gets the value of the spaceId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpaceId() {
        return spaceId;
    }

    /**
     * Sets the value of the spaceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpaceId(String value) {
        this.spaceId = value;
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
     * Gets the value of the reportFilters property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFilter }
     *     
     */
    public ArrayOfFilter getReportFilters() {
        return reportFilters;
    }

    /**
     * Sets the value of the reportFilters property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFilter }
     *     
     */
    public void setReportFilters(ArrayOfFilter value) {
        this.reportFilters = value;
    }

    /**
     * Gets the value of the zoomFactor property.
     * 
     */
    public int getZoomFactor() {
        return zoomFactor;
    }

    /**
     * Sets the value of the zoomFactor property.
     * 
     */
    public void setZoomFactor(int value) {
        this.zoomFactor = value;
    }

    /**
     * Gets the value of the page property.
     * 
     */
    public int getPage() {
        return page;
    }

    /**
     * Sets the value of the page property.
     * 
     */
    public void setPage(int value) {
        this.page = value;
    }

}
