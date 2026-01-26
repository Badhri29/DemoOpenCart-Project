package org.demo.pom;

import org.demo.base.CommonUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends CommonUtility{
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//table[@class='cart']/descendant::a)[1]")
	private WebElement productName;

	@FindBy(xpath = "//input[@id='termsofservice']")
	private WebElement termsAndConditions;
	
	@FindBy(xpath = "//button[@value='checkout']")
	private WebElement checkOutBtn;
	
	@FindBy(xpath = "//div[@id='terms-of-service-warning-box']")
	private WebElement termsAndConditionWarningMessage;
	
	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getTermsAndConditions() {
		return termsAndConditions;
	}

	public WebElement getCheckOutBtn() {
		return checkOutBtn;
	}

	public WebElement getTermsAndConditionWarningMessage() {
		return termsAndConditionWarningMessage;
	}
	
	
}
	