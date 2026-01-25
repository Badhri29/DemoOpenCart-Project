package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;
import org.junit.Assert;

import io.cucumber.java.en.*;

public class CommonSteps extends CommonUtility {
	PomManager pomManager = PomManager.getPomManager();

	@When("click {string} button")
	public void clickButton(String name) {
		switch (name) {
		case "register_link":
			click(pomManager.getHomePom().getRegisterLink(), 2);
			break;
		case "register_submit":
			click(pomManager.getRegisterPom().getRegisterBtn(), 2);
			break;
		case "login_link":
			break;
		case "login_submit":
			break;
		case "continue":
			break;
		case "search":
			break;
		case "Add to Cart":
			break;
		}

	}

	@Given("Open Browser and launch url")
	public void openBrowserAndLaunchUrl() {
	}

	@Then("system should display {string} message")
	public void systemShouldDisplayMessage(String name) {
		switch (name) {
		case "registrationCompleted":
			Assert.assertTrue("registration should complete",
					getText(pomManager.getRegisterPom().getRegisterCompleteText(), 2)
							.contains(getValueFromProperties(name)));
			break;
		case "registerPassword":
			Assert.assertTrue("Password warning should display",
					getText(pomManager.getRegisterPom().getRegisterConfirmPasswordWarning(), 2)
					.contains(getValueFromProperties(name)));
			break;
		case "registerEmail":
			Assert.assertTrue("Email warning should display",
					getText(pomManager.getRegisterPom().getRegisterEmailWarning(), 2)
					.contains(getValueFromProperties(name)));
			break;
		case "loginEmail":
			break;
		}
	}
}
