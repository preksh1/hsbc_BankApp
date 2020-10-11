<%@page import="java.util.*,com.cf.openAccountService.Service,com.cf.openAccountService.ServiceInterface,com.cf.entity.CustomerDetails" %>

<%
//List<String> i=new ArrayList<String>();
//i.add("1234");
//i.add("5678");
//DaoInterface di=new Dao();
ServiceInterface si=new Service();
List<CustomerDetails> i=si.displayCustomer();

String ss="<select  id=custId >";
ss+="<option  disabled selected>Select Customer Id</option>";
//String ss="<select onClick=accountFields() id=custId >";//can disable the button on select or something
for(CustomerDetails ll:i){
	//ss=ss+"<option>"+ll+"</option>";
	ss=ss+"<option value='"+ll.getCustId()+"'>"+ll.getCustId()+" : "+ll.getName()+ "</option>";
}
ss=ss+"</select>";
out.println(ss);
%>