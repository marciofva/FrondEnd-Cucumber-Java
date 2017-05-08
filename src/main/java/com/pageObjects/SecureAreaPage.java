package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends AbstractPageDriver {

	By logout_btn = By.cssSelector(".icon-2x.icon-signout");
	By message_txt = By.id("flash");

	public SecureAreaPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * The method is aimed at clicking on Logout button in Secure Area Page
	 * 
	 * @return The object of Login Page passing the driver
	 */
	public LoginPage clickOnLogoutButton() {
		getUniqueElement(logout_btn).click();
		return new LoginPage(driver);
	}

	/**
	 * The method is aimed at getting the text name of element of the page
	 * 
	 * @return text name
	 */
	public String getMessageSecurePage() {
		return getMessage(message_txt);
	}

}
