package com.SeleniumCucumberFM.framework.TestScriptsPOMHybridFM.Registration;




import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import com.SeleniumCucumberFM.framework.helper.AssertionHelper.VerificationHelper;
import com.SeleniumCucumberFM.framework.helper.CustomListner.ExtentListner;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.TestBase.TestBase;
import com.SeleniumCucumberFM.framework.helper.TestBase.TestBasePOMHybrid;
import com.SeleniumCucumberFM.framework.pageobject.LoginPage;
import com.SeleniumCucumberFM.framework.pageobject.RegistrationPage;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.sl.In;

public class TS01Registration extends TestBasePOMHybrid{
	//WebDriver driver;
	private  Logger log = LoggerHelper.getLogger(TS01Registration.class.getName());
	RegistrationPage registrationPage;
	LoginPage loginPage;

	 @DataProvider(name="testdata")
	 public String[][] getTestData() throws IOException
	 {
		 String[][] data= getData("testData.xlsx","RegData");
		 return data;
	 }
	@Test(dataProvider="testdata")			
	
	public void doRegistration(String firstName,String lastName, String password, String  day,String month,String year,String addFirstName,String addLastName, String companyName,String address, String city, String state,String country, String zipCode, String mobileNumber,String alias) {
		log.info("************Starting registation***********");
		loginPage=new LoginPage(driver);
		loginPage.clickOnSigninLink();
		loginPage.enterRegistrationEmailAdd();
		
		System.out.println("run by thread: "+ Thread.currentThread().getId());
		registrationPage=loginPage.clickOnCreateAnAccount();
	
		new VerificationHelper();
		
		if( VerificationHelper.verifyElementPresnt(registrationPage.mrRadioButton))
			{log.info("Registration page  open");
			Assert.assertTrue(false, "Registration page  open");
			}
		else
			{log.info("Registration page not open");
			Assert.assertTrue(false, "Registration page not open");
			}
		
		registrationPage.completeRegistrationProcess(firstName, lastName,  password,   day, month, year, addFirstName, addLastName,  companyName, address,  city,  state, country,  zipCode,  mobileNumber, alias);
		log.info("************ending registation***********");
	
	}
	
	@Test
	public void multitest()
	{
		System.out.println("checking multi thread methods");
		System.out.println("run by thread: "+ Thread.currentThread().getId());
	}

}
