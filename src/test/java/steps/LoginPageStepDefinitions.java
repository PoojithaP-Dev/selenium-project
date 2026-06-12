package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class LoginPageStepDefinitions {
	
	private WebDriver driver;
	private LoginPage loginPage;
	
	
	@Given("the user launches the SauceDemo Application")
	public void launchApplication() {
		driver = TestBase.driver;
	}
	
	@When("User login into application with username {string} and password {string}")
	public void performLogin(String username, String password) {
		driver= TestBase.driver;
		loginPage = new LoginPage(driver);
		loginPage.login(username,password);
	}
	
	@Then("Check whether login is succeed")
	public void checkValidLogin() {
		Assert.assertTrue(loginPage.isLoginedInSuccessful());
	}
	
	@Then("Check whether login is not successful")
	public void checkInvalidLogin() {
		Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
	}
	
	@When("When User login into application with username {string} and password {string}")
	public void checkLoginWithIncorrectCredentials() {
		loginPage.login("invalid_user", "incorrect");
	}
	
	@Then("Error message should be displayed")
	public void displayingOfErrorMessage() {
		Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
	}
	
}
