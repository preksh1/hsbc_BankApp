<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

String doc1= request.getParameter("val1");
String doc2 = request.getParameter("val2");
String a1= request.getParameter("val3");
String a2= request.getParameter("val4");
System.out.println("hello"+doc1+" "+a1);
System.out.println("hello"+doc2+" "+a2);


out.println("yo:"+a1);


%>