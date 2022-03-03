package com.ohrm.qa.util;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import com.ohrm.qa.base.TestBase;

public class TestUtil extends TestBase {

	// static WebDriver driver;
    static List<WebElement> mendatoryFields;


	public static void setWebdriver(WebDriver driver) {
		TestUtil.driver = driver;
	}

//	public static void openBrowser() {
//		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		driver = new ChromeDriver();
//	}
//
	public static void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}

//
//	public static void navigatetoApplication(String baseURL) {
//		driver.get(baseURL);
//	}
//
//	public static boolean verifyPageTitle(String locName, String locValue, String textValue) {
//		String actual = driver.getTitle();
//		if (actual.equals(textValue)) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public static void enterText(String locName, String locValue, String textValue) {
//		if (locName.equals("id")) {
//			driver.findElement(By.id(locValue)).sendKeys(textValue);
//		} else if (locName.equals("xpath")) {
//			driver.findElement(By.xpath(locValue)).sendKeys(textValue);
//		} else if (locName.equals("name")) {
//			driver.findElement(By.name(locValue)).sendKeys(textValue);
//		} else if (locName.equals("cssselector")) {
//			driver.findElement(By.cssSelector(locValue)).sendKeys(textValue);
//		}
//
//	}
//
//	public static void click(String locName, String locValue) {
//		if (locName.equals("id")) {
//			driver.findElement(By.id(locValue)).click();
//		} else if (locName.equals("xpath")) {
//			driver.findElement(By.xpath(locValue)).click();
//		} else if (locName.equals("cssSelector")) {
//			driver.findElement(By.cssSelector(locValue)).click();
//		}
//	}
//
	public static boolean verifyText(String locName, String locValue, String textValue) {
		String actual = null;
		if (locName.equals("id")) {
			actual = driver.findElement(By.id(locValue)).getText();
		} else if (locName.equals("xpath")) {
			actual = driver.findElement(By.xpath(locValue)).getText();
		}
		if (actual.equals(textValue)) {
			return true;
		} else {
			return false;
		}
	}
//
//	public static boolean selected(String locName, String locValue, String textValue) {
//		boolean actual = false;
//		if (locName.equals("id")) {
//			actual = driver.findElement(By.id(locValue)).isSelected();
//		} else if (locName.equals("xpath")) {
//			actual = driver.findElement(By.xpath(locValue)).isSelected();
//		}
//		if (actual == true) {
//			return true;
//		} else {
//			return false;
//		}
//	}

	// public static void verifyEmployee(String locName, String locValue, String
	// textValue) {
	// int rowCount = -1;
	// int columnCount = 0;
	//
	// if (locName.equals("cssSelector")) {
	// WebElement simpleTable = driver.findElement(By.cssSelector(locValue));
	// // Get all rows
	// List<WebElement> allRows = simpleTable.findElements(By.tagName("tr"));
	// for (WebElement row : allRows) {
	// rowCount++;
	// List<WebElement> rowCells = row.findElements(By.tagName("td"));
	// for (WebElement cell : rowCells) {
	// columnCount++;
	// String userName = cell.getText();
	// if (userName.equals(textValue)) {
	// System.out.println("Table Data : - " + cell.getText());
	// driver.findElement(By.linkText(userName)).click();
	// }
	// }
	// columnCount = 0;
	// }
	// } else if (locName.equals("xpath")) {
	//
	// WebElement simpleTable = driver.findElement(By.xpath(locValue));
	// // Get all rows
	// List<WebElement> allRows = simpleTable.findElements(By.tagName("tr"));
	// for (WebElement row : allRows) {
	// rowCount++;
	// List<WebElement> rowCells = row.findElements(By.tagName("td"));
	// for (WebElement cell : rowCells) {
	// columnCount++;
	// String userName = cell.getText();
	// if (userName.equals(textValue)) {
	// System.out.println("Table Data : - " + cell.getText());
	// driver.findElement(By.linkText(userName)).click();
	// }
	// }
	// columnCount = 0;
	// }
	// }
	// }// method

	// Method to send key
	public static void sendKey(WebElement element, String value) {
		element.sendKeys(value);
	}

	// Method to click
	public static void click(WebElement element) {
		element.click();
		System.out.println("button clicked: ");
	}
	

	// Method to get Title
	public static String getPageTitle(WebDriver driver) {
		String title = driver.getTitle();
		System.out.println("Title is " + title);
		return title;
	}

	// Method to clear field
	public static void clearValue(WebElement element) {
		element.clear();
	}

	public static void closeBrowser() {
		driver.close();

	}

    public static void navigateToAdduserForm(List<WebElement> elementsList) throws InterruptedException {
        // TODO Auto-generated method stub
       
    	for(WebElement we : elementsList  ) {
            WaitNExceptions.waitUntilVisible1(we);
            Thread.sleep(1200);
            we.click();
           
        }
    }
       
       public static void navigateToAddEmpForm(List<WebElement> elementsList) throws InterruptedException {
    	   for(WebElement we : elementsList  ) {
               WaitNExceptions.waitUntilVisible1(we);
               Thread.sleep(1200);
               we.click(); 
       }
        
    }

    public static boolean  isAllFieldsExist(List<WebElement> userFormFields) {
        // TODO Auto-generated method stub
        boolean checkFields = false;
        
        //checkFields=  userFormFields.get(1).isDisplayed();
        for(WebElement we : userFormFields) {
            WaitNExceptions.waitUntilVisible1(we);
             try {
                 checkFields = we.isDisplayed();                 
             }
             catch (NoSuchElementException e) {
                // TODO: handle exception
                 return false;
            }
          
           //  System.out.println("------"+checkFields+ "---"+we.getText());

         }
        System.out.println("-----in pages class -add user fields--"+checkFields);
        return checkFields;
    }

    public static List<WebElement> addAllMendatoryFieldsinList(WebElement employeeName, WebElement userName, WebElement essRole,
            WebElement supervisorRole, WebElement password, WebElement confirmPassword) {
        // TODO Auto-generated method stub
        mendatoryFields = new ArrayList<WebElement>();
        mendatoryFields.add(employeeName);
        mendatoryFields.add(userName);
        mendatoryFields.add(essRole);
        mendatoryFields.add(supervisorRole);
        mendatoryFields.add(password);
        mendatoryFields.add(confirmPassword);
        return mendatoryFields;
        
    }

    public static void sendMendatoryElements(List<WebElement> mendatoryFieldsList, String emp_name, String user,
            String ess, String supervisor, String password, String cnfPwd) {
        // TODO Auto-generated method stub
        WaitNExceptions.waitUntilVisible(mendatoryFieldsList);

        mendatoryFieldsList.get(0).sendKeys(emp_name);
        mendatoryFieldsList.get(1).sendKeys(user);
        mendatoryFieldsList.get(2).sendKeys(ess);
        mendatoryFieldsList.get(3).sendKeys(supervisor);
        mendatoryFieldsList.get(4).sendKeys(password);
        mendatoryFieldsList.get(5).sendKeys(cnfPwd);
      
    }

    public static void saveUser(WebElement saveElement) {
        // TODO Auto-generated method stub
        //WaitNExceptions.waitUntilVisible1(saveElement);
        WaitNExceptions.clickWhenVisible(saveElement);
        System.out.println("save button clicked");
        //saveElement.is
    }
    
    public static boolean saveUserPerformed(WebElement saveElement, WebElement invalidErrorMsgs) {
        boolean saveClicked;
         WaitNExceptions.clickWhenVisible(saveElement);
        System.out.println("save button clicked");
        
        if(invalidErrorMsgs.isDisplayed()) {
            saveClicked = false;
            System.out.println("not able to save"+saveClicked);
        }
        else {
            saveClicked = true;
        }
        return saveClicked ;
    }
    

    public static void sendMendatoryInvalidElements(List<WebElement> mendatoryFieldsList, String invalid_emp_name,
            String user, String ess, String supervisor, String password, String cnfPwd) {
        // TODO Auto-generated method stub
        WaitNExceptions.waitUntilVisible(mendatoryFieldsList);

        mendatoryFieldsList.get(0).sendKeys(invalid_emp_name);
        mendatoryFieldsList.get(1).sendKeys(user);
        mendatoryFieldsList.get(2).sendKeys(ess);
        mendatoryFieldsList.get(3).sendKeys(supervisor);
        mendatoryFieldsList.get(4).sendKeys(password);
        mendatoryFieldsList.get(5).sendKeys(cnfPwd);
        
    }

    public static boolean getTableValues(WebElement table, String emp_name, String user) throws InterruptedException {
        // TODO Auto-generated method stub
        boolean flag = false;
         Thread.sleep(5000);

        WaitNExceptions.waitUntilVisible1(table);
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rowNumber = rows.size();
        
        //List<WebElement> cols = table.findElements(By.tagName("td"));
        //int colNumber = cols.size();
        
        System.out.println("Total number of rows = " + rowNumber);
       // System.out.println("Total number of columns = " + colNumber);

        
    
        for(int i = 1 ; i< rowNumber ; i++) {
            WaitNExceptions.waitUntilVisible1(rows.get(i));
            List<WebElement> cols  = rows.get(i).findElements(By.tagName("td"));
           
            for(int j = 1; j < 5 ; j++) {
                WaitNExceptions.waitUntilVisible1(cols.get(j));
                System.out.println(cols.get(j).getText());
               
                   if(cols.get(1).getText().equals(user) && cols.get(3).getText().equals(emp_name)) { 
                      flag = true;
                      System.out.println("got username: "+cols.get(1).getText());
                      //System.out.println("got employeename: "+cols.get(3).getText());
                   }
                   
            }
                //System.out.println(cols.get(i));
                //actualResult.add(cols.get(j).getText());
            
            System.out.println("------------------------");
            
        }
        
        System.out.println("flag is "+flag);
        return flag;        
    }
    
    public static void clickOnArrowIcon(WebElement nextPageIcon) {
        if(!nextPageIcon.isDisplayed()) {
            
        }
        WaitNExceptions.clickWhenVisible(nextPageIcon);
        System.out.println("next page button clicked");
        //saveElement.is
       
        
        
    }

    public static String addEmployeeName(WebElement employeeName_element, String employeename) throws InterruptedException {
        // TODO Auto-generated method stub
        WaitNExceptions.clickWhenVisible(employeeName_element);
        employeeName_element.sendKeys(employeename);
        Thread.sleep(1100);
       String actualEmpName =  employeeName_element.getAttribute("value");
       System.out.println("actual employee name "+ actualEmpName);
       return actualEmpName;

        
    }

    public static String addUserName(WebElement userName_element, String username) throws InterruptedException {
        // TODO Auto-generated method stub
       WaitNExceptions.clickWhenVisible(userName_element);
       userName_element.sendKeys(username);
       Thread.sleep(1100);
       String actualUserName =  userName_element.getAttribute("value");
       System.out.println("actual user name "+ actualUserName);
       return actualUserName;
    }

    public static String addInvalidUserName(WebElement userName_element, String username, WebElement invalidUserMsg) throws InterruptedException {
        // TODO Auto-generated method stub
        WaitNExceptions.waitUntilVisible1(userName_element);
        userName_element.sendKeys(username);
        Thread.sleep(1100);
        String errorMessage = WaitNExceptions.getWhenVisible(invalidUserMsg);
        System.out.println(" user name-invalid msg-toString "+ invalidUserMsg.toString());
        System.out.println(" user name-invalid msg "+ errorMessage);
        
        return errorMessage;
       
    }

  
    public static String addInvalidEmployeeName(WebElement employeeName_element, String employeename, WebElement invalidEmpMsg) throws InterruptedException {
        // TODO Auto-generated method stub
        
        WaitNExceptions.waitUntilVisible1(employeeName_element);
        employeeName_element.sendKeys(employeename);
        Thread.sleep(1100);
        String errorMessage = WaitNExceptions.getWhenVisible(invalidEmpMsg);
        System.out.println("--Emp name-invalid msg-- "+ errorMessage);

 
        return errorMessage;
    }
    
 
    public static void clickESSRole(WebElement essRole,WebElement defaultESS, WebElement cancel,
            WebElement addUserButton) {
        // TODO Auto-generated method stub
        WaitNExceptions.clickWhenVisible(essRole);
        System.out.println("Ess role drop down button clicked: ");
        
       WaitNExceptions.waitUntilVisible1(defaultESS);
        
        WaitNExceptions.clickWhenVisible(cancel);
        System.out.println("cancel button clicked: ");

        WaitNExceptions.clickWhenVisible(addUserButton);
        System.out.println("add user button clicked: ");
        WaitNExceptions.clickWhenVisible(essRole);

       // Actions action = new Actions(TestUtil.driver);
       // action.moveToElement(essRole).perform();
        //essRole.click();

        //action.sendKeys(Keys.ARROW_DOWN).perform();
        //action.sendKeys(Keys.ARROW_DOWN).click();
        System.out.println("essrole user button clicked: ");
    }

    public static void selectDefaultESSOption(WebElement defaultESS) throws InterruptedException {
        //Thread.sleep(1500);
       WaitNExceptions.waitUntilVisible1(defaultESS);
      // WaitNExceptions.waitUntilVisible1(defaultESS);

       // WaitNExceptions.clickWhenVisible(defaultESS);

       defaultESS.click();
      //Thread.sleep(1500);
        System.out.println("default ESS clicked: ");

    }
    
    public static boolean checkIfOptionSelected(WebElement defaultESSDiv) {
        // TODO Auto-generated method stub
        boolean isButtonSelected = false;
        WaitNExceptions.waitUntilVisible1(defaultESSDiv);

        if(defaultESSDiv.isDisplayed()) {
            System.out.println("option selected from dropdown: "+ defaultESSDiv.getText());
;            isButtonSelected = true;
            return isButtonSelected;
        }
        
        return isButtonSelected;
               
        }
    
    //supervisor drop-down
    public static void clickSupervisorRole(WebElement supervisorRole,WebElement generalSupervisor, WebElement cancel,
            WebElement addUserButton) {
        // TODO Auto-generated method stub
        WaitNExceptions.clickWhenVisible(supervisorRole);
        System.out.println("supervisorRole drop down button clicked: ");
        
        WaitNExceptions.waitUntilVisible1(generalSupervisor);
        
        WaitNExceptions.clickWhenVisible(cancel);
        System.out.println("cancel button clicked: ");

        WaitNExceptions.clickWhenVisible(addUserButton);
        System.out.println("add user button clicked: ");
        
        WaitNExceptions.clickWhenVisible(supervisorRole);
        System.out.println("supervisorRole  button clicked: ");
    }

    public static void selectGeneralSupervisorOption(WebElement generalSupervisor) throws InterruptedException {
        //Thread.sleep(1500);
       WaitNExceptions.waitUntilVisible1(generalSupervisor);
       generalSupervisor.click();
      //Thread.sleep(1500);
        System.out.println("generalSupervisor clicked: ");

    }
    
    public static String  checkIfSupervisorSelected(WebElement generalSupervisorDiv) {
        // TODO Auto-generated method stub
        boolean isButtonSelected = false;
        WaitNExceptions.waitUntilVisible1(generalSupervisorDiv);

        if(generalSupervisorDiv.isDisplayed()) {
            System.out.println("option selected from dropdown: "+generalSupervisorDiv.getText());
;            return generalSupervisorDiv.getText();
        }
        
        return null;
        }
    
 
    public static void selectAdminRole(WebElement adminrole, WebElement globalAdmin, WebElement globalAdminDiv,
            WebElement cancel, WebElement addUserButton) {
        // TODO Auto-generated method stub
        WaitNExceptions.clickWhenVisible(adminrole);
        System.out.println("Admin role drop down button clicked: ");

        WaitNExceptions.waitUntilVisible1(globalAdmin);
        
        WaitNExceptions.clickWhenVisible(cancel);
        System.out.println("cancel button clicked: ");

        WaitNExceptions.clickWhenVisible(addUserButton);
        System.out.println("add user button clicked: ");

        WaitNExceptions.clickWhenVisible(adminrole);
        System.out.println(" Admin Role button clicked: ");
        
        globalAdmin.click();
        System.out.println("global admin link clicked: ");
        
        
    }

   
    public static void clickonEnable( WebElement enabled) throws InterruptedException {
        // TODO Auto-generated method stub
        Thread.sleep(2000);
        enabled.click();
        System.out.println("enable clicked");
        Thread.sleep(1000);
        System.out.println("----in click method "+enabled.isSelected());

    }
    
    public static boolean checkIfEnableSelected(WebElement enabledTrue) {
        // TODO Auto-generated method stub
        boolean checkButtonClicked = false ;
        System.out.println("----"+enabledTrue.isSelected());
        if(enabledTrue.isSelected()) {
            System.out.println("enabled...");
            checkButtonClicked = true;
            return checkButtonClicked;
        }
      return checkButtonClicked;
        
    }

    public static boolean checkIfDisbledSelected(WebElement disabledTrue) {
        // TODO Auto-generated method stub
        boolean checkButtonClicked = false ;
        System.out.println("----"+disabledTrue.isSelected());
        if(disabledTrue.isSelected()) {
            System.out.println("diabled...");
            checkButtonClicked = true;
            return checkButtonClicked;
        }
      return checkButtonClicked;
        
    }

    public static void clickonDisable( WebElement disabled) throws InterruptedException {
        // TODO Auto-generated method stub
         //  WaitNExceptions.clickWhenVisible(disabled); 
        Thread.sleep(2000);
            disabled.click();
            System.out.println("disabled clicked");
            Thread.sleep(1000);
            System.out.println("----in click method "+disabled.isSelected());

            
    }


    public static void sendPassword(WebElement password, String password_emp) {
        // TODO Auto-generated method stub
        WaitNExceptions.waitUntilVisible1(password);
        password.sendKeys(password_emp);
    }
    public static String sendPassword1(WebElement password, String password_emp) {
        // TODO Auto-generated method stub
        WaitNExceptions.waitUntilVisible1(password);
        password.sendKeys(password_emp);
        System.out.println("entered password : "+password.getAttribute("value"));
        return password.getAttribute("value");
    }

    public static void sendconfirmPassword(WebElement confirmPassword, String confirmPwd) {
        // TODO Auto-generated method stub
        WaitNExceptions.waitUntilVisible1(confirmPassword);
        confirmPassword.sendKeys(confirmPwd);

    }
    public static String sendconfirmPassword1(WebElement confirmPassword, String confirmPassword_emp) {
        // TODO Auto-generated method stub
        WaitNExceptions.waitUntilVisible1(confirmPassword);
        confirmPassword.sendKeys(confirmPassword_emp);
        System.out.println("entered password : "+confirmPassword.getAttribute("value"));

        return confirmPassword.getAttribute("value");
    }

   
}
