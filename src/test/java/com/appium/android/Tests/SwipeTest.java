package com.appium.android.Tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.appium.BaseClass.TestBase;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class SwipeTest extends TestBase
{
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	}
	
	@Test(priority=1)
	public void swipeTest() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();                   
		driver.findElementByXPath("//android.widget.TextView[@text = 'Date Widgets']").click(); 
		driver.findElementByXPath("//android.widget.TextView[@text = '2. Inline']").click();
		driver.findElementByXPath("//*[@content-desc = '9']").click();
		
		//Solution:
		//LongPress on SourceElement for 2 Seconds and Move to DestinationElement and Release.
		TouchAction touchAction = new TouchAction(driver);
		WebElement sourceElement = driver.findElementByXPath("//*[@content-desc = '15']");
		WebElement destinationElement = driver.findElementByXPath("//*[@content-desc = '45']");
		touchAction.longPress(longPressOptions().withElement(element(sourceElement)).withDuration(ofSeconds(2))).moveTo(element(destinationElement)).release().perform();
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
