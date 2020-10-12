package com.OnlineBanking.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBanking.dao.BankDao;
import com.OnlineBanking.dao.BankDaoInterface;
import com.OnlineBanking.entity.BankingUser;



public class CustomerDetails extends HttpServlet {
	

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
		
out.print("hey");
BankDaoInterface d=new BankDao();

HttpSession session1 = request.getSession();
String var1=(String) session1.getAttribute("myUID");
String var=(String) session1.getAttribute("myUname");

BankingUser em=new BankingUser();
em.setUsername(var);
em.setPassword(var1);
	out.print(var);
BankingUser i=d.display_cust_details(em);

String custid=i.getCust_id();
request.setAttribute("custid",custid);
request.getRequestDispatcher("toaccount.jsp").forward(request, response); 
if(i != null)
{
	out.println("Customer ID is" +i.getCust_id()+"<br>");
	out.println("Customer Name is "+i.getName()+"<br>");
	out.println("Account Number is "+i.getAcc_no()+"<br>");
	out.println("Account Type is "+i.getAcc_type()+"<br>");
	out.println("Current Balance is "+i.getMin_bal()+"<br>");
	out.println("Last Login is "+i.getLast_login()+"<br>");
}

out.println("<html><body>");
out.println(" <a href=FundTransfer.html>FundTransfer</a>");
out.println(" <a href=.html>ViewAndEditDetails</a>");
out.println("</body></html>");
	}

}
