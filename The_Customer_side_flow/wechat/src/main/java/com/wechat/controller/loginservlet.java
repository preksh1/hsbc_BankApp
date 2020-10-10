package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.wechat.entity.Pojo;
import com.wechat.service.WeChatService;
import com.wechat.service.WeChatServiceInterface;

public class loginservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Pojo x = new Pojo();
		x.setName(name);
		x.setPassword(password);
		
		
		WeChatServiceInterface ws = new WeChatService();
		out.println("<html><body>");
		try {
			int i=ws.LoginData(x);
			if (i>0) {
				HttpSession ss = request.getSession();
				ss.setAttribute("userid", name);
				ss.setAttribute("pass", password);
				out.println(" Hi "+name+" Login sucessful. <a href=FriendServlet> Click here to View Friends </a>");
			}
			
			else {
				out.println("Invalid Password and ID");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
				rd.include(request, response);
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		out.println("</html></body>");
		
		
	}

}
