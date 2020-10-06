package com.project.dao;

import java.sql.ResultSet;
import java.util.List;

import com.project.entity.AccountDetails;
import com.project.entity.CustomerDetails;

public interface DaoInterface {
	public int checkNewCustomer(Integer custId) throws Exception;
	public List<CustomerDetails> displayCustomer() throws Exception ;
}
