package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterCustomer
 */
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
	
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String pan = request.getParameter("pan");
        String dob = request.getParameter("dob");
        String p_ph = request.getParameter("p_ph");
        String p_email = request.getParameter("p_email");
        String a_ph = request.getParameter("a_ph");
        String a_email = request.getParameter("a_email");
        
        
        try {
        
            // loading drivers for mysql
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:derby:c:/firstdb1;create=true","richa","priya");

            PreparedStatement ps = con.prepareStatement
                        ("insert into Customer values(?,?,?,?,?,?,?,?)");

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, pan);
            ps.setString(4, dob);
            ps.setString(5, p_ph);
            ps.setString(6, p_email);
            ps.setString(7, a_ph);
            ps.setString(8, a_email);
            int i = ps.executeUpdate();
            
            if(i > 0) {
              //  out.println("You are sucessfully registered");
                response.sendRedirect("open_account.html");
            }
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	}

}
