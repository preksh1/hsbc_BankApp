package com.cf.Dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.cf.Utility.EmployeeUser;

public interface DaoInterface {
	public EmployeeUser EmployeeInfoDao(String userId,String password) throws Exception;
	
}
