package org.demo.pom;

import org.demo.base.CommonUtility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends CommonUtility{
	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//select[@id='BillingNewAddress_CountryId']")
	private WebElement country;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_City']")
	private WebElement city;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_Address1']")
	private WebElement adddress;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_ZipPostalCode']")
	private WebElement pincode;
	
	@FindBy(xpath = "//input[@id='BillingNewAddress_PhoneNumber']")
	private WebElement phoneNumber;
	
	@FindBy(xpath = "(//input[@value='Continue'])[1]")
	private WebElement billingContinueBtn;
	
	@FindBy(xpath = "(//input[@value='Continue'])[2]")
	private WebElement shippingContinueBtn;
	
	@FindBy(xpath = "(//input[@value='Continue'])[3]")
	private WebElement shippingMethodBtn;
	
	@FindBy(xpath = "(//input[@value='Continue'])[4]")
	private WebElement paymentMethodBtn;
	
	@FindBy(xpath = "(//input[@value='Continue'])[5]")
	private WebElement paymentInformationBtn;
	
	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement orderConfirmationBtn;
	
	@FindBy(xpath = "//div[@class='section order-completed']/descendant::strong")
	private WebElement orderCompletedMessage;

	public WebElement getCountry() {
		return country;
	}

	public WebElement getCity() {
		return city;
	}

	public WebElement getAdddress() {
		return adddress;
	}

	public WebElement getPincode() {
		return pincode;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getBillingContinueBtn() {
		return billingContinueBtn;
	}

	public WebElement getShippingContinueBtn() {
		return shippingContinueBtn;
	}

	public WebElement getShippingMethodBtn() {
		return shippingMethodBtn;
	}

	public WebElement getPaymentMethodBtn() {
		return paymentMethodBtn;
	}

	public WebElement getPaymentInformationBtn() {
		return paymentInformationBtn;
	}

	public WebElement getOrderConfirmationBtn() {
		return orderConfirmationBtn;
	}

	public WebElement getOrderCompletedMessage() {
		return orderCompletedMessage;
	}
	
	PomManager pomManager = PomManager.getPomManager();
	int time = getIntValueFromProperties("waitingTime");
	public void checkOutProcess() {
		Select s = new Select(pomManager.getCheckoutPom().getCountry());
		s.selectByVisibleText(getStringValueFromProperties("country"));
		sendKeys(pomManager.getCheckoutPom().getCity(), getStringValueFromProperties("city"), time);
		sendKeys(pomManager.getCheckoutPom().getAdddress(), getStringValueFromProperties("address"), time);
		sendKeys(pomManager.getCheckoutPom().getPincode(), getStringValueFromProperties("zipcode"), time);
		sendKeys(pomManager.getCheckoutPom().getPhoneNumber(), getStringValueFromProperties("phoneNumber"), time);
		click(pomManager.getCheckoutPom().getBillingContinueBtn(), time);
		click(pomManager.getCheckoutPom().getShippingContinueBtn(), time);
		click(pomManager.getCheckoutPom().getShippingMethodBtn(), time);
		click(pomManager.getCheckoutPom().getPaymentMethodBtn(), time);
		click(pomManager.getCheckoutPom().getPaymentInformationBtn(), time);
		click(pomManager.getCheckoutPom().getOrderConfirmationBtn(), time);
	}
}
























