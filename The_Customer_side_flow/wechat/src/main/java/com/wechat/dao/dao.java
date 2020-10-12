package com.wechat.dao;
import com.wechat.entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class dao implements daoInterface {

	
	public int check_login_details(BankingUser em) {
		
		System.out.println(em.getName());	//print to console
		System.out.println(em.getCust_id());

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = null;
			con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");
			PreparedStatement ps = null;
		
			ps = con.prepareStatement("select * from customer where cust_id=? and cust_name=? ");
		   
		       ps.setString(1,em.getCust_id());
		       ps.setString(2, em.getName());

			ResultSet i= ps.executeQuery();  
			
			if(i.next())
			{
				return 1;
		}
		}
		catch(Exception e)    
		{    
		        e.printStackTrace();    
		} 
		


		return 0;
	}


	public void insert_login_details(BankingUser em) {
		//print to console
		System.out.println("hello i am sakshi");

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = null;
			con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");
			PreparedStatement ps = null;
		
			ps = con.prepareStatement("insert into login values(?,?,CURRENT_TIMESTAMP,?) ");
		   
		       ps.setString(1,em.getUsername());
		       ps.setString(2, em.getPassword());
		       	ps.setString(3,em.getCust_id());	//fetched by session
		       	
			int i= ps.executeUpdate();  
			
			
				System.out.print("success");
			}
		catch(Exception e)    
		{    
		        e.printStackTrace();    
		} 
	

		
	}


	public int user_login_details(BankingUser em) {
		String k=em.getCust_id();

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = null;
			con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");
			PreparedStatement ps = null;
		
			ps = con.prepareStatement("select * from login  where username=? and password=? ");
		   
		
		       	ps.setString(1, em.getUsername());
		       	ps.setString(2, em.getPassword());
				ResultSet i= ps.executeQuery();  
				
				if(i.next())
				{
					return 1;
				}
			}
			catch(Exception e)    
			{    
			        e.printStackTrace();    
			} 
			


			return 0;
	}

	
	public BankingUser display_cust_details(BankingUser em) {
		System.out.println("dao layer");

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = null;
			con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");
			PreparedStatement ps = null;
		
			ps = con.prepareStatement("select customer.cust_id,customer.cust_name,account.account_type,account.accountno,account.curr_bal,login.last_login from customer,account,login where customer.cust_id in(select cust_id from login where username=? and password=?) ");
		   
		
		       	ps.setString(1,em.getUsername());
		     	ps.setString(2,em.getPassword());
		      
				ResultSet i= ps.executeQuery();  
				
				System.out.println("query done");
				if(i.next())
				{
					System.out.print("hello");
					em.setCust_id(i.getString("cust_id"));
					em.setName(i.getString("cust_name"));
					em.setAcc_no(i.getString("accountno"));
					em.setAcc_type(i.getString("account_type"));
					em.setMin_bal(i.getString("curr_bal"));
					em.setLast_login(i.getString("last_login"));
					System.out.println("hey i in dao");
			return em;
					
				}
			}
			catch(Exception e)    
			{    
			        e.printStackTrace();    
			}
		return em;
		
			
		
	}

	
	public void update_details(BankingUser em) {
		
		String k=em.getCust_id();

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = null;
			con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");
			PreparedStatement ps = null;
		
			ps = con.prepareStatement("update  login set last_login=CURRENT_TIMESTAMP where cust_id=?");

ps.setString(4, em.getCust_id());
				int i= ps.executeUpdate();  
				 if(i>0)
				{
			System.out.println("success to logout" );
					

				}
				else
				{
					System.out.println("Fail");
				
				}
			}
				 catch(Exception e)    
				 {    
				         e.printStackTrace();    
				 } ;
		}
	
	
	
	


	@Override
	public int validate_details(BankingUser em) {
		
		System.out.print("In DAo");
		
		int k = 0,j = 0;
		
		String val1=em.getInput1();
		String val2=em.getInput2();
		System.out.print(val1);
		System.out.print(val2);
		int flag=0;
		long mob=em.getMOB();
		String pan = em.getPAN();
		String dob=em.getDOB();
		String email = em.getEMAIL();
		String P=null,D=null,E=null;
		long M = 0;
		
		PreparedStatement ps = null;
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    	con=DriverManager.getConnection("jdbc:derby:d:/firstdb;create=true","kunil","kunil");
			
		
			ps = con.prepareStatement("select * from credentials where cust_id=?");
		   
		
		       	ps.setInt(1,1);
		      
				ResultSet i= ps.executeQuery();  
				
				if(i.next())
				{
					System.out.println("inside i.next");
					 P=i.getString(1);
					 M=i.getLong(2);
					 D=i.getString(3);
					 E=i.getString(4);
					
				}
		
				if(val1.equalsIgnoreCase("MOB"))
				{
					if(M==mob) {
						k=1;
					}
				}
				else {
					if(P.equalsIgnoreCase(pan)) {
						k=1;
					}
				}
				
				if(val2.equalsIgnoreCase("DOB"))
				{
					if(D.equalsIgnoreCase(dob)) {
						j=1;
					}
				}
				
				else {
					if(E.equalsIgnoreCase(email)) {
						j=1;
					}
				}
				
				
				if(k==1 && j==1) {
					flag=1;
				}
		
	
	}catch(Exception e) {
		e.printStackTrace();
	}
		return flag;

		
	}
}


