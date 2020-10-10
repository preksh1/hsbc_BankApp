package com.cf.LoginController;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginServlet extends HttpServlet {
	
	String username=null;
	String password=null;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		username=request.getParameter("name");
		password=request.getParameter("pass");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		boolean i = login();
		
		out.println("<html><body>");
		
		
		if(i)
		{
			HttpSession ss = request.getSession(true);
			ss.setAttribute("username", username);
			ss.setAttribute("password", password);
			
			out.println("Welcome"+username);
			
		}
		else
		{
			out.println("Invalid id or password ");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			rd.include(request, response);
		}
	}
	
	
	public boolean login()
	{
		boolean i=false;
		//if ((username.equals("b"))&&((password.equals("b"))))
		i=true;

		return i;
	}
	

}
