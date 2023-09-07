package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class UserAccountName extends TestHelperUtility{
	
	
public WebDriver driver;
	
	public UserAccountName(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private final String _userAccountName ="//span[text()='Sharon A']";
	@FindBy(xpath = _userAccountName)
	private WebElement userAccountName;
	
	public String getUserAccountName() {
		String user_AccountName = page.getElementText(userAccountName);
		return user_AccountName;
	}

}
