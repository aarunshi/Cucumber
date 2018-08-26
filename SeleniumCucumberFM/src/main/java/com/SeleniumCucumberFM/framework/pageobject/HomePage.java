package com.SeleniumCucumberFM.framework.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.SeleniumCucumberFM.framework.configreader.ObjectRepo;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.Wait.WaitHelper;

public class HomePage {

	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")	
	WebElement signin;
	@FindBy(xpath="//*[@id='block_top_menu']/ul/li[1]/a")
	public WebElement WomenMenu;
	private WebDriver driver;
	private  Logger log = LoggerHelper.getLogger(HomePage.class.getName());
	WaitHelper waitHelper;
	public  HomePage(WebDriver driver)
	{
		
		this.driver = driver;
		log.debug("HomePage: "+ this.hashCode());//to debug if correct driver is being picked
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(driver,signin,ObjectRepo.reader.getExplicitWait());
		
	}
	public ProductCategoryPage clickOnMenu(WebElement element )
	{
		log.info("Click on  menu");
		element.click();
		return new ProductCategoryPage(this.driver);
	}
}
