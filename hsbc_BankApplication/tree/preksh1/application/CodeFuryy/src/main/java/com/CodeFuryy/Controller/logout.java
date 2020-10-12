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



public class logout extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In logout servlet");
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter(); 
		int i=0;

		CustomerServiceInterface c = ServiceFactory.createObject("CustomerServiceObject");

		HttpSession session = request.getSession(true);
		int var2= Integer.parseInt(session.getAttribute("myId").toString());

		
		BankingUser em=new BankingUser();
		
		em.setCust_id(var2);
		 i=c.update_detailsService(em);
		 System.out.print("Details Updated");

}
}