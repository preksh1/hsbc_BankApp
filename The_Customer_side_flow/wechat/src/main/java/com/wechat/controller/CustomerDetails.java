package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wechat.dao.dao;
import com.wechat.dao.daoInterface;
import com.wechat.entity.BankingUser;



public class CustomerDetails extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
		
out.print("hey");
daoInterface d=new dao();

HttpSession session1 = request.getSession();
String var1=(String) session1.getAttribute("myUID");
String var=(String) session1.getAttribute("myUname");

BankingUser em=new BankingUser();
em.setUsername(var);
em.setPassword(var1);
	out.print(var);
BankingUser i=d.display_cust_details(em);


if(i != null)
{
	out.println("Customer ID is" +em.getCust_id());
	out.print("\n");
	out.println("Customer Name is "+em.getName());
	out.println("Account Number is "+em.getAcc_no());
	out.println("Account Type is "+em.getAcc_type());
	out.println("Current Balance is "+em.getMin_bal());
	out.println("Last Login is "+em.getLast_login());
}


	}

}
