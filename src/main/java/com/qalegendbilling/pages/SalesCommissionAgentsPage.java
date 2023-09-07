package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class SalesCommissionAgentsPage extends TestHelperUtility{
	
	public WebDriver driver;

	public SalesCommissionAgentsPage(WebDriver driver) {
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
	private final String _addButton = "//a[@class='btn btn-block btn-primary']";
	@FindBy(xpath = _addButton)
	private WebElement addButton;

	private final String _deleteButton = "//button[@class='btn btn-xs btn-danger delete_user_button']";
	@FindBy(xpath = _deleteButton)
	private WebElement deleteButton;

	private final String _editButton = "//a[@class='btn btn-xs btn-primary']";//edit button

	@FindBy(xpath = _editButton)
	private WebElement editButton;

	private final String _searchBoxEmail = "//input[@class='form-control input-sm']";//email search box
	@FindBy(xpath = _searchBoxEmail)
	private WebElement searchBoxEmail;
	
	private final String _emailSearchBox = "//div[@id='sales_commission_agent_table_filter']//input[@class='form-control input-sm']";//email search box
	@FindBy(xpath = _emailSearchBox)
	private WebElement emailSearchBox;

	private final String _userEmailField = "//table[@id='users_table']//tbody//td[1]";
	@FindBy(xpath = _userEmailField)
	private WebElement userEmailField;
	
	private final String _userEmailFieldSales = "//tr[@class='odd']//td[2]";
	@FindBy(xpath = _userEmailFieldSales)
	private WebElement userEmailFieldSales;
	
	

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
	public void clickOnEditButton() {//edit button click
//		wait.waitForElementToBeVisible(driver, editButton);
		page.clickOnElement(editButton);

	}
	
	public void clickOkButton() {
		page.clickOnElement(okButton);
	}

	public void setValidEmail(String email) {
		wait.waitForElementToBeVisible(driver, searchBoxEmail);
		page.enterText(searchBoxEmail, email);
	}

	public String getValidEmail() {
		String email = page.getElementText(userEmailField);
		return email;

	}
	public String getEmptyTableText() {
		
		wait.waitForElementToBeVisible(driver, noRecordFoundField);
		String emptyText= page.getElementText(noRecordFoundField);
		return emptyText;
	}


	private final String _updateEmailField = "//input[@id='email']";//update email field
	@FindBy(xpath = _updateEmailField)
	private WebElement updateEmailField;
	
//public void enterEmail(String email) {//Update email
//		page.enterText(searchBoxEmail, email);
//		wait.waitForElementToBeVisible(driver, userEmailFieldSales);
//	}

public void enterEmailInSearchBox(String email) {//Update email
//	page.enterText(searchBoxEmail, email);
	wait.waitForElementToBeVisible(driver, emailSearchBox);
//	wait.waitForElementToBeVisible(driver, userEmailField);
	page.enterText(emailSearchBox, email);
}


private final String _addButtonSales = "//button[@class='btn btn-primary btn-modal pull-right']";
@FindBy(xpath = _addButtonSales)
private WebElement addButtonSales;

public CreatePage clickOnAddButtonSales() {
	page.clickOnElement(addButtonSales);
	return new CreatePage(driver);
}

private final String _prefixField = "//input[@id='surname']";
@FindBy(xpath = _prefixField)
private WebElement prefixField;

private final String _firstNameField = "//input[@id='first_name']";
@FindBy(xpath = _firstNameField)
private WebElement firstNameField;

private final String _lastNameField = "//input[@id='last_name']";
@FindBy(xpath = _lastNameField)
private WebElement lastNameField;

private final String _emailField = "//input[@id='email']";
@FindBy(xpath = _emailField)
private WebElement emailField;

private final String _contactNoField = "//input[@id='contact_no']";
@FindBy(xpath = _contactNoField)
private WebElement contactNoField;

private final String _addressField = "//textarea[@id='address']";
@FindBy(xpath = _addressField)
private WebElement addressField;

private final String _salesCommissionPercentageField = "//input[@id='cmmsn_percent']";
@FindBy(xpath = _salesCommissionPercentageField)
private WebElement salesCommissionPercentageField;

private final String _saveAgents = "//button[@class='btn btn-primary']";
@FindBy(xpath = _saveAgents)
private WebElement saveAgents;


public void addSalesCommissionAgents(String prefix, String firstName,String lastName, String email, String contactNo, String address, String salesCommissionPercentage) {
	wait.waitForElementToBeVisible(driver, prefixField);
	page.enterText(prefixField, prefix);
	page.enterText(firstNameField, firstName);
	page.enterText(lastNameField, lastName);
	page.enterText(emailField, email);
	page.enterText(contactNoField, contactNo);
	page.enterText(addressField, address);
	page.enterText(salesCommissionPercentageField, salesCommissionPercentage);
}

public void clickOnSaveButtonSales() {
	page.clickOnElement(saveAgents);
}

public String getValidEmailSales() {
	wait.waitForElementToBeVisible(driver, userEmailFieldSales); 
	String email = page.getElementText(userEmailFieldSales);
	return email;
}

}
