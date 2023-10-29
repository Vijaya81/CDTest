package com.cd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.qa.base.TestBase;
import com.cd.qa.pages.LandingPage;
import com.cd.qa.pages.WaterpikPage;

public class LandingPageTest extends TestBase{
	
	LandingPage landingPage;
	WaterpikPage waterpikPage;
	
	public LandingPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		initialization();
		landingPage = new LandingPage();
		waterpikPage = new WaterpikPage();
		
	}
	
	
	@Test(priority=1)
	public void waterpikIsDisplayedTest() {
		boolean flag = landingPage.waterpikIsDispalyed();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=2)
	public void waterpikTest() {	
		waterpikPage = landingPage.clickOnWaterpink();		
	}
	
	
	@AfterMethod
	public void teraDown() {
		
		driver.quit();
		
	}
	
	
	

}
