
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
 *         &lt;element name="getSpaceStatisticsResult" type="{http://www.birst.com/}SpaceStatistics" minOccurs="0"/>
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
    "getSpaceStatisticsResult"
})
@XmlRootElement(name = "getSpaceStatisticsResponse")
public class GetSpaceStatisticsResponse {

    protected SpaceStatistics getSpaceStatisticsResult;

    /**
     * Gets the value of the getSpaceStatisticsResult property.
     * 
     * @return
     *     possible object is
     *     {@link SpaceStatistics }
     *     
     */
    public SpaceStatistics getGetSpaceStatisticsResult() {
        return getSpaceStatisticsResult;
    }

    /**
     * Sets the value of the getSpaceStatisticsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpaceStatistics }
     *     
     */
    public void setGetSpaceStatisticsResult(SpaceStatistics value) {
        this.getSpaceStatisticsResult = value;
    }

}
