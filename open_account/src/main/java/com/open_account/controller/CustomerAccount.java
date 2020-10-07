package com.open_account.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.open_account.dao.Dao;
import com.open_account.entity.AccountDetails;
import com.open_account.entity.CustomerDetails;

/**
 * Servlet implementation class CustomerAccount
 */

public class CustomerAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dao d;
		try {
			d = new Dao(); 
		
		 //List<CustomerDetails> ll = d.displayCustomer();
			List<Integer> ll = d.displayCustomer();
	        request.setAttribute("customers", ll);
	        request.getRequestDispatcher("open_account.html").forward(request, response);
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}