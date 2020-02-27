package com.capgemini.pecunia.service;

import java.util.List;
import com.capgemini.pecunia.controller.Loan;
import com.capgemini.pecunia.dao.LoanRequestDAO;
import com.capgemini.pecunia.dao.LoanRequestDAOImpl;
import com.capgemini.pecunia.exception.LoanException;

public class LoanRequestServiceImpl implements LoanRequestService{
private LoanRequestDAO loanDao;
	
	public LoanRequestServiceImpl() {
		loanDao = new LoanRequestDAOImpl();
	}

	public Loan addLoanDetails(String accountId, double amount, int tenure,double roi, int creditScore) throws LoanException {
		if(!accountId.matches("[0-9]{12}"))
			throw new LoanException("Invalid account Id : Id should be 12 digit");
		if(!validateAmount(amount))
			throw new LoanException("Invalid Loan amount : Amount should be greater than 1000");
		if(!validateTenure(tenure))
			throw new LoanException("Invalid tenure: entered value is not valid");
		if(!validateCreditScore(creditScore))
			throw new LoanException("Invalid credit score : credit score should be in range of 100 to 999");
		
		return loanDao.addLoanDetails(accountId, amount, tenure, roi, creditScore) ;
	}

	public String createLoanRequest(Loan loan) throws LoanException {
		
		return loanDao.createLoanRequest(loan);
	}

	public List<Loan> loanRequestList() throws LoanException {
		
		return loanDao.loanRequestList();
	}

	@Override
	public List<Loan> loanApprovalList(Loan loan) throws LoanException {
		
		return loanDao.loanApprovalList(loan);
	}

	@Override
	public boolean validateAmount(double amount) {
		
		if(amount>=1000 && amount<=10000000)
			return true;
		else
		return false;
	}

	@Override
	public boolean validateTenure(int tenure) {
		
		if(tenure>=12 && tenure<=240)
			return true;
		else
		return false;
	}

	@Override
	public boolean validateCreditScore(int creditScore) {
		
		if(creditScore>=100 && creditScore<=999)
			return true;
		else
		return false;
	}

	@Override
	public String loanApprovalStatus(Loan loan) throws LoanException {
		
		return loanDao.loanApprovalStatus(loan);
	}

	@Override
	public double calculateEmiForLoan(Loan loan) throws LoanException {
		
		return loanDao.calculateEmiForLoan(loan);
	}

	
}
