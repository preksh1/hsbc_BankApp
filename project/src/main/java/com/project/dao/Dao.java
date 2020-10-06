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
		PreparedStatement ps=con.prepareStatement("select * from ACCOUNT_DETAILS where C_ID=?");
		ps.setInt(1, custId);
		
		ResultSet res=ps.executeQuery();
		//System.out.println("updated "+i);
		if(res.next())
			i=1;
		return i;
		
	}
	
	public List<CustomerDetails> displayCustomer() throws Exception {
		List<CustomerDetails> ll=new ArrayList<CustomerDetails>();
		
		
			PreparedStatement ps=con.prepareStatement("select CUST_ID from CUSTOMER_DETAILS");
			ResultSet res=ps.executeQuery();
			while(res.next()) {
				CustomerDetails a=new CustomerDetails();
				 a.setCustId(res.getInt("customerID"));
				 ll.add(a);
			}
						return ll;
	}

	
}

