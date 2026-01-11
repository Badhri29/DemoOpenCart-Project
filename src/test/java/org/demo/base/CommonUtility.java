package org.demo.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class CommonUtility {
	public static WebDriver driver;

	public static WebDriver launchBorwser(String browserName) {
		try {
			switch (browserName.toUpperCase()) {
			case "CHROME":
				driver = new ChromeDriver();
				break;
			case "EDGE":
				driver = new EdgeDriver();
				break;
			case "FIREFOX":
				driver = new FirefoxDriver();
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
			JavaScriptUtility.sendKeysJs(driver, element, values, explicityWait);
		}
	}

	public static void click(WebElement element, int explicityWait) {
		try {
			ExplicityWaitUtility.waitForClickable(driver, explicityWait, element);
			element.click();
		} catch (Exception e) {
			JavaScriptUtility.clickJs(driver, element, explicityWait);
		}
	}

	public static void screenShot(String screenshotName) {
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShot\\" + screenshotName);
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
}
