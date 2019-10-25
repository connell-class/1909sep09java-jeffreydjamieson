package com.jamieson.service;

import com.jamieson.dao.UserDao;
import com.jamieson.model.UserModel;

public class Service {
	static UserDao users = new UserDao();

	public static String getUser(String user, String pass) {
		if (users.getUserByUsername(user, pass) != null) {
			UserModel u = users.getUserByUsername(user, pass);
			if (u.getUser_role_id() == 1) {
				return "html/employee.html";
			} else {
				return "html/manager.html";
			}
		} else
			return "html/invalidLogin.html";
	}
}
