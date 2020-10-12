package com.wechat.dao;
import com.wechat.entity.*;
public interface daoInterface {
	
	int check_login_details(BankingUser em);
	void insert_login_details(BankingUser em);
	int user_login_details(BankingUser em);
	BankingUser display_cust_details(BankingUser em);
	void update_details(BankingUser em);
	public int validate_details(BankingUser em) ;

}
