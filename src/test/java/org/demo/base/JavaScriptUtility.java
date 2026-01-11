package org.demo.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {
	public static void openUrlJs(WebDriver driver, String url) {
		try {
			((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void sendKeysJs(WebDriver driver, WebElement element, String value, int explicityWait) {
		try {
			ExplicityWaitUtility.waitForVisibility(driver, explicityWait, element);
			ExplicityWaitUtility.waitForClickable(driver, explicityWait, element);
			((JavascriptExecutor) driver).executeScript("arguments[0].value = ''", element);
			((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "';", element);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clickJs(WebDriver driver, WebElement webElement, int explicityWait) {
		try {
			ExplicityWaitUtility.waitForClickable(driver, explicityWait, webElement);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTitleJs(WebDriver driver) {
		try {
			return ((JavascriptExecutor) driver).executeScript("return document.title").toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String getTextJs(WebDriver driver, WebElement element, int explicityWait) {
		try {
			ExplicityWaitUtility.waitForVisibility(driver, explicityWait, element);
			return ((JavascriptExecutor) CommonUtility.driver).executeScript("return arguments[0].textContent;", element).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
