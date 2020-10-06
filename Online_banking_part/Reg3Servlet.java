package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Reg3Servlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name= request.getParameter("username");
		String pass = request.getParameter("pass");
		
		System.out.println("Username:"+name);
		System.out.println("Passowrd:"+pass);

		out.println("Your Account For Online Banking is Ready to user"+"<a href=login.html>LOGIN HERE</a>");

		
	}

}
