package com.cd.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.qa.base.TestBase;

public class LandingPage extends TestBase{
	
	
	@FindBy(xpath = "//a[@title='WaterPik']")
	WebElement waterpik;
	
	@FindBy(xpath = "//a[@title='Flawless']")
	WebElement flawless;
	
		
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean waterpikIsDispalyed() {
		return waterpik.isDisplayed();
			
	}	
	
	public WaterpikPage clickOnWaterpink() {		
		waterpik.click();	
		
		Set <String> handler = driver.getWindowHandles();
		Iterator <String> it = handler.iterator();
		String parentWindow = it.next();
		String childWindow = it.next();
		
		driver.switchTo().window(childWindow);
		
		return new WaterpikPage();
	}

}
