package com.CodeFuryy.Dao;


import com.CodeFuryy.Entity.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class dao implements daoInterface {

	
	public int check_login_details(BankingUser em) {
		
		System.out.println(em.getName());	//print to console
		System.out.println(em.getCust_id());
		Connection con = null;
		PreparedStatement ps = null;
		int flag=0;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    	con=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			
			System.out.print("Worked fine till here");
			ps = con.prepareStatement("select * from customer1 where cust_id=? and cust_name=?");
		    ps.setInt(1,em.getCust_id());
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
		Connection con = null;
		PreparedStatement ps = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			
		
			ps = con.prepareStatement("insert into login values(?,?,CURRENT_TIMESTAMP,?)");
		   
		       ps.setString(1,em.getUsername());
		       ps.setString(2, em.getPassword());
		       	ps.setInt(3,em.getCust_id());	//fetched by session
		       	
			int i= ps.executeUpdate();  
			
			
				System.out.print("success");
			}
		catch(Exception e)    
		{    
		        e.printStackTrace();    
		} 
	

		
	}


	public int user_login_details(BankingUser em) {
		int k=em.getCust_id();
		Connection con = null;
		PreparedStatement ps = null;
		int flag=0;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			
		
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
		Connection con = null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			PreparedStatement ps = null;
		
			ps = con.prepareStatement("select customer1.cust_id,customer1.cust_name,account1.acc_type,account1.acc_no,account1.cur_bal,login.last_login from customer1,account1,login where customer1.cust_id in(select cust_id from login where username=? and password=?) ");
		   
		
		       	ps.setString(1,em.getUsername());
		     	ps.setString(2,em.getPassword());
		      
				ResultSet i= ps.executeQuery();  
				
				System.out.println("query done");
				if(i.next())
				{
					System.out.print("hello");
					em.setCust_id(i.getInt("cust_id"));
					em.setName(i.getString("cust_name"));
					em.setAcc_no(i.getString("acc_no"));
					em.setAcc_type(i.getString("acc_type"));
					em.setMin_bal(i.getInt("cur_bal"));
					em.setLast_login(i.getTimestamp("last_login"));
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

	
	public List<CustAccount> bank(CustAccount c){
		// TODO Auto-generated method stub
		
		List<CustAccount> ll=null;
		Connection con = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			
			PreparedStatement ps=con.prepareStatement("select * from account1 where cust_id=?");
			ps.setLong(1,c.getCustid());		
			ResultSet res=ps.executeQuery();
			
			ll=new ArrayList<CustAccount>();
			
			while(res.next()) {
				CustAccount uu=new CustAccount();
				System.out.println(res.getString(1));
				uu.setAccno(res.getString(7));
				uu.setAcctype(res.getString(1));
				ll.add(uu);
			}
		}
		catch(SQLException | ClassNotFoundException e1) {
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
	
	
	public int update_details(BankingUser em) {
		
		
		System.out.println("u in dao"+em.getUsername());
		Connection con = null;
		PreparedStatement ps = null;
		int flag=0;

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			con = DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			
		
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
		String phone=em.getPhone();
		String pan = em.getPAN();
		String dob=em.getDOB();
		String email = em.getEMAIL();
		String P=null,D=null,E=null;
		String ph = null;
		
		PreparedStatement ps = null;
		Connection con = null;
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    	con=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			
		
			ps = con.prepareStatement("select pan,phone,dob,email from customer1 where cust_id=?");
		   
		
		       	ps.setInt(1,em.getCust_id());
		      
				ResultSet i= ps.executeQuery();  
				
				if(i.next())
				{
					
					 P=i.getString(1);
					 ph=i.getString(2);
					 D=i.getString(3);
					 E=i.getString(4);
					 System.out.println(P);
					 System.out.println(ph);
					 System.out.println(D);
					 System.out.println(E);
					
				}
		
				if(val1.equalsIgnoreCase("MOB"))
				{
					if(ph.equals(phone)) {
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
	public int transferFunds(CustAccount c) {
		
		Connection con = null;
		List<CustAccount> ll=null;
		float amount=c.getAmount();
		String toaccount=c.getToaccno();
		String fromaccount=c.getFromaccno();
		System.out.println(amount+" "+toaccount+" "+fromaccount);
		int i=0;
		CustAccount uu=null;
		
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	    	con=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			PreparedStatement ps=con.prepareStatement("select * from account1 where acc_no=?");
			ps.setString(1,fromaccount);		
			ResultSet res=ps.executeQuery();
			
			ll=new ArrayList<CustAccount>();
			System.out.println("Inside try");
			if(res.next()) {
				i=1;
				
				uu=new CustAccount();
				uu.setAccno(res.getString(1));
				uu.setAcctype(res.getString(2));
				uu.setCurbal(res.getFloat(4));
				uu.setCustid(res.getInt(3));
				uu.setMinbal(res.getFloat(5));
				uu.setOverdraftamt(res.getFloat(6));
				System.out.println("Inside select fromacount to have details");
			}
			float rembal=0,fromcurbal=0,tocurbal=0;
			if(uu.getCurbal()>uu.getMinbal()) 
			{
				System.out.println("curbal is grater than minbal");
				rembal=uu.getCurbal()-amount;
				if(uu.getAcctype().equalsIgnoreCase("Savings")) 
				{
					System.out.println("account type is savings");
					if(rembal>=uu.getMinbal()) 
					{
					  fromcurbal=rembal;
					  System.out.println("rembal is gretr equla to minbal");
					}
					else 
					{
						i=-1;
					}
				}
				else if(uu.getAcctype().equalsIgnoreCase("Current")) 
				{
					System.out.println("account type is current");
					if((uu.getCurbal()+uu.getOverdraftamt())>=amount)
					{
						fromcurbal=rembal;
						System.out.println("curbal+overdraft is greatr than transamt");
					}
					else 
					{
						i=-2;
					}
				}
				else
				{
					i=-3;
				}
			}
			else 
			{
				i=-4;
			}
			PreparedStatement ps1=con.prepareStatement("update account1 set cur_bal=? where acc_no=?");
			ps1.setFloat(1,fromcurbal);
			ps1.setString(2,fromaccount);	
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
			PreparedStatement ps2=con.prepareStatement("select cur_bal from account1 where acc_no=?");
			ps2.setString(1,toaccount);		
			ResultSet res2=ps2.executeQuery();
			
			if(res2.next()) {
				tocurbal=res2.getFloat(1);
				System.out.println("tocurbaal selected");
			}
			tocurbal=tocurbal+amount;
			PreparedStatement ps3=con.prepareStatement("update account1 set cur_bal=? where acc_no=?");
			ps3.setFloat(1,tocurbal);
			ps3.setString(2,toaccount);
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
				ps4.setString(2,fromaccount );
				ps4.setString(3,"DEBIT");
				ps4.setString(4,sdf.format(date));
				ps4.setString(5,remark1);
			 int res4=ps4.executeUpdate();
			 if(res4>0) {
				 System.out.println("inserted fromaccount trans");
			 }
			 PreparedStatement ps5=con.prepareStatement("insert into trans values(?,?,?,?,?)");
				ps5.setLong(1,totransid );
				ps5.setString(2,toaccount );
				ps5.setString(3,"CREDIT");
				ps5.setString(4,sdf.format(date));
				ps5.setString(5,remark2);
			 int res5=ps5.executeUpdate();
			 if(res5>0) {
				 System.out.println("inserted toaccount trans");
			 }
			}
			catch(ClassNotFoundException|SQLException e1) {
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
	
	public UserDetails viewdetails(UserDetails id)
	{	
		UserDetails ue=null;
		Connection conn=null;
		 
		 try
		 {
		 
			 
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		    conn=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka"); 
		 	PreparedStatement ps=conn.prepareStatement("select * from customer1 where cust_id=?");
			ps.setInt(1, id.getCust_id());
			ResultSet res=ps.executeQuery();
			while(res.next()){
				
				ue=new UserDetails();
				ue.setCust_id(res.getInt(1));
				ue.setCust_name(res.getString(2));
				ue.setAddress(res.getString(3));
				ue.setPhone(res.getString(4));
				ue.setEmail(res.getString(5));
				ue.setPan(res.getString(6));
				ue.setDob(res.getString(7));
			}
		 }
		 catch(ClassNotFoundException|SQLException e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {
			 try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
			return ue;
		}
	
		public UserDetails editdetails(UserDetails u){
		// TODO Auto-generated method stub
			UserDetails ue=null;
			Connection con=null;
			try
			{
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				con=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
		 
				PreparedStatement ps=con.prepareStatement("select * from customer1 WHERE cust_id=? ");
				ps.setInt(1, u.getCust_id());
				ResultSet res=ps.executeQuery();
				while(res.next()) 
				{
				ue=new UserDetails();
				ue.setCust_id(res.getInt(1));
				ue.setCust_name(res.getString(2));
				ue.setAddress(res.getString(3));
				ue.setPhone(res.getString(4));
				ue.setEmail(res.getString(5));
				ue.setPan(res.getString(6));
				ue.setDob(res.getString(7));
				}
			}
			catch(ClassNotFoundException|SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return ue;
		}
		public UserDetails editdetail(UserDetails u) {
			
			UserDetails ue=null;
			Connection con=null;
			try
			{
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
			 PreparedStatement ps=con.prepareStatement("select * from customer1 WHERE cust_id=? ");
			 ps.setInt(1, u.getCust_id());
				ResultSet res=ps.executeQuery();
				while(res.next()) 
				{
				ue=new UserDetails();
				ue.setCust_id(res.getInt(1));
				ue.setCust_name(res.getString(2));
				ue.setAddress(res.getString(3));
				ue.setPhone(res.getString(4));
				ue.setEmail(res.getString(5));
				ue.setPan(res.getString(6));
				ue.setDob(res.getString(7));
				}
				
		
			}
			catch(ClassNotFoundException|SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return ue;



	}
		
		
		
		public int updatedetail(UserDetails u) {
			
			Connection con = null;
			int res=0;
			try
			{
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				con=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
				
				PreparedStatement ps=con.prepareStatement("update customer1 set email=?,phone = ? where cust_id=?");	
			 	
				ps.setString(1, u.getEmail());ps.setString(2, u.getPhone());
				ps.setInt(3, u.getCust_id());
				res=ps.executeUpdate();
			}
			catch(ClassNotFoundException|SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					con.close();
				} 
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			return res;
		}
		
		public int updatealtdetail(UserDetails u)  {
			 
			 Connection con = null;
			int res=0;
			try
			{
					Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
					con=DriverManager.getConnection("jdbc:derby:d:/firstdb2;create=true","anushka","anushka");
					
					PreparedStatement ps=con.prepareStatement("update details set secph = ? ,secem=? where customerid=?");	
				 	
					ps.setString(1, u.getEmail());ps.setString(2, u.getPhone());
					ps.setInt(3, u.getCust_id());
					res=ps.executeUpdate();
				}
				catch(ClassNotFoundException|SQLException e)
				{
					e.printStackTrace();
				}
				finally
				{
					try
					{
						con.close();
					} 
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				return res;
			}
		}
		

	
	
		



