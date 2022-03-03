package com.ohrm.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.util.TestUtil;

public class AddEmployee extends TestBase {

	public AddEmployee() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "PIM")
	WebElement pimLink;

	@FindBy(linkText = "Add Employee")
	WebElement addEmployeelink;

	@FindBy(id = "first-name-box")
	WebElement empFirstName;

	@FindBy(id = "middle-name-box")
	WebElement empMiddleName;

	@FindBy(id = "last-name-box")
	WebElement empLastName;

	@FindBy(id = "employeeId")
	WebElement employeeId;

	@FindBy(id = "location")
	WebElement locationDropDown;

	@FindBy(id = "photo-preview-lable")
	WebElement employeePicture;

	// pseudo elements
	@FindBy(id = "hasLoginDetails")
	WebElement createLoginDetailsSwitch;

	@FindBy(id = "username")
	WebElement userName;

	@FindBy(id = "status_Enabled")
	WebElement enabledRadioBtn;

	@FindBy(id = "status_Disabled")
	WebElement disabledRadioBtn;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "confirmPassword")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@data-id='essRoleId']")
	WebElement essRoleDropDown;

	@FindBy(xpath = "//button[@data-id='supervisorRoleId']")
	WebElement supervisorRoleDropDown;

	@FindBy(xpath ="//button[@data-id='adminRoleId']")
	WebElement adminRoleDropDown;

	@FindBy(xpath = "//button[@class='btn btn-ghost']")
	WebElement cancelBtn;

	@FindBy(xpath = "//button[@class='btn btn-secondary']")
	WebElement nextBtn;

	@FindBy(xpath = "//button[@class='btn btn-close']")
	static WebElement closeBtn;

	public void navigateToAddEmp() throws InterruptedException {
		List<WebElement> addEmployeeList = new ArrayList<WebElement>();
		addEmployeeList.add(pimLink);
		addEmployeeList.add(addEmployeelink);

		TestUtil.navigateToAddEmpForm(addEmployeeList);
	}

	/*
	 * public void navigate() { pimLink.click(); addEmployeelink.click(); }
	 * 
	 */
	public boolean isAllFieldsExistBeforeSelectingCreateLoginDetails() {
		List<WebElement> allFields1 = new ArrayList<WebElement>();
		allFields1.add(employeePicture);
		allFields1.add(empFirstName);
		allFields1.add(empMiddleName);
		allFields1.add(empLastName);
		allFields1.add(employeeId);
		allFields1.add(locationDropDown);
		allFields1.add(createLoginDetailsSwitch);
		allFields1.add(cancelBtn);
		allFields1.add(nextBtn);
		boolean checkFields = TestUtil.isAllFieldsExist(allFields1);
		return checkFields;

	}

	public boolean isAllFieldsExistAfterSelectingCreateLoginDetails() throws InterruptedException {

		//WebDriverWait wait= new WebDriverWait(driver,15);
		//wait.until(ExpectedConditions.elementToBeClickable(createLoginDetailsSwitch));
		Thread.sleep(5000);
		Actions action= new Actions(driver);
		action.moveToElement(createLoginDetailsSwitch).click().build().perform();

		isAllFieldsExistBeforeSelectingCreateLoginDetails();
		//createLoginDetailsSwitch.click();
	
		List<WebElement> allFields2 = new ArrayList<WebElement>();
		allFields2.add(userName);
		allFields2.add(enabledRadioBtn);
		allFields2.add(disabledRadioBtn);
		allFields2.add(password);
		allFields2.add(confirmPassword);
		allFields2.add(essRoleDropDown);
		allFields2.add(supervisorRoleDropDown);
		allFields2.add(adminRoleDropDown);
		boolean checkFields1 = TestUtil.isAllFieldsExist(allFields2);
		return checkFields1;
	}

	public void close() {
		closeBtn.click();
	}

	public void setOnlyMandatoryValues() {
		empFirstName.sendKeys(prop.getProperty("employeeFirstName"));
		empLastName.sendKeys(prop.getProperty("employeeLastName"));

		Select locationDropdown = new Select(locationDropDown);
		locationDropdown.selectByVisibleText(prop.getProperty("employeeLocation"));

		nextBtn.click();

	}

}
