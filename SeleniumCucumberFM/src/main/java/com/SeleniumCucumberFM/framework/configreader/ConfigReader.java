package com.SeleniumCucumberFM.framework.configreader;

import org.apache.log4j.Level;

import com.SeleniumCucumberFM.framework.browser.BrowserType;

public interface ConfigReader {
	public String getUserName();
	public String getPassword();
	public String getBrowser();
	public String getWebSite();
	public int getPageLoadTime();
	public int getImplicitWait();
	public int getExplicitWait();
	public String getLoggerLevel();
	public String getDBType();
	public String getDBConnString();
}
