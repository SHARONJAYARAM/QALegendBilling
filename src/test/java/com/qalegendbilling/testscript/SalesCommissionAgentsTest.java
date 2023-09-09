package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;

import com.qalegendbilling.pages.HomePage;
import com.qalegendbilling.pages.LoginPage;
//import com.qalegendbilling.pages.RolesPage;
import com.qalegendbilling.pages.SalesCommissionAgentsPage;
import com.qalegendbilling.pages.UsersPage;
import com.qalegendbilling.utilities.ExcelUtility;
import com.qalegendbilling.utilities.RandomUtility;

public class SalesCommissionAgentsTest extends Base {
	LoginPage login;
	HomePage home;
	SalesCommissionAgentsPage sales;

	UsersPage users;

	
    @Test
	public void TC_006_addSalesCommissionAgents() throws InterruptedException {
		
    	List<ArrayList<String>> data = ExcelUtility.excelDataReader("LoginPage");
		String uname = data.get(0).get(1);
		String pwrd = data.get(1).get(1);
		List<ArrayList<String>> data1 = ExcelUtility.excelDataReader("SalesCommissionAgent");
		String prefix = data1.get(0).get(1);
		String firstName = RandomUtility.getfName();
		String lastName = RandomUtility.getlName();
		String email = RandomUtility.getRandomEmail();
		String contactNo = data1.get(1).get(1);
		String address = data1.get(2).get(1);
		String salesCommissionPercentage = data1.get(3).get(1);
		login = new LoginPage(driver);
		login.enterUserName(uname);
		login.enterPassword(pwrd);
		home = login.clickSubmit();
		home.clickUserManagementTab();
		sales = home.clickSalesCommissionAgentTab();
		sales.clickOnAddButtonSales();
		sales.addSalesCommissionAgents(prefix, firstName, lastName, email, contactNo, address, salesCommissionPercentage);
		sales.clickOnSaveButtonSales();
	
//		sales.enterEmailInSearchBox(email);	
//		sales.setValidEmail(email);
//		sales.enterRoleName(email);
		sales.clickOnEditButtonSalesTest(email);
		String actEmail = sales.getValidEmailSales();
		Assert.assertEquals(email, actEmail, ErrorMessages.SALES_COMMISSION_ERROR);
	}
}
