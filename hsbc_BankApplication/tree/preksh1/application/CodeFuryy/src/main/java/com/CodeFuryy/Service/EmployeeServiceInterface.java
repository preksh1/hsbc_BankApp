package com.CodeFuryy.Service;



import java.util.List;

import com.CodeFuryy.Entity.Account;
import com.CodeFuryy.Entity.Customer1;
import com.CodeFuryy.Entity.Employee;

public interface EmployeeServiceInterface {
	
	public Employee loginEmployeeService(Employee e);
	
	public int insertCustomerandAccount(Customer1 c,Account a);

	public int insertAccount(Account a);
	public List<Integer> fetchcustid();
	
}
