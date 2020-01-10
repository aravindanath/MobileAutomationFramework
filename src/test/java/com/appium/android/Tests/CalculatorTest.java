package com.appium.android.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.Utilities.TestUtility;

import io.appium.java_client.android.AndroidDriver;

public class CalculatorTest 
{
	URL url;
	AndroidDriver<WebElement> driver;
	
	@BeforeMethod
	public void openCalculator() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "PavanEmulator");
		capabilities.setCapability("udid", "emulator-5554");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void additionOfTwoNumbersTest()
	{
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		driver.findElementById("com.android.calculator2:id/op_add").click();
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		driver.findElementById("com.android.calculator2:id/eq").click();
		
		String actualResult = driver.findElementById("com.android.calculator2:id/result").getText();
		System.out.println("The Addition of 5 + 5 is ::: " +actualResult);
		
		Assert.assertTrue(actualResult.equalsIgnoreCase(TestUtility.additionOfTwoNumbers));
	}
	
	@Test(priority=2)
	public void multiplicationOfTwoNumbersTest()
	{
		driver.findElementById("com.android.calculator2:id/digit_5").click();
		driver.findElementById("com.android.calculator2:id/op_mul").click();
		driver.findElementById("com.android.calculator2:id/digit_8").click();
		driver.findElementById("com.android.calculator2:id/eq").click();
		
		String actualResult = driver.findElementById("com.android.calculator2:id/result").getText();
		System.out.println("The Multiplication of 5 * 8 is ::: " +actualResult);
		
		Assert.assertTrue(actualResult.equalsIgnoreCase(TestUtility.multiplicationOfTwoNumbers));
	}
	
	@AfterMethod
	public void closeCalculator()
	{
		driver.quit();
	}
}
