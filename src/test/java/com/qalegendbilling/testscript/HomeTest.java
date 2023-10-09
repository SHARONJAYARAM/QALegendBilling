package com.qalegendbilling.testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

//import com.demowebshop.constants.ErrorMessages;
//import com.demowebshop.utilities.ExcelUtility;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.utilities.ExcelUtility;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class HomeTest extends Base{

	HomePage home;
	@Test(priority=1,description="TC_008 verify edit user",groups= {"Regression"})
	public void TC_001_verifyHomePageTitle()
	{
		List<ArrayList <String>> data = ExcelUtility.excelDataReader("HomePage");
		String exp_title = data.get(1).get(0);
		home = new HomePage(driver);//to get the methods or elements from HomePage, defining homepage
		String actualHomePageTitle=home.getHomePageTitle();
		Assert.assertEquals(exp_title, actualHomePageTitle,ErrorMessages.INVALID_TITLE);
	}	
}
