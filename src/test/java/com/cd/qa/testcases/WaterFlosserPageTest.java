package com.cd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.qa.base.TestBase;
import com.cd.qa.pages.LandingPage;
import com.cd.qa.pages.WaterFlosserPage;
import com.cd.qa.pages.WaterpikOnlinePage;
import com.cd.qa.pages.WaterpikPage;

public class WaterFlosserPageTest extends TestBase {
	
	LandingPage landingPage;
	WaterpikPage waterpikPage;
	WaterFlosserPage waterFlosserPage;
	WaterpikOnlinePage waterpikOnlinePage;
	
	public WaterFlosserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		waterpikOnlinePage = new WaterpikOnlinePage();
		waterpikPage = landingPage.clickOnWaterpink();
		waterFlosserPage = waterpikPage.clickOnWaterFlosser();
		
	}
	
	
	
	@Test
	public void goToWaterFlosserPageTest() {
		//waterFlosserPage.clickOnSideKickShopRetailers();
		waterpikOnlinePage = waterFlosserPage.goToWaterpikOnlinePage();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
