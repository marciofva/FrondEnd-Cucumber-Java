package com.pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageDriver {

	protected final WebDriver driver;
	protected WebDriverWait wait;
	protected WebElement element;
	protected List<WebElement> elements;

	public AbstractPageDriver(WebDriver driver) {
		this.driver = driver;
		wait = (new WebDriverWait(driver, 15));
	}

	/**
	 * The method aimed at checking if the element really exists and if the
	 * element is unique too
	 * 
	 * @param element
	 *            (Type: By)
	 * @return The element
	 */
	public WebElement getUniqueElement(By selector) {

		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(selector));
		} catch (RuntimeException e) {
			throw new RuntimeException("Element {'" + selector.toString() + "'} not found. [Error " + e.getMessage());
		}

		elements = driver.findElements(selector);

		Assert.assertTrue(
				"Element {'" + selector.toString() + "}' should be UNIQUE for " + this.getClass().getSimpleName(),
				(elements.size() == 1));

		return elements.get(0);
	}

	/**
	 * This method aimed at getting the text value from any element
	 * 
	 * @param element
	 *            (Type: By)
	 * @return Text description of the element
	 */
	public String getMessage(By selector) {

		try {
			return (driver.findElement(selector).getText());
		} catch (NoSuchElementException e) {
		} catch (RuntimeException f) {
			throw new RuntimeException(
					"An error has occurred trying to find the Element {'" + selector.toString() + "'}");
		}
		return "";
	}

}
