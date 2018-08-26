package com.SeleniumCucumberFM.framework.pageobject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.SeleniumCucumberFM.framework.configreader.ObjectRepo;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.Wait.WaitHelper;

public class ProductCategoryPage {

	@FindBy(xpath="//*[@id='center_column']/ul/li")
	List<WebElement> ProductList;
	@FindBy(xpath="//*[@id='product']/div/div/div[2]/p[7]/button[2]/i")
	WebElement faceBookLink;
	@FindBy(xpath="//*[@id='email_container']/div/label")
	WebElement faceBookLinkMssg;
	
	private WebDriver driver;
	private  Logger log = LoggerHelper.getLogger(ProductCategoryPage.class.getName());
	WaitHelper waitHelper;
	public  ProductCategoryPage(WebDriver driver)
	{
		
		this.driver = driver;
		log.debug("ProductCategoryPage: "+ this.hashCode());//to debug if correct driver is being picked
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		//waitHelper.waitForElement(driver,signin,ObjectRepo.reader.getExplicitWait());
		
	}
	public int getTotalNumberofProductsDisplayed()
	{
		log.info("No of Products");
		return ProductList.size();
	}
	public void selectProduct(String pName)
	{
		log.info("click on product");
		WebElement Product = driver.findElement(By.xpath("//a/img[@title='"+pName+"']"));
		Product.click();
	}
	public void clickonFacebook()
	{
		//Set<String> win = driver.getWindowHandles();
//	Iterator<String> itr = win.iterator();
//	String Win1 = itr.next();//parents
//	String Win2 = itr.next();
//driver.switchTo().window(Win2);
		faceBookLink.click();
		log.info("click on facebook");
	}
	public boolean verifyFacebookMssg()
	{
		System.out.println("previous"+driver.getWindowHandle());
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		String Win1 = itr.next();//parents
		System.out.println("switch"+driver.getWindowHandle());
		String Win2 = itr.next();
		driver.switchTo().window(Win2);
		
		try{
			log.info("check msg");
		faceBookLinkMssg.isDisplayed();
		driver.switchTo().window(Win1);
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
}
