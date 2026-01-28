package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;

import io.cucumber.java.en.When;

public class RegisterSteps extends CommonUtility {
	
	PomManager pomManager = PomManager.getPomManager();

	@When("enter all details")
	public void enterAllDetails() {
		pomManager.getRegisterPom().registerAllDetails();
		extentAndLoggerReport(RegisterSteps.class,"Register all details entered success");
	}
	
	@When("enter mandatroy filed only")
	public void enterMandatroyFiledOnly() {
		pomManager.getRegisterPom().registerMandatoryOnly();
		extentAndLoggerReport(RegisterSteps.class,"Register all manadatroy entered success");
	}

	@When("enter invalid register email")
	public void enterInvalidRegisterEmail() {
		pomManager.getRegisterPom().registerInvalidEmail();
		extentAndLoggerReport(RegisterSteps.class,"Register invalid email entered success");
	}

	@When("enter different confirm password")
	public void enterDifferentConfirmPassword() {
		pomManager.getRegisterPom().registerInvalidPassword();
		extentAndLoggerReport(RegisterSteps.class,"Register invalid password entered success");
	}
}
