package com.appium.android.Tests;

import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;

public class DialCallNumbersTest extends TestBase
{	
	@BeforeMethod
	public void openDialer() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("HomePageAppPackage"),property.getProperty("HomePageAppActivity"));
	}
	
	@Test(priority=1)
	public void dialCallNumbersTest() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.TextView[@text = 'Phone']").click();
		Thread.sleep(5000);
		
		driver.findElementById("com.google.android.dialer:id/fab").click();
		Thread.sleep(5000);
		
		driver.findElementById("com.google.android.dialer:id/nine").click();
		driver.findElementById("com.google.android.dialer:id/one").click();
		driver.findElementById("com.google.android.dialer:id/six").click();
		driver.findElementById("com.google.android.dialer:id/four").click();
		driver.findElementById("com.google.android.dialer:id/five").click();
		driver.findElementById("com.google.android.dialer:id/four").click();
		driver.findElementById("com.google.android.dialer:id/six").click();
		driver.findElementById("com.google.android.dialer:id/zero").click();
		driver.findElementById("com.google.android.dialer:id/zero").click();
		driver.findElementById("com.google.android.dialer:id/zero").click();
		
		driver.findElementById("com.google.android.dialer:id/dialpad_floating_action_button").click();	
		Thread.sleep(5000);
		
		driver.findElementById("com.google.android.dialer:id/incall_end_call").click();
	}
	
	@AfterMethod
	public void closeDialer()
	{
		driver.quit();
	}
}
