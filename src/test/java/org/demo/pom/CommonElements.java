package org.demo.pom;

import org.demo.base.CommonUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonElements extends CommonUtility{

	public CommonElements() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@value='Add to cart'])[1]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[@id='bar-notification']/p")
	private WebElement productAddedMessage;
	
}
