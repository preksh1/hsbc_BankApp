<%@ page import="java.io.IOException,java.io.PrintWriter,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse" %>
<%
	
	HttpSession ss = request.getSession(true);
	String id=ss.getAttribute("id").toString();
	String name=ss.getAttribute("name").toString();

	out.println("<h2>Welcome "+name+"</h2>");
	out.println("<p>Your employee id is: "+id+"</p>");
	
%>