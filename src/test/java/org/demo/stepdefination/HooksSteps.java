package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksSteps extends CommonUtility{
	
	@Before
	public void setUp() {
		print("----------start---------");
		launchBorwser("chrome");
		launchUrl("https://demowebshop.tricentis.com/");
	}
	
	@After
	public void tearDown(Scenario sc) {
		screenShot(sc.getName()+"_Line_"+sc.getLine());
		if(!sc.isFailed())
		closeBrowser(0);
		PomManager.setPomManager(null);
		print("----------stop---------");
	}
}
