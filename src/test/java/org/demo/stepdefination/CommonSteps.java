package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.base.ExplicityWaitUtility;
import org.demo.pom.PomManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
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
			click(pomManager.getCommonElement().getRegisterLink(), time);
			break;
		case "register_submit":
			click(pomManager.getRegisterPom().getRegisterBtn(), time);
			break;
		case "login_link":
			click(pomManager.getCommonElement().getLoginLink(), time);
			break;
		case "login_submit":
			click(pomManager.getLoginPom().getLoginBtn(), time);
			break;
		case "Checkout":
			click(pomManager.getCartPom().getCheckOutBtn(), time);
			break;
		case "search":
			click(pomManager.getCommonElement().getSearchBtn(), time);
			break;
		case "Add to Cart":
			click(pomManager.getCommonElement().getAddToCartBtn(), time);
			break;
		case "shopping Cart":
			click(pomManager.getCommonElement().getShoppingCartLink(), time);
			break;
		}
		extentAndLoggerReport(CommonSteps.class,"'" + name.toUpperCase() + "' button clicked");
	}

	@Given("Open Browser and launch url")
	public void openBrowserAndLaunchUrl() {
		extentAndLoggerReport(CommonSteps.class,"Browser -'" + getStringValueFromProperties("browser") + "', and URL -'"
				+ getStringValueFromProperties("url") + "' launched sucessfully");
	}

	@Then("system should display {string} message")
	public void systemShouldDisplayMessage(String name) {
		switch (name) {

		case "registrationCompleted":
			String expectedCase1 = getStringValueFromProperties(name);
			String actualCase1 = getText(pomManager.getRegisterPom().getRegisterCompleteText(), time);
			Assert.assertTrue("registration should complete", actualCase1.contains(expectedCase1));
			extentAndLoggerReport(CommonSteps.class,
					"Expected Complete Result: " + expectedCase1 + " | Actual Complete Result: " + actualCase1);
			break;

		case "registerPassword_Error":
			String expectedCase2 = getStringValueFromProperties(name);
			String actualCase2 = getText(pomManager.getRegisterPom().getRegisterConfirmPasswordWarning(), time);
			Assert.assertTrue("Password warning should display", actualCase2.contains(expectedCase2));
			extentAndLoggerReport(CommonSteps.class,"Expected Register Password Warning: " + expectedCase2
					+ " | Actual Register Password Warning: " + actualCase2);
			break;

		case "registerEmail_Error":
			String expectedCase3 = getStringValueFromProperties(name);
			String actualCase3 = getText(pomManager.getRegisterPom().getRegisterEmailWarning(), time);
			Assert.assertTrue("Register Email warning should display", actualCase3.contains(expectedCase3));
			extentAndLoggerReport(CommonSteps.class,"Expected Register Email Warning: " + expectedCase3
					+ " | Actual Register Email Warning: " + actualCase3);
			break;

		case "loginEmail_Error":
			String expectedCase4 = getStringValueFromProperties(name);
			String actualCase4 = getText(pomManager.getLoginPom().getLoginEmailWarning(), time);
			Assert.assertTrue("Login Email warning should display", actualCase4.contains(expectedCase4));
			extentAndLoggerReport(CommonSteps.class,
					"Expected Login Email Warning: " + expectedCase4 + " | Actual Login Email Warning: " + actualCase4);
			break;

		case "loginFail":
			String expectedCase5 = getStringValueFromProperties(name);
			String actualCase5 = getText(pomManager.getLoginPom().getLoginFailedWarning(), time);
			Assert.assertTrue("Login failed warning should display", actualCase5.contains(expectedCase5));
			extentAndLoggerReport(CommonSteps.class,"Expected Login Failed Warning: " + expectedCase5 + " | Actual Login Failed Warning: "
					+ actualCase5);
			break;

		case "success":
			String expectedCase6 = getStringValueFromProperties(name);
			String actualCase6 = getText(pomManager.getCommonElement().getProductAddedMessage(), time);
			Assert.assertTrue("product added to cart success message should display",
					actualCase6.contains(expectedCase6));
			extentAndLoggerReport(CommonSteps.class,"Expected Product Added Message: " + expectedCase6
					+ " | Actual Product Added Message: " + actualCase6);
			break;

		case "alert":
			String expectedCase7 = getStringValueFromProperties(name);
			ExplicityWaitUtility.waitForAlert(driver, time);
			Alert alert = driver.switchTo().alert();
			String actualCase7 = alert.getText();
			alert.accept();
			Assert.assertEquals("Alert should present", expectedCase7, actualCase7);
			extentAndLoggerReport(CommonSteps.class,"Expected Alert Text: " + expectedCase7 + " | Actual Alert Text: " + actualCase7);
			break;

		case "termsAndConditionsWarning":
			String expectedCase8 = getStringValueFromProperties(name);
			String actualCase8 = getText(pomManager.getCartPom().getTermsAndConditionWarningMessage(), time);
			Assert.assertTrue("Terms and conditions warning should display", actualCase8.contains(expectedCase8));
			extentAndLoggerReport(CommonSteps.class,
					"Expected Terms Warning: " + expectedCase8 + " | Actual Terms Warning: " + actualCase8);
			break;

		case "orderConfirm":
			String expectedCase9 = getStringValueFromProperties(name);
			String actualCase9 = getText(pomManager.getCheckoutPom().getOrderCompletedMessage(), time);
			Assert.assertTrue("Order confirmation message should display", actualCase9.contains(expectedCase9));
			extentAndLoggerReport(CommonSteps.class,
					"Expected Order Confirmation: " + expectedCase9 + " | Actual Order Confirmation: " + actualCase9);
			break;
		}
	}
}
