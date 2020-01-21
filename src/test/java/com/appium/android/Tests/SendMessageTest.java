package com.appium.android.Tests;

import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.SendMessagePage;

public class SendMessageTest extends TestBase
{
	SendMessagePage sendMessagePage;
	
	@BeforeMethod
	public void openMessenger() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("HomePageAppPackage"),property.getProperty("HomePageAppActivity"));
	
		sendMessagePage = new SendMessagePage(driver);
	}
	
	@Test(priority=1)
	public void sendMessageTest() throws InterruptedException
	{
		sendMessagePage.sendMessage();
	}

	@AfterMethod
	public void closeMessenger()
	{
		driver.quit();
	}
}
