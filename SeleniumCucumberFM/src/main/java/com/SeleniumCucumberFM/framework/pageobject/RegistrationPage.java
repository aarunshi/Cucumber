package com.SeleniumCucumberFM.framework.pageobject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SeleniumCucumberFM.framework.configreader.ObjectRepo;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.Wait.WaitHelper;

public class RegistrationPage {
	private  Logger log = LoggerHelper.getLogger(RegistrationPage.class.getName());
	WebDriver driver;
	WaitHelper waitHelper;
	
	
	
	@FindBy(xpath="//*[@id='id_gender1']")
	
	public WebElement mrRadioButton;
	
	@FindBy(xpath="//*[@id='id_gender2']")
	
	WebElement mrsRadioButton;
	
	@FindBy(xpath="//*[@id='customer_firstname']")
	
	WebElement firstName;	
	
	@FindBy(xpath="//*[@id='customer_lastname']")
	
	WebElement lastName;
	
	@FindBy(xpath="//*[@id='passwd']")
	
	WebElement password;
	
	@FindBy(xpath="//*[@id='days']/option")
		
	WebElement day;
	
	@FindBy(xpath="//*[@id='months']/option")
	
	WebElement month;
	
	@FindBy(xpath="//*[@id='years']/option")
	
	WebElement year;	
	
	@FindBy(xpath="//*[@id='firstname']")
	
	WebElement addressFirstName;
	
	@FindBy(xpath="//*[@id='lastname']")
	
	WebElement addressLastName;
	
	@FindBy(xpath="//*[@id='company']")
	
	WebElement companyName;
	
	@FindBy(xpath="//*[@id='address1']")
	
	WebElement address;
	
	@FindBy(xpath="//*[@id='city']")
	
	WebElement city;
	
	@FindBy(xpath="//*[@id='id_state']/option")
	
	WebElement state;	
	
	@FindBy(xpath="//*[@id='id_country']/option")
	
	WebElement country;	
	
	@FindBy(xpath="//*[@id='postcode']")
	
	WebElement zipcode;
	
	@FindBy(xpath="//*[@id='phone_mobile']")
	
	WebElement mobilePhoneNumber;
	
	@FindBy(xpath="//*[@id='alias']")
	
	WebElement addressAlias;
	
	@FindBy(xpath="//*[@id='submitAccount']")
	
	WebElement registrationButton;
	
	public RegistrationPage(WebDriver driver)
	{
		
		this.driver = driver;
		log.debug("LoginPage: "+ this.hashCode());//to debug if correct driver is being picked
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver,mrRadioButton,ObjectRepo.reader.getExplicitWait());
		
	}
	public void setMrRadioButton()
	{
		log.info("Selection Mr Checbox");
		this.mrRadioButton.click();
	}
	public void setMrsRadioButton()
	{
		log.info("Selection Mrs Checbox");
		this.mrsRadioButton.click();
	}
	public void enterFirstName(String firstName)
	{
		log.info("enter first name");
		this.firstName.sendKeys(firstName);;
	}
	public void enterLastName(String lastName)
	{
		log.info("enter last name");
		this.lastName.sendKeys(lastName);;
	}
	public void enterPassword(String password)
	{
		log.info("enter password");
		this.password.sendKeys(password);;
	}
	public void selectDay(String day)
	{
		log.info("Selection of Day");
		List<WebElement> days=driver.findElements(By.xpath("//*[@id='days']/option"));
		Iterator<WebElement> itr = days.iterator();
		
		while(itr.hasNext())
		{
			WebElement dayElement = itr.next();
			if ((dayElement.getText().trim()).equals(day))
			{
				dayElement.click();
				break;
			}
		}
				
	}
	public void selectMonth(String month)
	{
		log.info("Selection of Month");
		List<WebElement> months=driver.findElements(By.xpath("//*[@id='months']/option"));
		Iterator<WebElement> itr = months.iterator();
		
		while(itr.hasNext())
		{
			WebElement monthElement = itr.next();
			if ((monthElement.getText().trim()).equals(month))
			{
				monthElement.click();
				break;
			}
		}
	}
	public void selectYear(String year)
	{
		log.info("Selection of year");
		List<WebElement> years=driver.findElements(By.xpath("//*[@id='years']/option"));
		Iterator<WebElement> itr = years.iterator();
		
		while(itr.hasNext())
		{
			WebElement yearElement = itr.next();
			if ((yearElement.getText().trim()).equals(year))
			{
				yearElement.click();
				break;
			}
		}
	}
	public void enterAddress(String address)
	{
		log.info("enter address");
		this.address.sendKeys(address);
	}
	public void enterAddressFirstName(String addressFirstName)
	{
		log.info("enter addressFirstName");
		this.addressFirstName.sendKeys(addressFirstName);
	}
	public void enterAddressLastName(String addressLastName)
	{
		log.info("enter addressLastName");
		this.addressLastName.sendKeys(addressLastName);
	}
	public void enterCompanyName(String companyName)
	{
		log.info("enter companyName");
		this.companyName.sendKeys(companyName);
	}
	public void address(String address)
	{
		log.info("enter address");
		this.address.sendKeys(address);
	}
	public void selectCity(String city)
	{
		log.info("enter city");
		this.city.sendKeys(city);
	}
	public void selectState(String state)
	{
		log.info("Selection of state");
		List<WebElement> states=driver.findElements(By.xpath("//*[@id='id_state']/option"));
		Iterator<WebElement> itr = states.iterator();
		
		while(itr.hasNext())
		{
			WebElement stateElement = itr.next();
			if ((stateElement.getText().trim()).equals(state))
			{
				stateElement.click();
				break;
			}
		}
	}
	public void selectCountry(String country)
	{
		log.info("Selection of country");
		List<WebElement> countrys=driver.findElements(By.xpath("//*[@id='id_country']/option"));
		Iterator<WebElement> itr = countrys.iterator();
		
		while(itr.hasNext())
		{
			WebElement countryElement = itr.next();
			if ((countryElement.getText().trim()).equals(country))
			{
				countryElement.click();
				break;
			}
		}
	
	}
	public void zipCode(String zipcode)
	{
		log.info("enter zipcode");
		this.zipcode.sendKeys(zipcode);
	}
	public void mobilePhoneNumber(String mobilePhoneNumber)
	{
		log.info("enter mobilePhoneNumber");
		this.mobilePhoneNumber.sendKeys(mobilePhoneNumber);
	}
	public void addressAlias(String alias)
	{log.info("enter alias");
	this.addressAlias.sendKeys(alias);
	
	}
	public void clickRegistration()
	{log.info("click Registration");
	this.registrationButton.click();
	
	
	
	}
	public void completeRegistrationProcess(String firstName,String lastName, String password, String  day,String month,String year,String addFirstName,String addLastName, String companyName,String address, String city, String state,String country, String zipCode, String mobileNumber,String alias) 
	{
		log.info("Fill the registartion form");
		enterFirstName(firstName);
		
		enterLastName(lastName);
	
		enterPassword(password);
	
		selectDay(day);	
		
		selectMonth(month);
	
		selectYear(year);	
		
		enterAddressFirstName(addFirstName);
	
		enterAddressLastName(addLastName);	
		
		enterCompanyName(companyName);	
		
		address(address);	
		
		selectCity(city);
		
		selectState(state);
	
		selectCountry(country);
	
		zipCode(zipCode);
		
		mobilePhoneNumber(mobileNumber);	
		
		addressAlias(alias);	
		
		clickRegistration();
		
	}

}
