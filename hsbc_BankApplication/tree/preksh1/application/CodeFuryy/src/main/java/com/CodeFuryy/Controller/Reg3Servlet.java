package com.CodeFuryy.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CodeFuryy.Service.CustomerServiceInterface;
import com.CodeFuryy.Utility.ServiceFactory;

import com.CodeFuryy.Entity.BankingUser;


public class Reg3Servlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("hey");
		CustomerServiceInterface c = ServiceFactory.createObject("CustomerServiceObject");
		String name= request.getParameter("username");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession(true);
		int var=Integer.parseInt(session.getAttribute("myId").toString());

		
		BankingUser em=new BankingUser();
		em.setUsername(name);
		em.setPassword(pass);
		em.setCust_id(var);
		c.insert_login_detailsService(em);

		out.println("Your Account For Online Banking is Ready to user"+"<a href=Login.html>LOGIN HERE</a>");

		
	}

}
