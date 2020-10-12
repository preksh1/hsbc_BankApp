<%
		
		String result=session.getAttribute("result").toString();
		System.out.println("result="+result);
		int j=Integer.parseInt(result);
		System.out.println("j="+j);
		if(j>0){%>
		<font color=green>Fund Transfer Successful</font>

		 <% }
		else if(j==-1){%>
			<font color=red>The remaining balance after fund transfer  for savings account is less than required minimum balance </font>
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

