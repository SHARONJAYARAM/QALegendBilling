package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.CreatePage;
import com.qalegendbilling.pages.EditUserPage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class EditUserTest extends Base {
	LoginPage login;
	HomePage home;
	UsersPage users;
	CreatePage create;
	EditUserPage edit;
	@Test(priority=1,description="TC_008 verify edit user",groups= {"Regression"})
	public void TC_008_verifyEditUserTab() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(0).get(1);
		String pwrd = data.get(1).get(1);
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("CreatePage");
		String prefix = data1.get(0).get(1);
		String firstName = RandomUtility.getfName();
		String lastName = RandomUtility.getlName();
		String email = RandomUtility.getRandomEmail();
		String update_email = RandomUtility.getRandomEmail();		
		String userName = firstName + lastName;
		String password = firstName + "@123";
		String confirmPassword = password;
		String salesCommissionPercentage = data1.get(1).get(1);
		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		home.clickUserManagementTab();
		users = home.clickUsersTab();
		create = users.clickOnAddButton();
		create.enterUserDetails(prefix, firstName, lastName, email, userName, password, confirmPassword, salesCommissionPercentage);
		create.clickOnIsActive();
		users=create.clickOnSaveButton();
		users.enterSearchUserName(prefix+" "+firstName+" "+lastName);//right
		edit = users.clickOnEditButton();
		edit.enterEmail(update_email);//entering new email id(updating)
		users = edit.clickOnUpdateButton();
		users.setValidEmail(update_email);
		String actualEmail = users.getValidEmail();
		Assert.assertEquals(update_email, actualEmail,ErrorMessages.INVALID_USER_UPDATE);		
}

}
