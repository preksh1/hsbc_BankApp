package com.open_account.dao;

import java.sql.ResultSet;
import java.util.List;

import com.open_account.entity.AccountDetails;
import com.open_account.entity.CustomerDetails;

public interface DaoInterface {
	public int checkNewCustomer(Integer custId) throws Exception;
	public List<Integer> displayCustomer() throws Exception ;
	public boolean checkPhone(CustomerDetails c);
	
}