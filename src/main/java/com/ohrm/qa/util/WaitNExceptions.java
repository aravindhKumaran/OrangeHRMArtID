package com.ohrm.qa.util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ohrm.qa.base.TestBase;

public class WaitNExceptions extends TestBase {

	// Method to click on visible element

	public static void clickWhenVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
		} catch (Exception e) {
		}

	}
	
	// Method to get value on visible element

	public static String getWhenVisible(WebElement element) {
		String getValue = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
		try {
			getValue = element.getText();

		} catch (Exception e) {
		}
		return getValue;

	}
	   public static void waitUntilVisible(List<WebElement> elements) {
	        try {
	            WebDriverWait wait = new WebDriverWait(driver,30);
	            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	        } catch (Exception e) {
	        }

	    }

	   public static void waitUntilVisible1(WebElement element) {
           try {
               WebDriverWait wait = new WebDriverWait(driver, 20);
               wait.until(ExpectedConditions.visibilityOf(element));
           } catch (Exception e) {
           }

       }


	// Method to get value on visible element

	public static void getWhenReady(WebElement element) {

		int TimeOut = 20;
		try {
			while (!element.isEnabled() && TimeOut > 0) {
				Thread.sleep(1000);
				TimeOut--;
			}
			element.click();
		} catch (Exception e) {
		}

	}

	// Method fluentWait

	public static FluentWait<WebDriver> fluentWait(int SECONDS) {
		return new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(SECONDS))
				.pollingEvery(Duration.ofSeconds(SECONDS)).ignoring(Exception.class);
	}

    public static void waitUntilVisibleDDOptions(Select essOptions) {
        // TODO Auto-generated method stub
        try {
            WebDriverWait wait = new WebDriverWait(driver, 20);
            wait.until(ExpectedConditions.visibilityOf((WebElement) essOptions));
        } catch (Exception e) {
        }

    }

}
