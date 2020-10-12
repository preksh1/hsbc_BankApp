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



public class logout extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In logout servlet");
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		int i=0;

		BankDaoInterface d=new BankDao();

		HttpSession session = request.getSession();
		String var2=(String) session.getAttribute("myId");

		
		BankingUser em=new BankingUser();
		
		em.setCust_id(var2);
		 i=d.update_details(em);
		 System.out.print("Details Updated");

}
}