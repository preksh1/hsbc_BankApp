
<%@page import="java.util.*,java.sql.*,java.time.*"%>
<%

System.out.println("hey");
int i=0;


try {
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");


Connection con = null;

	con = DriverManager.getConnection("jdbc:derby:d:/bankdb;create=true", "sakshi", "sakshi");

PreparedStatement ps = null;

	ps = con.prepareStatement("update  sakshi set fieldname=CURRENT_TIMESTAMP where id=123");


	 i= ps.executeUpdate();  
	 if(i>0)
	{
System.out.println("<html><a>login.html</a></html>" );
		

	}
	else
	{
		out.println("Fail");
	
	}
}
	 catch(Exception e)    
	 {    
	         e.printStackTrace();    
	 } 

 %>
	