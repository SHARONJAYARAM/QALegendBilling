package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UsersPage extends TestHelperUtility {
	public WebDriver driver;

	public UsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private final String _userSearchBox="//input[@class='form-control input-sm']";//Finding search box
	@FindBy(xpath=_userSearchBox)
	WebElement userSearchBox;
	
	private final String _tdSearchData="//tr[@role='row']//td[text()=' Jack ']";//Getting searched data	
	@FindBy(xpath=_tdSearchData)
	WebElement tdSearchData;

	private final String _tdSearchEmail="//table[@id='users_table']//tbody//td[4]";//Getting searched email	
	@FindBy(xpath=_tdSearchEmail)
	WebElement tdSearchEmail;
	
	public void enterUserName(String user_name) {//Searching role name
		page.enterText(userSearchBox, user_name);
		wait.waitForElementToBeVisible(driver, tdSearchData);
	}
	public void enterSearchUserName(String userName) {//Searching username for user update
		page.enterText(userSearchBox, userName);
		wait.waitForElementToBeVisible(driver, tdSearchEmail);
	}

	
	public String getSearchValue() {//Fetching searched value
		String tdSearch = page.getElementText(tdSearchData);
		return tdSearch;		
	}
	
	public String getSearchedEmail() {//Fetching searched email value
		wait.waitForElementToBeVisible(driver, tdSearchEmail);
		String tdSearchemail = page.getElementText(tdSearchEmail);
		return tdSearchemail;		
	}
	
//	private final String _addButton="//span[text()='User Management']";//Getting searched data	
//	@FindBy(xpath=_addButton)
//	WebElement addButton;
	
	
//	public CreatePage clickOnAddButton() {
//		page.clickOnElement(addButton);
//		return new CreatePage(driver);
//		}
	
	
//	private final String _addButton = "//a[@class='btn btn-block btn-primary']";
//	@FindBy(xpath = _addButton)
//	private WebElement addButton;

//	private final String _deleteButton = "//button[@class='btn btn-xs btn-danger delete_user_button']";
//	@FindBy(xpath = _deleteButton)
//	private WebElement deleteButton;

//	private final String _editButton = "//a[@class='btn btn-block btn-primary']";
//	@FindBy(xpath = _editButton)
//	private WebElement editButton;

//	private final String _searchEmail = "//input[@class='form-control input-sm']";
//	@FindBy(xpath = _searchEmail)
//	private WebElement searchEmail;

//	private final String _userEmailField = "//table[@id='users_table']//tbody//td[4]";
//	@FindBy(xpath = _userEmailField)
//	private WebElement userEmailField;

//	private final String _okButton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
//	@FindBy(xpath = _okButton)
//	private WebElement okButton;
	
//	private final String _noRecordFoundField = "//td[@class='dataTables_empty']";
//	@FindBy(xpath = _noRecordFoundField)
//	private WebElement noRecordFoundField;
	
//	public CreatePage clickOnAddButton() {
//		page.clickOnElement(addButton);
//		return new CreatePage(driver);
//	}

//	public void clickOnDeleteButton() {
//		wait.waitForElementToBeVisible(driver, deleteButton);
//		page.clickOnElement(deleteButton);
//
//	}
//
//	public void clickOkButton() {
//		page.clickOnElement(okButton);
//	}

//	public void setValidEmail(String email) {
//		wait.waitForElementToBeVisible(driver, searchEmail);
//		page.enterText(searchEmail, email);
//	}
//
//	public String getValidEmail() {
//		wait.waitForElementToBeVisible(driver, userEmailField);
//		String email = page.getElementText(userEmailField);
//		return email;
//
//	}
//	public String getEmptyTableText() {
//		
//		wait.waitForElementToBeVisible(driver, noRecordFoundField);
//		String emptyText= page.getElementText(noRecordFoundField);
//		return emptyText;
//	}

//	public EditUserPage clickOnEditButton() {
//		page.clickOnElement(editButton);
//		return new EditUserPage(driver);
//
//	}
	
//	**********************************************************************************
//	*************************************************************************************
	
	private final String _addButton = "//a[@class='btn btn-block btn-primary']";
	@FindBy(xpath = _addButton)
	private WebElement addButton;

	private final String _deleteButton = "//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath = _deleteButton)
	private WebElement deleteButton;

	private final String _editButton = "//a[@class='btn btn-xs btn-primary']";//edit button
//	private final String _editButton = "//a[@class='btn btn-xs btn-primary']";//edit button
	
	//table[@id='users_table']//tbody//td[5]//a[@class='btn btn-xs btn-primary']
	@FindBy(xpath = _editButton)
	private WebElement editButton;

	private final String _searchEmail = "//input[@class='form-control input-sm']";
	@FindBy(xpath = _searchEmail)
	private WebElement searchEmail;

	private final String _userEmailField = "//table[@id='users_table']//tbody//td[4]";
	@FindBy(xpath = _userEmailField)
	private WebElement userEmailField;

	private final String _okButton = "//button[@class='swal-button swal-button--confirm swal-button--danger']";
	@FindBy(xpath = _okButton)
	private WebElement okButton;
	
	private final String _noRecordFoundField = "//td[@class='dataTables_empty']";
	@FindBy(xpath = _noRecordFoundField)
	private WebElement noRecordFoundField;
	
	public CreatePage clickOnAddButton() {
		page.clickOnElement(addButton);
		return new CreatePage(driver);
	}

	public void clickOnDeleteButton() {
		wait.waitForElementToBeVisible(driver, deleteButton);
		page.clickOnElement(deleteButton);

	}
	public EditUserPage clickOnEditButton() {//edit button click
		wait.waitForElementToBeVisible(driver, editButton);
		page.clickOnElement(editButton);
		return new EditUserPage(driver);

	}
//	public EditUserPage clickOnUpdateButton() {//update button click
//	page.clickOnElement(updateButton);
//	return new EditUserPage(driver);
//	}
	
	public void clickOkButton() {
		page.clickOnElement(okButton);
	}

	public void setValidEmail(String email) {
		wait.waitForElementToBeVisible(driver, searchEmail);
		page.enterText(searchEmail, email);
	}

	public String getValidEmail() {
		wait.waitForElementToBeVisible(driver, userEmailField);
		String email = page.getElementText(userEmailField);
		return email;

	}
	public String getEmptyTableText() {
		
		wait.waitForElementToBeVisible(driver, noRecordFoundField);
		String emptyText= page.getElementText(noRecordFoundField);
		return emptyText;
	}


	

//	
//	public EditUserPage updateEmail() {
//		page.clickOnElement(updateButton);
//		return new EditUserPage(driver);
//	}
	
//	private final String _updateEmailField = "//input[@id='email']";//update email field
//	@FindBy(xpath = _updateEmailField)
//	private WebElement updateEmailField;
	
//public EditUserPage enterEmail(String update_email) {//Update email
//	    updateEmailField.clear();
//		page.enterText(updateEmailField, update_email);
//		wait.waitForElementToBeVisible(driver, tdSearchData);
//		return new EditUserPage(driver);
//	}

	
	
}
