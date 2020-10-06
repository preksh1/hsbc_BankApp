package com.OnlineBanking.dao;
import java.util.List;
import java.util.Map;

import com.OnlineBanking.entity.CustAccount;

public interface BankDaoInterface {

	List<CustAccount> bankDAO(CustAccount c) throws Exception;

	int transferDAO(CustAccount c)throws Exception;

	
	

}
