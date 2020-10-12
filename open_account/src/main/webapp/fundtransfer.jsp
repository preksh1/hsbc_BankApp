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
System.out.println(j);
String str = Integer.toString(j); 
    
	session.setAttribute("result",str);


if(j>0){%>
<font color=green>Fund Transfer Successful</font>
 <% }
else if(j==-1){%>

	<font color=red>The remaining balance after fund transfer for savings account is less than required minimum balance </font>
	<font color=red>Transfer cannot be processed</font>
<% }
else if(j==-2){%>
	<font color=red>Fund transfer overdraft limit exceeded for current existing user</font>
	<font color=red>Transfer cannot be processed</font>
<% }
else if(j==-3){%>
	<font color=red>Invalid account type</font>
	<font color=red>Transfer cannot be processed</font>
<% }
else if(j==-4){%>
	<font color=red>your available balance is less than the required minimum balance</font>
	<font color=red>Transfer cannot be processed</font>
<% }
else{ %>
	<font color=red>The account number in which you want to transfer money does not exist</font>
<% }
%>