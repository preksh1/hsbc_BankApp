package com.OnlineBanking.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.dao.BankDaoInterface;
import com.OnlineBanking.entity.BankingUser;



public class CustRegServlet extends HttpServlet {
	int j=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		
		BankDaoInterface d=new BankDao(); 
		BankingUser em=new BankingUser();
		String cust_id = request.getParameter("i");
		String name = request.getParameter("n");
	
		em.setCust_id(cust_id);
		em.setName(name);
		
		HttpSession session = request.getSession();
		session.setAttribute("myId", cust_id);
		System.out.println(cust_id);
		System.out.println(name);
		
		
		j=d.check_login_details(em);
		if(j>0) {
			out.println("YES");
		}
		else{
			out.println("NO");
		}
		
		
		
		
		
		
	}

}
