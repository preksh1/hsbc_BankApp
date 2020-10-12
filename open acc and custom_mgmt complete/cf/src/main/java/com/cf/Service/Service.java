package com.cf.Service;

import com.cf.Dao.Dao;
import com.cf.Dao.DaoInterface;
import com.cf.Utility.EmployeeUser;

public class Service implements ServiceInterface {

	public EmployeeUser EmployeeInfo(String userId,String password) throws Exception {
		DaoInterface di=new Dao();
		return di.EmployeeInfoDao(userId, password);
	}
}
