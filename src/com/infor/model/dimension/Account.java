package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BI_Dim_Account_Mst_View database table.
 * 
 */
@Deprecated
@Entity
@Table(name="BI_Dim_Account_Mst_View")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	private String account;
	private String  accountClassDescription;
	private String  accountDescription;
	private String accountType;
	private String acctClass;
	private String typeDescription;

	public Account() {
	}


	@Column(name="Account")
	public Object getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}


	@Column(name="account_class_description")
	public Object getAccountClassDescription() {
		return this.accountClassDescription;
	}

	public void setAccountClassDescription(String accountClassDescription) {
		this.accountClassDescription = accountClassDescription;
	}


	@Column(name="account_description")
	public Object getAccountDescription() {
		return this.accountDescription;
	}

	public void setAccountDescription(String accountDescription) {
		this.accountDescription = accountDescription;
	}


	@Column(name="account_type")
	public Object getAccountType() {
		return this.accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	@Column(name="acct_class")
	public Object getAcctClass() {
		return this.acctClass;
	}

	public void setAcctClass(String acctClass) {
		this.acctClass = acctClass;
	}


	@Column(name="type_description")
	public String getTypeDescription() {
		return this.typeDescription;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}

}