package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.automationcore.Base;

public class LoginTest extends Base{
	LoginPage login;
	HomePage home;
	
		@Test(priority=1, description="TC_002 verify Valid Login",groups= {"Regression"})
		public void TC_002_verifyValidLogin() {
			List<ArrayList<String>>data=ExcelUtility.excelDataReader("LoginPage");
			String uname=data.get(0).get(1);
			String pwrd=data.get(1).get(1);
			String expUserName=data.get(2).get(1);
			login=new LoginPage(driver);
			login.enterUserName(uname);		
			login.enterPassword(pwrd);
			home=login.clickSubmit();     
			String actualUserName=home.getUserAccountName();
			Assert.assertEquals(expUserName, actualUserName,ErrorMessages.USERNAME_FAILURE_MESSAGE);
		}
		
		@Test(priority=1, description="TC_003 verify Invalid Login",groups= {"Reggression"},dataProvider = "InvalidUserCredentials",dataProviderClass = DataProviders.class)
		public void TC_003_verifyInvalidLogin(String username, String password) {
			List<ArrayList<String>>data1=ExcelUtility.excelDataReader("LoginPage");
			String expErrorMessage=data1.get(3).get(1);
			login=new LoginPage(driver);
			login.enterUserName(username);
			login.enterPassword(password);
			login.clickLogin();
			String actualErrorMessage = login.getErrorMessage();
			Assert.assertEquals(expErrorMessage, actualErrorMessage, ErrorMessages.INVALID_LOGIN);	
		}
}
