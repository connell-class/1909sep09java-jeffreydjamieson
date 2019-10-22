package com.jamieson.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jamieson.model.UserModel;
public class UserDao {
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public UserModel getUserById(int id) {
		String username="jeffreydjamieson";
		String password="j!552148J";
		String url="jdbc:postgresql://postgresql-class.c4bzybwncbrh.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=training";
		
		try (Connection conn=DriverManager.getConnection(url, username, password)){
			String sql="select * from users where user_id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();	
			UserModel u=null;
			while (rs.next()) {
				u=new UserModel(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
