package com.SeleniumCucumberFM.framework.Runner.Login;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:FeatureFile/Login/Login.feature" },glue = {"classpath:com/SeleniumCucumberFM/framework/stepdefinations" ,"classpath:com/SeleniumCucumberFM/framework/helper"},plugin = {"html:target/cucumber-html-report" })

public class LoginRunner extends AbstractTestNGCucumberTests {

}
