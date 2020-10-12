package com.OnlineBanking.service;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.util.List;
import java.util.Map;
import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.dao.BankDaoInterface;
import com.OnlineBanking.entity.CustAccount;
import com.OnlineBanking.utility.ServiceFactory;
import com.OnlineBanking.entity.Pojo;
import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.utility.DAOFactory;
import com.OnlineBanking.utility.*;

public class BankService implements BankServiceInterface {
private BankDaoInterface id;
	
	public BankService() {
		//id=new InstagramDAO();
		id=DAOFactory.createObject("admin service");
	}
	@Override
	public List<CustAccount> bankService(CustAccount c) throws Exception {
		// TODO Auto-generated method stub
		return id.bankDAO(c);
	}

	@Override
	public int transferService(CustAccount c) throws Exception {
		// TODO Auto-generated method stub
		return id.transferDAO(c);
	}
	@Override
	public int RegistrationService(Pojo p) {
		
		int i = id.RegistrationDao(p);
		return i;
	}
	@Override
	public int LoginData(Pojo x) {
		
		int i = id.LoginDao(x);
		return i;
	}
	@Override
	public ArrayList<Pojo> FriendList(Pojo x) {
		
		ArrayList<Pojo> a=  id.FriendListDao(x);
		
		return a;
	}

}
