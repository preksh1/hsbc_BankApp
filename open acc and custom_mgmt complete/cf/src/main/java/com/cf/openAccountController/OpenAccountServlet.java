package com.cf.openAccountController;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class RegisterCustomer
 */
public class OpenAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
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
        
        String accountType=request.getParameter("accountType");
    	String depositAmount=request.getParameter("depositAmount");
    	int d=Integer.parseInt(depositAmount) ;
    	 String minimumBalance=request.getParameter("minimumBalance");
    	int m=Integer.parseInt(minimumBalance);
    	 String overdraftAmount=request.getParameter("overdraftAmount");
    	int o=Integer.parseInt(overdraftAmount);
        
        
        
        try {
        
            // loading drivers for mysql
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            
            //creating connection with the database 
            Connection con = DriverManager.getConnection
                        ("jdbc:derby:e:/db2");

            
            PreparedStatement ps1 = con.prepareStatement("insert into acc values(?,?,?,?,?,?)");
            
            //to check if update or insert required for old and new customer respectively
            PreparedStatement ps2 = con.prepareStatement("select *from customer where cid=?");
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
            ps1.setInt(5, m);
            ps1.setInt(6, o);
            
           
            int i,j;
            
            if(k==0) {
            	//new customer
            	
            	PreparedStatement ps = con.prepareStatement("insert into customer values(?,?,?,?,?,?,?,?,?)");
            	
            	ps.setInt(1,cid);
                ps.setString(2, name);
                ps.setString(3, address);
                ps.setString(4, pan);
                ps.setString(5, dob);
                ps.setString(6, p_ph);
                ps.setString(7, p_email);
                ps.setString(8, a_ph);
                ps.setString(9, a_email);
                
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
				
				out.println("registration successful <a href=open_account.html> Continue?</a>");
				out.println("<br>customer id is "+cid);
				out.println("<br>your account id is "+accId);
				
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
