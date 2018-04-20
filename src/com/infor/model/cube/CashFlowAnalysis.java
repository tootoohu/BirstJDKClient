package com.infor.model.cube;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the BI_Fact_Cash_Flow_Analysis_Actual_Full_BV_View database table.
 * 
 */
@Deprecated
@Entity
@Table(name="BI_Fact_Cash_Flow_Analysis_Actual_Full_BV_View")
//@NamedQuery(name="CashFlowAnalysis.findAll", query="SELECT c FROM CashFlowAnalysis c")
public class CashFlowAnalysis implements Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal amount;
	private String cashAccount;
	private String cashType;
	private String currencyCode;
	@JoinTable(name="BI_Dim_Customer_BV_View",
			joinColumns = @JoinColumn(name = "customer"))
	private String customer;
	private String fiscalPeriod;
	private int orderCount;
	private Timestamp recordDate;
	private String rowPointer;
	private String site;
	private String timeCalculation;
	private String vendor;
	private String version;

	public CashFlowAnalysis() {
	}


	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


	@Column(name="cash_account")
	public Object getCashAccount() {
		return this.cashAccount;
	}

	public void setCashAccount(String cashAccount) {
		this.cashAccount = cashAccount;
	}


	@Column(name="cash_type")
	public Object getCashType() {
		return this.cashType;
	}

	public void setCashType(String cashType) {
		this.cashType = cashType;
	}


	@Column(name="currency_code")
	public Object getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public Object getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}


	@Column(name="fiscal_period")
	public String getFiscalPeriod() {
		return this.fiscalPeriod;
	}

	public void setFiscalPeriod(String fiscalPeriod) {
		this.fiscalPeriod = fiscalPeriod;
	}


	@Column(name="order_count")
	public int getOrderCount() {
		return this.orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}


	@Column(name="RecordDate")
	public Timestamp getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}


	@Column(name="RowPointer")
	public String getRowPointer() {
		return this.rowPointer;
	}

	public void setRowPointer(String rowPointer) {
		this.rowPointer = rowPointer;
	}


	public Object getSite() {
		return this.site;
	}

	public void setSite(String site) {
		this.site = site;
	}


	@Column(name="time_calculation")
	public String getTimeCalculation() {
		return this.timeCalculation;
	}

	public void setTimeCalculation(String timeCalculation) {
		this.timeCalculation = timeCalculation;
	}


	public Object getVendor() {
		return this.vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public Object getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}