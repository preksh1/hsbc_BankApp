package com.OnlineBanking.entity;

import java.util.Date;
import java.util.Timer;

public class CustAccount {
private long custid;
private long transid;
private long fromaccno;//account number of the user logged in
private long toaccno;
private String acctype;//account type of the user logged in
private Date transdate;
private Timer transtime;
private float  minbal;
private float overdraftamt;
private float amount;
private long accno;
private float curbal;
/**
 * @return the curbal
 */
public float getCurbal() {
	return curbal;
}
/**
 * @param curbal the curbal to set
 */
public void setCurbal(float curbal) {
	this.curbal = curbal;
}
/**
 * @return the accno
 */
public long getAccno() {
	return accno;
}
/**
 * @param accno the accno to set
 */
public void setAccno(long accno) {
	this.accno = accno;
}
/**
 * @return the fromaccno
 */
public long getFromaccno() {
	return fromaccno;
}
/**
 * @param fromaccno the fromaccno to set
 */
public void setFromaccno(long fromaccno) {
	this.fromaccno = fromaccno;
}
/**
 * @return the toaccno
 */
public long getToaccno() {
	return toaccno;
}
/**
 * @param toaccno the toaccno to set
 */
public void setToaccno(long toaccno) {
	this.toaccno = toaccno;
}
/**
 * @return the acctype
 */
public String getAcctype() {
	return acctype;
}
/**
 * @param acctype the acctype to set
 */
public void setAcctype(String acctype) {
	this.acctype = acctype;
}
/**
 * @return the amount
 */
public float getAmount() {
	return amount;
}
/**
 * @param amount the amount to set
 */
public void setAmount(float amount) {
	this.amount = amount;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (fromaccno ^ (fromaccno >>> 32));
	result = prime * result + ((acctype == null) ? 0 : acctype.hashCode());
	result = prime * result + (int) (custid ^ (custid >>> 32));
	result = prime * result + (int) (transid ^ (transid >>> 32));
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CustAccount other = (CustAccount) obj;
	if (fromaccno != other.fromaccno)
		return false;
	if (acctype == null) {
		if (other.acctype != null)
			return false;
	} else if (!acctype.equals(other.acctype))
		return false;
	if (custid != other.custid)
		return false;
	if (minbal != other.minbal)
		return false;
	if (overdraftamt != other.overdraftamt)
		return false;
	if (transid != other.transid)
		return false;
	return true;
}
/**
 * @return the custid
 */
public long getCustid() {
	return custid;
}
/**
 * @param custid the custid to set
 */
public void setCustid(long custid) {
	this.custid = custid;
}
/**
 * @return the transid
 */
public long getTransid() {
	return transid;
}
/**
 * @param transid the transid to set
 */
public void setTransid(long transid) {
	this.transid = transid;
}
/**
 * @return the transdate
 */
public Date getTransdate() {
	return transdate;
}
/**
 * @param transdate the transdate to set
 */
public void setTransdate(Date transdate) {
	this.transdate = transdate;
}
/**
 * @return the transtime
 */
public Timer getTranstime() {
	return transtime;
}
/**
 * @param transtime the transtime to set
 */
public void setTranstime(Timer transtime) {
	this.transtime = transtime;
}
/**
 * @return the minbal
 */
public float getMinbal() {
	return minbal;
}
/**
 * @param minbal the minbal to set
 */
public void setMinbal(float minbal) {
	this.minbal = minbal;
}
/**
 * @return the overdraftamt
 */
public float getOverdraftamt() {
	return overdraftamt;
}
/**
 * @param overdraftamt the overdraftamt to set
 */
public void setOverdraftamt(float overdraftamt) {
	this.overdraftamt = overdraftamt;
}



}
