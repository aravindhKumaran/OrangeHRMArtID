package com.ohrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.pages.AddEmployee;
import com.ohrm.qa.pages.JobPage;
import com.ohrm.qa.pages.LoginPage;
import com.ohrm.qa.pages.LogoutPage;
import com.ohrm.qa.pages.PersonalDetailsPage;

public class AddEmployeeTest extends TestBase {

	AddEmployee emp;
	LoginPage login;
	LogoutPage logout;
	PersonalDetailsPage personalDetails;
	
	JobPage jp;

	// Why we need to call parent class constructor?
	public AddEmployeeTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		emp = new AddEmployee();
		login = new LoginPage();
		logout = new LogoutPage();
		jp= new JobPage();
		personalDetails=new PersonalDetailsPage();
		login.login();
	}

	@Test(priority = 1)
	public void navigateToAddEmployee() throws InterruptedException {
		emp.navigateToAddEmp();
		Thread.sleep(5000);
		emp.close();
	}

	@Test(priority = 2)
	public void verifyAllFieldsExistBeforeSelectingCreateLoginDetails() throws InterruptedException {
		emp.navigateToAddEmp();
		boolean isAllFieldsExist = emp.isAllFieldsExistBeforeSelectingCreateLoginDetails();
		if (isAllFieldsExist == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		emp.close();
	}

	@Test(priority = 3)
	public void verifyAllFieldsExistAfterSelectingCreateLoginDetails() throws InterruptedException {
		emp.navigateToAddEmp();
		boolean isAllFieldsExist1 = emp.isAllFieldsExistAfterSelectingCreateLoginDetails();
		if (isAllFieldsExist1 == true) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		//Thread.sleep(000);
		emp.close();
	}
	
	@Test(priority=4,enabled=false)
	public void verifySendingMandatoryValues() throws InterruptedException {
		emp.navigateToAddEmp();
		Thread.sleep(5000);
		
		emp.setOnlyMandatoryValues();
		Thread.sleep(5000);
	
		personalDetails.clickNext();
		//Thread.sleep(7000);
		
		jp.sendMandatoryValues();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		
		logout.clickOnLogoutLink();
		driver.quit();
		
	}

}
