package com.SeleniumCucumberFM.framework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.SeleniumCucumberFM.framework.configreader.ObjectRepo;
import com.SeleniumCucumberFM.framework.helper.AssertionHelper.VerificationHelper;
import com.SeleniumCucumberFM.framework.helper.DropDown.DropDownHelper;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.Wait.WaitHelper;

//POM of Login page
public class LoginPage {
	
	private WebDriver driver;
	private  Logger log = LoggerHelper.getLogger(LoginPage.class.getName());
	WaitHelper waitHelper;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	
	WebElement signin;	
	
	@FindBy(xpath="//*[@id='email']")
	
	WebElement emailAddress;
	
	@FindBy(xpath="//*[@id='passwd']")
	
	WebElement password;
	
	@FindBy(xpath="//*[@id='SubmitLogin']")
	
	WebElement submiButton;
	
	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	
	WebElement ErrorMessage;
	
	@FindBy(xpath="//*[@id='email_create']")
	
	WebElement registrationEmailId;	
	
	@FindBy(xpath="//*[@id='SubmitCreate']")
	
	WebElement openAccountButton;
	
	public LoginPage(WebDriver driver)
	{
		
		this.driver = driver;
		log.debug("LoginPage: "+ this.hashCode());//to debug if correct driver is being picked
		PageFactory.initElements(this.driver, this);
		waitHelper = new WaitHelper(this.driver);
		waitHelper.waitForElement(this.driver,signin,ObjectRepo.reader.getExplicitWait());
		
	}
	
	public void enterEmailAddress(String email)
	{
		log.info("enter email address : "+email );
		this.emailAddress.sendKeys(email);	
	}
	public void enterPassword(String password)
	{
		log.info("enter password : "+password );
		this.  password.sendKeys(password);
	}
	public void clickOnSubmitButton()
	{
		log.info("Click on Submit");
		this.submiButton.click();
	}
	public HomePage clickOnSigninLink()
	{
		log.info("Click on signin");
		this.signin.click();
		return new HomePage(this.driver);//it should return homepgae object
	}
	public boolean verifySuccessfulMessage()
	{
		return VerificationHelper.verifyElementPresnt(ErrorMessage);
				
	}
	public void enterRegistrationEmailAdd()
	{
		log.info("enter reg email id");
	//	System.out.println("Inside");
		this.registrationEmailId.sendKeys(System.currentTimeMillis()+"@gamil.com");
	}
	public RegistrationPage clickOnCreateAnAccount()
	{
	log.info("click createOncreateaccount");
	this.openAccountButton.click();	
	return new RegistrationPage(this.driver);
	}
}
