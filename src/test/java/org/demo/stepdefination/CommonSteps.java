package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.*;

public class CommonSteps extends CommonUtility {

	public CommonSteps() {
		PageFactory.initElements(driver, this);
	}

	PomManager pomManager = PomManager.getPomManager();
	int time = getIntValueFromProperties("waitingTime");

	@When("click {string} button")
	public void clickButton(String name) {
		switch (name) {
		case "register_link":
			click(pomManager.getHomePom().getRegisterLink(), time);
			break;
		case "register_submit":
			click(pomManager.getRegisterPom().getRegisterBtn(), time);
			break;
		case "login_link":
			click(pomManager.getHomePom().getLoginLink(), time);
			break;
		case "login_submit":
			click(pomManager.getLoginPom().getLoginBtn(), time);
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
					getText(pomManager.getRegisterPom().getRegisterCompleteText(), time)
							.contains(getStringValueFromProperties(name)));
			break;

		case "registerPassword_Error":
			print(getText(pomManager.getRegisterPom().getRegisterConfirmPasswordWarning(), time));
			Assert.assertTrue("Password warning should display",
					getText(pomManager.getRegisterPom().getRegisterConfirmPasswordWarning(), time)
							.contains(getStringValueFromProperties(name)));
			break;

		case "registerEmail_Error":
			print(getText(pomManager.getRegisterPom().getRegisterEmailWarning(), time));
			Assert.assertTrue("Register Email warning should display",
					getText(pomManager.getRegisterPom().getRegisterEmailWarning(), time)
							.contains(getStringValueFromProperties(name)));
			break;

		case "loginEmail_Error":
			print(getText(pomManager.getLoginPom().getLoginEmailWarning(), time));
			Assert.assertTrue("Login Email warning should display",
					getText(pomManager.getLoginPom().getLoginEmailWarning(), time)
							.contains(getStringValueFromProperties(name)));
			break;

		case "loginFail":
			print(getText(pomManager.getLoginPom().getLoginFailedWarning(), time));
			Assert.assertTrue("Login failed warning should display",
					getText(pomManager.getLoginPom().getLoginFailedWarning(), time)
							.contains(getStringValueFromProperties(name)));
			break;
		}
	}
}
