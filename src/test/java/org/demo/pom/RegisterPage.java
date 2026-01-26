package org.demo.pom;

import java.awt.event.KeyEvent;

import org.demo.base.CommonUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends CommonUtility {
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id = 'gender-male']")
	private WebElement genderMale;

	@FindBy(xpath = "//input[@id = 'gender-female']")
	private WebElement genderFemale;

	@FindBy(id = "FirstName")
	private WebElement firstName;

	@FindBy(id = "LastName")
	private WebElement lastName;

	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(id = "ConfirmPassword")
	private WebElement confirmPassword;

	@FindBy(id = "register-button")
	private WebElement registerBtn;

	@FindBy(xpath = "//div[@class='page registration-page']/descendant::span[@for='Email']")
	private WebElement registerEmailWarning;

	@FindBy(xpath = "//div[@class='page registration-page']/descendant::span[@for='ConfirmPassword']")
	private WebElement registerConfirmPasswordWarning;

	@FindBy(xpath = "//div[@class = 'result']")
	private WebElement registerCompletedText;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getGenderMale() {
		return genderMale;
	}

	public WebElement getGenderFemale() {
		return genderFemale;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getConfirmPassword() {
		return confirmPassword;
	}

	public WebElement getRegisterBtn() {
		return registerBtn;
	}

	public WebElement getRegisterEmailWarning() {
		return registerEmailWarning;
	}

	public WebElement getRegisterConfirmPasswordWarning() {
		return registerConfirmPasswordWarning;
	}

	public WebElement getRegisterCompleteText() {
		return registerCompletedText;
	}

	int time = getIntValueFromProperties("waitingTime");

	public void registerAllDetails() {
		click(getGenderMale(), time);
		sendKeys(getFirstName(), getStringValueFromProperties("firstName"), time);
		sendKeys(getLastName(), getStringValueFromProperties("lastName"), time);
		sendKeys(getEmail(), getStringValueFromProperties("email"), time);
		sendKeys(getPassword(), getStringValueFromProperties("password"), time);
		sendKeys(getConfirmPassword(), getStringValueFromProperties("password"), time);
	}

	public void registerMandatoryOnly() {
		sendKeys(getFirstName(), getStringValueFromProperties("firstName"), time);
		sendKeys(getLastName(), getStringValueFromProperties("lastName"), time);
		sendKeys(getEmail(), getStringValueFromProperties("email"), time);
		sendKeys(getPassword(), getStringValueFromProperties("password"), time);
		sendKeys(getConfirmPassword(), getStringValueFromProperties("password"), time);
	}

	public void registerInvalidEmail() {
		sendKeys(getEmail(), getStringValueFromProperties("password"), time);
		keyboardKeyPress(KeyEvent.VK_TAB);
	}

	public void registerInvalidPassword() {
		sendKeys(getPassword(), getStringValueFromProperties("password"), time);
		sendKeys(getConfirmPassword(), getStringValueFromProperties("email"), time);
		keyboardKeyPress(KeyEvent.VK_TAB);
	}
}
