<%@ page import="java.io.IOException,java.io.PrintWriter,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,com.cf.openAccountDao.Dao,com.cf.openAccountDao.DaoInterface"%>

<%
/*
String custId=request.getParameter("custId");
int x=Integer.parseInt(custId);
DaoInterface di=new Dao();
int i=di.checkNewCustomer(x);*/
//output of i say 0 for no customer and 1 for customer found can handle js functions in the script of open account html

out.println("<form id=x><h1 align=center tabindex=1>New Customer Registration</h1><table border=0 width=580px cellpadding=10 cellspacing=0 align=center tabindex=1 ><tr><td>Customer Name</td><td><input type=text id=name name=name required><br></td></tr><tr><td>Address</td><td><textarea id=address name=address rows=5 cols=20 required></textarea><br></td></tr><tr><td>PAN Number</td><td><input type=text id=name name=pan required ><br></td><!-- <td><input type=text id=name name=pan required pattern=[A-Z]{5}[0-9]{4}[A-Z]{1}><br></td> --></tr>");
out.println("<tr><td>DOB</td><td><input type=text id=name name=dob required placeholder=dd-mm-yy><br></td></tr><tr><td>Primary Phone</td><td><input type=text id=p_ph name=p_ph required ><input type=text id=phone hidden/><br></td></tr>");
out.println("<tr><td>Primary Email</td><td><input type=text id=p_email name=p_email required><br></td></tr><tr><td>Alternate Phone</td><td><input type=text id=a_ph name=a_ph ><br></td><!-- <td><input type=text id=a_ph name=a_ph><br></td> --></tr><tr><td>Alternate Email</td><td><input type=text id=a_email name=a_email><br></td></tr></table></form>");
%>




<% 

//<input type=text id="p_ph" name="p_ph" required ><div id="phone"></div><br></td>
//out.println("<tr><td>DOB</td><td><input type=text id=name name=dob required placeholder=dd-mm-yy><br></td></tr><tr><td>Primary Phone</td><td><!--  <input type=text id=p_ph name=p_ph required pattern=[\+]\d{2}[\-]\d{10}><div id=phone></div><br></td>--><input type=text id=p_ph name=p_ph required ><div id=phone></div><br></td></tr>");
//out.println("<tr><td>Primary Email</td><td><input type=text id=p_email name=p_email required><br></td></tr><tr><td>Alternate Phone</td><td><input type=text id=a_ph name=a_ph ><br></td><!-- <td><input type=text id=a_ph name=a_ph pattern=[\+]\d{2}[\-]\d{10}><br></td> --></tr><tr><td>Alternate Email</td><td><input type=text id=a_email name=a_email><br></td></tr><tr><td><input type=submit value=Submit ></td></tr></table></form>");




//out.println("<tr><td>Account Type</td><td><input type=radio id=saving name=account value=saving required><label for=saving>Saving</label><input type=radio id=current name=account value=current required><label for=current>Current</label><br></td></tr><tr><td>Deposit Amount</td><td><input type=text id=deposit name=deposit required></input><br></td></tr><tr><td>Minimum Balance</td><td><input type=text id=balance name=balance required></input><br></td></tr><tr><td>Overdraft Amount</td><td><input type=text id=overdraft name=overdraft required></input><br></td></tr>");
//out.println("<br><input type=submit value=Register id=bb onClick=validate("+i+") ><br>");
		
		
		//document.getElementById("form_elem").innerHTML=
/*
out.println("<tr><td>Account Type</td><td><input type=radio id=saving name=account value=saving><label for=saving>Saving</label><input type=radio id=current name=account value=current><label for=current>Current</label><br></td></tr>");



if(i==0){
	//for new user method output of dao be int i==0
	//
	out.println("<tr><td>Deposit Amount</td><td><input type=text id=deposit name=deposit ></input><br></td></tr><tr><td>Minimum Balance</td><td><input type=text id=balance name=balance></input><br></td></tr><tr><td>Overdraft Amount</td><td><input type=text id=overdraft name=overdraft></input><br></td></tr>");
}

*/




%>