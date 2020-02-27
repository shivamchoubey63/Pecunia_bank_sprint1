package com.capgemini.pecunia.controller;

public class Loan {
	private String accountId;
	private int tenure;
	private double amount;
	private double roi;
	private String loanStatus;
	private int creditScore;
	private double accountBalance;
	private double emi;
	
	
	public double getEmi() {
		return emi;
	}
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getLoanStatus() {
		return loanStatus;
	}
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public double getRoi() {
		return roi;
	}
	public void setRoi(double roi) {
		this.roi = roi;
	}
	@Override
	public String toString() {
		return "Loan [accountId=" + accountId + ", tenure=" + tenure + ", amount=" + amount + ", roi=" + roi
				+ ", loanStatus=" + loanStatus + ", creditScore=" + creditScore + ", accountBalance=" + accountBalance
				+ ", emi=" + emi + "]";
	}
	public Loan(String accountId, double amount, int tenure,double roi, int creditScore) {
		super();
		this.accountId=accountId;
		this.amount=amount;
		this.tenure=tenure;
		this.roi=roi;
		this.creditScore=creditScore;
	}
	public Loan() {
		
	}
	
}
