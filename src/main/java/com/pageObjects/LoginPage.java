package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends AbstractPageDriver {

	By username_fld = By.id("username");
	By password_fld = By.id("password");
	By login_btn = By.cssSelector(".radius");
	By message_txt = By.id("flash");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * The method is aimed at entering the username which was passed by argument
	 * in command line
	 * 
	 * @param username
	 */
	public void enterUsername(String username) {
		getUniqueElement(username_fld).clear();
		getUniqueElement(username_fld).sendKeys(username);
	}

	/**
	 * The method is aimed at entering the password which was passed by argument
	 * in command line
	 * 
	 * @param password
	 */
	public void enterPassword(String password) {
		getUniqueElement(password_fld).clear();
		getUniqueElement(password_fld).sendKeys(password);
	}

	/**
	 * The method is aimed at clicking on Login button in login page
	 * 
	 * @return The object of SecureAreaPage passing the driver
	 */
	public SecureAreaPage clickOnLoginButton() {
		getUniqueElement(login_btn).click();
		return new SecureAreaPage(driver);
	}

	/**
	 * The method is aimed at getting the text name of element of the page
	 * 
	 * @return text name
	 */
	public String getMessageLogIn() {
		return getMessage(message_txt);
	}

}
