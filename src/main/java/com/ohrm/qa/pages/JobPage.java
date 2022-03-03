package com.ohrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ohrm.qa.base.TestBase;

public class JobPage extends TestBase{

	public JobPage() {
		PageFactory.initElements(driver, this);
	}
	
	 //select[@id='work_shift_id']
	@FindBy(id="work_shift_id")
	WebElement workShift;
	
	//div[@id='P758950172_root']/following-sibling::i
	@FindBy(id="P758950172_root")
	WebElement effectiveFromDate;
	
	//xpath="//select[@id='9']"
	//ul[@id='select-options-5970616d-e07d-311c-6521-cabe22058ae6']/li[2]/span
	@FindBy(xpath="//select[@id='9']")
	WebElement region;
	
	//select[@id='10']
	@FindBy(id="10")
	WebElement fte;
	
	//select[@id='11']
	//select-options-be164a94-768f-760a-7ddb-1f47c625976c
	@FindBy(xpath="//select[@id='11']")
	WebElement temporaryDept;
	
	
	@FindBy(xpath="//button[@translate='Save']")
	WebElement saveBtn;
	
	@FindBy(id="subunit_id")
	WebElement subUnit;
	
	
	
	
	
public void sendMandatoryValues() throws InterruptedException {
	
	/*Select workshift=new Select(workShift);
	workshift.selectByIndex(1);
		*/

		
	//Select selectRegion=new Select(region);
	//selectRegion.selectByValue("string:Region-1");	
	/*Select selectFte=new Select(fte);
	selectFte.selectByIndex(0);*/
	/*
	Select selectTempDept=new Select(temporaryDept);
	selectTempDept.selectByIndex(1);
		
	/*
	saveBtn.click();
	
	region.click();
	
	Select pay= new Select(subUnit);
	pay.selectByIndex(1);*/
	Thread.sleep(5000);
	Actions action=new Actions(driver);
	action.moveToElement(effectiveFromDate).click().build().perform();
	
	
	
	//saveBtn.click();
	
	
	
	
}




}
