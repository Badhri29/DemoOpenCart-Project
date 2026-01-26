package org.demo.pom;

import org.demo.base.CommonUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListingPage extends CommonUtility{
	public ProductListingPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//h2[@class='product-title']/descendant::a)[1]")
	private WebElement selectProduct;
	
	public WebElement getSelectProduct() {
		return selectProduct;
	}

}
