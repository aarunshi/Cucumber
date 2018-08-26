package com.SeleniumCucumberFM.framework.stepdefinations.Login;

import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.SeleniumCucumberFM.framework.configreader.ObjectRepo;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.TestBase.TestBase;
import com.SeleniumCucumberFM.framework.pageobject.LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class Login {
private  Logger log = LoggerHelper.getLogger(Login.class.getName());
	LoginPage loginPage;
	@Given("^Navigate to application$")
	public void navigate_to_application() throws Exception {
	   
	  TestBase.driver.get(ObjectRepo.reader.getWebSite());
		//TestBase.driver.get(System.getProperty("url"));
	}

	@When("^User Click on sign in link$")
	public void user_Click_on_sign_in_link() throws Exception {
	   
		loginPage = new LoginPage(TestBase.driver);
		loginPage.clickOnSigninLink();
	}

	

	
	@When("^Enter email address as \"([^\"]*)\"$")
	public void enter_email_address_as(String arg1) throws Exception {
	  
		loginPage.enterEmailAddress(arg1);
	}

	@When("^Enter password as \"([^\"]*)\"$")
	public void enter_password_as(String arg1) throws Exception {
	    
		loginPage.enterPassword(arg1);
	}

	@When("^Click on Login Button$")
	public void click_on_Login_Button() throws Exception {
	    //
		loginPage.clickOnSubmitButton();
	}

	@Then("^Login is successful$")
	public void login_is_successful() throws Exception {
	    
	    if (loginPage.verifySuccessfulMessage())
	    {
	    	log.info("Login test passed");
	    }
	    else
	    {
	    	assertTrue(false,this.getClass().getSimpleName()+" Failed");
	    }
	   
	    	
	}



}
