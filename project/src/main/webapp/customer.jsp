<%@page import="java.util.*,com.project.dao.Dao,com.project.entity.CustomerDetails,com.project.dao.DaoInterface"%>

<%

//i.add("1234");
//i.add("5678");
DaoInterface d=new Dao();
 List<CustomerDetails> ll = d.displayCustomer();
String ss="<select onClick=accountFields() id=custId >";
for(CustomerDetails i:ll){
	ss=ss+"<option>"+i+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>