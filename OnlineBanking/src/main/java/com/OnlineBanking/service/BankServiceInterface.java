package com.OnlineBanking.service;
import java.util.List;
import java.sql.*;
import java.util.List;
import java.util.Map;
import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.dao.BankDaoInterface;
import com.OnlineBanking.entity.CustAccount;
import com.OnlineBanking.utility.ServiceFactory;
import com.OnlineBanking.utility.*;
public interface BankServiceInterface {
	List<CustAccount> bankService(CustAccount c)throws Exception;
	
	int transferService(CustAccount c)throws Exception;
}
