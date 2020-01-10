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

public class SendMessageTest 
{
	URL url;
	AndroidDriver<WebElement> driver;
	
	@BeforeMethod
	public void openMessenger() throws MalformedURLException
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
	public void sendMessageTest() throws InterruptedException
	{
		driver.findElementByXPath("//*[contains(@text, 'Messages')]").click();
		Thread.sleep(3000);
		
		driver.findElementById("com.google.android.apps.messaging:id/start_new_conversation_button").click();
		
		driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view").sendKeys("9164546000");	
		Thread.sleep(3000);
		
		driver.findElementById("com.google.android.apps.messaging:id/contact_picker_create_group").click();
		driver.findElementById("com.google.android.apps.messaging:id/compose_message_text").sendKeys("Hi, Pavan KrishnanReddy..!!");
		driver.findElementById("com.google.android.apps.messaging:id/send_message_button_container").click();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closeMessenger()
	{
		driver.quit();
	}
}
