package com.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pageObjects.LoginPage;
import com.pageObjects.SecureAreaPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	LoginPage loginObj;

	SecureAreaPage secureObj;

	protected static final String WEB_SERVER = System.getProperty("WEB_SERVER",
			"https://the-internet.herokuapp.com/login");

	/**
	 * The BROWSER value can be passed by command line. So, for BROWSER was used
	 * this format "-Dbrowser=" as an argument
	 */
	protected static final String BROWSER = System.getProperty("browser");

	WebDriver driver;

	String currentDir, driverLocation;

	String username = "", password = "";

	/**
	 * This method aimed at setting the browser and launching the Webpage
	 */
	@Before
	public void setUp() {

		currentDir = System.getProperty("user.dir");

		if (BROWSER.equalsIgnoreCase("chrome")) {
			driverLocation = currentDir + "/src/main/resources/drivers/chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverLocation);
			driver = new ChromeDriver();
		} else {
			if (BROWSER.equalsIgnoreCase("firefox")) {
				driverLocation = currentDir + "/src/main/resources/drivers/geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", driverLocation);
				DesiredCapabilities capabilitiesf = DesiredCapabilities.firefox();
				capabilitiesf.setBrowserName("firefox");
				capabilitiesf.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				capabilitiesf.setCapability("marionette", true);
				WebDriver driverFirefox = new FirefoxDriver(capabilitiesf);
				driver = driverFirefox;
			} else {
				if (BROWSER.equalsIgnoreCase("ie")) {
					driverLocation = currentDir + "/src/main/resources/drivers/IEDriverServer.exe";
					System.setProperty("webdriver.ie.driver", driverLocation);
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
					InternetExplorerDriver driverIE = new InternetExplorerDriver(capabilities);
					driver = driverIE;
				} else {
					throw new RuntimeException("Browser '" + BROWSER + "' not supported");
				}
			}
		}

		driver.manage().window().maximize();
		loadApplication();
	}

	private void loadApplication() {
		driver.navigate().to(WEB_SERVER);
	}

	/**
	 * This method is aimed at leaving the browser
	 */
	@After
	public void shotDown() {
		driver.quit();
	}

	@Given("^I access the login page$")
	public void i_access_the_login_page() throws Throwable {
		loginObj = new LoginPage(driver);
		Assert.assertTrue("Wrong Page has been launched", driver.getTitle().equals("The Internet"));
	}

	/**
	 * The USERNAME value can be passed by command line. So, for username was
	 * used this format "-Dusername=" as an argument and the value is passed
	 * through command line when the application was run. For instance,
	 * "-Dusername=tomsmith"
	 * 
	 * For this reason 'getProperty("username")' statement was invoked below. So, contains the value of username
	 * 
	 * @throws Throwable
	 */
	@When("^I enter an username$")
	public void i_enter_an_username() throws Throwable {
		username = System.getProperty("username");
		loginObj.enterUsername(username);

		Assert.assertTrue("Invalid USERNAME", username.equals("tomsmith"));
	}

	/**
	 * The PASSWORD value can be passed by command line. So, for password was
	 * used this format "-Dpassword=" as an argument and the value is passed
	 * through command line when the application was run. For instance,
	 * "-Dpassword=SuperSecretPassword!"
	 * 
	 * For this reason 'getProperty("password")' statement was invoked below. So, contains the value of password
	 * 
	 * @throws Throwable
	 */

	@When("^I enter a password$")
	public void i_enter_a_password() throws Throwable {
		password = System.getProperty("password");
		loginObj.enterPassword(password);

		Assert.assertTrue("Invalid PASSWORD", password.equals("SuperSecretPassword!"));
	}

	/**
	 * This step is aimed at calling the click event for all buttons
	 * 
	 * @param buttonTxt
	 *            which is the Name of the button (The name should be unique for
	 *            all pages)
	 * @throws Throwable
	 */
	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String buttonTxt) throws Throwable {

		if (buttonTxt.equals("Login")) {
			secureObj = loginObj.clickOnLoginButton();
		} else if (buttonTxt.equals("Logout")) {
			loginObj = secureObj.clickOnLogoutButton();
		}
	}

	/**
	 * This step is aimed at checking if the system was logged IN successfully
	 * 
	 * @param message
	 * @throws Throwable
	 */
	@Then("^I should see the message \"([^\"]*)\" after login$")
	public void i_should_see_the_login_message(String message) throws Throwable {
		Assert.assertTrue("Wrong Message", secureObj.getMessageSecurePage().contains(message));
	}

	/**
	 * This step is aimed at checking if the system was logged OUT successfully
	 * 
	 * @param message
	 * @throws Throwable
	 */
	@Then("^I should see the message \"([^\"]*)\" after logout$")
	public void i_should_see_the_logout_message(String message) throws Throwable {
		Assert.assertTrue("Wrong Message", loginObj.getMessageLogIn().contains(message));
	}
}
