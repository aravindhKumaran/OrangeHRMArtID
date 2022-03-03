package com.ohrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.base.TestBase;

public class PersonalDetailsPage extends TestBase {

	public PersonalDetailsPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@translate='Next']")
	WebElement nextBtn;
	
	
	public void clickNext() {
		nextBtn.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
