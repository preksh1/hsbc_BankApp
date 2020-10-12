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
		
		daoInterface d=new dao();
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


