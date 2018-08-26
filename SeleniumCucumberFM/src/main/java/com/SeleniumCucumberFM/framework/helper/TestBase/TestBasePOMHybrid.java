package com.SeleniumCucumberFM.framework.helper.TestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.SeleniumCucumberFM.framework.browser.BrowserType;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.SeleniumCucumberFM.framework.browser.BrowserType;
import com.SeleniumCucumberFM.framework.configreader.ObjectRepo;
import com.SeleniumCucumberFM.framework.configreader.PropertyFileReader;
import com.SeleniumCucumberFM.framework.helper.CustomListner.ExtentListner;
import com.SeleniumCucumberFM.framework.helper.CustomListner.WebEventListner;
import com.SeleniumCucumberFM.framework.helper.ExcelReader.ExcelReader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBasePOMHybrid {
	public static Properties OR;
//	public static EventFiringWebDriver driver1;
//	public WebEventListner eventListner;
	public static WebDriver driver;
	public FileInputStream file;
	public File f1;
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	public static final Logger logger = Logger.getLogger(TestBase.class
			.getName());

	static {
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent = new ExtentReports(System.getProperty("user.dir")
				+ "/src/test/java/Reports/" + "test"
				+ formater.format(calender.getTime()) + ".html", false);

	}

	public void setUpDriver(String bType) {

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

	public void getBrowser(String bType) {
		if (System.getProperty("os.name").contains("Window"))// to support
																// different OS
		{
			if (bType.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir")
								+ "/drivers/geckodriver.exe");
				driver = new FirefoxDriver();

			}
			if (bType.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir")
								+ "/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				System.out.println("driver created"
						+ System.getProperty("os.name"));
			}
		}
		
//		driver1= new EventFiringWebDriver(driver);
//		WebEventListner eventListner = new WebEventListner();
//		driver1.register(eventListner);
	}

	public void lounchBrowser() {
		try {
			loadPropertiesFile();
			System.out.println(logger.getAllAppenders());
		} catch (IOException e) {

			e.printStackTrace();
		}
		ObjectRepo.reader = new PropertyFileReader();
		getBrowser(ObjectRepo.reader.getBrowser());
		setUpDriver(ObjectRepo.reader.getBrowser());

	}

	public void loadPropertiesFile() throws IOException {
		String log4jConfPath = System.getProperty("user.dir")
				+ "/src/main/resources/configfile/Log4J.properties";
		PropertyConfigurator.configure(log4jConfPath);
		OR = new Properties();
		f1 = new File(System.getProperty("user.dir")
				+ "/src/main/resources/configfile/config.properties");
		file = new FileInputStream(f1);
		OR.load(file);

	}

	public WebElement getLocator(String locator) throws Exception {
		String[] arr = locator.split(":");
		String locatorType = arr[0];
		String locatorValue = arr[1];
		System.out.println(locatorType + "::" + locatorValue);
		if (locatorType.toLowerCase().equals("id")) {
			return driver.findElement(By.id(locatorValue));
		} else if (locatorType.toLowerCase().equals("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		}

		else if (locatorType.toLowerCase().equals("name")) {
			return driver.findElement(By.name(locatorValue));
		} else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class"))) {
			return driver.findElement(By.className(locatorValue));
		} else if (locatorType.toLowerCase().equals("tag")
				|| (locatorType.toLowerCase().equals("tagname"))) {
			return driver.findElement(By.tagName(locatorValue));
		} else if (locatorType.toLowerCase().equals("link")
				|| (locatorType.toLowerCase().equals("linktext"))) {
			return driver.findElement(By.linkText(locatorValue));
		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			return driver.findElement(By.partialLinkText(locatorValue));
		} else if (locatorType.toLowerCase().equals("cssselector")
				|| (locatorType.toLowerCase().equals("css"))) {
			return driver.findElement(By.cssSelector(locatorValue));
		} else
			throw new Exception("Unknown Locator Type" + locatorType);

	}

	// Getting locator from locator value
	public List<WebElement> getLocators(String locator) throws Exception {

		String[] arr = locator.split(":");
		String locatorType = arr[0];
		String locatorValue = arr[1];
		if (locatorType.toLowerCase().equals("id")) {
			return driver.findElements(By.id(locatorValue));
		} else if (locatorType.toLowerCase().equals("xpath")) {
			return driver.findElements(By.xpath(locatorValue));
		}

		else if (locatorType.toLowerCase().equals("name")) {
			return driver.findElements(By.name(locatorValue));
		} else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class"))) {
			return driver.findElements(By.className(locatorValue));
		} else if (locatorType.toLowerCase().equals("tag")
				|| (locatorType.toLowerCase().equals("tagname"))) {
			return driver.findElements(By.tagName(locatorValue));
		} else if (locatorType.toLowerCase().equals("link")
				|| (locatorType.toLowerCase().equals("linktext"))) {
			return driver.findElements(By.linkText(locatorValue));
		} else if (locatorType.toLowerCase().equals("partiallinktext")) {
			return driver.findElements(By.partialLinkText(locatorValue));
		} else if (locatorType.toLowerCase().equals("cssselector")
				|| (locatorType.toLowerCase().equals("css"))) {
			return driver.findElements(By.cssSelector(locatorValue));
		} else
			throw new Exception("Unknown Locator Type" + locatorType);
	}

	public WebElement getWebElement(String locator) throws Exception {
		return getLocator(locator);
	}

	public List<WebElement> getWebElements(String locator) throws Exception {

		return getLocators(locator);

	}

	// To Read data from Excel
	public String[][] getData(String excelLocation, String sheetName)
			throws IOException {

		excelLocation = System.getProperty("user.dir")
				+ "/src/main/java/com/SeleniumCucumberFM/framework/Data/"
				+ excelLocation;
		ExcelReader excelReader = new ExcelReader(excelLocation);
		return excelReader.getExcelData(sheetName);

	}

	public void getUrl(String url) {
		driver.get(url);
	}

	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + "TestStarted");
		// System.out.println("in before method");

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		new ExtentListner().getResults(result, test);
		// System.out.println("in after method");
	}

	@AfterClass()
	public void endTest() {
		this.driver.quit();
		extent.endTest(test);
		extent.flush();
		// System.out.println("in after class");
	}

	@BeforeClass
	// TestBase initialiser
	public static WebDriver init() throws IOException {
		TestBasePOMHybrid test = new TestBasePOMHybrid();
		// System.out.println("in main");
		test.loadPropertiesFile();
		test.lounchBrowser();
		test.getUrl(ObjectRepo.reader.getWebSite());
		return (driver);
	}
	

}
