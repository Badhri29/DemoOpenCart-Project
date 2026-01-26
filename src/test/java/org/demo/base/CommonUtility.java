package org.demo.base;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class CommonUtility {
	public static WebDriver driver;

	public static WebDriver launchBorwser(String browserName) {
		List<String> args = new ArrayList<>();
		args.add("--start-maximized");
		args.add("--incognito");

		try {
			switch (browserName.toUpperCase()) {
			case "CHROME":
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments(args);
				driver = new ChromeDriver(chromeOptions);
				break;
			case "EDGE":
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments(args);
				driver = new EdgeDriver(edgeOptions);
				break;
			case "FIREFOX":
				FirefoxOptions ffOptions = new FirefoxOptions();
				ffOptions.addArguments(args);
				driver = new FirefoxDriver(ffOptions);
				break;
			default:
				throw new IllegalArgumentException("Invalid Browser Name" + browserName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		}
	}

	public static void sendKeys(WebElement element, String values, int explicityWait) {
		try {
			ExplicityWaitUtility.waitForVisibility(driver, explicityWait, element);
			ExplicityWaitUtility.waitForClickable(driver, explicityWait, element);
			element.clear();
			element.sendKeys(values);
		} catch (Exception e) {
			print(values + " sendkeys using js");
			JavaScriptUtility.sendKeysJs(driver, element, values, explicityWait);
		}
	}

	public static void click(WebElement element, int explicityWait) {
		try {
			ExplicityWaitUtility.waitForClickable(driver, explicityWait, element);
			element.click();
		} catch (Exception e) {
			print(element + " click using js");
			JavaScriptUtility.clickJs(driver, element, explicityWait);
		}
	}

	public static void screenShot(String screenshotName) {
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file = new File(
				System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShot\\" + screenshotName + ".png");
		try {
			FileHandler.copy(screenShot, file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void closeBrowser(int staticWait) {
		staticWait(staticWait);
		if (driver != null)
			driver.quit();
	}

	public static void staticWait(int staticWait) {
		try {
			Thread.sleep(staticWait * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static String getTitile() {
		try {
			return driver.getTitle();
		} catch (Exception e) {
			return JavaScriptUtility.getTitleJs(driver);
		}
	}

	public static String getText(WebElement element, int explicityWait) {
		try {
			ExplicityWaitUtility.waitForVisibility(driver, explicityWait, element);
			return element.getText();
		} catch (Exception e) {
			return JavaScriptUtility.getTextJs(driver, element, explicityWait);
		}
	}

	public static void keyboardKeyPress(int keyName) {
		try {
			Robot r = new Robot();
			r.keyPress(keyName);
			r.keyRelease(keyName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void print(String text) {
		boolean permission = getBolleanValueFromProperties("printPermission");
		if (permission) {
			System.out.println(text);
		}
	}

	public static boolean getBolleanValueFromProperties(String key) {
		Properties prop = null;
		if (prop == null)
			prop = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("src/test/resources/Datas/configure.properties");
			prop.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("configure property file load error");
		}
		return Boolean.parseBoolean(prop.getProperty(key));
	}
	
	public static String getStringValueFromProperties(String key) {
		Properties prop = null;
		if (prop == null)
			prop = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("src/test/resources/Datas/configure.properties");
			prop.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("configure property file load error");
		}
		return prop.getProperty(key);
	}

	public static int getIntValueFromProperties(String key) {
		Properties prop = null;
		if (prop == null)
			prop = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("src/test/resources/Datas/configure.properties");
			prop.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("configure property file load error");
			;
		}
		return Integer.parseInt(prop.getProperty(key));
	}

	public static void generateJvmReport(String reportStoredLocation, String jsonFileLocation) {
		try {

			File file = new File(System.getProperty("user.dir") + reportStoredLocation);
			print("file location is "+file);

			Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
			String tester = "tester", approved = "approved", manager = "manager", sprint = "sprint",
					projectName = "projectName", environment = "environment";

			Configuration con = new Configuration(file, getStringValueFromProperties(projectName));
			con.addClassifications("PlatformName", cap.getPlatformName().toString());
			con.addClassifications("BrowserName", cap.getBrowserName());
			con.addClassifications("BrowserVersion", cap.getBrowserVersion());
			con.addClassifications(environment, getStringValueFromProperties(environment));
			con.addClassifications(tester, getStringValueFromProperties(tester));
			con.addClassifications(approved, getStringValueFromProperties(approved));
			con.addClassifications(manager, getStringValueFromProperties(manager));
			con.addClassifications(sprint, getStringValueFromProperties(sprint));

			LinkedList<String> li = new LinkedList<String>();
			li.add(jsonFileLocation);

			ReportBuilder build = new ReportBuilder(li, con);
			build.generateReports();
			print("jvm report generated");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("jvm report error...");
		}
	}

}
