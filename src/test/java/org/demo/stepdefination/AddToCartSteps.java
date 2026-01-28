package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps extends CommonUtility {
	PomManager pomManager = PomManager.getPomManager();
	int time = getIntValueFromProperties("waitingTime");

	@When("the user enters a {string} in the search field")
	public void theUserEntersProductNameInTheSearchField(String productName) {
		sendKeys(pomManager.getCommonElement().getSearchField(), getStringValueFromProperties(productName), time);
		extentAndLoggerReport(AddToCartSteps.class,"Product name entered in search field: " + productName);
	}

	@When("the user selects a product from the listing")
	public void theUserSelectsAProductFromTheListing() {
		click(pomManager.getProductListingPom().getSelectProduct(), time);
		extentAndLoggerReport(AddToCartSteps.class,"Product selected from the product listing");
	}

	@Then("check added product should present in the cart page")
	public void checkAddedProductShouldPresentInTheCartPage() {
		staticWait(2);

		String actualProductName = getText(pomManager.getCartPom().getProductName(), time);
		String expectedProductName = getStringValueFromProperties("validProductName");

		Assert.assertTrue("Added product should be present in the cart page",
				actualProductName.contains(expectedProductName));

		extentAndLoggerReport(AddToCartSteps.class,"Expected Product Name: " + expectedProductName + " | Actual Product Name in Cart: "
				+ actualProductName);
	}

	@Then("{string} message should be displayed")
	public void messageShouldBeDisplayed(String searchResult) {

		String actualMessage = getText(pomManager.getProductListingPom().getSearchResult(), time);

		Assert.assertTrue("Expected search result message should be displayed", actualMessage.contains(searchResult));

		extentAndLoggerReport(AddToCartSteps.class,
				"Expected Search Result Message: " + searchResult + " | Actual Message Displayed: " + actualMessage);
	}
}
