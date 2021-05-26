package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(),'Saijothy Meda')]")
	@CacheLookup
	WebElement userNameLabel;
	
	//advantage of having @CacheLookup, this element is made into store in this cache memory.
	//its more helpful and powerful, if the element is called many times.
	//improve performance of your script. 
	//Disadvantage is, when page got refreshed, the data in Cache memory will get interrepted.
	//Document object model (DOM) got changed.
	
	
	@FindBy(xpath="//a/i[@class='users icon']")
	WebElement contactsLink;
	
	@FindBy(xpath="//i[@class='users icon']/parent::a/parent::div/button[@class='ui mini basic icon button']")
	WebElement newContactLink;
	
	@FindBy(xpath="//a/i[@class='money icon']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a/i[@class='tasks icon']")
	WebElement tasksLink;
	
	
	//Initializing the Page Objects;
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
		public String validateHomePageTitle() {
			
			return driver.getTitle();
		}
	
		public boolean verifyCurrectUserName() {
			
			return userNameLabel.isDisplayed();
			
		}
		public ContactsPage clickOnContactsLink() {
				
			contactsLink.click();
			return new ContactsPage();
			
		}
		
		public void clickOnNewContactLink() {
			
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			
			newContactLink.click();	
			
		} 
		
		
		public DealsPage clickOnDealsLink() {
				
			dealsLink.click();
			return new DealsPage();
			
		}
		
		public TasksPage clickOnTasksLink() {
				
			tasksLink.click();
			return new TasksPage();
			
		}
}
