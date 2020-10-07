package com.Bank.controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*; 

import java.io.IOException;    
import java.io.PrintWriter;    
import java.sql.*;    
import javax.servlet.ServletException;    
import javax.servlet.annotation.WebServlet;    
import javax.servlet.http.HttpServlet;    
import javax.servlet.http.HttpServletRequest;    
import javax.servlet.http.HttpServletResponse;  
import java.util.Date; 

import javax.servlet.*; 

import javax.servlet.http.*; 


public class CustomerDetails extends HttpServlet { 

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet res=null;
		response.setContentType("text/html"); 
	
		String uid = request.getParameter("uid");

		PrintWriter out = response.getWriter(); 


		 


		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");


		Connection con = null;

			con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");

		PreparedStatement ps = null;
		//apply join in customer and account table to display account id,type of account and balance

		//ps = con.prepareStatement("select id,name,last_login,account id,current_bal from sakshi,account_table where ID=?");
			ps = con.prepareStatement("select * from sakshi where ID=?");
		   
		        
		     
		       ps.setString(1,uid );

			



			ResultSet i= ps.executeQuery();  
			
		
			if(i.next())
			{//insert html
			    //out.println( "ID is " + i.getString(1));
				//pass customer id from customer table
			    out.println("name is " + i.getString(2));
			    out.println("Last Login " + i.getString(3));
			    //out.println("Account is"+ i.getString("account_id");
			    //out.println("current balance of "+i.getstring("account_id")+"is "+i.getString("current_bal");
		}
		}
		catch(Exception e)    
		{    
		        e.printStackTrace();    
		} 
		
		}

	}


