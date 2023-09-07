package com.qalegendbilling.testscript;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qalegendbilling.automationcore.Base;
import com.qalegendbilling.constants.ErrorMessages;
import com.qalegendbilling.pages.LoginPage;
import com.qalegendbilling.pages.ResetPage;
import com.qalegendbilling.utilities.ExcelUtility;

public class ResetTest extends Base{
	ResetPage reset;
	LoginPage login;

	@Test(priority=1, description="TC_005 verify errorMessage Displayed onthe_Reset passwordPage with InavlidemailID",groups= {"Smoke"})
	public void TC_005_errorMessage_Displayed_onthe_Reset_passwordPage_with_InavlidemailID() {
		List<ArrayList<String>> data = ExcelUtility.excelDataReader("ResetPassword");
		String email = data.get(0).get(1);
		String act_ErrorMsg = data.get(1).get(1);
		login = new LoginPage(driver);
		reset = login.clickforgot();
		reset.getEmail(email);
		reset.clickResetLinkButton();
		String expEmailMsg = reset.EmailMessage();
		Assert.assertEquals(expEmailMsg, act_ErrorMsg, ErrorMessages.RESET_PASSWORD_ERROR_MESSAGE);
	}
}
