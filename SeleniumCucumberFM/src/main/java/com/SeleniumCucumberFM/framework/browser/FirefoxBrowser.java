package com.SeleniumCucumberFM.framework.browser;

import java.io.File;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.SeleniumCucumberFM.framework.utility.ResourceHelper;
//set the required browser with initial set up
public class FirefoxBrowser {
	public Capabilities getFireforxCapabilities()
	{
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		//profile.setPreference(“javascript.enabled”, false);
		profile.setAssumeUntrustedCertificateIssuer(true);
		cap.setCapability(FirefoxDriver.PROFILE,profile);
		cap.setCapability("marionette", true);
		return cap;
	}

	public WebDriver getFirefoxDriver(Capabilities cap)

	{
	
		FirefoxOptions options =new FirefoxOptions();
	
		System.setProperty("webdriver.gecko.driver",ResourceHelper.getResourcePath("src/main/resources/Drivers/geckodriver.exe") );
		
		return new FirefoxDriver(options);
	}

}
