package org.demo.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.demo.base.CommonUtility;

public class HomePage extends CommonUtility {
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class = 'header-links']/descendant::a[@class='account'])")
	private WebElement myAccountLink;
	
	@FindBy(xpath = "(//div[@class = 'header-links']/descendant::a[@class='ico-logout'])")
	private WebElement logoutLink;
	
	@FindBy(xpath = "//div[@class='header-links']/descendant::a[@class='ico-register']")
	private WebElement registerLink;

	@FindBy(xpath = "//div[@class='header-links']/descendant::a[@class='ico-login']")
	private WebElement loginLink;

	@FindBy(xpath = "//div[@class='header-links']/descendant::a[@class='ico-cart']")
	private WebElement shoppingCartLink;

	@FindBy(xpath = "//div[@class='header-links']/descendant::a[@class='ico-wishlist']")
	private WebElement wishlistLink;

	@FindBy(id = "small-searchterms")
	private WebElement searchField;

	@FindBy(xpath = "//input[@value='Search']")
	private WebElement searchBtn;

	public WebElement getMyAccountLink() {
		return myAccountLink;
	}

	public WebElement getLogoutLink() {
		return logoutLink;
	}

	public WebElement getRegisterLink() {
		return registerLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

	public WebElement getShoppingCartLink() {
		return shoppingCartLink;
	}

	public WebElement getWishlistLink() {
		return wishlistLink;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
}
