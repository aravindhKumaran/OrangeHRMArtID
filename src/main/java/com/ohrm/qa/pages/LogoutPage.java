package com.ohrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.base.TestBase;

public class LogoutPage extends TestBase {

	@FindBy(xpath="//a[@id='user-dropdown']/span/i[@class='material-icons']")
	WebElement iconOnProfile;
	
	@FindBy(id = "logoutLink")
	WebElement btnLogout;

	// Initializing the Page Objects:
	public LogoutPage() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnLogoutLink() throws InterruptedException {
		Thread.sleep(2000);
		//Actions actions= new Actions(driver);
		//actions.moveToElement(AddEmployee.closeBtn).click().build().perform();
		iconOnProfile.click();
		Thread.sleep(2000);
		//actions.moveToElement(btnLogout).click().build().perform();
		btnLogout.click();
		Thread.sleep(2000);
	}
}