<%@ page import="java.io.IOException,java.io.PrintWriter,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,com.project.dao.Dao,com.project.dao.DaoInterface"%>

<%
String custId=request.getParameter("custId");
int x=Integer.parseInt(custId);
DaoInterface di=new Dao();
int i=di.checkNewCustomer(x);
//output of i say 0 for no customer and 1 for customer found can handle js functions in the script of open account html
out.println("<tr><td>Account Type</td><td><input type=radio id=saving name=account value=saving required><label for=saving>Saving</label><input type=radio id=current name=account value=current required><label for=current>Current</label><br></td></tr><tr><td>Deposit Amount</td><td><input type=text id=deposit name=deposit required></input><br></td></tr><tr><td>Minimum Balance</td><td><input type=text id=balance name=balance required></input><br></td></tr><tr><td>Overdraft Amount</td><td><input type=text id=overdraft name=overdraft required></input><br></td></tr>");
out.println("<br><input type=submit value=Register id=bb onClick=validate("+i+") ><br>");
		
		
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