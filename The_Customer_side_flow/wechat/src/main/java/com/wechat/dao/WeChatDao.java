package com.wechat.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wechat.entity.Pojo;

public class WeChatDao implements WeChatDaoInterface {

	
	
	@Override
	public int RegistrationDao(Pojo p) {
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection("jdbc:derby:d:/firstdb","kunil","kunil ");
			PreparedStatement ps = con.prepareStatement("Insert into google values(?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2,p.getEmail());
			ps.setString(3,p.getPassword());
			ps.setString(4,p.getAddress());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.print("Done");
		return 1;
	}

	@Override
	public int LoginDao(Pojo x) {
		Connection con=null;
		ResultSet rs=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection("jdbc:derby:d:/firstdb","kunil","kunil ");
			PreparedStatement ps = con.prepareStatement("Select * From google Where name=? and password=?");
			ps.setString(1, x.getName());
			ps.setString(2,x.getPassword());
			 rs = ps.executeQuery();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Done");
		
		
		int i=0;
		try {
			if(rs.next()) {
				 
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("i="+i);
			return i;
		
	}

	@Override
	public ArrayList<Pojo> FriendListDao(Pojo x) {
		ArrayList<Pojo> friends = new ArrayList<Pojo>();
		ResultSet rs=null;
		Connection con=null;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con= DriverManager.getConnection("jdbc:derby:d:/firstdb","kunil","kunil ");
			PreparedStatement ps = con.prepareStatement("Select * From Friends Where name=?");
			ps.setString(1, x.getName());
			
			 rs = ps.executeQuery();
			System.out.print("Done");
			int i=0;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int i=0;
		try {
			while(rs.next()) {
				Pojo p = new Pojo();
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				p.setName(rs.getString(1));
				p.setEmail(rs.getString(2));
				p.setPassword(rs.getString(3));
				p.setAddress(rs.getString(4));
				friends.add(p);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i);
		return friends;
	}

}
