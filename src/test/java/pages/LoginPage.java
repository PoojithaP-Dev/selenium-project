package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestUtils;

public class LoginPage {

	public WebDriver driver;
	public TestUtils testUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		testUtils = new TestUtils(driver);
	}

	private By usernamefield = By.id("user-name");
	private By passwordfield = By.name("password");
	private By loginButton = By.id("login-button");
	private By errorMessageField = By.cssSelector("h3[data-test='error'");
	private By productPageTitle = By.className("header_secondary_container");

	public void enterUsername(String username) {
		driver.findElement(usernamefield).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordfield).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public void login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginButton();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessageField).getText();
	}

	public boolean isLoginedInSuccessful() {

		testUtils.waitForElement(productPageTitle);
		if (driver.getCurrentUrl().contains("inventory")) {
			return true;
		}
		return false;
	}

}
