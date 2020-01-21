package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.ViewsPage;
import com.appium.Utilities.TestUtility;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TappingTest extends TestBase
{
	ViewsPage viewsPage;
	
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	
		viewsPage = new ViewsPage(driver);
	}
	
	@Test(priority=1)
	public void tappingTest() throws InterruptedException
	{
		viewsPage.clickOnViewsButton();
		viewsPage.tapOnExpandableList();
		Thread.sleep(3000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
