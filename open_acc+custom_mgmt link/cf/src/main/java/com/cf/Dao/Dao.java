package com.cf.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cf.Utility.EmployeeUser;

public class Dao implements DaoInterface {

	Connection con=null;
	public Dao() throws Exception {
		Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		con=DriverManager.getConnection("jdbc:derby:e:/db2");
	}
	@Override
	public EmployeeUser EmployeeInfoDao(String userId, String password) throws Exception {
		{
			PreparedStatement ps=con.prepareStatement("select employeeId,employeeName from Employee where userId=? and password=?");
			ps.setString(1,userId);
			ps.setString(1,password);
			ResultSet res=ps.executeQuery();
			EmployeeUser eu=new EmployeeUser();
			if(res.next()) {
				eu.setEmployeeId(res.getString(1));
				eu.setEmployeeName(res.getString(2));
			}
			return eu;
		} 
		
	}
	

}
