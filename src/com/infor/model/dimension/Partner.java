package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BI_Dim_Partner_Mst_View database table.
 * 
 */
@Entity
//@NamedQuery(name="BI_Dim_Partner_Mst_View.findAll", query="SELECT b FROM BI_Dim_Partner_Mst_View b")
public class Partner implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String partner;
	private String type;

	public Partner() {
	}


	public Object getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(name="Partner")
	public Object getPartner() {
		return this.partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}


	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}