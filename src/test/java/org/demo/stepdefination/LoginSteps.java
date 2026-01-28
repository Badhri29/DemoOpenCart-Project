package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends CommonUtility {
	PomManager pomManager = PomManager.getPomManager();
	int time = getIntValueFromProperties("waitingTime");

	@When("enter email and password")
	public void enterEmailAndPassword() {
		pomManager.getLoginPom().enterValidLoginDetails();
		extentAndLoggerReport(LoginSteps.class,"Valid login details entered");
	}

	@Then("user should navigate to home page")
	public void userShouldNavigateToHomePage() {
		String expected = getStringValueFromProperties("email");
		String actual = getText(pomManager.getCommonElement().getMyAccountLink(), time);
		Assert.assertEquals("login mail id should display", expected, actual);
		extentAndLoggerReport(LoginSteps.class,"Expected emailID: "+expected+ " | Actual emailId: "+actual);
	}

	@When("enter invalid login email")
	public void enterInvalidLoginEmail() {
		pomManager.getLoginPom().invalidEmailLogin();
		 extentAndLoggerReport(LoginSteps.class,"Login attempted with invalid email");
	}

	@When("enter invalid login password")
	public void enterInvalidLoginPassword() {
		pomManager.getLoginPom().invalidPasswordLogin();
		extentAndLoggerReport(LoginSteps.class,"Login attempted with invalid password");
	}

	@When("leave empty email and password")
	public void leaveEmptyEmailAndPassword() {
		pomManager.getLoginPom().emptyLogin();
		extentAndLoggerReport(LoginSteps.class,"Login attempted without entering email and password");
	}
}
