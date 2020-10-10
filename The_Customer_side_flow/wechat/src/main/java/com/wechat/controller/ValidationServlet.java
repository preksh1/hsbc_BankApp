package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ValidationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();	
		String doc1= request.getParameter("d1");
		String doc2 = request.getParameter("d2");
		String type1= (String) request.getAttribute("id2");
		
		out.println(doc1);
		out.println(doc2);
		out.println(type1);
		
		out.println("Data Stored");
	}

}
