package com.jamieson.dao;

public class Config {
	private static String username="jeffreydjamieson";
	private static String password="j!552148J";
	private static String url="jdbc:postgresql://postgresql-class.c4bzybwncbrh.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=training";
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Config.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		Config.password = password;
	}
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		Config.url = url;
	}
	

}
