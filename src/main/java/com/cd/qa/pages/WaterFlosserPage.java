package com.cd.qa.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cd.qa.base.TestBase;

public class WaterFlosserPage extends TestBase {
	
	@FindBy(xpath = "//div[@data-ps-sku='PDB1856']")
	WebElement sidekickShopRetailers;
	
	
	@FindBy(xpath = "//div[@data-ps-sku='PDB10076']")
	WebElement radianceShopRetailers;
	
	@FindBy(xpath = "//div[@data-seller='4352771']")
	WebElement waterpikOnlineStoreBuyNow;
	
	@FindBy(xpath = "//div[@class='ps-lightbox-close']")
	WebElement popupClose;
	
	
	
	public WaterFlosserPage() {
		PageFactory.initElements(driver,this);
	}
	
	
	/*public void clickOnSideKickShopRetailers() {
		sidekickShopRetailers.click();			
		
	}*/
	
	public WaterpikOnlinePage goToWaterpikOnlinePage() {
		
		sidekickShopRetailers.click();	
		
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String parentWindow = it.next();
		String childWindow1 = it.next();	
		
		
		driver.switchTo().window(childWindow1);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(waterpikOnlineStoreBuyNow));
		
		
		waterpikOnlineStoreBuyNow.click();
		
		popupClose.click();
		
		
		
		Set<String> handler1 = driver.getWindowHandles();
		Iterator<String> it1 = handler1.iterator();
		String parentWindow1 = it1.next();
		String childWindow3 = it1.next();
		String childWindow4 =  it1.next();
		
		driver.switchTo().window(childWindow4);
		
		return new WaterpikOnlinePage();	
		
		
	}
	
	
	
	

}
