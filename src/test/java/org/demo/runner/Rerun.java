package org.demo.runner;

import org.demo.base.CommonUtility;
import org.demo.base.AllureReportUtility;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
					features			=	"@src/test/resources/RerunFeatures",
					glue				=	"org.demo.stepdefination",
					stepNotifications	=	true,
					plugin				=	{
												"pretty",
												"html:src/test/resources/RerunReports/HtmlReport/htmlReport.html",
												"json:src/test/resources/RerunReports/JsonReport/jsonReport.json",
												"junit:src/test/resources/RerunReports/JunitReport/junitReport.xml",
												"rerun:src/test/resources/RerunFeatures/FailedScenarioCapture.txt"
											}
				)
public class Rerun extends CommonUtility{
	@BeforeClass
	public static void setUp() {
		AllureReportUtility.startReport("src/test/resources/RerunReports/ExtendReport/extentReport.html");
	}
	@AfterClass
	public static void tearDown() {
		generateJvmReport("src/test/resources/RerunReports/JVM Report", "src/test/resources/RerunReports/JsonReport/jsonReport.json");
		AllureReportUtility.endReport();
	}
}
