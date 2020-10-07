package com.open_account.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Account
 */
public class Account extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
    //    String accountNo=request.getParameter("accountNo");
    //    int a=Integer.parseInt(accountNo);
     //   String customerID=request.getParameter("customerID");
    //	int c=Integer.parseInt(customerID);
    	String accountType=request.getParameter("accountType");
    	String depositAmount=request.getParameter("depositAmount");
    	int d=Integer.parseInt(depositAmount) ;
    	 String minimumBalance=request.getParameter("minimumBalance");
    	int m=Integer.parseInt(minimumBalance);
    	 String overdraftAmount=request.getParameter("overdraftAmount");
    	int o=Integer.parseInt(overdraftAmount);
        
        
        
        
        
            // loading drivers for mysql
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:derby:c:/firstdb1;create=true","richa","priya");
           // Connection con = DriverManager.getConnection("jdbc:derby:e:/db2;");
            PreparedStatement ps = con.prepareStatement
                        ("insert into ACCOUNT_DETAILS values(?,?,?,?)");

           // ps.setInt(1, a);
           // ps.setInt(2, c);
            ps.setString(3, accountType);
            ps.setInt(4, d);
            ps.setInt(5, m);
            ps.setInt(6, o);
            
            int i = ps.executeUpdate();
            
            if(i > 0) {
                out.println("Account Created");
               
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	}

	}


