package com.ohrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.pages.HomePage;
import com.ohrm.qa.pages.LoginPage;
import com.ohrm.qa.pages.LogoutPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	LogoutPage logoutPage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		//homePage = loginPage.login();
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Dashboard");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}

	@Test(priority = 3)
	public void Logout() throws InterruptedException {
		LogoutPage logoutPage = new LogoutPage();
		logoutPage.clickOnLogoutLink();
		String logoutTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(logoutTitle, "OrangeHRM");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
