package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	String sheetName="Contacts";
	
	public ContactsPageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		loginPage =new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = new ContactsPage();
		homePage.clickOnContactsLink();
		
	}
	
	@Test (priority=1)
	public void verifyContactsLinkTest() {
		boolean countLabel= contactsPage.verifyContactsLabel();
		System.out.println("contact page label is on the page");
		Assert.assertTrue(countLabel, "contact page label is missing in the page");
		
	}
	
	@Test (priority=2)
	public void verifyShowFilterLabel() {
		boolean enableShowFilter = contactsPage.verifyShowFilterLabel();
		System.out.println("Show filter is enabled");
		Assert.assertTrue(enableShowFilter, "Show filter is not enabled");
		
	}
	
	@Test(priority=3)	
	public void verifySingleSelectContactByNameTest() {
		System.out.println(contactsPage.verifySelectContactByName("test2 test2"));
		
		
	}
	
//	@DataProvider
//	public Object[][] getCRMTestData() {
//		
//		Object data[][]=testUtil.getTestData(sheetName);
//		return data;
//	}
//	
//	
//	@Test(priority=4, dataProvider="getCRMTestData")
//	public void validateCreateNewContact(String fName,String lName,String compName) {
//		
//		homePage.clickOnNewContactLink();
//		//contactsPage.createNewContact("Tom","Peter","tcs");
//
//		contactsPage.createNewContact(fName,lName,compName);
//		
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
