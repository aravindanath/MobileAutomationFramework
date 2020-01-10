package com.appium.android.Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DialCallNumbersTest 
{
	URL url;
	AndroidDriver<WebElement> driver;
	
	@BeforeMethod
	public void openDialer() throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "PavanEmulator");
		capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		
		capabilities.setCapability("appPackage", "com.google.android.apps.nexuslauncher");
		capabilities.setCapability("appActivity", "com.google.android.apps.nexuslauncher.NexusLauncherActivity");
		
		url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test(priority=1)
	public void dialCallNumbersTest() throws InterruptedException
	{
		driver.findElementByXPath("//*[contains(@text, 'Phone')]").click();
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
