package com.cf.Service;

import com.cf.Utility.EmployeeUser;

public interface ServiceInterface {

	public EmployeeUser EmployeeInfo(String userId,String password) throws Exception;
}
