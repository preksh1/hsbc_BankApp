package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wechat.dao.dao;
import com.wechat.dao.daoInterface;
import com.wechat.entity.BankingUser;


public class Reg3Servlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print("hey");
		daoInterface d=new dao();
		String name= request.getParameter("username");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();
		String var=(String) session.getAttribute("myId");

		
		BankingUser em=new BankingUser();
		em.setUsername(name);
		em.setPassword(pass);
		em.setCust_id(var);
		d.insert_login_details(em);

		out.println("Your Account For Online Banking is Ready to user"+"<a href=Login.html>LOGIN HERE</a>");

		
	}

}
