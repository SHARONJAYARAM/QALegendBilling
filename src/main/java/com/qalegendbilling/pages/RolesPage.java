package com.qalegendbilling.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qalegendbilling.utilities.TestHelperUtility;

public class RolesPage extends TestHelperUtility{
	public WebDriver driver;
	public RolesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	private final String _searchBox="//input[@class='form-control input-sm']";//Finding search box
	@FindBy(xpath=_searchBox)
	WebElement searchBox;
	
//	private final String _tdSearchData="//td[text()='Admin']";//Getting searched data
	private final String _tdSearchData="//tr[@class='odd']//td[text()='Admin']";//Getting searched data	
	@FindBy(xpath=_tdSearchData)
	WebElement tdSearchData;
	
	public void enterRoleName(String role_name) {//Searching role name
		page.enterText(searchBox, role_name);
		wait.waitForElementToBeVisible(driver, tdSearchData);
	}
	public String getSearchValue() {//Fetching searched value
		String tdSearch = page.getElementText(tdSearchData);
		return tdSearch;		
	}
}
