package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.ViewsPage;

public class SwipeTest extends TestBase
{
	ViewsPage viewsPage;
	
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	
		viewsPage = new ViewsPage(driver);
	}
	
	@Test(priority=1)
	public void swipeTest() throws InterruptedException
	{	
		viewsPage.clickOnViewsButton();
		viewsPage.swipe();
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
