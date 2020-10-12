package com.CodeFuryy.Service;

import java.util.List;

import com.CodeFuryy.Dao.daoInterface;
import com.CodeFuryy.Entity.BankingUser;
import com.CodeFuryy.Entity.CustAccount;
import com.CodeFuryy.Entity.UserDetails;
import com.CodeFuryy.Utility.DaoFactory;

public class CustomerService implements CustomerServiceInterface{

	private daoInterface d;
	
	public CustomerService()
	{
		d=DaoFactory.createObjectCustomer("CustomerDaoObject");
	}
	
	@Override
	public int check_login_detailsService(BankingUser em) {
		int i = d.check_login_details(em);
		return i;
	}

	@Override
	public void insert_login_detailsService(BankingUser em) {
		
		
	}

	@Override
	public int user_login_detailsService(BankingUser em) {
		int i = d.user_login_details(em);
		return i;
	}

	@Override
	public BankingUser display_cust_detailsService(BankingUser em) {
		BankingUser b = d.display_cust_details(em);
		return b;
	}

	@Override
	public int update_detailsService(BankingUser em) {
		int i = d.update_details(em);
		return i;
	}

	@Override
	public int validate_detailsService(BankingUser em) {
		int i = d.validate_details(em);
		return i;
	}

	@Override
	public int transferFundsService(CustAccount c) {
		int i = d.transferFunds(c);
		return i;
	}

	@Override
	public List<CustAccount> bankService(CustAccount c) {
		List<CustAccount> l = d.bank(c);
		return l;
	}

	@Override
	public UserDetails viewdetailsService(UserDetails id) {
		 UserDetails u =d.viewdetails(id);
		return u;
	}

	@Override
	public UserDetails editdetailsService(UserDetails u) {
		 UserDetails u1 = d.editdetails(u); 
		 return u1;
	}

	@Override
	public UserDetails editdetailService(UserDetails u) {
		 UserDetails u1 = d.editdetail(u);
		return u1;
	}

	@Override
	public int updatealtdetailService(UserDetails u) {
		int i = d.updatealtdetail(u);
		return i;
	}

	@Override
	public int updatedetailService(UserDetails u) {
		int i = d.updatedetail(u);
		return i;
	}

}
