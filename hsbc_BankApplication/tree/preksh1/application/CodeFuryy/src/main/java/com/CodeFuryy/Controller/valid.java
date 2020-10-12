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


public class valid extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		int var= Integer.parseInt(session.getAttribute("myId").toString());
		
		CustomerServiceInterface cs = ServiceFactory.createObject("CustomerServiceObject");//this should have been done via service factory as per standards
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String doc1= request.getParameter("val1");
		String doc2 = request.getParameter("val2");
		String a1= request.getParameter("val3");
		String a2= request.getParameter("val4");
		
		BankingUser c= new BankingUser();
		if(doc1.equalsIgnoreCase("PAN")) {
			c.setPAN(a1);
			c.setInput1(doc1);
		}
		else if(doc1.equalsIgnoreCase("MOB")) {
			c.setPhone(a1);
			c.setInput1(doc1);
		}
		
		if(doc2.equalsIgnoreCase("EMAIL")) {
			c.setEMAIL(a2);
			c.setInput2(doc2);
		}
		else if(doc2.equalsIgnoreCase("DOB")) {
			c.setDOB(a2);
			c.setInput2(doc2);
		}
		
		c.setCust_id(var);
		
		int i=cs.validate_detailsService(c);
		
		
		if(i==1) {
			
			out.println("User-Validated");
			System.out.println("valid session");
			
		}
		else {
			
			out.println("Invalid");
			System.out.println("Invalid session");
			
		}

	}

}
