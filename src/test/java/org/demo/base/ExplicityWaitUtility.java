package org.demo.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicityWaitUtility extends JavaScriptUtility{
	
	public static WebDriverWait wait(WebDriver driver, int explicityWait) {
		return new WebDriverWait(driver,Duration.ofSeconds(explicityWait));
	}
	
	public static void waitForClickable(WebDriver driver, int explicityWait, WebElement element) {
		try {
			wait(driver, explicityWait).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForVisibility(WebDriver driver, int explicityWait, WebElement element) {
		try {
			wait(driver, explicityWait).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void waitForAlert(WebDriver driver, int explicityWait) {
		try {
			wait(driver, explicityWait).until(ExpectedConditions.alertIsPresent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
