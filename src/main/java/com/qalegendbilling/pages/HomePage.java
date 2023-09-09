package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class HomePage extends TestHelperUtility {
	public WebDriver driver;

	public HomePage(WebDriver driver) {// creating the constructor of the home page
		this.driver = driver;
		PageFactory.initElements(driver, this);//
	}

	public String getHomePageTitle() {
		String title = page.getPageTitle(driver);
		return title;

	}

	private final String _userAccount = "//a[@class='dropdown-toggle']//span";
	@FindBy(xpath = _userAccount)
	WebElement userAccount;

	private final String _signoutField = "//a[text()='Sign Out']";
	@FindBy(xpath = _signoutField)
	WebElement signoutField;

	private final String _userManagementTab = "//span[text()='User Management']";// Finding UserManagement tab
	@FindBy(xpath = _userManagementTab)
	WebElement userManagementTab;

//	private final String _rolesTab="//span[contains(text(),'Roles')]";//Finding Roles tab
	private final String _rolesTab = "//i[@class='fa fa-briefcase']//following-sibling::span";// Finding Roles tab
	@FindBy(xpath = _rolesTab)
	WebElement rolesTab;

	private final String _userTab = "//i[@class='fa fa-user']//following-sibling::span";// Finding Roles tab
	@FindBy(xpath = _userTab)
	WebElement userTab;

	private final String _roles_Tab = "//i[@class='fa fa-briefcase']//following-sibling::span";// Finding Roles tab
	@FindBy(xpath = _roles_Tab)
	WebElement roles_Tab;

	private final String _salesCommissionAgent = "//i[@class='fa fa-handshake-o']//following-sibling::span";// Finding
																											// Roles tab
	@FindBy(xpath = _salesCommissionAgent)
	WebElement salesCommissionAgent;

//	------------------------
	private final String _userTabSearch = "//i[@class='fa fa-user']//following-sibling::span";// Finding Roles tab
	@FindBy(xpath = _userTabSearch)
	WebElement userTabSearch;// User Tab

	public String getUserAccountName() {
		String accountName = page.getElementText(userAccount);
		return accountName;
	}

	public LoginPage clickSighnoutButton() {
		page.clickOnElement(userAccount);
		page.clickOnElement(signoutField);
		return new LoginPage(driver);
	}

	public void clickUserManagementTab() {// Click on UserManagementTab
		page.clickOnElement(userManagementTab);
		wait.waitForElementToBeVisible(driver, salesCommissionAgent);
	}

	public RolesPage clickRolesTab() {// Click on RolesTab
		page.clickOnElement(rolesTab);
		return new RolesPage(driver);
	}

//	public Page clickSalesCommissionAgentsTab() {//Click on RolesTab
//		page.clickOnElement(rolesTab);
//		return new RolesPage(driver);
//	}
//	public Page clickSalesCommissionAgentsTab() {//Click on RolesTab
//		page.clickOnElement(rolesTab);
//		return new RolesPage(driver);
//	}

	public UsersPage clickUsersTab() {// Click on UserTab
		page.clickOnElement(userTabSearch);
		return new UsersPage(driver);
	}

	public boolean userMenuIsDisplayed() {
		boolean status = page.isDisplayed(userTab);
		return status;
	}

	public boolean rolesMenuIsDisplayed() {
		boolean status = page.isDisplayed(roles_Tab);
		return status;
	}

	public boolean salesMenuIsDisplayed() {
		boolean status = page.isDisplayed(salesCommissionAgent);
		return status;
	}

	public SalesCommissionAgentsPage clickSalesCommissionAgentTab() {// Click on UserManagementTab
		wait.waitForElementToBeVisible(driver, salesCommissionAgent);
		page.clickOnElement(salesCommissionAgent);
		return new SalesCommissionAgentsPage(driver);

	}
	private final String _homeTab = "//a[@href='https://qalegend.com/billing/public/home']//span";
	@FindBy(xpath = _homeTab)
	private WebElement homeTab;
public void clickOnHomeTab() {
			page.clickOnElement(homeTab);
}
	
	

}
