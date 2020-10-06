package com.OnlineBanking.dao;

import java.util.ArrayList;
import java.util.List;

import com.OnlineBanking.utility.DAOFactory;
import com.OnlineBanking.entity.CustAccount;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;
public class BankDao implements BankDaoInterface {
	Connection con=null;
	public BankDao() {
		//userList=InstagramDAOFactory.createObject("admin service");
	    
	    
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
		int i=0;
		CustAccount uu=null;
		try {
			PreparedStatement ps=con.prepareStatement("select * from account where accountno=?");
			ps.setLong(1,fromaccount);		
			ResultSet res=ps.executeQuery();
			
			ll=new ArrayList<CustAccount>();
			
			if(res.next()) {
				i=1;
				 uu=new CustAccount();
				uu.setAccno(res.getLong(1));
				uu.setAcctype(res.getString(2));
				uu.setCurbal(res.getFloat(4));
				uu.setCustid(res.getLong(3));
				uu.setMinbal(res.getFloat(5));
				uu.setOverdraftamt(res.getFloat(6));
			}
		
			if(uu.getCurbal()>uu.getMinbal()) {
				float rembal=uu.getCurbal()-amount;
				if(uu.getAcctype().equalsIgnoreCase("Savings")) {
				if(rembal>=uu.getMinbal()) {
					float fromcurbal=rembal;
					PreparedStatement ps1=con.prepareStatement("update account set curbal=? where accountno=?");
					ps1.setFloat(1,fromcurbal);
					ps1.setLong(2,fromaccount);	
					int res1=ps1.executeUpdate();
					PreparedStatement ps2=con.prepareStatement("select curbal from account where accountno=?");
					ps.setLong(1,toaccount);		
					ResultSet res2=ps2.executeQuery();
					float tocurbal=0;
					if(res2.next()) {
						tocurbal=res.getFloat(1);
					}
					tocurbal=tocurbal+amount;
					PreparedStatement ps3=con.prepareStatement("update account set curbal=? where accountno=?");
					ps3.setFloat(1,tocurbal);
					ps3.setLong(2,toaccount);
				}
				}
				else if(uu.getAcctype().equalsIgnoreCase("Current")) {
					//if(uu)
				}
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
}
