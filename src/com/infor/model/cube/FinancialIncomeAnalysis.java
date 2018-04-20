package com.infor.model.cube;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the BI_fact_financial_income_analysis_staging database table.
 * 
 */
@Deprecated
@Entity
@Table(name="BI_fact_financial_income_analysis_staging")
//@NamedQuery(name="FinancialIncomeAnalysis.findAll", query="SELECT f FROM FinancialIncomeAnalysis f")
public class FinancialIncomeAnalysis implements Serializable {
	private static final long serialVersionUID = 1L;

	private Object account;
	private BigDecimal actualAmount;
	private BigDecimal actualAssets;
	private BigDecimal actualExpense;
	private BigDecimal actualLiabilities;
	private BigDecimal actualOwnerEquity;
	private BigDecimal actualProfit;
	private BigDecimal actualRevenue;
	private BigDecimal budgetAmount;
	private BigDecimal budgetExpense;
	private BigDecimal budgetRevenue;
	private BigDecimal budgetVariance;
	private String currencyCode;
	private Date date;
	private Date fiscalPeriod;
	private Timestamp recordDate;
	private String unitCode1;
	private String unitCode2;
	private String unitCode3;
	private String unitCode4;

	public FinancialIncomeAnalysis() {
	}


	public Object getAccount() {
		return this.account;
	}

	public void setAccount(Object account) {
		this.account = account;
	}


	@Column(name="actual_amount")
	public BigDecimal getActualAmount() {
		return this.actualAmount;
	}

	public void setActualAmount(BigDecimal actualAmount) {
		this.actualAmount = actualAmount;
	}


	@Column(name="actual_assets")
	public BigDecimal getActualAssets() {
		return this.actualAssets;
	}

	public void setActualAssets(BigDecimal actualAssets) {
		this.actualAssets = actualAssets;
	}


	@Column(name="actual_expense")
	public BigDecimal getActualExpense() {
		return this.actualExpense;
	}

	public void setActualExpense(BigDecimal actualExpense) {
		this.actualExpense = actualExpense;
	}


	@Column(name="actual_liabilities")
	public BigDecimal getActualLiabilities() {
		return this.actualLiabilities;
	}

	public void setActualLiabilities(BigDecimal actualLiabilities) {
		this.actualLiabilities = actualLiabilities;
	}


	@Column(name="actual_owner_equity")
	public BigDecimal getActualOwnerEquity() {
		return this.actualOwnerEquity;
	}

	public void setActualOwnerEquity(BigDecimal actualOwnerEquity) {
		this.actualOwnerEquity = actualOwnerEquity;
	}


	@Column(name="actual_profit")
	public BigDecimal getActualProfit() {
		return this.actualProfit;
	}

	public void setActualProfit(BigDecimal actualProfit) {
		this.actualProfit = actualProfit;
	}


	@Column(name="actual_revenue")
	public BigDecimal getActualRevenue() {
		return this.actualRevenue;
	}

	public void setActualRevenue(BigDecimal actualRevenue) {
		this.actualRevenue = actualRevenue;
	}


	@Column(name="budget_amount")
	public BigDecimal getBudgetAmount() {
		return this.budgetAmount;
	}

	public void setBudgetAmount(BigDecimal budgetAmount) {
		this.budgetAmount = budgetAmount;
	}


	@Column(name="budget_expense")
	public BigDecimal getBudgetExpense() {
		return this.budgetExpense;
	}

	public void setBudgetExpense(BigDecimal budgetExpense) {
		this.budgetExpense = budgetExpense;
	}


	@Column(name="budget_revenue")
	public BigDecimal getBudgetRevenue() {
		return this.budgetRevenue;
	}

	public void setBudgetRevenue(BigDecimal budgetRevenue) {
		this.budgetRevenue = budgetRevenue;
	}


	@Column(name="budget_variance")
	public BigDecimal getBudgetVariance() {
		return this.budgetVariance;
	}

	public void setBudgetVariance(BigDecimal budgetVariance) {
		this.budgetVariance = budgetVariance;
	}


	@Column(name="currency_code")
	public Object getCurrencyCode() {
		return this.currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}


	public Object getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Column(name="fiscal_period")
	public Object getFiscalPeriod() {
		return this.fiscalPeriod;
	}

	public void setFiscalPeriod(Date fiscalPeriod) {
		this.fiscalPeriod = fiscalPeriod;
	}


	@Column(name="RecordDate")
	public Timestamp getRecordDate() {
		return this.recordDate;
	}

	public void setRecordDate(Timestamp recordDate) {
		this.recordDate = recordDate;
	}


	@Column(name="unit_code_1")
	public Object getUnitCode1() {
		return this.unitCode1;
	}

	public void setUnitCode1(String unitCode1) {
		this.unitCode1 = unitCode1;
	}


	@Column(name="unit_code_2")
	public Object getUnitCode2() {
		return this.unitCode2;
	}

	public void setUnitCode2(String unitCode2) {
		this.unitCode2 = unitCode2;
	}


	@Column(name="unit_code_3")
	public Object getUnitCode3() {
		return this.unitCode3;
	}

	public void setUnitCode3(String unitCode3) {
		this.unitCode3 = unitCode3;
	}


	@Column(name="unit_code_4")
	public Object getUnitCode4() {
		return this.unitCode4;
	}

	public void setUnitCode4(String unitCode4) {
		this.unitCode4 = unitCode4;
	}

}