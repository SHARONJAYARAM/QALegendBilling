package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class EditUserPage extends TestHelperUtility {
	public WebDriver driver;
	public EditUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	public void enterUserName(String user_name) {//Searching role name
//		page.enterText(userSearchBox, user_name);
//		wait.waitForElementToBeVisible(driver, tdSearchData);
//	}
	
	
	
	private final String _updateButton = "//button[@id='submit_user_button']";//update button
	@FindBy(xpath = _updateButton)
	private WebElement updateButton;
	
	
	private final String _tdSearchData="//table[@id='users_table']//tbody//td[4]";//Getting searched email	
	@FindBy(xpath=_tdSearchData)
	WebElement tdSearchData;
	
	

	public UsersPage clickOnUpdateButton() {//click update button
//		wait.waitForElementToBeVisible(driver, deleteButton);
		page.clickOnElement(updateButton);
		return new UsersPage(driver);
	}
	
	private final String _updateEmailField = "//input[@id='email']";//update email field
	@FindBy(xpath = _updateEmailField)
	private WebElement updateEmailField;
	
	public void enterEmail(String update_email) {//Update email
	    updateEmailField.clear();
		page.enterText(updateEmailField, update_email);
//		wait.waitForElementToBeVisible(driver, tdSearchData);

	}
	

}
