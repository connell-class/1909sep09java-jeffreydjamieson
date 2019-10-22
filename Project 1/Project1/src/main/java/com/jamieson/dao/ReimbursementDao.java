package com.jamieson.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jamieson.model.ReimbursementModel;


public class ReimbursementDao {
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ReimbursementModel getReimbusrementById(int id) {
		String username="jeffreydjamieson";
		String password="j!552148J";
		String url="jdbc:postgresql://postgresql-class.c4bzybwncbrh.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=Project 1";
		
		try (Connection conn=DriverManager.getConnection(url, username, password)){
			String sql="select * from reimbursement where reimb_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();	
			ReimbursementModel r=null;
			while (rs.next()) {
				r=new ReimbursementModel(rs.getInt(1), rs.getInt(2), rs.getTimestamp(3), rs.getTimestamp(4), rs.getString(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9));
			}
			return r;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
