package com.project.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.project.entity.CustomerDetails;



public class Dao implements DaoInterface{

	Connection con=null;
	public Dao() throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
	}
	@Override
	public int checkNewCustomer(Integer custId) throws Exception {
		// TODO Auto-generated method stub
		int i=0;
		PreparedStatement ps=con.prepareStatement("select * from account_details where c_id=?");
		ps.setInt(1, custId);
		
		ResultSet res=ps.executeQuery();
		//System.out.println("updated "+i);
		if(res.next())
			i=1;
		return i;
		
	}
	
	//public List<Integer> displayCustomer() throws Exception {
	public List<Integer> displayCustomer() throws Exception {
		List<CustomerDetails> ll=new ArrayList<CustomerDetails>();
		
		
			PreparedStatement ps=con.prepareStatement("select cust_id from customer_details");
			ResultSet res=ps.executeQuery();
			List<Integer> a=new ArrayList<Integer>();
			while(res.next()) {
				//CustomerDetails a=new CustomerDetails();
				 a.add(res.getInt("cust_id"));
				 //ll.add(a);
			}
						return a;
	}

	public boolean checkPhone(CustomerDetails c) {
		boolean i=false;
		try {
			PreparedStatement ps=con.prepareStatement("select * from facebook where email=?");
			ps.setString(1, c.getPphone());
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				return true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}


