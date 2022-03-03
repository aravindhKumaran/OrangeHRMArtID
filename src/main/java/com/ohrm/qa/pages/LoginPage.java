package com.ohrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.util.TestUtil;
import com.ohrm.qa.util.WaitNExceptions;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(name = "txtUsername")
	WebElement username;

	@FindBy(name = "txtPassword")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	@FindBy(xpath = "//*[@id=\"divLogin\"]/div[2]/div/div[1]/img")
	WebElement crmLogo;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

//	 Actions:
//	public String validatePageTitle() {
//		return driver.getTitle();
//	}

	public boolean validateImage() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return crmLogo.isDisplayed();
	}

	public void login() {
		TestUtil.sendKey(username, prop.getProperty("username"));
		TestUtil.sendKey(password, prop.getProperty("password"));
//		WaitNExceptions.fluentWait(50).until(ExpectedConditions.elementToBeClickable(loginBtn));
	   // WaitNExceptions.clickWhenVisible(loginBtn);
        TestUtil.click(loginBtn);


//		TestUtil.clearValue(username);
//		TestUtil.sendKey(username, un);
//		username.sendKey(un);
//		password.sendKey(pwd);
//		loginBtn.click();
	//	return new HomePage();

	}

}
