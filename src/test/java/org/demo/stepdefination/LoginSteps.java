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
	}

	@Then("user should navigate to home page")
	public void userShouldNavigateToHomePage() {
		Assert.assertEquals("login mail id should display", getStringValueFromProperties("email"),
				getText(pomManager.getCommonElement().getMyAccountLink(), time));
	}

	@When("enter invalid login email")
	public void enterInvalidLoginEmail() {
		pomManager.getLoginPom().invalidEmailLogin();
	}

	@When("enter invalid login password")
	public void enterInvalidLoginPassword() {
		pomManager.getLoginPom().invalidPasswordLogin();
	}

	@When("leave empty email and password")
	public void leaveEmptyEmailAndPassword() {
		pomManager.getLoginPom().emptyLogin();
	}
}
