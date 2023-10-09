package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.SignoutPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class SignoutTest extends Base {
	SignoutPage signout;
	LoginPage login;
	HomePage home;

	@Test(priority=1, description="TC_004 verify if user is navigate to login page by clicking signoutbutton",groups= {"Sanity"})
	
	public void TC_004_verifyuser_isNavigate_to_LoginPage_by_clicking_signout() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");
		String uname = data.get(0).get(1);
		login = new LoginPage(driver);
		String actTitile = login.loginPageTitle();
		System.out.println(actTitile);
		login.enterUserName(uname);
		String pwrd = data.get(1).get(1);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		login = home.clickSighnoutButton();
		String expTitle = login.loginPageTitle();
		Assert.assertEquals(actTitile, expTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
	}
}
