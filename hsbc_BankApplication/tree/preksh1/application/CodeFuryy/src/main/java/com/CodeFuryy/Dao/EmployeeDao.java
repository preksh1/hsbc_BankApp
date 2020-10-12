package com.CodeFuryy.Dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CodeFuryy.Entity.Account;
import com.CodeFuryy.Entity.Customer1;
import com.CodeFuryy.Entity.Employee;


public class EmployeeDao implements EmployeeDaoInterface{
	
	
	
	public List<Integer> fetchcustid()
	{
		Connection conn=null;
		List<Integer> l = new ArrayList<Integer>();
		try
		{
		
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			PreparedStatement ps= conn.prepareStatement("Select cust_id from customer1");
			ResultSet res = ps.executeQuery();
			
			while(res.next())
			{
				l.add(res.getInt(1));
			}
			
			
			
		}
		catch(ClassNotFoundException |SQLException e2)
		{
			e2.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		return l;
		
	}

	@Override
	public Employee loginEmployeeDao(Employee e) {
		
		Employee e1 =null;
		Connection conn=null;
		try
		{
		
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			PreparedStatement ps= conn.prepareStatement("Select * from BankEmployee where eusername=? and epassword=?");
			ps.setString(1,e.getEUsername());
			ps.setString(2,e.getEPassword());
			ResultSet res =  ps.executeQuery();
			
			
			
			
			if(res.next())
			{
				
				
				e1 = new Employee();
				e1.setEmpid(res.getString(1));
				e1.setEName(res.getString(2));
				e1.setEUsername(res.getString(3));
				e1.setEPassword(res.getString(4));
			}
			
		}
		catch(ClassNotFoundException |SQLException e2)
		{
			e2.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		
	
		return e1;
	}

	@Override
	public int insertCustomerandAccountDao(Customer1 c, Account a) {
		
		
		Connection conn=null;
		try
		{
		
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			PreparedStatement ps= conn.prepareStatement("insert into Customer1 values(?,?,?,?,?,?,?)");
			ps.setInt(1,c.getCustid());
			ps.setString(2,c.getName());
			ps.setString(3,c.getAddress());
			ps.setString(4,c.getPhone());
			ps.setString(5,c.getEmail());
			ps.setString(6,c.getPan());
			ps.setString(7,c.getDob());
			int i =  ps.executeUpdate();
			PreparedStatement ps1= conn.prepareStatement("insert into Account1 values(?,?,?,?,?,?,?)");
			
			ps1.setString(1,a.getTpofacc());
			ps1.setInt(2,a.getCurbal());
			ps1.setDate(5,a.getOpendate());
			ps1.setInt(3,a.getMinbal());
			ps1.setInt(4,a.getOverdraftam());
			ps1.setInt(6,a.getCustid());
			ps1.setString(7,a.getAccountnum());
			int j = ps1.executeUpdate();
			
			if(i>0 && j>0)
			{
				return 1;
			}
			
			
		}
		catch(ClassNotFoundException |SQLException e2)
		{
			e2.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		
		return 0;
	}

	@Override
	public int insertAccountDao(Account a) {
		Connection conn=null;
		try
		{
		
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			
			PreparedStatement ps1= conn.prepareStatement("insert into Account values(?,?,?,?,?,?,?");
			
			ps1.setString(1,a.getTpofacc());
			ps1.setInt(2,a.getCurbal());
			ps1.setDate(5,a.getOpendate());
			ps1.setInt(3,a.getMinbal());
			ps1.setInt(4,a.getOverdraftam());
			ps1.setInt(6,a.getCustid());
			ps1.setString(7,a.getAccountnum());
			int j = ps1.executeUpdate();
			
			if(j>0)
				return 1;
		}
		
		
		catch(ClassNotFoundException |SQLException e2)
		{
			e2.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		
		
			
		return 0;
	}
	
	

}
