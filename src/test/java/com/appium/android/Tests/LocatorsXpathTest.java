package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.PreferencesPage;

public class LocatorsXpathTest extends TestBase
{
	PreferencesPage preferencesPage;
	
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	
		preferencesPage = new PreferencesPage(driver);
	}
	
	//tagName[@attribute = 'value']
	//For MobileElements, ClassName is equal to TagName.
	
	@Test(priority=1)
	public void locatorsXpathTest() throws InterruptedException
	{		
		preferencesPage.performLocatorsStrategy("Hello");
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
