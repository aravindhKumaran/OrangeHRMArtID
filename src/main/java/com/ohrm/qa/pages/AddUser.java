package com.ohrm.qa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.base.TestBase;
import com.ohrm.qa.util.TestUtil;
import com.ohrm.qa.util.WaitNExceptions;

public class AddUser extends TestBase {


    @FindBy(id="menu_admin_viewAdminModule")
    WebElement adminLink;

    @FindBy(id="menu_admin_UserManagement")
    WebElement userManagementLink;

    @FindBy(id="menu_admin_viewSystemUsers")
    WebElement usersLink;

    @FindBy(xpath="//a[@class='btn-floating btn-large waves-effect waves-light']")
    WebElement addUserButton;

    @FindBy(id="selectedEmployee_value")
    WebElement employeeName_element;

    @FindBy(id = "user_name")
    WebElement userName_element;

    @FindBy(xpath = "//button[@data-id='essrole']")
    WebElement essRole;

    @FindBy(linkText = "Default ESS")
    WebElement defaultESS;

    @FindBy(linkText = "GeneralManager")
    WebElement generalManager;

    @FindBy(linkText = "-- Select --")
    WebElement select;

    @FindBy(xpath = "//*[@class='dropdown-menu show']")
    WebElement essRoleOptionsDiv;

    @FindBy(xpath ="//div[@class ='filter-option-inner-inner' and text()='Default ESS']")
    WebElement defaultESSDiv;

    @FindBy(xpath = "//button[@data-id='supervisorrole']")
    WebElement supervisorRole;

    @FindBy(linkText = "General Supervisor")
    WebElement generalSupervisor;

    @FindBy(xpath="//div[@class ='filter-option-inner-inner' and text()='General Supervisor']")
    WebElement generalSupervisorDiv;

    @FindBy(linkText = "Default Supervisor")
    WebElement defaultSupervisor;


    // @FindBy(id = "essrole")
    //WebElement essRole_dropdown;


    @FindBy(xpath ="//button[@data-id='adminrole'] ")
    WebElement adminrole;

    @FindBy(linkText = "Global Admin")
    WebElement globalAdmin;

    @FindBy(xpath = "//div[@class ='filter-option-inner-inner' and text()='Global Admin']")
    WebElement globalAdminDiv;

    @FindBy(xpath = "//div[@class='radio-display-horizontal']")
    WebElement status;

    @FindBy(xpath = "//label[@ng-class='{disabled: form.readonly}' and @for='status_1']")
    WebElement enabled;

    // @FindBy(xpath = "//input[@id='status_0']")
    @FindBy(xpath="//label[@ng-class='{disabled: form.readonly}' and @for='status_0']")
    WebElement disabled;

    @FindBy(xpath = "//*[@id='status_0']")
    WebElement disabledTrue;

    @FindBy(xpath ="//*[@id='status_1']")
    WebElement enabledTrue;

    @FindBy(xpath= "//input[@id=\"password\"]")
    WebElement password_element;

    @FindBy(xpath = "//input[@id=\"confirmpassword\"]")
    WebElement confirmPassword_element;

    @FindBy(id="modal-save-button")
    WebElement saveElement;

    @FindBy(xpath = "//button[@class = 'btn btn-ghost']")
    WebElement cancel;

    List<WebElement> userFormFields;

    @FindBy(xpath = "//table[@class= \"highlight bordered\"]")
    WebElement table;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    WebElement invalidEmployeeMsg;

    @FindBy(xpath = "//span[@class='invalid-feedback'][1]")
    WebElement invalidUserMsg;


    @FindBy(xpath = "//i[@class='material-icons' and text()='chevron_right']")
    WebElement nextPageIcon;

    @FindBy(xpath ="//i[@class='material-icons' and text()='chevron_left']")
    WebElement previousPageIcon;

    @FindBy(xpath ="//*[@class='modal-content']")
    WebElement addUserBox;

    @FindBy(xpath ="//span[@class='invalid-feedback']")
    WebElement invalidErrorMsgs;

    public AddUser() {
        PageFactory.initElements(driver, this);
    }


    public void navigateToAddUser() throws InterruptedException {
        List<WebElement> userList = new ArrayList<WebElement>();
        userList.add(adminLink);
        userList.add(userManagementLink);
        userList.add(usersLink);

        TestUtil.navigateToAdduserForm(userList);
        WaitNExceptions.clickWhenVisible(addUserButton);

        //Thread.sleep(1100);

        //Thread.sleep(1100);

    }

    public void navigateToUsersScreen() throws InterruptedException {
        // TODO Auto-generated method stub
        List<WebElement> userList = new ArrayList<WebElement>();
        userList.add(adminLink);
        userList.add(userManagementLink);
        userList.add(usersLink);
        

        TestUtil.navigateToAdduserForm(userList);
    }

    public boolean isAllFieldExist() {
        userFormFields = new ArrayList<WebElement>();

        userFormFields.add(employeeName_element);
        userFormFields.add(userName_element);
        userFormFields.add(essRole);

        userFormFields.add(supervisorRole);
        userFormFields.add(adminrole);
        userFormFields.add(status);
        userFormFields.add(password_element);
        userFormFields.add(confirmPassword_element);

        return TestUtil.isAllFieldsExist(userFormFields);
    }

    public boolean addWithMendatoryFields(String emp_name, String user, String password, String cnfPwd) throws InterruptedException {
        boolean foundUser = false;
        TestUtil.clickESSRole(essRole, defaultESS, cancel, addUserButton);
        Thread.sleep(1500);

        TestUtil.selectDefaultESSOption(defaultESS);
        Thread.sleep(1500);

        // TODO Auto-generated method stub
        TestUtil.clickSupervisorRole(supervisorRole, generalSupervisor, cancel, addUserButton);
        Thread.sleep(1500);

        TestUtil.selectGeneralSupervisorOption(generalSupervisor);
        Thread.sleep(1500);

        TestUtil.clickonEnable(enabled);
        Thread.sleep(1500);

        TestUtil.addEmployeeName(employeeName_element, emp_name);
        Thread.sleep(1500);

        TestUtil.addUserName(userName_element, user);
        Thread.sleep(1500);

        TestUtil.sendPassword(password_element, password);
        Thread.sleep(1500);

        TestUtil.sendconfirmPassword(confirmPassword_element, cnfPwd);
        Thread.sleep(1500);


        boolean saveEnable = TestUtil.saveUserPerformed(saveElement, invalidErrorMsgs);
        System.out.println("save done: "+saveEnable);
        if(saveEnable == true) {

            Thread.sleep(1500);
            foundUser = TestUtil.getTableValues(table,  emp_name,  user);
            // boolean foundUser = TestUtil.getTableValues(table, emp_name, user,saveElement, nextPageIcon);

            while(foundUser== false) {
                TestUtil.clickOnArrowIcon(nextPageIcon);
                foundUser = TestUtil.getTableValues(table, emp_name, user);
            }
            System.out.print("record matched");


        }

        else {
            saveEnable = false;
        }


        // boolean foundUser = TestUtil.getTableValues(table,  emp_name,  user, saveElement);



        return saveEnable;

    }


    public boolean matchRecordsfromWebTable(String emp_name, String user) throws InterruptedException {
        boolean foundUser = false;

        while(!foundUser) {
            // Thread.sleep(3000);
            // WaitNExceptions.waitUntilVisible1(table);

            foundUser =  TestUtil.getTableValues(table, emp_name, user);
            if(foundUser == true) {
                break;
            }
            //System.out.println("not found on current page: click on Arrow icon");
            TestUtil.clickOnArrowIcon(nextPageIcon);
          
            // foundUser = true;


        }
        System.out.print("record matched");
        return foundUser;

    }

    public void addWithInvalidFields(String invalid_emp_name, String user, String ess, String supervisor, String password, String cnfPwd) {
        List<WebElement> mendatoryFieldsList =TestUtil.addAllMendatoryFieldsinList(employeeName_element,userName_element,essRole, supervisorRole,password_element, confirmPassword_element );

        TestUtil.sendMendatoryInvalidElements(mendatoryFieldsList, invalid_emp_name, user,ess, supervisor,password, cnfPwd );
        TestUtil.saveUser(saveElement);
    }

    public String addValidEmployeeName(String employeename ) throws InterruptedException {
        return TestUtil.addEmployeeName(employeeName_element, employeename);

    }

    public String addValidUserName(String username) throws InterruptedException {
        return TestUtil.addUserName(userName_element, username);

    }

    public String addInvalidUserName(String username) throws InterruptedException {
        return TestUtil.addInvalidUserName(userName_element, username, invalidUserMsg);

    }

    public String addInvalidEmployee(String employeename) throws InterruptedException {
        return TestUtil.addInvalidEmployeeName(employeeName_element, employeename, invalidEmployeeMsg);

    }

    public boolean selectEssRole() throws InterruptedException {
        TestUtil.clickESSRole(essRole, defaultESS, cancel, addUserButton);
        TestUtil.selectDefaultESSOption(defaultESS);
        boolean isOptionSelected = TestUtil.checkIfOptionSelected(defaultESSDiv);
        return isOptionSelected;
    }


    public String SupervisorRole() throws InterruptedException {
        // TODO Auto-generated method stub
        TestUtil.clickSupervisorRole(supervisorRole, generalSupervisor, cancel, addUserButton);
        TestUtil.selectGeneralSupervisorOption(generalSupervisor);
        String isOptionSelected = TestUtil.checkIfSupervisorSelected(generalSupervisorDiv);
        return isOptionSelected;

    }

    public void selectEnableAdminRole() {
        TestUtil.selectAdminRole(adminrole, globalAdmin,globalAdminDiv, cancel, addUserButton );
    }

    public boolean selectDisableRadioButton() throws InterruptedException {
        //TestUtil.clickonEnable(status, enabled);
        TestUtil.clickonDisable(disabled);
        boolean isDisabled= TestUtil.checkIfDisbledSelected(disabledTrue);
        System.out.println("check status of disable selection"+ isDisabled);
        return isDisabled;
    }

    public boolean selectEnabledRadioButton() throws InterruptedException {
        TestUtil.clickonEnable(enabled);
        boolean isEnabled= TestUtil.checkIfEnableSelected(enabledTrue);
        System.out.println("check status of enable selection"+ isEnabled);

        return isEnabled;


    }


    public void addPassword(String password_emp) throws InterruptedException {
        TestUtil.sendPassword(password_element, password_emp);

    }


    public void addConfirmPwdPassword(String confirmPwd) {
        // TODO Auto-generated method stub
        TestUtil.sendconfirmPassword(confirmPassword_element, confirmPwd);

    }


    public boolean comparePwdAndConfirmpwd(String password, String confirmPassword) {
        // TODO Auto-generated method stub
        boolean checkIfPwdFieldsSame = false;
        String password_str =  TestUtil.sendPassword1(password_element, password);
        String confirmPwd_str = TestUtil.sendconfirmPassword1(confirmPassword_element, confirmPassword);
        if(password_str.equals(confirmPwd_str)) {
            checkIfPwdFieldsSame = true;
        }
        return checkIfPwdFieldsSame;

    }












}
