<%@page import="java.util.*,com.cf.openAccountDao.Dao,com.cf.openAccountDao.DaoInterface" %>

<%
//List<String> i=new ArrayList<String>();
//i.add("1234");
//i.add("5678");
DaoInterface di=new Dao();
List<Integer> i=di.displayCustomer();

String ss="<select  id=custId >";
ss+="<option  disabled selected>Select Customer Id</option>";
//String ss="<select onClick=accountFields() id=custId >";//can disable the button on select or something
for(Integer ll:i){
	//ss=ss+"<option>"+ll+"</option>";
	ss=ss+"<option value='"+ll+"'>"+ll+"</option>";
}
ss=ss+"</select>";
out.println(ss);
%>