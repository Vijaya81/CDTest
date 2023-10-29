package com.cd.qa.pages;

import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cd.qa.base.TestBase;

public class WaterpikPage extends TestBase{
	
		
	@FindBy(xpath = "//img[@class='img-fluid py-2']")
	WebElement waterpikHeader;
	
	@FindBy(xpath = "//a[@id='navbarDropdownMenuLink1']")
	WebElement shopProducts;
	
	@FindBy(xpath = "//a[contains(text(),'Water Flossers')]")
	WebElement waterFlossers;
	
	
	public WaterpikPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyWaterpikPageHeader() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(waterpikHeader));
					
		boolean waterpikHeaderIsDisplayed = waterpikHeader.isDisplayed();
		
		return waterpikHeaderIsDisplayed;
		
	}
	
	
	/*public void moveToShopProducts() {
		Actions action = new Actions(driver);
		action.moveToElement(shopProducts).build().perform();
	}*/
	
	
	public WaterFlosserPage clickOnWaterFlosser() {
		Actions action = new Actions(driver);
		action.moveToElement(shopProducts).build().perform();
		
		waterFlossers.click();
		return new WaterFlosserPage();
	}
	
	

}
