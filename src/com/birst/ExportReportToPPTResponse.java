
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
 *         &lt;element name="exportReportToPPTResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "exportReportToPPTResult"
})
@XmlRootElement(name = "exportReportToPPTResponse")
public class ExportReportToPPTResponse {

    protected String exportReportToPPTResult;

    /**
     * Gets the value of the exportReportToPPTResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExportReportToPPTResult() {
        return exportReportToPPTResult;
    }

    /**
     * Sets the value of the exportReportToPPTResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExportReportToPPTResult(String value) {
        this.exportReportToPPTResult = value;
    }

}
