package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase   {

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	
	//test cases should be seperated -- independent with each other.
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	public HomePageTest() {
		super();
		
	}
	@BeforeMethod
	public void setUp() {
		
		initialization();
		contactsPage = new ContactsPage();
		loginPage =new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle=homePage.validateHomePageTitle();
		
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home Page title not matched."); 
	}
	
	@Test(priority=2)
	public void verifyCurrectUserNameTest() {
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	Assert.assertTrue(homePage.verifyCurrectUserName(),"false");
	}
	
	@Test(priority=3)
	public void verifyClickOnContactLink() {
		
	contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
