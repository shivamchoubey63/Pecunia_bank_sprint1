package com.capgemini.pecunia.dao;

import java.util.List; 
import com.capgemini.pecunia.controller.Loan;
import com.capgemini.pecunia.exception.LoanException;

public interface LoanRequestDAO {
	
	public Loan addLoanDetails(String accountId, double amount, int tenure, double roi, int creditScore ) throws LoanException;
	public String createLoanRequest(Loan loan) throws LoanException;
	public List<Loan> loanRequestList() throws LoanException;
	public List<Loan> loanApprovalList(Loan loan) throws LoanException;
	public String loanApprovalStatus(Loan loan) throws LoanException;
	public double calculateEmiForLoan(Loan loan) throws LoanException;
}
