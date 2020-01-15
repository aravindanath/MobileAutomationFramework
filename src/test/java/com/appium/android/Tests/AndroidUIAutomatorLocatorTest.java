package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;

import io.appium.java_client.MobileBy;

public class AndroidUIAutomatorLocatorTest extends TestBase
{
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	}
	
	//Syntax:
	//("attribute("value")")
	
	@Test(priority=1)
	public void androidUIAutomatorLocatorTest() throws InterruptedException
	{	
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Views\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"Focus\")")).click();
		driver.findElement(MobileBy.AndroidUIAutomator("text(\"1. Vertical\")")).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
