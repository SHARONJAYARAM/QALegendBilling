package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class RolesTest extends Base{
	
	RolesPage roles;
	LoginPage login;
	HomePage home;
	@Test(priority=1, description="TC_006 verify roles search",groups= {"Smoke"})
	public void TC_006_verifyRoleSearch() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("HomePage");//Excel read for login
		String uname = data.get(0).get(1);
		String pwrd = data.get(1).get(1);
		List<ArrayList<String>>data1=ExcelUtility.excelDataReader("RoleSearch");//Excel read for role search
		String rname=data1.get(0).get(1);		
		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		home.clickUserManagementTab();//clickUserManagementTab
		roles = home.clickRolesTab();//clickRolesTab
		roles.enterRoleName(rname);		
		String td_Search=roles.getSearchValue();
		Assert.assertEquals(rname, td_Search,ErrorMessages.INVALID_ROLE_NAME);

	}
}

