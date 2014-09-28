package com.testng.tests;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testng.infra.MyCode;

public class MyCodeTests extends TestListenerAdapter {

	private MyCode myCode;
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("before class called ...");
		myCode = new MyCode();
		
	}

	@Test(testName = "test add")
	@Parameters({"num1","num2"})
	public void testAdd(int a, int b) {
		Reporter.log("running testAdd("+ a +", " + b + ")", 0);
		Reporter.log("running int res = myCode.add(a, b);", 1);
		int res = myCode.add(a, b);
		Reporter.log("after running int res = myCode.add(a, b);", 1);
		Assert.assertEquals(res, 9);
		Reporter.log("after running Assert.assertEquals(res, 9);", 0);
	}

	@Override
	public void onStart(ITestContext testContext) {
		System.out.println("test context.getName() returns: " + testContext.getName());
	}
}
