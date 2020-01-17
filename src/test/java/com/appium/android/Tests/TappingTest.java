package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class TappingTest extends TestBase
{
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	}
	
	@Test(priority=1)
	public void tappingTest() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();
		
		TouchAction touchAction = new TouchAction(driver);
		WebElement expandableList = driver.findElementByXPath("//android.widget.TextView[@text = 'Expandable Lists']");
		touchAction.tap(tapOptions().withElement(element(expandableList))).perform();
		Thread.sleep(5000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
