package com.cf.openAccountController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OpenAccountServlet1
 */
public class OpenAccountServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Date date=new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd.MM.yyyy");
        String stringDate= DateFor.format(date);
        
        
		response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String customerId=request.getParameter("CustomerId");
        int cid=Integer.parseInt(customerId);
        
        
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String pan = request.getParameter("pan");
        String dob = request.getParameter("dob");
        String p_ph = request.getParameter("p_ph");
        String p_email = request.getParameter("p_email");
        String a_ph = request.getParameter("a_ph");
        String a_email = request.getParameter("a_email");
        
        //12digit account number generation
        //double accId=(((Math.random())*Math.pow(10,12))%Math.pow(10,12));
        
        long accId=(long) (((Math.random())*Math.pow(10,12))%Math.pow(10,12));
        
        String accountType=request.getParameter("account");
    	String depositAmount=request.getParameter("deposit");
    	int d=Integer.parseInt(depositAmount);
    	 String minimumBalance=request.getParameter("balance");
    	int m=Integer.parseInt(minimumBalance);
    	 String overdraftAmount=request.getParameter("overdraft");
    	 int o;
    	 
    	 //change this
    	 if(overdraftAmount!=null)
    		 o=Integer.parseInt(overdraftAmount);
    	 else
    		 o=0;
        
        
        
        try {
        
            // loading drivers for mysql
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection("jdbc:derby:e:/db2");

            //deposited amount will be the current balance in this task of creating a new account
            PreparedStatement ps1 = con.prepareStatement("insert into accnt values(?,?,?,?,?,?,?)");
            
            //to check if update or insert required for old and new customer respectively
            PreparedStatement ps2 = con.prepareStatement("select *from customers where cid=?");
            ps2.setInt(1, cid);
            ResultSet res=ps2.executeQuery();
            int k=0;
            if(res.next()) {
            	k=1;
            }
            ////////////////////////////////////////////////////////////////////////////////////
            
            
            
            ps1.setInt(1, cid);
            ps1.setLong(2, accId);
            ps1.setString(3, accountType);
            ps1.setInt(4, d);
            ps1.setString(5, stringDate);
            ps1.setInt(6, m);
            ps1.setInt(7, o);
            
           
            int i,j;
            
            if(k==0) {
            	//new customer
            	
            	PreparedStatement ps = con.prepareStatement("insert into customers(cid,name,address,pphone,pemail,aphone,aemail,pan,dob) values(?,?,?,?,?,?,?,?,?)");
            	
            	ps.setInt(1,cid);
                ps.setString(2, name);
                ps.setString(3, address);
                
                ps.setString(4, p_ph);
                ps.setString(5, p_email);
                ps.setString(6, a_ph);
                ps.setString(7, a_email);
                ps.setString(8, pan);
                ps.setString(9, dob);
                
                i = ps.executeUpdate();
                j= ps1.executeUpdate();
                
                
            	
            	
            	
            }
            
            else {
            	//oldCustomer;
            	i=1;
            	j= ps1.executeUpdate();//insert values in account table
            	
            	
            }
            
            
            
            
            
            
            
            
            out.println("<html><body");
            if(i>0 && j>0) {
				
				out.println("registration successful!");
				out.println("<br>customer id is "+cid);
				out.println("<br>your account id is "+accId);
				out.println("<br><a href=open_account.html> Continue?</a>");
				out.println("</body></html>");
			}
			else {
				//out.println("<html><body>");
				
				out.println("<br>could not add to database");
				out.println("</body></html>");
			}
            
            
        
        }
        catch(Exception se) {
            se.printStackTrace();
        }
	}

}
