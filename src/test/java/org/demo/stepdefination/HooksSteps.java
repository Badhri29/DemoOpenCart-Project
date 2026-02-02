package org.demo.stepdefination;

import org.demo.base.AllureReportUtility;
import org.demo.base.CommonUtility;
import org.demo.pom.PomManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksSteps extends CommonUtility{
	
	@Before()
	public void setUp(Scenario sc) {
		AllureReportUtility.createTest(sc);
//		String browser = "chrome".toUpperCase();
//		launchBorwser(browser);
//		String url = "https://demowebshop.tricentis.com/";
//		launchUrl(url);
		
	}
	
	@After
	public void tearDown(Scenario sc) {
		byte[] bytee = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		sc.attach(bytee, "image/png", sc.getName()+"_line_"+sc.getLine());
		AllureReportUtility.logger(sc);
		closeBrowser(0);
		PomManager.setPomManager(null);
		extentAndLoggerReport(HooksSteps.class,"Browser closing sucess");
		
	}
}
