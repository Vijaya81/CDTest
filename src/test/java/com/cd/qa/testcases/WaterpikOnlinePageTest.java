package com.cd.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cd.qa.base.TestBase;
import com.cd.qa.pages.LandingPage;
import com.cd.qa.pages.WaterFlosserPage;
import com.cd.qa.pages.WaterpikOnlinePage;
import com.cd.qa.pages.WaterpikPage;

public class WaterpikOnlinePageTest extends TestBase{
	
	LandingPage landingPage;
	WaterpikPage waterpikPage;
	WaterFlosserPage waterFlosserPage;
	WaterpikOnlinePage waterpikOnlinePage;
	
	
	public WaterpikOnlinePageTest() {
		super();
	}	
	
	@BeforeMethod
	public void setup() {
		initialization();		
		landingPage = new LandingPage();
		waterpikPage = landingPage.clickOnWaterpink();
		waterFlosserPage = waterpikPage.clickOnWaterFlosser();
		waterpikOnlinePage = waterFlosserPage.goToWaterpikOnlinePage();
		
	}
	
	@Test(priority=1)
	public void verifyWaterpikOnlinePageTitleTest() {
		String actualTitle = waterpikOnlinePage.verifyPageTitle();
		String expectedTitle = "Sidekick® Water Flosser, White with Chrome Accents WF-04 | Waterpik®";		
		Assert.assertEquals(actualTitle, expectedTitle, "Correct title is not displayed");

	}
	
	@Test(priority=2, dependsOnMethods= {"verifyWaterpikOnlinePageTitleTest"})
	public void clickAddToCartTest() {
		waterpikOnlinePage.clickAddToCart();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
