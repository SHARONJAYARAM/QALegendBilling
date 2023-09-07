package com.qalegendbilling.testscript;
import java.util.ArrayList;
import java.util.List;

//import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.CreatePage;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;



public class DeleteUserTest extends Base {
	LoginPage login;
	HomePage home;
	UsersPage users;
	CreatePage create;
	@Test(priority=1,description="TC_008 verify delete user",groups= {"Regression"})
	public void TC_008_verifyDeleteUserTab() {
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
		String expEmptyMsg = data1.get(2).get(1);

		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		home.clickUserManagementTab();
//		users = home.clickOnUsers();
		users = home.clickUsersTab();
		create = users.clickOnAddButton();
		create.enterUserDetails(prefix, firstName, lastName, email, userName, password, confirmPassword, salesCommissionPercentage);
		create.clickOnIsActive();
		users=create.clickOnSaveButton();
		users.setValidEmail(email);
		users.clickOnDeleteButton();
		users.clickOkButton();
		String emptyMsg=users.getEmptyTableText();
		Assert.assertEquals(emptyMsg, expEmptyMsg, ErrorMessages.INVALID_EMPTY_MESSAGE);
		
}

}
