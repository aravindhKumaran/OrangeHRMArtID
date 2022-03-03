package com.ohrm.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.pages.AddUser;
import com.ohrm.qa.pages.HomePage;
import com.ohrm.qa.pages.LoginPage;
import com.ohrm.qa.pages.LogoutPage;
import com.ohrm.qa.util.TestUtil;

public class AddUserTest extends TestBase {
    
    LoginPage loginPage;
    HomePage homePage;
    LogoutPage logoutPage;
    AddUser adduser;
    

    public AddUserTest() {
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
       // homePage = loginPage.login();
    }

    @Test(priority = 1,  enabled = false)
    public void navaigateToAdduserForm() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();
    }
    

    @Test(priority = 2, enabled = false)
    public void testAllUserFields() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();
        boolean checkUserData = adduser.isAllFieldExist();
        System.out.print("check in test script---"+checkUserData);
        Assert.assertTrue(checkUserData);

    }
    

    @Test(priority = 3, enabled = true)
    public void testValidEmployeeName() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();        
        String actualEmployee =  adduser.addValidEmployeeName(prop.getProperty("employee_name"));
        Assert.assertEquals(actualEmployee, prop.getProperty("employee_name"));
    }
    
    
    @Test(priority = 4, enabled = true)
    public void testValidUserName() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();        
        String actualuser =  adduser.addValidUserName(prop.getProperty("username_emp"));
        Assert.assertEquals(actualuser, prop.getProperty("username_emp"));
    }
    
    @Test(priority = 5, enabled = true)
    public void testInvalidUserName() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();        
        String errormessge =  adduser.addInvalidUserName(prop.getProperty("invalid_user"));
        Assert.assertEquals(errormessge, prop.getProperty("user_errorMsg"));
    }
    
    @Test(priority = 6, enabled = true)
    public void testInvalidEmpName() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();        
        String errormessge =  adduser.addInvalidEmployee(prop.getProperty("invalid_emp"));
        Assert.assertEquals(errormessge, prop.getProperty("employee_errorMsg"));
    }
    
    @Test(priority = 7, enabled = true)
    public void testEssRoleDD() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();        
       boolean isSelectedDefaultESS = adduser.selectEssRole();
       Assert.assertTrue(isSelectedDefaultESS);
    }
    
    @Test(priority = 8, enabled = true)
    public void testSupervisorRoleDD() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();        
        String actualSelectedOption = adduser.SupervisorRole();
       Assert.assertEquals(actualSelectedOption,prop.getProperty("supervisor_role") );
    }
    
    @Test(priority = 9, enabled = true)
    public void testAdminRoleRD() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();        
        adduser.selectEnableAdminRole();
    }
    
    //radio button
    @Test(priority = 10, enabled = true)
    public void testDisableStatus() throws InterruptedException {
       adduser = new AddUser();
       adduser.navigateToAddUser();        
        boolean isSelected =adduser.selectDisableRadioButton();
        System.out.println("get value: disable "+isSelected);
     Assert.assertTrue(isSelected);
    }
    
    @Test(priority = 11, enabled = true)
    public void testEnableStatus() throws InterruptedException {
       adduser = new AddUser();
       adduser.navigateToAddUser();        
        boolean isSelected =adduser.selectEnabledRadioButton();
        System.out.println("get value: enable "+isSelected);
     Assert.assertTrue(isSelected);
    }
    
    @Test(priority = 12, enabled = true)
    public void testPasswordEntered() throws InterruptedException {
      adduser = new AddUser();
      adduser.navigateToAddUser();        
     adduser.addPassword(prop.getProperty("password_emp"));
    }
    
    @Test(priority = 13, enabled = true)
    public void testConfirmPwdEntered() throws InterruptedException {
      adduser = new AddUser();
      adduser.navigateToAddUser();        
     adduser.addConfirmPwdPassword(prop.getProperty("confirmPassword_emp"));
    }
    
    @Test(priority = 14, enabled = true)
    public void testMatchingPwdAndConfirmPwd() throws InterruptedException {
      adduser = new AddUser();
      adduser.navigateToAddUser();        
    boolean isPasswordFieldsEqual = adduser.comparePwdAndConfirmpwd(prop.getProperty("password_emp"), prop.getProperty("confirmPassword_emp"));
    Assert.assertTrue(isPasswordFieldsEqual);
    }
    
    @Test(priority = 15,  enabled = true )
    public void testWithMendatoryFields() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToAddUser();
        boolean foundUser = adduser.addWithMendatoryFields(prop.getProperty("employee_name"), prop.getProperty("username_emp"), 
                 prop.getProperty("password_emp"), prop.getProperty("confirmPassword_emp"));
        if(foundUser) {
            Assert.assertTrue(foundUser);
        }
        else {
            Assert.assertFalse(foundUser);
            System.out.print("user is unable to saved:" );
        }
       /*
        * for(int i=0;i<actualCellRecords.size();i++) {
        * if(actualCellRecords.get(i).contains(expectedRecords.get(i))) {
        * System.out.print("Search function verified"); }else {
        * System.out.print("Search function verification failed"+actualCellRecords.get(
        * i)); } }
        */
    }
    
    @Test(priority = 16,  enabled = true )
    public void testMatchingRecordsWithWebTable() throws InterruptedException {
        adduser = new AddUser();
        adduser.navigateToUsersScreen();
      
        boolean foundUser = adduser.matchRecordsfromWebTable(prop.getProperty("employee_name"), prop.getProperty("username_emp")); 
              
        if(foundUser == true) {
            Assert.assertTrue(foundUser);
        }
        else {
            Assert.assertFalse(foundUser);
            System.out.print("user is not found:" );
        }
     
    }
    
    
    
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
