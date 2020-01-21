package com.appium.android.Tests;

import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.PhoneCallPage;

public class PhoneCallTest extends TestBase
{	
	PhoneCallPage phoneCallPage;
	
	@BeforeMethod
	public void openDialer() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("HomePageAppPackage"),property.getProperty("HomePageAppActivity"));
	
		phoneCallPage = new PhoneCallPage(driver);
	}
	
	@Test(priority=1)
	public void phoneCallTest() throws InterruptedException
	{
		phoneCallPage.clickOnPhoneButton();
		phoneCallPage.makeCall();
	}
	
	@AfterMethod
	public void closeDialer()
	{
		driver.quit();
	}
}
