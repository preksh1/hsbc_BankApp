package com.CodeFuryy.Entity;


import java.util.Random;


public class CustAccount {
private int custid;
private String transid;
private String fromaccno;//account number of the user logged in
private String toaccno;
private String acctype;//account type of the user logged in
private float  minbal;
private float overdraftamt;
private float amount;
private String accno;

public int getCustid() {
	return custid;
}


public void setCustid(int custid) {
	this.custid = custid;
}


public String getTransid() {
	return transid;
}


public void setTransid(String transid) {
	this.transid = transid;
}


public String getFromaccno() {
	return fromaccno;
}


public void setFromaccno(String fromaccno) {
	this.fromaccno = fromaccno;
}


public String getToaccno() {
	return toaccno;
}


public void setToaccno(String toaccno) {
	this.toaccno = toaccno;
}


public String getAcctype() {
	return acctype;
}


public void setAcctype(String acctype) {
	this.acctype = acctype;
}


public float getMinbal() {
	return minbal;
}


public void setMinbal(float minbal) {
	this.minbal = minbal;
}


public float getOverdraftamt() {
	return overdraftamt;
}


public void setOverdraftamt(float overdraftamt) {
	this.overdraftamt = overdraftamt;
}


public float getAmount() {
	return amount;
}


public void setAmount(float amount) {
	this.amount = amount;
}





public String getAccno() {
	return accno;
}


public void setAccno(String accno) {
	this.accno = accno;
}


public float getCurbal() {
	return curbal;
}


public void setCurbal(float curbal) {
	this.curbal = curbal;
}


private float curbal;


	public  long generateTransid(int length) {
	    Random random = new Random();
	    char[] digits = new char[length];
	    digits[0] = (char) (random.nextInt(9) + '1');
	    for (int i = 1; i < length; i++) {
	        digits[i] = (char) (random.nextInt(10) + '0');
	    }
	    return Long.parseLong(new String(digits));
	}
	

}
