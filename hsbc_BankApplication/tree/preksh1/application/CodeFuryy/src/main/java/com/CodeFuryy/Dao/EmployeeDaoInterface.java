package com.CodeFuryy.Dao;

import java.util.List;

import com.CodeFuryy.Entity.Account;
import com.CodeFuryy.Entity.Customer1;
import com.CodeFuryy.Entity.Employee;

public interface EmployeeDaoInterface {

	public Employee loginEmployeeDao(Employee e);

	public int insertCustomerandAccountDao(Customer1 c, Account a);
	public int insertAccountDao(Account a);
	public List<Integer> fetchcustid();

}
