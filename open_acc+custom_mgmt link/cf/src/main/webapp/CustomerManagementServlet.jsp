<%@ page import="java.io.IOException,java.io.PrintWriter,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,com.cf.Service.Service,com.cf.Service.ServiceInterface,com.cf.Dao.Dao,com.cf.Dao.DaoInterface,com.cf.Utility.EmployeeUser" %>
<%
	//String userId="s";
	//String password="s";
	//String userId=(String)session.getAttribute("userId");
	//String password=(String)session.getAttribute("password");
	ServiceInterface si=new Service();
	
	//EmployeeUser eu=si.EmployeeInfo(String userId,String password);
	//out.println("<h2>Welcome Employee "+eu.EmployeeName+"</h2>");
	//out.println("<p>Your employee id is: "+eu.EmployeeId+"</p>");
	out.println("<h2>Welcome Employee "+"x"+"</h2>");
	out.println("<p>Your employee id is: "+"z"+"</p>");
%>