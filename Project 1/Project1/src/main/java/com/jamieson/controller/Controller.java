package com.jamieson.controller;

import javax.servlet.http.HttpServletRequest;

import com.jamieson.service.Service;

public class Controller {

	protected static String loginCheck(HttpServletRequest req) {
		String user=req.getParameter("username");
		String pass=req.getParameter("password");
		return Service.getUser(user, pass);
	}
}
