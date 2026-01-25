package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;

import io.cucumber.java.en.When;

public class RegisterSteps extends CommonUtility {
	PomManager pomManager = PomManager.getPomManager();

	@When("enter all details")
	public void enterAllDetails() {
		pomManager.getRegisterPom().registerAllDetails();
	}

	@When("enter mandatroy filed only")
	public void enterMandatroyFiledOnly() {
		pomManager.getRegisterPom().registerMandatoryOnly();
	}

	@When("enter invalid email")
	public void enterInvalidEmail() {
		pomManager.getRegisterPom().registerInvalidEmail();
	}

	@When("enter different confirm password")
	public void enterDifferentConfirmPassword() {
		pomManager.getRegisterPom().registerInvalidPassword();
	}
}
