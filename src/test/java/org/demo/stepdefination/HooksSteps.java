package org.demo.stepdefination;

import org.demo.base.CommonUtility;
import org.demo.base.ExtendReportUtility;
import org.demo.pom.PomManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksSteps extends CommonUtility{
	
	@Before()
	public void setUp() {
		print("----------start---------");
		launchBorwser("chrome");
		launchUrl("https://demowebshop.tricentis.com/");
	}
	
	@After
	public void tearDown(Scenario sc) {
		byte[] bytee = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(bytee, "image/png", sc.getName()+"_line_"+sc.getLine());
		ExtendReportUtility.logger(sc);
		closeBrowser(0);
		PomManager.setPomManager(null);
		print("----------stop---------");
	}
}
