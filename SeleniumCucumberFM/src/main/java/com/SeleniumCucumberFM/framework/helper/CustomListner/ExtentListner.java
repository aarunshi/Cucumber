package com.SeleniumCucumberFM.framework.helper.CustomListner;

import java.io.IOException;

import org.testng.ITestResult;

import com.SeleniumCucumberFM.framework.helper.TestBase.TestBasePOMHybrid;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public  class ExtentListner extends TestBasePOMHybrid{
	public static ScreenshotCapture SC= new ScreenshotCapture(TestBasePOMHybrid.driver);
	public  void getResults(ITestResult result, ExtentTest test) throws IOException
	{
		if (result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(LogStatus.PASS, result.getName()+"test is pass");
		}
		 if (result.getStatus()==ITestResult.FAILURE)
		 {
			 test.log(LogStatus.FAIL, result.getName()+"test is failed");
			String screen =  SC.getScreenShot(" ");
			test.log(LogStatus.FAIL,test.addScreenCapture(screen));
		 }
		 if (result.getStatus()==ITestResult.SKIP)
		 {
			 test.log(LogStatus.SKIP, result.getName()+"test is skipped");
		 }
		 if (result.getStatus()==ITestResult.STARTED)
		 {
			 test.log(LogStatus.INFO, result.getName()+"test i s started");
		 }
	}

}
