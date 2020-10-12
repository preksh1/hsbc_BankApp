package com.CodeFuryy.Service;

import java.util.List;

import com.CodeFuryy.Dao.EmployeeDao;
import com.CodeFuryy.Dao.EmployeeDaoInterface;
import com.CodeFuryy.Entity.Account;
import com.CodeFuryy.Entity.Customer1;
import com.CodeFuryy.Entity.Employee;

public class EmployeeService implements EmployeeServiceInterface{
	
	private EmployeeDaoInterface ed;
	
	public EmployeeService()
	{
		ed=new EmployeeDao();
	}
	
	@Override
	public Employee loginEmployeeService(Employee e) {
		Employee e1 = ed.loginEmployeeDao(e);
		return e1;
	}

	@Override
	public int insertCustomerandAccount(Customer1 c, Account a) {
		int i = ed.insertCustomerandAccountDao(c,a);
		return i;
	}

	@Override
	public int insertAccount(Account a) {
		int i = ed.insertAccountDao(a);
		return i;
	}

	@Override
	public List<Integer> fetchcustid() {
		List<Integer> l = ed.fetchcustid();
		return l;
	}

}
