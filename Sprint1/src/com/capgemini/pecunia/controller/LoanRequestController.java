package com.capgemini.pecunia.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.capgemini.pecunia.controller.Loan;
import com.capgemini.pecunia.exception.LoanException;
import com.capgemini.pecunia.service.LoanRequestService;
import com.capgemini.pecunia.service.LoanRequestServiceImpl;

public class LoanRequestController {
	
	public  LoanRequestController() {
		 Scanner scan = new Scanner(System.in);
			Loan loan = null;
			LoanRequestService loanService = new LoanRequestServiceImpl();
			List<Loan> list= null;
			while(true) {
				System.out.println("\n");
				System.out.println("****************************************************************");
				System.out.println("         *********Welcome To Loan Section*************          ");
				System.out.println("****************************************************************");
				System.out.println("1. Add Details for Loan Request");
				System.out.println("2. Create Request for Loan");
				System.out.println("3. Loan Approval Status");
				System.out.println("4. Calculate Loan EMI");
				System.out.println("5. List of Loan Requests");
				System.out.println("6. Loan approval List");
				System.out.println("7. Exit");
				int choice = scan.nextInt();
				
				switch (choice) {
				case 1:
					try {
						System.out.println("Enter Account Number");
						String id = scan.next();
						System.out.println("Select Loan Type:");
						System.out.println("1. Housing Loan");
						System.out.println("2. Personal Loan");
						System.out.println("3. Education Loan");
						int t = scan.nextInt();
						String type[] = {"Housing Loan","Personal Loan","Education Loan"};
						double roi =0;
						switch(t){
						case 1: roi = 10;System.out.println("Rate of Intrest is: "+roi);
							break;
						case 2: roi =15;System.out.println(" Rate of Intrest is: "+roi);
							break;
						case 3: roi = 5;System.out.println("Rate of Intrest is: "+roi);
							break;
							default: System.out.println("Please enter '1','2' or '3' only");
							break;
						}
						System.out.println("Enter Loan amount");
						double amount = scan.nextDouble();
						System.out.println("Enter Tenure in months");
						int tenure = scan.nextInt();
						System.out.println("Enter credit score");
						int score = scan.nextInt();
						loan = loanService.addLoanDetails(id, amount, tenure, roi, score);
						loan.setAccountBalance(20000);
						System.out.println("(Account Number:"+loan.getAccountId()+") Details Added Sucessfully. Please create a request for your Loan.");
						
					}
					catch (LoanException le) {
						System.err.println(le.getMessage());
					}
					break;
					
				case 2:
					try {
						String id = loanService.createLoanRequest(loan);
						System.out.println("(Account Number:"+id+") requested for loan of "+ loan.getAmount()+" for "+loan.getTenure()+" months");
						
					}
					catch (LoanException le) {
						System.err.println(le.getMessage());
					}
					break;
					
	           case 3:
					try {
						System.out.println("(Account Number:"+loan.getAccountId()+") Loan Status = "+loanService.loanApprovalStatus(loan));
						
					}
					catch(LoanException le) {
						System.err.println(le.getMessage());
					}
					break;
				
				case 4:
					try {
						System.out.println("(Account Number:"+loan.getAccountId()+") emi = "+loanService.calculateEmiForLoan(loan));
						
					}
					catch(LoanException le) {
						System.err.println(le.getMessage());
					}
					break;
					
				case 5:
					try {
						list = new ArrayList<Loan>();
						list = loanService.loanRequestList();
						System.out.println("Account ID\tTenure\t\tLoan Amount\tRate Of Interest\tCredit Score\tLoan Status\tAccount Balance\t\tEMI\n");
						list.stream().forEach(p -> System.out.println(p));		
					}
					catch(LoanException le) {
						System.err.println(le.getMessage());
					}
					break;
				case 6:
					try {
						list = new ArrayList<Loan>();
						list = loanService.loanApprovalList(loan);
						System.out.println("Account ID\t\tTenure\t\tLoan Amount\t\tRate Of Interest\t\tCredit Score\t\tLoan Status\t\tAccount Balance\t\tEMI\n");
						list.stream().forEach(p -> System.out.println(p));
						
					}
					catch(LoanException le) {
						System.err.println(le.getMessage());
					}
					break;
				
				case 7:
					System.out.println("Exising  System...Thank You :) ");
					System.exit(0);
					return;

				default:
					System.out.println("Please Enter a Correct Choice");
					break;
				}
			}
		}
	
	public static void main(String[] args) {
		new LoanRequestController();	
	}
}

