package com.ohrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.pages.HomePage;
import com.ohrm.qa.pages.LoginPage;
import com.ohrm.qa.pages.LogoutPage;
import com.ohrm.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
		TestUtil.setWebdriver(driver);
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() {
		Assert.assertEquals(TestUtil.getPageTitle(driver), "OrangeHRM");
	}

	@Test(priority = 2)
	public void LogoImageTest() {
		boolean flag = loginPage.validateImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() throws InterruptedException {
		LogoutPage logoutPage = new LogoutPage();
		loginPage.login();
		
		logoutPage.clickOnLogoutLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}