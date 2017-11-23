
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
 *         &lt;element name="importCubeMetaDataIntoSpaceResult" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "importCubeMetaDataIntoSpaceResult"
})
@XmlRootElement(name = "importCubeMetaDataIntoSpaceResponse")
public class ImportCubeMetaDataIntoSpaceResponse {

    protected boolean importCubeMetaDataIntoSpaceResult;

    /**
     * Gets the value of the importCubeMetaDataIntoSpaceResult property.
     * 
     */
    public boolean isImportCubeMetaDataIntoSpaceResult() {
        return importCubeMetaDataIntoSpaceResult;
    }

    /**
     * Sets the value of the importCubeMetaDataIntoSpaceResult property.
     * 
     */
    public void setImportCubeMetaDataIntoSpaceResult(boolean value) {
        this.importCubeMetaDataIntoSpaceResult = value;
    }

}
