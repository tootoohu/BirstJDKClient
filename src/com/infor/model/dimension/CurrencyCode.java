package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BI_Dim_Currency_Code_Mst_View database table.
 * 
 */
@Entity
@Table(name="BI_Dim_Currency_Code_Mst_View")
//@NamedQuery(name="CurrencyCode.findAll", query="SELECT c FROM CurrencyCode c")
public class CurrencyCode implements Serializable {
	private static final long serialVersionUID = 1L;
	private String currency_Code;
	private String description;

	public CurrencyCode() {
	}


	@Column(name="Currency_Code")
	public String getCurrency_Code() {
		return this.currency_Code;
	}

	public void setCurrency_Code(String currency_Code) {
		this.currency_Code = currency_Code;
	}


	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}