
<%@page import="java.util.*,java.sql.*,com.OnlineBanking.entity.Customer" %>




<%
Customer c = new Customer();
String cust_id = request.getParameter("i");
String name = request.getParameter("n");
request.setAttribute("identification", cust_id);
RequestDispatcher rd= request.getRequestDispatcher("Reg3Servlet");
c.setCust_id(Integer.parseInt(cust_id));
c.setName(name);
System.out.println(cust_id);
System.out.println(name);
if(cust_id.equals("123") && name.equals("Kunil")) {
	out.println("YES");
}
else{
	out.println("NO");
}
%>