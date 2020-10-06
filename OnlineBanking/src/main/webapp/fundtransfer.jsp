
<%@page import="java.util.*,com.OnlineBanking.service.BankServiceInterface,com.OnlineBanking.utility.ServiceFactory" %>
<%@page import="com.OnlineBanking.entity.CustAccount" %>

<%
//System.out.println(request.getParameter("faccot"));
long fromaccount=Long.parseLong(request.getParameter("faccot"));
long toaccount=Long.parseLong(request.getParameter("toaccot"));
float amount=Long.parseLong(request.getParameter("amont"));
//System.out.println(fromaccount+" "+toaccount+" "+amount);
CustAccount c=new CustAccount();
c.setFromaccno(fromaccount);
c.setToaccno(toaccount);
c.setAmount(amount);
BankServiceInterface is=ServiceFactory.createObject("admin service");
int j=is.transferService(c);

if(j>0){%>
<font color=green>Fund Transfer Successful</font>
 <% }
else{ %>
	<font color=red>Some error occured.Please try again</font>
<% }
%>