
<%@ page import="java.util.*,com.CodeFury1.Service.*"%>

<%


		EmployeeServiceInterface e = new EmployeeService();
		List<Integer> l = new ArrayList<Integer>();
		l= e.fetchcustid();
		String sta = "<datalist id=hugelist>";
		int length = l.size();
		//for(int i=0;i<length;i++)
		//{
			String s = Integer.toString(l.get(0));
			sta = sta+"<option value ="+s+">"+s+"</option>";
			System.out.println(sta);
		//}
				
		sta=sta+"</datalist>";
		out.println(sta);
%>