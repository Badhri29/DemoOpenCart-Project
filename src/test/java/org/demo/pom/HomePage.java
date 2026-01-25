package org.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.demo.base.CommonUtility;

public class HomePage extends CommonUtility{
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//a[@class='ico-register']")
	private WebElement registerLink;

	public WebElement getRegisterLink() {
		return registerLink;
	}
}
