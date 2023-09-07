package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.CreatePage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class UsersTest extends Base {
	UsersPage users;
	LoginPage login;
	HomePage home;
	CreatePage create;
	
	
	
	
	
	@Test
	public void TC_008_verifyUserSearch() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");//Excel read for login
		String uname = data.get(0).get(1);
		String pwrd = data.get(1).get(1);
		List<ArrayList<String>>data1=ExcelUtility.excelDataReader("UserSearch");//Excel read for role search
		String userName=data1.get(0).get(1);		
		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		home.clickUserManagementTab();//clickUserManagementTab
		users = home.clickUsersTab();//clickUsersTab
		users.enterUserName(userName);	
		String td_Search=users.getSearchValue();
		Assert.assertEquals(userName, td_Search,ErrorMessages.INVALID_USER_NAME);
	}

	@Test(priority=1,description="TC_006 verify add user details",groups= {"Smoke"})
	public void TC_006_verifyAddUserDetails() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(0).get(1);
		String pwrd = data.get(1).get(1);
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("CreatePage");
		String prefix = data1.get(0).get(1);
		String firstName = RandomUtility.getfName();
		String lastName = RandomUtility.getlName();
		String email = RandomUtility.getRandomEmail();
		String userName = firstName + lastName;
		String password = firstName + "@123";
		String confirmPassword = password;
		String salesCommissionPercentage = data1.get(1).get(1);

		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
//		home.clickOnUserManagementTab();
		home.clickUserManagementTab();
//		users = home.clickOnUsers();
//		users = home.clickUsersTab();
		create = users.clickOnAddButton();
		
		create.enterUserDetails(prefix, firstName, lastName, email, userName, password, confirmPassword, salesCommissionPercentage);
		create.clickOnIsActive();
		users=create.clickOnSaveButton();
		users.setValidEmail(email);
		// user added successfully assert or find element of search -then assert using
		// email id or name
		String actEmail = users.getValidEmail();
		Assert.assertEquals(email, actEmail, ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);
	}
	
	
}
