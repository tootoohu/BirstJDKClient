package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BI_Dim_Customer_BV_View database table.
 * 
 */
@Deprecated
@Entity
@Table(name="BI_Dim_Customer_BV_View")
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object address;
	private Object city;
	private Object country;
	private BigDecimal creditLimit;
	private Object customer;
	private Object customerName;
	private int customerSeq;
	private String customerType;
	private BigDecimal onOrderBalance;
	private BigDecimal postedBalance;
	private Object siteRef;
	private Object state;
	private Object typeDescription;
	private Object zip;

	public Customer() {
	}


	public Object getAddress() {
		return this.address;
	}

	public void setAddress(Object address) {
		this.address = address;
	}


	public Object getCity() {
		return this.city;
	}

	public void setCity(Object city) {
		this.city = city;
	}


	public Object getCountry() {
		return this.country;
	}

	public void setCountry(Object country) {
		this.country = country;
	}


	@Column(name="credit_limit")
	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}


	public Object getCustomer() {
		return this.customer;
	}

	public void setCustomer(Object customer) {
		this.customer = customer;
	}


	@Column(name="customer_name")
	public Object getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(Object customerName) {
		this.customerName = customerName;
	}


	@Column(name="customer_seq")
	public int getCustomerSeq() {
		return this.customerSeq;
	}

	public void setCustomerSeq(int customerSeq) {
		this.customerSeq = customerSeq;
	}


	@Column(name="customer_type")
	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}


	@Column(name="on_order_balance")
	public BigDecimal getOnOrderBalance() {
		return this.onOrderBalance;
	}

	public void setOnOrderBalance(BigDecimal onOrderBalance) {
		this.onOrderBalance = onOrderBalance;
	}


	@Column(name="posted_balance")
	public BigDecimal getPostedBalance() {
		return this.postedBalance;
	}

	public void setPostedBalance(BigDecimal postedBalance) {
		this.postedBalance = postedBalance;
	}


	@Column(name="site_ref")
	public Object getSiteRef() {
		return this.siteRef;
	}

	public void setSiteRef(Object siteRef) {
		this.siteRef = siteRef;
	}


	public Object getState() {
		return this.state;
	}

	public void setState(Object state) {
		this.state = state;
	}


	@Column(name="type_description")
	public Object getTypeDescription() {
		return this.typeDescription;
	}

	public void setTypeDescription(Object typeDescription) {
		this.typeDescription = typeDescription;
	}


	public Object getZip() {
		return this.zip;
	}

	public void setZip(Object zip) {
		this.zip = zip;
	}

}