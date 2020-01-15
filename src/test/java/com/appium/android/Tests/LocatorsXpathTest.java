package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;

public class LocatorsXpathTest extends TestBase
{
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	}
	
	//Xpath Syntax:
	//tagName[@attribute = 'value']
	//For MobileElements, ClassName is equal to TagName.
	
	@Test(priority=1)
	public void locatorsXpathTest() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.TextView[@text = 'Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text = '3. Preference dependencies']").click();
	
		driver.findElementById("android:id/checkbox").click();
		
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		driver.findElementByClassName("android.widget.EditText").sendKeys("Hello");
		
		driver.findElementsByClassName("android.widget.Button").get(1).click();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
