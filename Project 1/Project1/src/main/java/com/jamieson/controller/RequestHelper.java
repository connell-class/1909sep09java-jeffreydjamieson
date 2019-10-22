package com.jamieson.controller;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {
	public static String process(HttpServletRequest req) {
		switch (req.getRequestURI()) {
		case "/Project1/home.proj":
			return "html/index.html";
		case "/Project1/login.proj":
			return "html/login.html";
		default:
			return null;
		}
	}
}