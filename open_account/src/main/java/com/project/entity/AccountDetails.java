package com.project.entity;

public class AccountDetails {

	private int accountNo;
	private int customerID;
	private String accountType;
	private int depositAmount;
	private int minimumBalance;
	private int overdraftAmount;
	
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(int depositAmount) {
		this.depositAmount = depositAmount;
	}
	public int getMinimumBalance() {
		return minimumBalance;
	}
	public void setMinimumBalance(int minimumBalance) {
		this.minimumBalance = minimumBalance;
	}
	public int getOverdraftAmount() {
		return overdraftAmount;
	}
	public void setOverdraftAmount(int overdraftAmount) {
		this.overdraftAmount = overdraftAmount;
	}
}
