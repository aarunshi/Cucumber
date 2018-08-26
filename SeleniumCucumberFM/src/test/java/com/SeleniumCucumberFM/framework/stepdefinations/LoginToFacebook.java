package com.SeleniumCucumberFM.framework.stepdefinations;

import org.openqa.selenium.By;

import com.SeleniumCucumberFM.framework.helper.TestBase.TestBase;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToFacebook {
	@Given("^User navigate to Facbook\\.com$")
	public void user_navigate_to_Facbook_com() throws Exception {
		TestBase.driver.get("https://www.facebook.com");
		System.getProperty("${url}");
	}

	@When("^User enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enter_username_as_and_password_as(String arg1, String arg2) throws Exception {
		TestBase.driver.findElement(By.xpath(".//*[@id='email']")).sendKeys(arg1);
		TestBase.driver.findElement(By.xpath("//*[@id='pass']")).sendKeys(arg2);
	}

	@When("^user click on login button$")
	public void user_click_on_login_button() throws Exception {
		
		TestBase.driver.findElement(By.xpath("//*[@id='u_0_a']")).click();
	}

	@Then("^Login should be successful$")
	public void login_should_be_successful() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Login should not be successful$")
	public void login_should_not_be_successful() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}



}
