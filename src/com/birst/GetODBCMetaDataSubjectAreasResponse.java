
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
 *         &lt;element name="getODBCMetaDataSubjectAreasResult" type="{http://www.birst.com/}MetaDataResult" minOccurs="0"/>
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
    "getODBCMetaDataSubjectAreasResult"
})
@XmlRootElement(name = "getODBCMetaDataSubjectAreasResponse")
public class GetODBCMetaDataSubjectAreasResponse {

    protected MetaDataResult getODBCMetaDataSubjectAreasResult;

    /**
     * Gets the value of the getODBCMetaDataSubjectAreasResult property.
     * 
     * @return
     *     possible object is
     *     {@link MetaDataResult }
     *     
     */
    public MetaDataResult getGetODBCMetaDataSubjectAreasResult() {
        return getODBCMetaDataSubjectAreasResult;
    }

    /**
     * Sets the value of the getODBCMetaDataSubjectAreasResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MetaDataResult }
     *     
     */
    public void setGetODBCMetaDataSubjectAreasResult(MetaDataResult value) {
        this.getODBCMetaDataSubjectAreasResult = value;
    }

}
