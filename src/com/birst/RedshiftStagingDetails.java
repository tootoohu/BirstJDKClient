
package com.birst;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RedshiftStagingDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RedshiftStagingDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="stagingTableName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sourceS3Path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="delimiter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="columnNames" type="{http://www.birst.com/}ArrayOfString" minOccurs="0"/>
 *         &lt;element name="awsKeyID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="awsSecretKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="awsTempToken" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="encryptionKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="compressionFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ignoreHeaders" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="keepQuotes" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="skipEscape" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RedshiftStagingDetails", propOrder = {
    "stagingTableName",
    "sourceS3Path",
    "delimiter",
    "columnNames",
    "awsKeyID",
    "awsSecretKey",
    "awsTempToken",
    "encryptionKey",
    "dateFormat",
    "compressionFormat",
    "ignoreHeaders",
    "keepQuotes",
    "skipEscape"
})
public class RedshiftStagingDetails {

    protected String stagingTableName;
    protected String sourceS3Path;
    protected String delimiter;
    protected ArrayOfString columnNames;
    protected String awsKeyID;
    protected String awsSecretKey;
    protected String awsTempToken;
    protected String encryptionKey;
    protected String dateFormat;
    protected String compressionFormat;
    protected int ignoreHeaders;
    protected boolean keepQuotes;
    protected boolean skipEscape;

    /**
     * Gets the value of the stagingTableName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStagingTableName() {
        return stagingTableName;
    }

    /**
     * Sets the value of the stagingTableName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStagingTableName(String value) {
        this.stagingTableName = value;
    }

    /**
     * Gets the value of the sourceS3Path property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceS3Path() {
        return sourceS3Path;
    }

    /**
     * Sets the value of the sourceS3Path property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceS3Path(String value) {
        this.sourceS3Path = value;
    }

    /**
     * Gets the value of the delimiter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * Sets the value of the delimiter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDelimiter(String value) {
        this.delimiter = value;
    }

    /**
     * Gets the value of the columnNames property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getColumnNames() {
        return columnNames;
    }

    /**
     * Sets the value of the columnNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setColumnNames(ArrayOfString value) {
        this.columnNames = value;
    }

    /**
     * Gets the value of the awsKeyID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwsKeyID() {
        return awsKeyID;
    }

    /**
     * Sets the value of the awsKeyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwsKeyID(String value) {
        this.awsKeyID = value;
    }

    /**
     * Gets the value of the awsSecretKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwsSecretKey() {
        return awsSecretKey;
    }

    /**
     * Sets the value of the awsSecretKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwsSecretKey(String value) {
        this.awsSecretKey = value;
    }

    /**
     * Gets the value of the awsTempToken property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAwsTempToken() {
        return awsTempToken;
    }

    /**
     * Sets the value of the awsTempToken property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAwsTempToken(String value) {
        this.awsTempToken = value;
    }

    /**
     * Gets the value of the encryptionKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * Sets the value of the encryptionKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncryptionKey(String value) {
        this.encryptionKey = value;
    }

    /**
     * Gets the value of the dateFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateFormat() {
        return dateFormat;
    }

    /**
     * Sets the value of the dateFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateFormat(String value) {
        this.dateFormat = value;
    }

    /**
     * Gets the value of the compressionFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCompressionFormat() {
        return compressionFormat;
    }

    /**
     * Sets the value of the compressionFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCompressionFormat(String value) {
        this.compressionFormat = value;
    }

    /**
     * Gets the value of the ignoreHeaders property.
     * 
     */
    public int getIgnoreHeaders() {
        return ignoreHeaders;
    }

    /**
     * Sets the value of the ignoreHeaders property.
     * 
     */
    public void setIgnoreHeaders(int value) {
        this.ignoreHeaders = value;
    }

    /**
     * Gets the value of the keepQuotes property.
     * 
     */
    public boolean isKeepQuotes() {
        return keepQuotes;
    }

    /**
     * Sets the value of the keepQuotes property.
     * 
     */
    public void setKeepQuotes(boolean value) {
        this.keepQuotes = value;
    }

    /**
     * Gets the value of the skipEscape property.
     * 
     */
    public boolean isSkipEscape() {
        return skipEscape;
    }

    /**
     * Sets the value of the skipEscape property.
     * 
     */
    public void setSkipEscape(boolean value) {
        this.skipEscape = value;
    }

}
