package org.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath = "//div[@class='page login-page']/descendant::span[@for='Email']")
	private WebElement loginEmailWarning;
}
