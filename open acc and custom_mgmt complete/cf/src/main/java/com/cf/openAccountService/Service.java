package com.cf.openAccountService;

import java.util.List;

import com.cf.entity.CustomerDetails;
import com.cf.openAccountDao.Dao;
import com.cf.openAccountDao.DaoInterface;

public class Service implements ServiceInterface{

	private DaoInterface di=null;
	public Service() {
		
		try {
			di=new Dao();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Override
	public List<CustomerDetails> displayCustomer() {
		// TODO Auto-generated method stub
		List<CustomerDetails> l=null;
		try {
			l=di.displayCustomer();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public int checkPhone(CustomerDetails c) {
		int i=0;
		try {
			i=di.checkPhone(c);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return i;
	}

	
}
