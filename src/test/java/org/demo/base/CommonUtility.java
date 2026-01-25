package org.demo.base;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

public class CommonUtility {
	public static WebDriver driver;

	public static WebDriver launchBorwser(String browserName) {
		List <String> args = new ArrayList<>();
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
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\ScreenShot\\" + screenshotName + ".png");
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
		boolean permission = true;
		if(permission) {
			System.out.println(text);
		}
	}
	
	public static String getValueFromProperties(String key) {
		Properties prop = null;
		if(prop ==  null) prop = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream("src/test/resources/Datas/configure.properties");
			prop.load(fileInputStream);
		} catch (Exception e) {
			System.out.println("configure property file load error");;
		}
		return prop.getProperty(key);
	}
}


















