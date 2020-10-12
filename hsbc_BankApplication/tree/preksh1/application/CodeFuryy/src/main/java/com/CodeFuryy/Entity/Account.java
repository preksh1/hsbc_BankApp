package com.CodeFuryy.Entity;

import java.sql.Date;

public class Account {
	
	private String Accountnum;
	private String tpofacc;
	private int curbal;
	private Date opendate;
	private int minbal;
	private int overdraftam;
	private int custid;
	public String getAccountnum() {
		return Accountnum;
	}
	public void setAccountnum(String accountnum) {
		Accountnum = accountnum;
	}
	public String getTpofacc() {
		return tpofacc;
	}
	public void setTpofacc(String tpofacc) {
		this.tpofacc = tpofacc;
	}
	public int getCurbal() {
		return curbal;
	}
	public void setCurbal(int curbal) {
		this.curbal = curbal;
	}
	public Date getOpendate() {
		return opendate;
	}
	public void setOpendate(Date opendate) {
		this.opendate = opendate;
	}
	public int getMinbal() {
		return minbal;
	}
	public void setMinbal(int minbal) {
		this.minbal = minbal;
	}
	public int getOverdraftam() {
		return overdraftam;
	}
	public void setOverdraftam(int overdraftam) {
		this.overdraftam = overdraftam;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
		

}
