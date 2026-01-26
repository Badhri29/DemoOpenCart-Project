package org.demo.runner;

import org.demo.base.CommonUtility;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;




@RunWith(Cucumber.class)
@CucumberOptions(
					features 			= "src/test/resources/Features",
					glue 				= "org.demo.stepdefination",
					snippets 			= SnippetType.CAMELCASE,
					dryRun 				=  true,
					tags 				= "@AddToCart",
					stepNotifications 	= true,
					plugin 				= 	{
													"pretty",
													"usage:src/test/resources/Reports/UsageReport/usageReport.txt",
													"html:src/test/resources/Reports/HtmlReport/htmlReport.html",
													"json:src/test/resources/Reports/JsonReport/jsonReport.json",
													"junit:src/test/resources/Reports/JunitReport/junitReport.xml"
											}
				)
public class Run extends CommonUtility{
	@AfterClass
	public static void tearDown() {
		generateJvmReport("\\src\\test\\resources\\Reports\\JVM Report","src/test/resources/Reports/JsonReport/jsonReport.json");
	}
}
	