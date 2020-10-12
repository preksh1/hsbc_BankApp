
<%@page import="java.util.*,java.sql.*" %>




<%

List<String> i=new ArrayList<String>();

i.add("DOB");
i.add("EMAIL");
Random rand = new Random();
int random=rand.nextInt(2);


System.out.print(random);
out.println(i.get(random));



%>