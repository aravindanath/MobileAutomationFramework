package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.ViewsPage;
import com.appium.Utilities.TestUtility;

public class VerticalScrollingTest extends TestBase
{
	ViewsPage viewsPage;
	
	@BeforeMethod
	public void openAPIDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	
		viewsPage = new ViewsPage(driver);
	}
	
	@Test(priority=1)
	public void verticalScrollingTest() throws InterruptedException
	{
		viewsPage.clickOnViewsButton();
		
		TestUtility.verticalScroll("WebView");		
		Thread.sleep(20000);
	}
	
	@AfterMethod
	public void closeAPIDemos()
	{
		driver.quit();
	}
}
