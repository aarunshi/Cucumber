package com.SeleniumCucumberFM.framework.browser;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.SeleniumCucumberFM.framework.utility.ResourceHelper;
//set the required browser with initial set up
public class ChromeBrowser {
	
	public Capabilities getChromeCapabilities()
	{
		ChromeOptions options =new ChromeOptions();
		options.addArguments("start-maximized");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setJavascriptEnabled(true);
		cap.setCapability(ChromeOptions.CAPABILITY,options);
		return cap;
	}

	public WebDriver getChromeDriver(Capabilities cap)

	{
		ChromeDriverService service =new ChromeDriverService.Builder().usingDriverExecutable(new File(ResourceHelper.getResourcePath("src/main/resources/Drivers/chromedriver.exe"))).usingAnyFreePort().build();
		ChromeOptions options =new ChromeOptions();
		options.merge(cap);
		System.setProperty("webdriver.chrome.driver",ResourceHelper.getResourcePath("src/main/resources/Drivers/chromedriver.exe") );
		return new ChromeDriver(service,options);
	}
	
}
