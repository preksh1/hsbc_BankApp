package com.OnlineBanking.dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.OnlineBanking.entity.*;
import com.OnlineBanking.entity.CustAccount;
import com.OnlineBanking.entity.BankingUser;
import com.OnlineBanking.entity.Pojo;
import java.util.ArrayList;

import com.OnlineBanking.entity.Pojo;

public interface BankDaoInterface {

	List<CustAccount> bankDAO(CustAccount c) throws Exception;

	int transferDAO(CustAccount c)throws Exception;
	int check_login_details(BankingUser em);
	void insert_login_details(BankingUser em);
	int user_login_details(BankingUser em);
	BankingUser display_cust_details(BankingUser em);
	int update_details(BankingUser em);
	public int validate_details(BankingUser em) ;
	
	public int RegistrationDao(Pojo p);

	public int LoginDao(Pojo x);

	public ArrayList<Pojo> FriendListDao(Pojo x);

}
