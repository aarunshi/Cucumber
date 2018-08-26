package com.SeleniumCucumberFM.framework.TestScriptsPOMHybridFM.Product;

import org.testng.annotations.Test;

import com.SeleniumCucumberFM.framework.helper.TestBase.TestBasePOMHybrid;
import com.SeleniumCucumberFM.framework.pageobject.ProductCategoryPage;

public class TS02ProductDetail extends TestBasePOMHybrid {
	
	@Test
	public void selectProduct()
	{
		ProductCategoryPage pc= new ProductCategoryPage(driver);
		pc.selectProduct("Blouse");
		
	}
	

}
