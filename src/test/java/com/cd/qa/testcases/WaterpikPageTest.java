package com.cd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.qa.base.TestBase;
import com.cd.qa.pages.LandingPage;
import com.cd.qa.pages.WaterFlosserPage;
import com.cd.qa.pages.WaterpikPage;

public class WaterpikPageTest extends TestBase {
	
	LandingPage landingPage;
	WaterpikPage waterpikPage;
	WaterFlosserPage waterFlosserPage;
	
	public WaterpikPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		waterFlosserPage = new WaterFlosserPage();
		waterpikPage = landingPage.clickOnWaterpink();
	}
	
	
	@Test(priority=1)
	public void verifyWaterpikHeaderTest() {
		boolean flag = waterpikPage.verifyWaterpikPageHeader();
		Assert.assertTrue(flag);		
	}
	
		
	@Test(priority=2)
	public void waterFlosserPageTest() {
		//waterpikPage.moveToShopProducts();
		waterFlosserPage = waterpikPage.clickOnWaterFlosser();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
