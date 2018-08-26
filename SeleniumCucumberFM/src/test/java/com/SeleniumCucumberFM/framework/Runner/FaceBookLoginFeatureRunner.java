package com.SeleniumCucumberFM.framework.Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "classpath:FeatureFile/FaceBookLogin.feature" },glue = {"classpath:com/SeleniumCucumberFM/framework/stepdefinations" ,"classpath:com/SeleniumCucumberFM/framework/helper"})

public class FaceBookLoginFeatureRunner extends AbstractTestNGCucumberTests{
	
	           

}
