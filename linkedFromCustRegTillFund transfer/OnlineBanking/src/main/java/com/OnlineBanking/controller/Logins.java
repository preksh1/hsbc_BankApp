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


public class Logins extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html"); 
		int i=0;
		String name = request.getParameter("val1");
		String uid = request.getParameter("val2");
		
		HttpSession session1 = request.getSession();
		session1.setAttribute("myUID", uid);
		session1.setAttribute("myUname", name);
		
		BankDaoInterface d=new BankDao();
		BankingUser em=new BankingUser();

		em.setUsername(name);
		em.setPassword(uid);
		System.out.println(name);
		System.out.println(uid);
		
		PrintWriter out = response.getWriter(); 

i=d.user_login_details(em);

if(i>0)
{
	out.println("YES");
}
else
{
	out.print("NO");
}
		 


			 

		}
			

	}


