package com.CodeFuryy.Dao;
import java.util.List;

import com.CodeFuryy.Entity.*;
public interface daoInterface {
	
	public int check_login_details(BankingUser em);
	public void insert_login_details(BankingUser em);
	public int user_login_details(BankingUser em);
	public BankingUser display_cust_details(BankingUser em);
	public int update_details(BankingUser em);
	public int validate_details(BankingUser em) ;
	public int transferFunds(CustAccount c);
	public List<CustAccount> bank(CustAccount c);
	public UserDetails viewdetails(UserDetails id);
	public UserDetails editdetails(UserDetails u);
	public UserDetails editdetail(UserDetails u);
	public int updatealtdetail(UserDetails u) ;
	public int updatedetail(UserDetails u);

}
