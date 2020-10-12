package com.wechat.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wechat.entity.Pojo;
import com.wechat.service.WeChatService;
import com.wechat.service.WeChatServiceInterface;




public class FriendServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession ss = request.getSession();
		String name=ss.getAttribute("userid").toString();
		System.out.println(name);
		Pojo x = new Pojo();
		x.setName(name);
		ArrayList<Pojo> l = new ArrayList<Pojo>();
		WeChatServiceInterface ws = new WeChatService();
		try {
			 l=ws.FriendList(x);
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			int i=1;
			if(l.size()>0) {
				for(Pojo ff:l) {
					out.println("<br>Friend"+i);
					out.println(ff.getName());
					out.println(ff.getEmail());
					out.println(ff.getPassword());
					out.println(ff.getAddress());
					out.println("<br>");
					i++;
				}
			}
			else {
				out.println("no friend found");
			}
			
			out.println("</body></html>");
		}
		
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
