package com.jamieson.tester;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jamieson.service.Service;


public class UnitTester {
	//Login tests
	@Test
	public void testEmployeeLogin() {
		assertEquals("html/employee.html", Service.getUser("snoopiedogg", "doggpound"));
	}

	@Test
	public void testManagerLogin() {
		assertEquals("html/manager.html", Service.getUser("notoriousbiggie", "bigpoppa"));
	}
	
	@Test
	public void invalidLogin() {
		assertEquals("html/invalidLogin.html", Service.getUser("unregistered", "nonexist"));
	}
	

}
