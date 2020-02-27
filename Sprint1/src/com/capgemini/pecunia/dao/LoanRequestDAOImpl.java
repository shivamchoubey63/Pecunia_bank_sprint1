package com.capgemini.pecunia.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import com.capgemini.pecunia.controller.Loan;
import com.capgemini.pecunia.exception.LoanException;

public class LoanRequestDAOImpl implements LoanRequestDAO{
	//private  Logger logger = Logger.getLogger(LoanRequestDAOImpl.class);
	
	private HashMap<String,Loan> loanMap;
	
	public LoanRequestDAOImpl() {
		loanMap = new HashMap<String,Loan>();
		loanMap.put("Shivam",new Loan("987654321987",100000,50,10,850));
		loanMap.put("Akash",new Loan("987654321478",500000,40,14,650));
		
	}

	public String createLoanRequest(Loan loan) throws LoanException {
		if(loanMap.containsKey(loan.getAccountId()))
			throw new LoanException("Loan exist's for above id");
		else
			loanMap.put(loan.getAccountId(),loan);
		return loan.getAccountId();
	}

	public Loan addLoanDetails(String accountId, double amount, int tenure,double roi, int creditScore) throws LoanException {
		
		Loan loan = new Loan();
		
		if(loanMap.containsKey(loan.getAccountId()))
			throw new LoanException("Loan exist's for above id");
		
		loan.setAccountId(accountId);
		loan.setAmount(amount);
		loan.setRoi(roi);
		loan.setCreditScore(creditScore);
		loan.setTenure(tenure);
		loan.setLoanStatus("pending");
		return loan;
	}

	@Override
	public String loanApprovalStatus(Loan loan) throws LoanException {
		if(loan.getCreditScore()>=670 && loan.getCreditScore()<=999) {
			loan.setLoanStatus("approved");
			double balance = loan.getAccountBalance()+loan.getAmount();
			loan.setAccountBalance(balance);
		}
		else
			loan.setLoanStatus("rejected");
		
		double amount = loan.getAmount() + (loan.getAmount()*loan.getRoi()/100);
		double emi = amount/(loan.getTenure());
		if(loan.getLoanStatus().equals("approved"))
			loan.setEmi(emi);
		
		return loan.getLoanStatus();
	}

	public List<Loan> loanRequestList() throws LoanException {
		Collection<Loan> collection = loanMap.values();
		List<Loan> list = new ArrayList<Loan>();
		for(Loan loan : collection) {
			list.add(loan);
		}
		return list;
	}

	@Override
	public List<Loan> loanApprovalList(Loan loan) throws LoanException {
		Collection<Loan> collection = loanMap.values();
		List<Loan> list = new ArrayList<Loan>();
		for(Loan approvedLoan : collection) {
			if(approvedLoan.getCreditScore()>=700 && approvedLoan.getCreditScore()<=999)
				list.add(approvedLoan);
		}
		return list;
	}

	@Override
	public double calculateEmiForLoan(Loan loan) throws LoanException {
		
		if(loan.getLoanStatus().equals("approved"))
			return loan.getEmi();
		else 
			throw new LoanException("loan not approved");
		
	}

	



	

	

}
