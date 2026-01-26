package org.demo.pom;

import org.demo.base.CommonUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends CommonUtility {
	public ProductDetailsPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='qty-input']")
	private WebElement quantityField;

}
