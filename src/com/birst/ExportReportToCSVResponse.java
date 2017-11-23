
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
 *         &lt;element name="exportReportToCSVResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "exportReportToCSVResult"
})
@XmlRootElement(name = "exportReportToCSVResponse")
public class ExportReportToCSVResponse {

    protected String exportReportToCSVResult;

    /**
     * Gets the value of the exportReportToCSVResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportReportToCSVResult() {
        return exportReportToCSVResult;
    }

    /**
     * Sets the value of the exportReportToCSVResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportReportToCSVResult(String value) {
        this.exportReportToCSVResult = value;
    }

}
