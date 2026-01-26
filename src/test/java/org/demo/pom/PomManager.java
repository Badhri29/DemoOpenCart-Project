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
	
	private HomePage homePom;
	public HomePage getHomePom() {
		return homePom == null? homePom = new HomePage() : homePom;
	}

	private RegisterPage registerPom;
	public RegisterPage getRegisterPom() {
		return registerPom == null? registerPom = new RegisterPage() : registerPom;
	}

	private LoginPage loginPom;
	public LoginPage getLoginPom() {
		return loginPom == null? loginPom = new LoginPage() : loginPom;
	}
}
