package com.SeleniumCucumberFM.framework.stepdefinations.Registration;

import org.apache.log4j.Logger;

import com.SeleniumCucumberFM.framework.helper.AssertionHelper.VerificationHelper;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.TestBase.TestBase;
import com.SeleniumCucumberFM.framework.pageobject.LoginPage;
import com.SeleniumCucumberFM.framework.pageobject.RegistrationPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;;

public class Registration {
	private  Logger log = LoggerHelper.getLogger(Registration.class.getName());
	RegistrationPage registrationPage;
	LoginPage loginPage;
		
	@When("^Enter Registration email id$")
	public void enter_Registration_email_id() throws Exception {
		
		loginPage=new LoginPage(TestBase.driver);
		loginPage.enterRegistrationEmailAdd();
	}

	@When("^Click on open account$")
	public void click_on_open_account() throws Exception {
		
		registrationPage=loginPage.clickOnCreateAnAccount();
	}

	@Then("^Registration form open$")
	public void registration_form_open() throws Exception {
		if( new VerificationHelper().verifyElementPresnt(registrationPage.mrRadioButton))
	  return;
		else
			log.info("Registration page not open");
	}

	@Then("^Select Mr radio button$")
	public void select_Mrs_radio_button() throws Exception {
	   
	}

	@Then("^Enter first Name \"([^\"]*)\"$")
	public void enter_first_Name(String arg1) throws Exception {
		
		registrationPage.enterFirstName(arg1);
	}
	@Then("^Enter last Name \"([^\"]*)\"$")
	public void enter_last_Name(String arg1) throws Exception {
		
		registrationPage.enterLastName(arg1);
	}
	

	@Then("^Enter password \"([^\"]*)\"$")
	public void enter_password(String arg1) throws Exception {
		registrationPage.enterPassword(arg1);
	}
	
	@Then("^Select a Day \"([^\"]*)\"$")
	public void select_a_Day(String arg1) throws Exception {
		
		registrationPage.selectDay(arg1);
	}
	
	@Then("^Select a month \"([^\"]*)\"$")
	public void select_a_month(String arg1) throws Exception {
		
		registrationPage.selectMonth(arg1);
	}
	@Then("^Select a year \"([^\"]*)\"$")
	public void select_a_year(String arg1) throws Exception {
		
		registrationPage.selectYear(arg1);
	}

	
	@Then("^Enter your address first Name \"([^\"]*)\"$")
	public void enter_your_address_first_Name(String arg1) throws Exception {
		
		registrationPage.enterAddressFirstName(arg1);
	}

	@Then("^Enter your address last Name \"([^\"]*)\"$")
	public void enter_your_address_last_Name(String arg1) throws Exception {
		
		registrationPage.enterAddressLastName(arg1);
	}

	@Then("^Enter your company Name \"([^\"]*)\"$")
	public void enter_your_company_Name(String arg1) throws Exception {
		
		registrationPage.enterCompanyName(arg1);
	}

	@Then("^Enter Address \"([^\"]*)\"$")
	public void enter_Address(String arg1) throws Exception {
		
		registrationPage.address(arg1);
	}

	@Then("^Select city \"([^\"]*)\"$")
	public void select_city(String arg1) throws Exception {
		
		registrationPage.selectCity(arg1);
	}

	@Then("^Select state \"([^\"]*)\"$")
	public void select_state(String arg1) throws Exception {
		
		registrationPage.selectState(arg1);
	}

	@Then("^Select country \"([^\"]*)\"$")
	public void select_country(String arg1) throws Exception {
		
		registrationPage.selectCountry(arg1);
	}

	@Then("^Enter Zipcode \"([^\"]*)\"$")
	public void enter_Zipcode(String arg1) throws Exception {
		
		registrationPage.zipCode(arg1);
			}


	@Then("^Enter mobile phone number \"([^\"]*)\"$")
	public void enter_mobile_phone_number(String arg1) throws Exception {
		
		registrationPage.mobilePhoneNumber(arg1);
	}

	@Then("^Select Address alias \"([^\"]*)\"$")
	public void select_Address_alias(String arg1) throws Exception {
		
		registrationPage.addressAlias(arg1);
	}

	@Then("^Click on registration button$")
	public void click_on_registration_button() throws Exception {
		
	registrationPage.clickRegistration();
	}

	@Then("^Verify Registration successfull message$")
	public void verify_Registration_successfull_message() throws Exception {
	  Thread.sleep(80000);
	}



}
