package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.entity.Pojo;
import com.wechat.service.WeChatService;
import com.wechat.service.WeChatServiceInterface;

public class regservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();		
		out.println("<html><body>");
		out.println("<br>Your name is"+name);
		out.println("<br>Your email is"+email);
		out.println("<br>Your password is"+password);
		out.println("<br>Your address is"+address);
		
		Pojo x = new Pojo();
		x.setName(name);
		x.setEmail(email);
		x.setPassword(password);
		x.setAddress(address);
		
		WeChatServiceInterface ws = new WeChatService();
		try {
			int i=ws.RegistrationService(x);
			if (i==1) {
				out.println("Registration sucessful.<a href=Login.html>Click here to login</a>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.println("</html></body>");
		
	}

}
