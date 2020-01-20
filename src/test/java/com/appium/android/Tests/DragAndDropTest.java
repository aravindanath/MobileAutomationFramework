package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;
import com.appium.Pages.ViewsPage;
import com.appium.Utilities.TestUtility;

public class DragAndDropTest extends TestBase
{
	ViewsPage viewsPage;
	
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	
		viewsPage = new ViewsPage(driver);
	}
	
	@Test(priority=1)
	public void dragAndDropTest() throws InterruptedException
	{                  
		viewsPage.clickOnViewsButton();
		viewsPage.dragAndDrop();
		
		TestUtility.andriodBackClick();
		viewsPage.tapOnExpandableList();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
