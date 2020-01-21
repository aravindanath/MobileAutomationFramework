package com.appium.android.Tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.CalculatorPage;
import com.appium.Utilities.TestUtility;

public class CalculatorTest extends TestBase
{	
	CalculatorPage calculatorPage;
	
	@BeforeMethod
	public void openCalculator() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("CalculatorAppPackage"),property.getProperty("CalculatorAppActivity"));
	
		calculatorPage = new CalculatorPage(driver);
	}
	
	@Test(priority=1)
	public void additionOfTwoNumbersTest()
	{
		calculatorPage.additionOfTwoNumbers();
		
		String actualResult = driver.findElementById("com.android.calculator2:id/result").getText();
		System.out.println("The Addition of 5 + 5 is ::: " +actualResult);
		
		Assert.assertTrue(actualResult.equalsIgnoreCase(TestUtility.additionOfTwoNumbers));
	}
	
	@Test(priority=2)
	public void multiplicationOfTwoNumbersTest()
	{
		calculatorPage.multiplicationOfTwoNumbers();
		
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
