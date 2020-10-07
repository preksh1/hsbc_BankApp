<%@page import="java.util.*,com.open_account.dao.Dao,com.open_account.dao.DaoInterface" %>

<%
//List<String> i=new ArrayList<String>();
//i.add("1234");
//i.add("5678");
DaoInterface di=new Dao();
List<Integer> i=di.displayCustomer();
String ss="<select onClick=accountFields() id=custId >";
for(Integer ll:i){
	//ss=ss+"<option>"+ll+"</option>";
	ss=ss+"<option value='"+ll+"'>"+ll+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>