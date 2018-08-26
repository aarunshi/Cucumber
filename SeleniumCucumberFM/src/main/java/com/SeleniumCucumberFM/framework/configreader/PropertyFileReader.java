package com.SeleniumCucumberFM.framework.configreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Level;

import com.SeleniumCucumberFM.framework.browser.BrowserType;
import com.SeleniumCucumberFM.framework.utility.ResourceHelper;
//To Read from config property file
public class PropertyFileReader implements ConfigReader {
	
	
		private Properties OR;
		 public PropertyFileReader() 
		{
			OR = new Properties();
									 		 
			 try {
				OR.load(ResourceHelper.getResourcePathInputStream("src/main/resources/configfile/config.properties"));
				// System.out.println(ResourceHelper.getResourcePathInputStream("src/main/resources/configfile/config.properties"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}			
		}
		
		public String getUserName()
		{
			return OR.getProperty("UserName");
		}
		public String getPassword()
		{
			return OR.getProperty("Password");
		}
		public String getBrowser()
		{
			return OR.getProperty("Browser");
			//switch(OR.getProperty("Browser"))
//			{
//			case "Iexplorer":
//				return BrowserType.Iexplorer;
//				
//			case "firefox":
//				return BrowserType.Firefox;
//			case "Chrome":
//				return BrowserType.Chrome;
//	
//			}		
//			return null;
	
		}
		public String getWebSite()
		{
			return OR.getProperty("WebSite");
		}
		public int getPageLoadTime()
		{
			//System.out.println(OR.getProperty("PageLoadTime")+21);
			//return Integer.valueOf(OR.getProperty("PageLoadTime"));
			return Integer.parseInt(OR.getProperty("PageLoadTime"));
			//to convert string to integer
			
		}
		public int getImplicitWait()
		{
			return Integer.parseInt(OR.getProperty("ImplicitWait"));
		}
		public int getExplicitWait()
		{
			return Integer.parseInt(OR.getProperty("ExplicitWait"));
		}
		public String getLoggerLevel()		
		{
			return OR.getProperty("Logger.level");
			//switch( OR.getProperty("Logger.level"))
//			{
//			case "INFO":
//				return Level.INFO;
//			case "DEBUG":
//				return Level.DEBUG;
//			case "WARN":
//				return Level.WARN;
//			case "ERROR":
//				return Level.ERROR;
//			case "FATAL":
//				return Level.FATAL;
//				
//			}
			//return Level.ALL;
				
		}
		public String getDBType()
		{
			return OR.getProperty("DB.Type");
		}
		public String getDBConnString()
		{
			return OR.getProperty("DB.ConnectionString");
		}
		
	/*	public static void main(String[] args)
		{
			PropertyFileReader p = new PropertyFileReader();
			p.getPageLoadTime();
		}*/

	}



