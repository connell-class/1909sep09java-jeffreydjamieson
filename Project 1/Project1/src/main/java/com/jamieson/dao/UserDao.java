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
	
	public UserModel getUserByUsername(String user, String pass) {
	
		
		try (Connection conn=DriverManager.getConnection(Config.getUrl(), Config.getUsername(), Config.getPassword())){
			String sql="select * from users where user_password = md5(?||?||'hiphop');";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
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
