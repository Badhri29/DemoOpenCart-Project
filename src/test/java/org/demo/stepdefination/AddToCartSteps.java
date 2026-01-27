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
	public void theUserEntersAValidProductNameInTheSearchField(String productName) {
		sendKeys(pomManager.getCommonElement().getSearchField(), getStringValueFromProperties(productName), time);
	}

	@When("the user selects a product from the listing")
	public void theUserSelectsAProductFromTheListing() {
		click(pomManager.getProductListingPom().getSelectProduct(), time);
	}

	@Then("check added product should present in the cart page")
	public void checkAddedProductShouldPresentInTheCartPage() {
		staticWait(2);
		print("product name "+getText(pomManager.getCartPom().getProductName(), time));
		Assert.assertTrue("Added Product should present", getText(pomManager.getCartPom().getProductName(), time)
				.contains(getStringValueFromProperties("validProductName")));
	}

	@Then("{string} message should be displayed")
	public void aNoResultsFoundMessageShouldBeDisplayed(String searchResult) {
		Assert.assertTrue("Product Listing page should be empty",
				getText(pomManager.getProductListingPom().getSearchResult(), time).contains(searchResult));
	}

	@Then("a validation message should be displayed to enter product name")
	public void aValidationMessageShouldBeDisplayedToEnterProductName() {
	}

}
	