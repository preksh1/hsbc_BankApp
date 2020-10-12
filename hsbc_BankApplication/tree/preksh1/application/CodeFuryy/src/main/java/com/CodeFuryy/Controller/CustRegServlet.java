package com.CodeFuryy.Controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CodeFuryy.Service.CustomerServiceInterface;
import com.CodeFuryy.Utility.ServiceFactory;
import com.CodeFuryy.Service.*;

import com.CodeFuryy.Entity.BankingUser;



public class CustRegServlet extends HttpServlet {
	int j=0;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		
		CustomerServiceInterface c = ServiceFactory.createObject("CustomerServiceObject"); //FactoryMethodLeft
		BankingUser em=new BankingUser();
		int cust_id = Integer.parseInt(request.getParameter("i"));
		String name = request.getParameter("n");
	
		em.setCust_id(cust_id);
		em.setName(name);
		//http://localhost:12000/wechat/Validation.html
		HttpSession ss = request.getSession(true);
		ss.setAttribute("myId", cust_id);
		System.out.println(cust_id);
		System.out.println(name);
		
		
		j=c.check_login_detailsService(em);
		if(j>0) {
			out.println("YES");
		}
		else{
			out.println("NO");
		}
		
		
		
		
		
		
	}

}
