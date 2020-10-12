package com.CodeFuryy.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.CodeFuryy.Entity.Account;
import com.CodeFuryy.Entity.Customer1;
import com.CodeFuryy.Service.EmployeeService;
import com.CodeFuryy.Service.EmployeeServiceInterface;

/**
 * Servlet implementation class OpenAnAccount
 */
public class OpenAnAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		int custid = Integer.parseInt(request.getParameter("id"));
		String Account = request.getParameter("account");
		int deposit = Integer.parseInt(request.getParameter("deposit"));
		int minbal = Integer.parseInt(request.getParameter("balance"));
		int overd = Integer.parseInt(request.getParameter("overdraft"));
		String acc_no = request.getParameter("accno");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		EmployeeServiceInterface es = new EmployeeService();
		
		if(overd==0)
		{
			String name = request.getParameter("name");
			
			String address = request.getParameter("address");
			String pan = request.getParameter("pan");
			String dob = request.getParameter("dob");
			String p_ph = request.getParameter("p_ph");
			String pemail = request.getParameter("p_email");
			String alternatph = request.getParameter("a_ph");
			String aemail = request.getParameter("a_email");
			
			Customer1 c = new Customer1();
			c.setCustid(custid);
			c.setAddress(address);
			c.setName(name);
			c.setDob(dob);
			c.setPhone(p_ph);
			c.setEmail(pemail);
			c.setPan(pan);
			
			Account a = new Account();
			a.setAccountnum(acc_no);
			a.setTpofacc(Account);
			a.setCurbal(minbal);
			a.setMinbal(minbal);
			a.setOverdraftam(overd);
			a.setCustid(custid);
			
			
			int i = es.insertCustomerandAccount(c, a);
			
			if(i>0)
			{
			
				out.println("<html><body>");
				out.println("Account Created Successfully................");
				out.println("<a href =OpenAnAccount.html>Back to Open Account Page</a>");
				out.println("</body></html>");
			}
			else
			{
				out.println("<html><body>");
				out.println("Account Not Created !!!! ReTry....");
				out.println("<a href =OpenAnAccount.html>Back to Open Account Page</a>");
				out.println("</body></html>");
			}
				
		}
		else
		{
			Account a1 = new Account();
			a1.setCustid(custid);
			
			
			a1.setAccountnum(acc_no);
			a1.setTpofacc(Account);
			a1.setCurbal(minbal);
			a1.setMinbal(minbal);
			a1.setOverdraftam(overd);
			a1.setCustid(custid);
			
			int i = es.insertAccount(a1);
			if(i>0)
			{
				out.println("<html><body>");
				out.println("Account Created Successfully................");
				out.println("<a href =OpenAnAccount.html>Back to Open Account Page</a>");
				out.println("</body></html>");
			}
			else
			{
				out.println("<html><body>");
				out.println("Account Not Created !!!! ReTry....");
				out.println("<a href =OpenAnAccount.html>Back to Open Account Page</a>");
				out.println("</body></html>");
			}
		}
		
		out.println("<html><body>");
		out.println("<a href = Login.html>LOGOUT</a>");
		out.println("</body></html>");
		
		
	}

}
