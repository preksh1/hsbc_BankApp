package com.cf.openAccountDao;

import java.sql.ResultSet;
import java.util.List;

import com.cf.entity.AccountDetails;
import com.cf.entity.CustomerDetails;

public interface DaoInterface {
	//public int checkNewCustomer(Integer custId) throws Exception;
	public List<Integer> displayCustomer() throws Exception ;
	public boolean checkPhone(CustomerDetails c) throws Exception;
}
