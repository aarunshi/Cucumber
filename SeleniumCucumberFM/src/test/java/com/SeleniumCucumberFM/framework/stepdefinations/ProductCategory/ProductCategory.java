package com.SeleniumCucumberFM.framework.stepdefinations.ProductCategory;

import org.apache.log4j.Logger;
import org.testng.Assert;

import com.SeleniumCucumberFM.framework.helper.Logger.LoggerHelper;
import com.SeleniumCucumberFM.framework.helper.TestBase.TestBase;
import com.SeleniumCucumberFM.framework.pageobject.HomePage;
import com.SeleniumCucumberFM.framework.pageobject.LoginPage;
import com.SeleniumCucumberFM.framework.pageobject.ProductCategoryPage;
import com.SeleniumCucumberFM.framework.stepdefinations.Login.Login;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class ProductCategory {
	private  Logger log = LoggerHelper.getLogger(ProductCategory.class.getName());
	HomePage homePage;
	ProductCategoryPage productCategoryPage;
	
	
	@When("^user click on women navigation menu$")
	public void user_click_on_women_navigation_menu() throws Exception {
		homePage=new HomePage(TestBase.driver);
		productCategoryPage = homePage.clickOnMenu(homePage.WomenMenu);
	   
	}

	@Then("^verify total no of products is \"([^\"]*)\"$")
	public void verify_total_no_of_products_is(String arg1) throws Exception {
		int noOfProducts = productCategoryPage.getTotalNumberofProductsDisplayed();
		if (Integer.parseInt(arg1)==noOfProducts)
		{
			Assert.assertTrue(true, "No of Products is as expected");
		}
		else
		{
			Assert.assertTrue(false, "No of Products is not as expected");
		}
	   
	}


}
