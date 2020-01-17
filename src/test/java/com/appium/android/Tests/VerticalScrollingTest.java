package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;

public class VerticalScrollingTest extends TestBase
{
	@BeforeMethod
	public void openAPIDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	}
	
	@Test(priority=1)
	public void verticalScrollingTest() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))").click();
		Thread.sleep(20000);
	}
	
	@AfterMethod
	public void closeAPIDemos()
	{
		driver.quit();
	}
}
