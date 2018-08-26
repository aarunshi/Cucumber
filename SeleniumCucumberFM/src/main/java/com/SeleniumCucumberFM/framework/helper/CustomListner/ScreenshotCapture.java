package com.SeleniumCucumberFM.framework.helper.CustomListner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotCapture {
	WebDriver driver;
	public ScreenshotCapture(WebDriver driver)
	{
		this.driver =driver;
	}

	public String getScreenShot(String imageName) throws IOException
	{
		
		if (imageName.equals(""))
		{
			imageName ="Blank";
		}
		File image =((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
		String imageLocation =System.getProperty("user.dir")+"/src/main/java/com/SeleniumCucumberFM/framework/Screenshots/";
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss");
		String actualImageName =imageLocation+imageName+"_"+formater.format(calender.getTime())+".png";
		File desFile = new File (actualImageName);
		FileHandler.copy(image, desFile);
		return actualImageName;
		
	}

}
