package com.cd.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cd.qa.base.TestBase;
import com.cd.qa.pages.LandingPage;
import com.cd.qa.pages.WaterFlosserPage;
import com.cd.qa.pages.WaterpikOnlineCreateAnAccount;
import com.cd.qa.pages.WaterpikOnlinePage;
import com.cd.qa.pages.WaterpikPage;
import com.cd.qa.util.TestUtil;

public class WaterpikOnlineCreateAnAccountPageTest extends TestBase{

	LandingPage landingPage;
	WaterpikPage waterpikPage;
	WaterFlosserPage waterFlosserPage;
	WaterpikOnlinePage waterpikOnlinePage;
	WaterpikOnlineCreateAnAccount waterpikOnlineCreateAnAccount;
	
	public WaterpikOnlineCreateAnAccountPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		landingPage = new LandingPage();
		waterpikPage = landingPage.clickOnWaterpink();
		waterFlosserPage = waterpikPage.clickOnWaterFlosser();
		waterpikOnlinePage = waterFlosserPage.goToWaterpikOnlinePage();
		waterpikOnlineCreateAnAccount = waterpikOnlinePage.clickOnCreateAnAccount();
	}
	
	@DataProvider
	public Object[][] getWaterpikOnlineAccountTestData() {
		Object data[][] = TestUtil.dataSupplier("WaterpikOnlineAccount");
		return data;
	
				
	}
	
	@Test(dataProvider="getWaterpikOnlineAccountTestData")
	public void createAnAccountTest(String firstName, String lastName, String email, String password, String cfmPassword) throws InterruptedException {
		
		waterpikOnlineCreateAnAccount.createAnAccount(firstName, lastName, email,password, cfmPassword);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
