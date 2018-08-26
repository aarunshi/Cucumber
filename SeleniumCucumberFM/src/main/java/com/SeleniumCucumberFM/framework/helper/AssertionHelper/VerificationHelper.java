package com.SeleniumCucumberFM.framework.helper.AssertionHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.SeleniumCucumberFM.framework.helper.DropDown.DropDownHelper;
import com.SeleniumCucumberFM.framework.helper.JavaScript.JavaScriptHelper;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;

public class VerificationHelper {
	
	
	private static Logger log = LoggerHelper.getLogger(VerificationHelper.class.getName());
	
	public static synchronized boolean verifyElementPresnt(WebElement element)
	{
		
		
		boolean displayed =false;
		try
		{
			displayed = element.isDisplayed();
		}
		catch(Exception ex)
		{
			log.error("element not present: "+ ex);
		}
			return 	displayed;
		
	}
	
	public static synchronized boolean verifyElementNotPresnt(WebElement element)
	{
		
		
		boolean displayed =false;
		try
		{
			 element.isDisplayed();
		}
		catch(Exception ex)
		{
			displayed =true;
			log.error("element not present: "+ ex);
		}
			return 	displayed;
		
	}
	
	public static synchronized boolean verifyTextEqual(WebElement element , String Expectedtext)
	{
		if (verifyElementPresnt(element))
		{
			String actualValue = element.getText();
			if (actualValue.equals(Expectedtext))
			{
				return true;
			}
			else
				return false;
			}
		else
			return false;
	}
}
