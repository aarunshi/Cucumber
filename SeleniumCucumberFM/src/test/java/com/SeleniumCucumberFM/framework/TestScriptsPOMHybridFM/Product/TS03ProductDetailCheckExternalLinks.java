package com.SeleniumCucumberFM.framework.TestScriptsPOMHybridFM.Product;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SeleniumCucumberFM.framework.helper.TestBase.TestBasePOMHybrid;
import com.SeleniumCucumberFM.framework.pageobject.ProductCategoryPage;

public class TS03ProductDetailCheckExternalLinks extends TestBasePOMHybrid{

	@Test
	public void checkExternalLinks()
	{
		System.out.println("run by threadprod: "+ Thread.currentThread().getId());
	ProductCategoryPage pc= new ProductCategoryPage(driver);
	pc.selectProduct("Blouse");
	pc.clickonFacebook();
	Assert.assertEquals(true, pc.verifyFacebookMssg());
	
}
}
