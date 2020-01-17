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
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class LongPressTest extends TestBase
{
	@BeforeMethod
	public void openApiDemos() throws MalformedURLException
	{
		TestBase.launchAndroidDriver(property.getProperty("ApkDemoAppPackage"),property.getProperty("ApkDemoAppActivity"));
	}
	
	@Test(priority=1)
	public void longPressTest() throws InterruptedException
	{
		driver.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();                   
		
		TouchAction touchAction = new TouchAction(driver);
		WebElement expandableList = driver.findElementByXPath("//android.widget.TextView[@text = 'Expandable Lists']");
		touchAction.tap(tapOptions().withElement(element(expandableList))).perform();
		
		driver.findElementByXPath("//android.widget.TextView[@text = '1. Custom Adapter']").click();
		
		WebElement peopleNames = driver.findElementByXPath("//android.widget.TextView[@text = 'People Names']");
		touchAction.longPress(longPressOptions().withElement(element(peopleNames)).withDuration(ofSeconds(2))).release().perform();
		
		boolean elementPresent = driver.findElementById("android:id/title").isDisplayed();
		System.out.println("The Sample Menu is Present ::: " +elementPresent);
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closeApiDemos()
	{
		driver.quit();
	}
}
