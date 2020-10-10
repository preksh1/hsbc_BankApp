package com.wechat.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wechat.dao.dao;
import com.wechat.dao.daoInterface;
import com.wechat.entity.BankingUser;



public class logout extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hey");
		int i=0;

		daoInterface d=new dao();

		HttpSession session = request.getSession();
		String var2=(String) session.getAttribute("myId");

		
		BankingUser em=new BankingUser();
		
		em.setCust_id(var2);
		d.update_details( em);

}
}