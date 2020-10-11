<%@page import="java.util.*,com.cf.openAccountService.Service,com.cf.openAccountService.ServiceInterface,com.cf.entity.CustomerDetails" %>

<% 
	String phone=request.getParameter("phone");
	CustomerDetails c=new CustomerDetails();
	c.setPphone(phone);
	
	ServiceInterface si=new Service();
	int k=si.checkPhone(c);
	
	if(k==1)
	{	//out.println("1");//ph no. present
		out.println("1");
	}
	else
	{	
		out.println("0");
			
	}
		//out.println("alert('number used');");
		
	//else
		//out.println("0");
		
		
		
		%>
		
	 
	 
	 