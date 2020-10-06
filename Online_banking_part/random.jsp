
<%@page import="java.util.*,java.sql.*" %>




<%

List<String> i=new ArrayList<String>();

i.add("ADHAR");
i.add("GOV-ID");
Random rand = new Random();
int random=rand.nextInt(2);


System.out.print(random);
out.println(i.get(random));



%>