package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CheckoutSteps extends CommonUtility {
	PomManager pomManager = PomManager.getPomManager();
	int time = getIntValueFromProperties("waitingTime");

	@Given("the user logs in with valid credentials")
	public void theUserLogsInWithValidCredentials() {

		click(pomManager.getCommonElement().getLoginLink(), time);
		pomManager.getLoginPom().enterValidLoginDetails();
		click(pomManager.getLoginPom().getLoginBtn(), time);

		extentAndLoggerReport(CheckoutSteps.class,"User logged in with valid credentials");
	}

	@Given("the user add product to the cart")
	public void theUserAddProductToTheCart() {

		sendKeys(pomManager.getCommonElement().getSearchField(), getStringValueFromProperties("validProductName"),
				time);
		click(pomManager.getCommonElement().getSearchBtn(), time);
		click(pomManager.getCommonElement().getAddToCartBtn(), time);
		click(pomManager.getCommonElement().getShoppingCartLink(), time);

		extentAndLoggerReport(CheckoutSteps.class,"Product added to cart");
	}

	@Given("user accept terms and condition")
	public void userAcceptTermsAndCondition() {

		click(pomManager.getCartPom().getTermsAndConditions(), time);

		extentAndLoggerReport(CheckoutSteps.class,"Terms and conditions accepted");
	}

	@When("process all checkout steps")
	public void processAllCheckoutSteps() {

		pomManager.getCheckoutPom().checkOutProcess();

		extentAndLoggerReport(CheckoutSteps.class,"Checkout process executed");
	}
}