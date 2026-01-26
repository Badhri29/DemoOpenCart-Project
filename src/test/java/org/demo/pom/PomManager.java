package org.demo.pom;

public class PomManager {
	private PomManager() {
	}

	private static PomManager pomManager;
	public static PomManager getPomManager() {
		return pomManager == null ? pomManager = new PomManager() : pomManager;
	}
	public static void setPomManager(PomManager pomManager) {
		PomManager.pomManager = pomManager;
	}
	
	private CommonElements commonElementPom;	
	public CommonElements getCommonElement() {
		return commonElementPom == null? commonElementPom = new CommonElements() : commonElementPom;
	}

	private RegisterPage registerPom;
	public RegisterPage getRegisterPom() {
		return registerPom == null? registerPom = new RegisterPage() : registerPom;
	}

	private LoginPage loginPom;
	public LoginPage getLoginPom() {
		return loginPom == null? loginPom = new LoginPage() : loginPom;
	}
	
	private ProductListingPage productListingPom;
	public ProductListingPage getProductListingPom() {
		return productListingPom == null? productListingPom = new ProductListingPage(): productListingPom;
	}
	
	private CartPage cartPom;
	public CartPage getCartPom() {
		return cartPom == null? cartPom = new CartPage(): cartPom;
	}
	
	private ProductDetailsPage productDetailsPom;
	public ProductDetailsPage getProductDetailsPom() {
		return productDetailsPom == null? productDetailsPom = new ProductDetailsPage(): productDetailsPom;
	}
	
	
	
	
	
	
	
	
	
	
}
