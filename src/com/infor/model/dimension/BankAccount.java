package com.infor.model.dimension;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the BI_Dim_Bank_Account_BV_View database table.
 * 
 */
@Entity
@Table(name="BI_Dim_Bank_Account_BV_View")
//@NamedQuery(name="BankAccount.findAll", query="SELECT b FROM BankAccount b")
public class BankAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	private Object bankAccount;
	private Object name;

	public BankAccount() {
	}


	@Column(name="bank_account")
	public Object getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(Object bankAccount) {
		this.bankAccount = bankAccount;
	}


	public Object getName() {
		return this.name;
	}

	public void setName(Object name) {
		this.name = name;
	}

}