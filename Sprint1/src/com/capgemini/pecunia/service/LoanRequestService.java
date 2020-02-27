package com.capgemini.pecunia.service;

import java.util.List;
import com.capgemini.pecunia.controller.Loan;
import com.capgemini.pecunia.exception.LoanException;

public interface LoanRequestService {
	public Loan addLoanDetails(String accountId, double amount, int tenure,double roi, int creditScore ) throws LoanException;
	public String createLoanRequest(Loan loan) throws LoanException;
	public List<Loan> loanRequestList() throws LoanException;
	public List<Loan> loanApprovalList(Loan loan) throws LoanException;
	public boolean validateAmount(double amount);
	public boolean validateTenure(int tenure);
	public boolean validateCreditScore(int creditScore);
	public String loanApprovalStatus(Loan loan) throws LoanException;
	public double calculateEmiForLoan(Loan loan) throws LoanException;
	
}
