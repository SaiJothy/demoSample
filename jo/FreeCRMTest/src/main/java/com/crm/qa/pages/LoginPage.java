package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement login;
	
	@FindBy(linkText="Sign Up")
	WebElement signUp;
	
	@FindBy(xpath="//*[@id=\"ui\"]/div/div/div[2]/a")
	WebElement classicCrm;
	
	//Initializing the Page Objects;
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle() {
		
		return driver.getTitle();
	}
public boolean validateClassicCRMLink() {
		boolean b = classicCrm.isDisplayed();
		return b;
		
		
	}
	public HomePage login(String username, String pwd) {
		
		email.sendKeys(username);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
	}
	
	
}
