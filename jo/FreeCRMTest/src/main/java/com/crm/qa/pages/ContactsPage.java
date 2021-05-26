package com.crm.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase {
	
	
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsNameLabel;
	
	@FindBy(xpath="//button[contains(text(),'Show Filters')]")
	WebElement ShowFilterLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']/div/descendant::div[@role='option']")
	WebElement company;
	
	@FindBy(xpath="//i[@class='save icon']/parent::button")
	WebElement saveBtn;
	
	
	
	//Initializing the Page Objects;
		public ContactsPage() {
			
			PageFactory.initElements(driver, this);
		}
		//Actions
		public boolean verifyContactsLabel() {
					
		return contactsNameLabel.isDisplayed();
		}
		
		public boolean verifyShowFilterLabel() {
			
			return ShowFilterLabel.isEnabled();
		}
		
		public String verifySelectContactByName(String name) {
			//test2 test2
			 //tbody/tr[1]/td[1]/div[1]/label[1]
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);		
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);	
			//driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name='id']")).click();
			
			return driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).getText();
			
		}
		
		public void selectCompany(String compName) {
			List<WebElement> list =driver.findElements(By.xpath("//div[@name='company']/div/descendant::div[@role='option']"));
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains(compName)) {
				
				list.get(i).click();
				
			}
		}
		}
		
		public void createNewContact(String fName, String lName, String compName)  {
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			selectCompany(compName);
			saveBtn.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
}
