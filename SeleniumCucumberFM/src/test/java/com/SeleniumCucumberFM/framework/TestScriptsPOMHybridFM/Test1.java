package com.SeleniumCucumberFM.framework.TestScriptsPOMHybridFM;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.SeleniumCucumberFM.framework.helper.CustomListner.ExtentListner;
import com.SeleniumCucumberFM.framework.helper.TestBase.TestBasePOMHybrid;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Test1 extends TestBasePOMHybrid {
	//WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports extent;
//	static 
//	{
//		Calendar calender = Calendar.getInstance();
//		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//		extent = new ExtentReports(System.getProperty("user.dir")+"/src/main/java/com/SeleniumCucumberFM/Reports/test"+formater.format(calender.getTime())+".html",false);
//		
//		System.out.println(System.getProperty("user.dir")+"/src/main/java/com/SeleniumCucumberFM/Reports/test"+formater.format(calender.getTime())+".html");//System.out.println(System.getProperty("user.dir")+"/src/main/java/com/SeleniumMaven/Reports/test"+formater.format(calender.getTime())+".html");
//	}	
//	@AfterMethod
//	public void afterMethod(ITestResult result) throws IOException
//	{
//		
//		ExtentListner.getResults(result);
//		System.out.println("in after method");
//	}
//	@BeforeMethod
//	public void beforeMethod(ITestResult result)
//	{
//		test = extent.startTest(result.getName());
//		test.log(LogStatus.INFO, result.getName()+"TestStarted");
//		System.out.println("in before method");
//
//	}
//
//@BeforeClass
//	 public void getdriver() throws IOException
//	 {
//	 this.driver= init();
//	}


@Test()
	public void testName()
	{
	//Calendar calender = Calendar.getInstance();
	//System.out.println(calender.getCalendarType());
	Reporter.log("checking listner fail");
	Assert.assertTrue(false, "checking");
	}
}
