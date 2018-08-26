package com.SeleniumCucumberFM.framework.Runner.Registration;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:FeatureFile/Registration/Registration.feature" },glue = {"classpath:com/SeleniumCucumberFM/framework/stepdefinations" ,"classpath:com/SeleniumCucumberFM/framework/helper"},plugin = {"html:target/cucumber-html-report" })

public class RegistrationRunner extends AbstractTestNGCucumberTests {

}