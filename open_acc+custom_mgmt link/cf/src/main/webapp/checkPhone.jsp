<%@page import="java.util.*,com.cf.openAccountDao.Dao,com.cf.openAccountDao.DaoInterface,com.cf.entity.CustomerDetails" %>

<% 
	String phone=request.getParameter("phone");
	CustomerDetails c=new CustomerDetails();
	c.setPphone(phone);
	
	DaoInterface di=new Dao();
	boolean i=di.checkPhone(c);
	
	if(i==true)
		//out.println("1");//ph no. present
		
		
		out.println("alert('number used');");
		
	//else
		//out.println("0");
		
		
		
		%>
		
	 
	 
	 