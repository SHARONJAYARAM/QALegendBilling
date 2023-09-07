package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;
import org.openqa.selenium.support.FindBy;

public class SignoutPage extends TestHelperUtility{
	public WebDriver driver;

	public SignoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
