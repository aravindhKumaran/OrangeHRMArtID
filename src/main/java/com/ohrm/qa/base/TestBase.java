package com.ohrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//import com.projectname.qa.util.TestUtil;
//import com.projectname.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	// public static WebEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			//System.out.println(System.getProperty("user.dir"));
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/ohrm/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
			} else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}

		//e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		// eventListener = new WebEventListener();
		// e_driver.register(eventListener);
		//driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,
		// TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,
		// TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

}
