package com.OnlineBanking.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.dao.BankDaoInterface;
import com.OnlineBanking.entity.BankingUser;

public class Logout_Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			System.out.println("In logout servlet");
			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter(); 
			int i=0;

		  BankDaoInterface d=new BankDao();

			HttpSession session1 = request.getSession();
			String var1=(String) session1.getAttribute("myUID");
			String var=(String) session1.getAttribute("myUname");

			System.out.print("ID in servlet:"+var1);
			BankingUser em=new BankingUser();
			
			em.setUsername(var);
			em.setPassword(var1);
			
			 i=d.update_details(em);
			 System.out.print("Details Updated");
			 out.print("Details Updated");
	}

}
