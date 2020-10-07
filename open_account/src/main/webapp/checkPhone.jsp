<%@page import="java.util.*,com.open_account.dao.Dao,com.open_account.dao.DaoInterface,com.open_account.entity.CustomerDetails" %>

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