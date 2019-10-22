package com.jamieson.driver;

import com.jamieson.dao.UserDao;

public class Driver {

	public static void main(String[] args) {
		UserDao users=new UserDao();
		System.out.println(users.getUserById(2));
	}
}
