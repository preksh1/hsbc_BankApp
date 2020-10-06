
<%@page import="java.util.*,com.OnlineBanking.service.BankServiceInterface,com.OnlineBanking.utility.ServiceFactory" %>
<%@page import="com.OnlineBanking.entity.CustAccount" %>

<%--FacebookServiceInterface fs=ServiceFactory.createObject("user");
List<String> i=fs.country(); --%>

<%
long custid=12345678;
//String custid1=request.getParameter("custid");
//long custid=Long.parseLong(custid1);

CustAccount c=new CustAccount();
c.setCustid(custid);
BankServiceInterface is=ServiceFactory.createObject("admin service");
List<CustAccount> ll=is.bankService(c);

String ss="<select id=fmac name=country >";
for(CustAccount ll1:ll){
	ss=ss+"<option value='"+ll1.getAccno()+"'>"+ll1.getAccno()+"</option>";
}
ss=ss+"</select>";

out.println(ss);
%>