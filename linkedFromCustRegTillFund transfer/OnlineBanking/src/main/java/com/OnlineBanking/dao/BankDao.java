package com.OnlineBanking.dao;
import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.dao.BankDaoInterface;
import com.OnlineBanking.entity.BankingUser;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.OnlineBanking.entity.Pojo;
import com.OnlineBanking.utility.DAOFactory;
import com.OnlineBanking.entity.BankingUser;
import com.OnlineBanking.entity.Pojo;
import com.OnlineBanking.entity.CustAccount;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.io.*;
import com.OnlineBanking.entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BankDao implements BankDaoInterface {
	Connection con=null;
	public BankDao() {
	    try {
	    	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    	con=DriverManager.getConnection("jdbc:derby:c:/documents/firstdb1;create=true","dhananjay","dhananjay");
	    	}
	    	catch(ClassNotFoundException|SQLException e) {
	    		e.printStackTrace();
	    	}
	    
	}
	
	@Override
	public List<CustAccount> bankDAO(CustAccount c) throws Exception {
		// TODO Auto-generated method stub
		
		List<CustAccount> ll=null;
	
		try {
		PreparedStatement ps=con.prepareStatement("select * from account where custid=?");
		ps.setLong(1,c.getCustid());		
		ResultSet res=ps.executeQuery();
		
		ll=new ArrayList<CustAccount>();
		
		while(res.next()) {
			CustAccount uu=new CustAccount();
			uu.setAccno(res.getLong(1));
			uu.setAcctype(res.getString(2));
			ll.add(uu);
		}
		}
		catch(SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return ll;
	}

	@Override
	public int transferDAO(CustAccount c) throws Exception {
	
		// TODO Auto-generated method stub
		List<CustAccount> ll=null;
		float amount=c.getAmount();
		long toaccount=c.getToaccno();
		long fromaccount=c.getFromaccno();
		System.out.println(amount+" "+toaccount+" "+fromaccount);
		int i=0;
		CustAccount uu=null;
		
		try {
			PreparedStatement ps=con.prepareStatement("select * from account where accountno=?");
			ps.setLong(1,fromaccount);		
			ResultSet res=ps.executeQuery();
			
			ll=new ArrayList<CustAccount>();
			System.out.println("Inside try");
			if(res.next()) {
				i=1;
				
				 uu=new CustAccount();
				uu.setAccno(res.getLong(1));
				uu.setAcctype(res.getString(2));
				uu.setCurbal(res.getFloat(4));
				uu.setCustid(res.getLong(3));
				uu.setMinbal(res.getFloat(5));
				uu.setOverdraftamt(res.getFloat(6));
				System.out.println("Inside select fromacount to have details");
			}
		float rembal=0,fromcurbal=0,tocurbal=0;
			if(uu.getCurbal()>uu.getMinbal()) {
				System.out.println("curbal is grater than minbal");
				rembal=uu.getCurbal()-amount;
				if(uu.getAcctype().equalsIgnoreCase("Savings")) {
					System.out.println("account type is savings");
				if(rembal>=uu.getMinbal()) {
				  fromcurbal=rembal;
				  System.out.println("rembal is gretr equla to minbal");
				}
				else {
					i=-1;
				}
				}
				else if(uu.getAcctype().equalsIgnoreCase("Current")) {
					System.out.println("account type is current");
					if((uu.getCurbal()+uu.getOverdraftamt())>=amount) {
						fromcurbal=rembal;
						System.out.println("curbal+overdraft is greatr than transamt");
					}
					else {
						i=-2;
					}
				}
				else {
					i=-3;
				}
			}
			else {
				i=-4;
			}
			PreparedStatement ps1=con.prepareStatement("update account set curbal=? where accountno=?");
			ps1.setFloat(1,fromcurbal);
			ps1.setLong(2,fromaccount);	
			int res1=ps1.executeUpdate();
			String remark1="";
			if(res1>0) {
				remark1="transaction succesful";
				System.out.println(remark1);
			}
			else {
				remark1="transaction fail";
				System.out.println(remark1);
			}
			PreparedStatement ps2=con.prepareStatement("select curbal from account where accountno=?");
			ps2.setLong(1,toaccount);		
			ResultSet res2=ps2.executeQuery();
			
			if(res2.next()) {
				tocurbal=res2.getFloat(1);
				System.out.println("tocurbaal selected");
			}
			tocurbal=tocurbal+amount;
			PreparedStatement ps3=con.prepareStatement("update account set curbal=? where accountno=?");
			ps3.setFloat(1,tocurbal);
			ps3.setLong(2,toaccount);
			int res3=ps3.executeUpdate();
			String remark2="";
			if(res3>0) {
				remark2="transaction succesful";
				System.out.println("to curbal updated");
			}
			else {
				remark2="transaction fail";
				System.out.println("to curbal update failed");
			}
			int length =12;
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			 sdf.format(date);
			 long fromtransid=uu.generateTransid(length);
			 long totransid=uu.generateTransid(length);
			 PreparedStatement ps4=con.prepareStatement("insert into trans values(?,?,?,?,?)");
				ps4.setLong(1,fromtransid );
				ps4.setLong(2,fromaccount );
				ps4.setString(3,"DEBIT");
				ps4.setString(4,sdf.format(date));
				ps4.setString(5,remark1);
			 int res4=ps4.executeUpdate();
			 if(res4>0) {
				 System.out.println("inserted fromaccount trans");
			 }
			 PreparedStatement ps5=con.prepareStatement("insert into trans values(?,?,?,?,?)");
				ps5.setLong(1,totransid );
				ps5.setLong(2,toaccount );
				ps5.setString(3,"CREDIT");
				ps5.setString(4,sdf.format(date));
				ps5.setString(5,remark2);
			 int res5=ps5.executeUpdate();
			 if(res5>0) {
				 System.out.println("inserted toaccount trans");
			 }
			}
			catch(SQLException e1) {
				e1.printStackTrace();
			}
			finally {
				try {
					con.close();
				}
				catch(SQLException e){
					e.printStackTrace();
				}
			}
		
		
		return i;
	}
public int check_login_details(BankingUser em) {
		
		System.out.println(em.getName());	//print to console
		System.out.println(em.getCust_id());
		Connection con = null;
		PreparedStatement ps = null;
		int flag=0;
		try {
			
			
			System.out.print("Worked fine till here");
			ps = con.prepareStatement("select * from customer where cust_id=? and cust_name=?");
		    ps.setString(1,em.getCust_id());
		    ps.setString(2, em.getName());
			ResultSet rs= ps.executeQuery();  
			
			if(rs.next())
			{
				flag=1;
		}
		}
		catch(Exception e)    
		{    
		        e.printStackTrace();    
		} 
		


		return flag;
	}


	public void insert_login_details(BankingUser em) {
		//print to console
		System.out.println("hello i am kunil");
	
		PreparedStatement ps = null;
		try {
			
			
		
			ps = con.prepareStatement("insert into login values(?,?,CURRENT_TIMESTAMP,?)");
		   
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
	
		PreparedStatement ps = null;
		int flag=0;
		try {
			
		
			ps = con.prepareStatement("select * from login  where username=? and password=? ");
		   
		
		       	ps.setString(1, em.getUsername());
		       	ps.setString(2, em.getPassword());
				ResultSet i= ps.executeQuery();  
				
				if(i.next())
				{
					flag=1;
				}
			}
			catch(Exception e)    
			{    
			        e.printStackTrace();    
			} 
			


			return flag;
	}

	
	public BankingUser display_cust_details(BankingUser em) {
		System.out.println("dao layer");
		PreparedStatement ps = null;
		try {
			
			
		
			ps = con.prepareStatement("select customer.cust_id,customer.cust_name,account.acc_type,account.acc_no,account.curr_bal,login.last_login from customer,account,login where customer.cust_id in(select cust_id from login where username=? and password=?) ");
		   
		
		       	ps.setString(1,em.getUsername());
		     	ps.setString(2,em.getPassword());
		      
				ResultSet i= ps.executeQuery();  
				
				System.out.println("query done");
				if(i.next())
				{
					System.out.print("hello");
					em.setCust_id(i.getString("cust_id"));
					em.setName(i.getString("cust_name"));
					em.setAcc_no(i.getString("acc_no"));
					em.setAcc_type(i.getString("acc_type"));
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

	
	public int update_details(BankingUser em) {
		
		
		System.out.println("u in dao"+em.getUsername());
	
		PreparedStatement ps = null;
		int flag=0;

		try {
			
			
		
			ps = con.prepareStatement("update  login set last_login=CURRENT_TIMESTAMP   where username=? and password=?");
			ps.setString(1, em.getUsername());
			ps.setString(2, em.getPassword());
				int i= ps.executeUpdate();  
				System.out.println("query ran"+i );
				 if(i>0)
				{
					 	flag=1;
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
				 
				 return flag;
		}
	
	
	
	


	@Override
	public int validate_details(BankingUser em) {
		
		System.out.print("ID="+em.getCust_id());
		
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

		try {
			
		
			ps = con.prepareStatement("select pan,mob,dob,email from customer where cust_id=?");
		   
		
		       	ps.setString(1,em.getCust_id());
		      
				ResultSet i= ps.executeQuery();  
				
				if(i.next())
				{
					
					 P=i.getString(1);
					 M=i.getLong(2);
					 D=i.getString(3);
					 E=i.getString(4);
					 System.out.println(P);
					 System.out.println(M);
					 System.out.println(D);
					 System.out.println(E);
					
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
	@Override
	public int RegistrationDao(Pojo p) {
		
		try {
			
			PreparedStatement ps = con.prepareStatement("Insert into google values(?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2,p.getEmail());
			ps.setString(3,p.getPassword());
			ps.setString(4,p.getAddress());
			ps.executeUpdate();
		} 
		 catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.print("Done");
		return 1;
	}

	@Override
	public int LoginDao(Pojo x) {
	
		ResultSet rs=null;
		try {
			
			PreparedStatement ps = con.prepareStatement("Select * From google Where name=? and password=?");
			ps.setString(1, x.getName());
			ps.setString(2,x.getPassword());
			 rs = ps.executeQuery();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Done");
		
		
		int i=0;
		try {
			if(rs.next()) {
				 
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("i="+i);
			return i;
		
	}

	@Override
	public ArrayList<Pojo> FriendListDao(Pojo x) {
		ArrayList<Pojo> friends = new ArrayList<Pojo>();
		ResultSet rs=null;
		Connection con=null;
		try {
			
			PreparedStatement ps = con.prepareStatement("Select * From Friends Where name=?");
			ps.setString(1, x.getName());
			
			 rs = ps.executeQuery();
			System.out.print("Done");
			int i=0;
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		try {
			while(rs.next()) {
				Pojo p = new Pojo();
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				p.setName(rs.getString(1));
				p.setEmail(rs.getString(2));
				p.setPassword(rs.getString(3));
				p.setAddress(rs.getString(4));
				friends.add(p);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
		return friends;
	}
}
