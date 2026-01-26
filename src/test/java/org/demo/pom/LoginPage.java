package org.demo.pom;

import java.awt.event.KeyEvent;

import org.demo.base.CommonUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends CommonUtility {
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='validation-summary-errors']//span")
	private WebElement loginFailedWarning;

	@FindBy(xpath = "//div[@class='page login-page']/descendant::span[@for='Email']")
	private WebElement loginEmailWarning;

	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailField;

	@FindBy(id = "Password")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginBtn;

	public WebElement getLoginFailedWarning() {
		return loginFailedWarning;
	}

	public WebElement getLoginEmailWarning() {
		return loginEmailWarning;
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

	int time = getIntValueFromProperties("waitingTime");

	public void enterValidLoginDetails() {
		sendKeys(getEmailField(), getStringValueFromProperties("email"), time);
		sendKeys(getPasswordField(), getStringValueFromProperties("password"), time);
	}

	public void invalidEmailLogin() {
		sendKeys(getEmailField(), getStringValueFromProperties("password"), time);
		keyboardKeyPress(KeyEvent.VK_TAB);
	}
	
	public void invalidPasswordLogin() {
		sendKeys(getEmailField(), getStringValueFromProperties("email"), time);
		keyboardKeyPress(KeyEvent.VK_TAB);
	}
	
	public void emptyLogin() {
		getEmailField().clear();
		getPasswordField().clear();
	}
}





















