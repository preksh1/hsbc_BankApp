package com.CodeFuryy.Utility;

import com.CodeFuryy.Dao.dao;
import com.CodeFuryy.Dao.daoInterface;

public class DaoFactory {

	public static daoInterface createObjectCustomer(String string) {
		
		daoInterface d=null;
		if (string.equals("CustomerDaoObject"))
		{
			d=new dao();
		}
		
		return d;
	}
	
	
	

}
