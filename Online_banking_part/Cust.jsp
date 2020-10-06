
<%@page import="java.util.*,java.sql.*" %>




<%

String cust_id = request.getParameter("i");
String name = request.getParameter("n");
System.out.println(cust_id);
System.out.println(name);
if(cust_id.equals("123") && name.equals("Kunil")) {
	out.println("YES");
}
else{
	out.println("NO");
}
%>