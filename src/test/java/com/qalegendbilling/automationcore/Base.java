package com.qalegendbilling.automationcore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.qalegendbilling.constants.Constants;
import com.qalegendbilling.extentmanager.ExtentManager;
import com.qalegendbilling.utilities.TestHelperUtility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Parameters;

public class Base extends TestHelperUtility {

	public WebDriver driver;
	public static Properties prop;
	public FileInputStream fs;

	public Base() {
		prop = new Properties();
		try {
			fs = new FileInputStream(System.getProperty("user.dir") + Constants.CONFIG_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
//	@BeforeMethod(alwaysRun = true)	//individual test cases
//	public void setUP() {
//		String browser = prop.getProperty("browser");
//		String url = prop.getProperty("url");
//		driver = DriverFactory.testInitialization(browser);
//		driver.get(url);
//	}
	

	@BeforeMethod(alwaysRun = true)	//configuration files
	@Parameters({"browser"})
	public void setUP(String browserName){
	     String url= prop.getProperty("url");
	     driver = DriverFactory.testInitialization(browserName);
	     driver.get(url);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
			File screenshot = takeScreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("./Screenshots/" + result.getName() + ".png"));
		}
		driver.quit();
		
	}
	
	public static String getDriverPath() {
		String driverPath = System.getProperty("user.dir")+prop.getProperty("driverPathChrome");
		return driverPath;
	}

	@BeforeSuite
	public void setExtent(final ITestContext testContext) {
		ExtentManager.createInstance().createTest(testContext.getName(), "TEST FAILED");
	}

}
