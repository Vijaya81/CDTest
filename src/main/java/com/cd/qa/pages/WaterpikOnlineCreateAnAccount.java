package com.cd.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cd.qa.base.TestBase;

public class WaterpikOnlineCreateAnAccount extends TestBase{
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email_address")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="password-confirmation")
	WebElement confirmPassword;	
	
	
	@FindBy(id="send2")
	WebElement createAnAccountBtn;
	
	public WaterpikOnlineCreateAnAccount() {
		PageFactory.initElements(driver,this);
	}
	
	public void createAnAccount(String ftName, String ltName, String em, String pwd, String cfmpwd) throws InterruptedException {
		
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		email.sendKeys(em);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(cfmpwd);
		
		Thread.sleep(30000);
		
		createAnAccountBtn.click();
		
	}

}
