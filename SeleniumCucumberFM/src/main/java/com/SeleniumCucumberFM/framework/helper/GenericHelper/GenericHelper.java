package com.SeleniumCucumberFM.framework.helper.GenericHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import com.SeleniumCucumberFM.framework.helper.AssertionHelper.VerificationHelper;
import com.SeleniumCucumberFM.framework.helper.DropDown.DropDownHelper;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;

public class GenericHelper {
	private Logger log = LoggerHelper.getLogger(GenericHelper.class.getName());
	
	public String readValueFromElement(WebElement element)
	{//for element label text
		if (element==null)
		{
			log.info("Element is Null ");
			return null;
			
		}
		if(VerificationHelper.verifyElementPresnt(element))
		{
			String text =element.getText();
			log.info("webelement textvalue is : "+ text);
			return text;
		}
		else
			return null;
	}
	
	public String readValueFromInput(WebElement element)
	{//for element value from value tag in html
		if (element==null)
		{
			log.info("Element is Null ");
			return null;
			
		}
		if(VerificationHelper.verifyElementPresnt(element))
		{
			String text =element.getAttribute("value");
			log.info("webelement value is : "+ text);
			return text;
		}
		else
			return null;
		
	}
	
	
	

}
