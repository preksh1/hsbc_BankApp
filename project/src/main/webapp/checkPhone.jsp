<%@page import="java.util.*,com.project.dao.Dao,com.project.dao.DaoInterface,com.project.entity.CustomerDetails" %>

<% 
	String phone=request.getParameter("phone");
	CustomerDetails c=new CustomerDetails();
	c.setPphone(phone);
	
	DaoInterface d=new Dao();
	boolean i=d.checkPhone(c);
	if(i==true)
	{%>
	<font color=red>This Phone number already exists.</font>
	<%
	 }%>