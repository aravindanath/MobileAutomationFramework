package com.appium.android.Tests;

import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;

public class SendMessageTest extends TestBase
{
	@BeforeMethod
	public void openMessenger() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("HomePageAppPackage"),property.getProperty("HomePageAppActivity"));
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
		driver.findElementById("com.google.android.apps.messaging:id/action_confirm_participants").click();
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
