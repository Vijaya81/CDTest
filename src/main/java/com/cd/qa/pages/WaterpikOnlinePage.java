package com.cd.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cd.qa.base.TestBase;

public class WaterpikOnlinePage extends TestBase{
	
	
	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	WebElement addToCart;
	
	@FindBy(xpath = "//a[@id='idwnA7vxnq']")
	WebElement createAnAccount;
	
	public WaterpikOnlinePage() {
		PageFactory.initElements(driver,this);
	}
	
	public String verifyPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(addToCart));
		return driver.getTitle();
		
	}
	
	public void clickAddToCart() {
		addToCart.click();
	}
	
	public WaterpikOnlineCreateAnAccount clickOnCreateAnAccount() {
		
		List <WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'header links')]//li"));
		for(int i=0; i<list.size(); i++) {
			String name = list.get(i).getText();
			if(name.contains("Create an Account")) {
				list.get(i).click();
				break;
			}			
			
		}		
			
		return new WaterpikOnlineCreateAnAccount();
		
	}
	

}
