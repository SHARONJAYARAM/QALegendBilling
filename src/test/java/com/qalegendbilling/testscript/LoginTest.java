package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.CreatePage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;
import com.qalegendbilling.dataprovider.DataProviders;
import com.qalegendbilling.automationcore.Base;

public class LoginTest extends Base{
	LoginPage login;
	HomePage home;
	CreatePage create;
	UsersPage users;
	
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
		
		
		@Test(priority=1, description="TC_002 verify Login With Newly Added User",groups= {"Regression"})
		public void TC_002_verifyLoginWithNewlyAddedUser() {
			List<ArrayList<String>> data2 = ExcelUtility.excelDataReader("LoginPage");
			String uname = data2.get(0).get(1);
			String pwrd = data2.get(1).get(1);
			List<ArrayList<String>> data3 = ExcelUtility.excelDataReader("CreatePage");
			String prefix = data3.get(0).get(1);
			String firstName = RandomUtility.getfName();
			String lastName = RandomUtility.getlName();
			String email = RandomUtility.getRandomEmail();
			String userName = firstName + lastName;
			String user_password = firstName + "@123";
			String confirmPassword = user_password;
			String salesCommissionPercentage = data3.get(1).get(1);
			login = new LoginPage(driver);
			String actTitle = login.loginPageTitle();
			login.enterUserName(uname);
			login.enterPassword(pwrd);
			home = login.clickSubmit();
			home.clickUserManagementTab();
			users=home.clickUsersTab();
			create = users.clickOnAddButton();
			create.enterUserDetails(prefix, firstName, lastName, email, userName, user_password, confirmPassword, salesCommissionPercentage);
			create.clickOnIsActive();
			users=create.clickOnSaveButton();//?
			users.setValidEmail(email);
			String actEmail = users.getValidEmail();
			Assert.assertEquals(email, actEmail,ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);
			home.clickOnHomeTab();
			login = home.clickSighnoutButton();
			String expTitle =login.loginPageTitle();
			Assert.assertEquals(actTitle, expTitle, ErrorMessages.TITLE_FAILURE_MESSAGE);
			login.enterUserName(userName);		
			login.enterPassword(user_password);
			home=login.clickLoginbutton();
			String actualUserName=home.getUserAccountName();
			String expUserName=firstName+" "+lastName;
			Assert.assertEquals(expUserName, actualUserName,ErrorMessages.USERNAME_FAILURE_MESSAGE);	
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		@Test
//		public void TC_003_verifyLoginWithNewlyAddedUser(String username, String password) {
//			List<ArrayList<String>> data2 = ExcelUtility.excelDataReader("LoginPage");
//			String uname = data2.get(0).get(1);
//			String pwrd = data2.get(1).get(1);
//			List<ArrayList<String>> data3 = ExcelUtility.excelDataReader("CreatePage");
//			String prefix = data3.get(0).get(1);
//			String firstName = RandomUtility.getfName();
//			String lastName = RandomUtility.getlName();
//			String email = RandomUtility.getRandomEmail();
//			String userName = firstName + lastName;
//			String user_password = firstName + "@123";
//			String confirmPassword = user_password;
//			String salesCommissionPercentage = data3.get(1).get(1);
//			login = new LoginPage(driver);
//			login.enterUserName(uname);
//			login.enterPassword(pwrd);
//			home = login.clickSubmit();
//			home.clickUserManagementTab();
//			create = users.clickOnAddButton();
//			create.enterUserDetails(prefix, firstName, lastName, email, userName, user_password, confirmPassword, salesCommissionPercentage);
//			create.clickOnIsActive();
//			users=create.clickOnSaveButton();
//			
//			home.clickSighnoutButton();
//			
//
//			String expUserName=firstName+" "+lastName;
//			login=new LoginPage(driver);
//			login.enterUserName(userName);		
//			login.enterPassword(user_password);
//			home=login.clickSubmit();     
//			String actualUserName=home.getUserAccountName();
//			Assert.assertEquals(expUserName, actualUserName,ErrorMessages.USERNAME_FAILURE_MESSAGE);
//		}
}
