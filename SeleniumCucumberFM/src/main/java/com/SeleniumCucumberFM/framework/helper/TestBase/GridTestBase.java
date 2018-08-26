package com.SeleniumCucumberFM.framework.helper.TestBase;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SeleniumCucumberFM.framework.browser.BrowserType;
import com.SeleniumCucumberFM.framework.browser.ChromeBrowser;
import com.SeleniumCucumberFM.framework.browser.FirefoxBrowser;
import com.SeleniumCucumberFM.framework.browser.IExplorerBrowser;
import com.SeleniumCucumberFM.framework.configreader.ObjectRepo;
import com.SeleniumCucumberFM.framework.configreader.PropertyFileReader;
import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class GridTestBase {
	private Logger log = LoggerHelper.getLogger(GridTestBase.class.getName());
	// private Logger log = Logger.getLogger(TestBase.class.getName());

	public static RemoteWebDriver driver;
public ThreadLocal<RemoteWebDriver> dr = new ThreadLocal<RemoteWebDriver>();

		public RemoteWebDriver getBrowser(String bType) throws MalformedURLException
		{
			
			
			
			if(System.getProperty("os.name").contains("Window"))//to support different OS
			{
				if(bType.equals("FireFox"))
				{
					System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
					driver = new FirefoxDriver();
					
				}
				if(bType.equals("Chrome"))
				{
					//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
					//driver = new ChromeDriver();
					DesiredCapabilities cap = DesiredCapabilities.chrome();
					cap.setBrowserName("chrome");
					driver = new RemoteWebDriver(new URL("http://192.168.1.6:4040/wd/hub"),cap);//node machine
				System.out.println("driver created"+System.getProperty("os.name"));
				}
			}
			dr.set(driver);
			return driver;
		}

//	public void setUpDriver(String bType) {
//		// log.info("in setup");
//
//		driver = getBrowserObject(bType);
//		// System.out.println(ObjectRepo.reader.getPageLoadTime());
//		driver.manage()
//				.timeouts()
//				.pageLoadTimeout(ObjectRepo.reader.getPageLoadTime(),
//						TimeUnit.SECONDS);
//		driver.manage()
//				.timeouts()
//				.implicitlyWait(ObjectRepo.reader.getImplicitWait(),
//						TimeUnit.SECONDS);
//		driver.manage().window().maximize();
//
//	}
	public void setUpDriver(String bType) throws MalformedURLException {
		

driver = getBrowser(bType);
driver = dr.get();
		//driver = getBrowserObject(bType);
		// System.out.println(ObjectRepo.reader.getPageLoadTime());
		driver.manage()
				.timeouts()
				.pageLoadTimeout(ObjectRepo.reader.getPageLoadTime(),
						TimeUnit.SECONDS);
		driver.manage()
				.timeouts()
				.implicitlyWait(ObjectRepo.reader.getImplicitWait(),
						TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	@Test()
	public void before() throws MalformedURLException {
		// System.out.println("in testbase");

		// LoggerHelper.getLogger(TestBase.class);

		ObjectRepo.reader = new PropertyFileReader();
		// log.info("in testbase");
		setUpDriver(ObjectRepo.reader.getBrowser());
		// log.info(ObjectRepo.reader.getBrowser());
	}

	@After()
	public void after() {
		log.info("Closing Browser" );
		driver.quit();
	}
	
	  /*public static void main(String[] args) throws MalformedURLException
	  { TestBase a = new TestBase();
	  a.before();
	  
	  }
	 */

}
