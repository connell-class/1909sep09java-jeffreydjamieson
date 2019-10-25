package com.jamieson.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jamieson.model.UserModel;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/Project1/home.proj":
			return "html/index.html";
		case "/Project1/login.proj":
			return "html/login.html";
		case "/Project1/user.proj":
			return Controller.loginCheck(req);
		case "/Project1/logout.proj":{
			req.getSession().invalidate();
			return "html/index.html";
		}
		//Employee functions
		case "/Project1/reimb.proj":
			return "html/empFunc/newReimb.html";
		case "/Project1/view.proj":
			return "html/empFunc/viewReimb.html";
		//Manager functions
		case "/Project1/fullview.proj":
			return "html/manageFunc/allReimb.html";
			
		default:
			return null;
		}
	}
}