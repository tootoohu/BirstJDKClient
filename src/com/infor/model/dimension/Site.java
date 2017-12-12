package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BI_Dim_Sites_Mst_View database table.
 * 
 */
@Entity
@Table(name="BI_Dim_Sites_Mst_View")
//@NamedQuery(name="Site.findAll", query="SELECT s FROM Site s")
public class Site implements Serializable {
	private static final long serialVersionUID = 1L;
	private String address1;
	private String address2;
	private String address3;
	private String address4;
	private String city;
	private String company;
	private String country;
	private String email;
	private String parent;
	private String phone;
	private String site;
	private String siteName;
	private String state;
	private String zip;

	public Site() {
	}


	public Object getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}


	public Object getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}


	public Object getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}


	public Object getAddress4() {
		return this.address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}


	public Object getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public Object getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


	public Object getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public Object getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name="Parent")
	public String getParent() {
		return this.parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	}


	public Object getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Column(name="Site")
	public Object getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}


	@Column(name="site_name")
	public Object getSiteName() {
		return this.siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}


	public Object getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}


	public Object getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}