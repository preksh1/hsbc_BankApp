package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class valid extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String doc1= request.getParameter("val1");
		String doc2 = request.getParameter("val2");
		String a1= request.getParameter("val3");
		String a2= request.getParameter("val4");
		System.out.println("hello"+doc1+" "+a1);
		System.out.println("hello"+doc2+" "+a2);


		out.println(doc1+" "+a1);
		out.println(doc2+" "+a2);
		

	}

}
