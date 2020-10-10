package com.wechat.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wechat.dao.dao;
import com.wechat.dao.daoInterface;
import com.wechat.entity.BankingUser;



public class CustRegServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		
		daoInterface d=new dao();
		BankingUser em=new BankingUser();
		String cust_id = request.getParameter("i");
		String name = request.getParameter("n");
	
		em.setCust_id(cust_id);
		em.setName(name);
		
		HttpSession session = request.getSession();
		session.setAttribute("myId", cust_id);
		System.out.println(cust_id);
		System.out.println(name);
		
		int j=0;
		j=d.check_login_details(em);
		if(j>0) {
			out.println("YES");
		}
		else{
			out.println("NO");
		}
		
		
		
		
		
		
	}

}
