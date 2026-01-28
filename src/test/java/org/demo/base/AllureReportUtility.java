package org.demo.base;

import java.util.LinkedList;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.Scenario;

public class AllureReportUtility extends CommonUtility {
	static ExtentReports extentReport;
	public static ExtentTest test;

	/**
	 * @uses Paste this method very initial execution
	*/
	public static void startReport(String extendReportStorageLocation) {
		ExtentSparkReporter extendHtmlReport = new ExtentSparkReporter(
				System.getProperty("user.dir") + extendReportStorageLocation);
		extendHtmlReport.config().setDocumentTitle(getStringValueFromProperties("projectName"));
		extendHtmlReport.config().setReportName("Cucumber Extend Report");
		extendHtmlReport.config().setOfflineMode(false);

		extentReport = new ExtentReports();
		extentReport.attachReporter(extendHtmlReport);

	}

	/**
	 * @uses Paste this method end of all execution
	*/
	public static void endReport() {
		Capabilities capabilities = ((RemoteWebDriver) driver).getCapabilities();

		extentReport.setSystemInfo("BrowserName", capabilities.getBrowserName());
		extentReport.setSystemInfo("BrowserVersion", capabilities.getBrowserVersion());
		extentReport.setSystemInfo("PlatformName", capabilities.getPlatformName().toString());

		LinkedList<String> li = new LinkedList<String>();
		li.add("tester");
		li.add("approved");
		li.add("manager");
		li.add("sprint");
		li.add("environment");
		for (String string : li) {
			extentReport.setSystemInfo(string, getStringValueFromProperties(string));
		}

		extentReport.flush();
	}

	/**
	 * @uses Paste this method before Scenario
	 */
	public static void createTest(Scenario sc) {
		test = extentReport.createTest(sc.getName());
	}

	/**
	 * @uses Paste this method after scenario
	 */
	public static void logger(Scenario sc) {
		String screenshotAs = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		switch (sc.getStatus()) {
		case PASSED:
			test.pass("Test case passed").addScreenCaptureFromBase64String(screenshotAs,
					sc.getName() + "_line_" + sc.getLine());
			break;
		case FAILED:
			test.fail("Test case failed").addScreenCaptureFromBase64String(screenshotAs,
					sc.getName() + "_line_" + sc.getLine());
			break;
		default:
			test.skip("Test case skiped").addScreenCaptureFromBase64String(screenshotAs,
					sc.getName() + "_line_" + sc.getLine());
			break;
		}
	}
}
