package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class UserManagementTest extends Base{
	LoginPage login;
	HomePage home;
	
	
	@Test(priority=1, description="TC_007 verify UserManagement Tabs Are Displayed",groups= {"Smoke"})
	public void TC_007_verifuUserManagementTabsAreDisplayed() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");//Excel read for login
		String uname = data.get(0).get(1);
		String pwrd = data.get(1).get(1);		
		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		home.clickUserManagementTab();//clickUserManagementTab
//		Thread.sleep(5000);
		boolean userMenuStatus = home.userMenuIsDisplayed();
		boolean rolesMenuStatus = home.rolesMenuIsDisplayed();
		boolean salesMenuStatus = home.salesMenuIsDisplayed();
		Assert.assertTrue(userMenuStatus, ErrorMessages.USER_SUBMENU_NOT_FOUND);
		Assert.assertTrue(rolesMenuStatus, ErrorMessages.ROLES_SUBMENU_NOT_FOUND);
		Assert.assertTrue(salesMenuStatus, ErrorMessages.SALES_SUBMENU_NOT_FOUND);
	
	
	}

}
