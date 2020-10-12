package com.CodeFuryy.Service;

import java.util.List;

import com.CodeFuryy.Entity.BankingUser;
import com.CodeFuryy.Entity.CustAccount;
import com.CodeFuryy.Entity.UserDetails;

public interface CustomerServiceInterface {
	
	public int check_login_detailsService(BankingUser em);
	public void insert_login_detailsService(BankingUser em);
	public int user_login_detailsService(BankingUser em);
	public BankingUser display_cust_detailsService(BankingUser em);
	public int update_detailsService(BankingUser em);
	public int validate_detailsService(BankingUser em) ;
	public int transferFundsService(CustAccount c);
	public List<CustAccount> bankService(CustAccount c);
	public UserDetails viewdetailsService(UserDetails id);
	public UserDetails editdetailsService(UserDetails u);
	public UserDetails editdetailService(UserDetails u);
	public int updatealtdetailService(UserDetails u) ;
	public int updatedetailService(UserDetails u);

}
