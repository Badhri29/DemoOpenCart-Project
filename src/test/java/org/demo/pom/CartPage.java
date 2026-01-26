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

	public WebElement getProductName() {
		return productName;
	}
	
	
}
	