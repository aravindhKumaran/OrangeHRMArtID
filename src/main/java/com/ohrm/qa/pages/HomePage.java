package com.ohrm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//div[@id='menu-profile']")
	@CacheLookup
	WebElement userNameLabel;
	
	
	


	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public boolean verifyCorrectUserName() {
		return userNameLabel.isDisplayed();
	}

}
