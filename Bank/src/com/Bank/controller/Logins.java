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

//Extend HttpServlet class 

public class Logins extends HttpServlet { 

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 

	response.setContentType("text/html"); 
String name = request.getParameter("name");
String uid = request.getParameter("uid");

PrintWriter out = response.getWriter(); 

 


try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");


Connection con = null;

	con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true","sakshi","sakshi");

PreparedStatement ps = null;
//ps = con.prepareStatement("insert into sakshi values(?,?, CURRENT_TIMESTAMP)");
	ps = con.prepareStatement("select * from  sakshi where id=? and name=?");
   
        
     
       ps.setString(1,uid );

	ps.setString(2,name);



	ResultSet i= ps.executeQuery();  
	
	if(i.next())
	{
	 out.println("Welcome "+i.getString(2));
	 

}
	else if(!i.next())
	{
		out.println("Please go and log in ");
		
	}
}
catch(Exception e)    
{    
        e.printStackTrace();    
} 

}


}

