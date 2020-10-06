package com.Bank.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hey");
		int i=0;


		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");


		Connection con = null;

			con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");

		PreparedStatement ps = null;

			ps = con.prepareStatement("update  sakshi set fieldname=CURRENT_TIMESTAMP where id=123");


			 i= ps.executeUpdate();  
			 if(i>0)
			{
		System.out.println("i in logout servlet yo" );
				

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

}
