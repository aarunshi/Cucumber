package com.SeleniumCucumberFM.framework.Runner.ProductCategory;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:FeatureFile/ProductCategory/TestTotalNoOfWomenProduct.feature" },glue = {"classpath:com/SeleniumCucumberFM/framework/stepdefinations" ,"classpath:com/SeleniumCucumberFM/framework/helper"},plugin = {"html:target/cucumber-html-report" })

public class TestTotalNoOfProductRunner extends AbstractTestNGCucumberTests {

}