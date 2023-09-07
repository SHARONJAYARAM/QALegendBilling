package com.qalegendbilling.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.qalegendbilling.utilities.TestHelperUtility;

public class DeleteUserPage extends TestHelperUtility {
	public WebDriver driver;
	public DeleteUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
