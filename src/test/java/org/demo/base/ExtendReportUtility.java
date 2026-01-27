package org.demo.base;

import java.util.LinkedList;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.Scenario;

public class ExtendReportUtility extends CommonUtility {
	static ExtentSparkReporter extendHtmlReport;
	static ExtentReports report;
	static Capabilities capabilities;

	public static void startReport(String extendReportStorageLocation) {
		extendHtmlReport = new ExtentSparkReporter(System.getProperty("user.dir") + extendReportStorageLocation);
		extendHtmlReport.config().setDocumentTitle(getStringValueFromProperties("projectName"));
		extendHtmlReport.config().setReportName("Cucumber Extend Report");
		extendHtmlReport.config().setOfflineMode(true);

		report = new ExtentReports();
		report.attachReporter(extendHtmlReport);

	}

	public static void endReport() {
		capabilities = ((RemoteWebDriver) driver).getCapabilities();

		report.setSystemInfo("BrowserName", capabilities.getBrowserName());
		report.setSystemInfo("BrowserVersion", capabilities.getBrowserVersion());
		report.setSystemInfo("PlatformName", capabilities.getPlatformName().toString());

		LinkedList<String> li = new LinkedList<String>();
		li.add("tester");
		li.add("approved");
		li.add("manager");
		li.add("sprint");
		li.add("environment");

		for (String string : li) {
			report.setSystemInfo(string, getStringValueFromProperties(string));
		}	
		report.flush();
	}
	
	

	public static void logger(Scenario sc) {
		String screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		switch (sc.getStatus()) {
		case PASSED:
			report.createTest(sc.getName()).pass("Test case passed").addScreenCaptureFromBase64String(screenshotAs,
					sc.getName()+"_line_"+sc.getLine());
			break;
		case FAILED:
			report.createTest(sc.getName()).fail("Test case failed").addScreenCaptureFromBase64String(screenshotAs,
					sc.getName()+"_line_"+sc.getLine());
			break;
		default:
			report.createTest(sc.getName()).skip("Test case skiped").addScreenCaptureFromBase64String(screenshotAs,
					sc.getName()+"_line_"+sc.getLine());
			break;
		}
	}

}
