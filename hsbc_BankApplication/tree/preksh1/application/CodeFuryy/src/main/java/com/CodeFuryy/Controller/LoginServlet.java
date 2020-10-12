package com.CodeFuryy.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.CodeFuryy.Entity.Employee;
import com.CodeFuryy.Service.EmployeeService;
import com.CodeFuryy.Service.EmployeeServiceInterface;

/**
 * Servlet implementation class LoginServlet1
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	String username=null;
	String password=null;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		username=request.getParameter("name");
		password=request.getParameter("pass");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		EmployeeServiceInterface es = new EmployeeService();
		
		Employee e = new Employee();
		e.setEUsername(username);
		e.setEPassword(password);
		
		Employee e1 = es.loginEmployeeService(e);
		
		
		
	
		
		
		
		
		if(e1!=null)
		{
			HttpSession ss = request.getSession(true);
			
			
			ss.setAttribute("username", username);
			ss.setAttribute("password", password);
			ss.setAttribute("name", e1.getEName());
			ss.setAttribute("id", e1.getEmpid());
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/CustomerManagement.html");
			rd.forward(request, response);
			
		}
		else
		{
			out.println("Invalid id or password ");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			rd.include(request, response);
		}
		
		
		
	}

}
