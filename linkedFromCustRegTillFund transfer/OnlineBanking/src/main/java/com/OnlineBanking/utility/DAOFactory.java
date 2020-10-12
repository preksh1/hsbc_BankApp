package com.OnlineBanking.utility;
import com.OnlineBanking.dao.BankDaoInterface;
import com.OnlineBanking.utility.DAOFactory;


import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.dao.BankDaoInterface;
public class DAOFactory {
	public static BankDaoInterface createObject(String nn) {
	     BankDaoInterface id=null;
		if(nn.equals("admin service")) {
			id=new BankDao();
		}
		return id;
	}
}
