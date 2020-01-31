package com.appium.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.Utilities.TestUtility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase
{
	public static Properties property; 
	public static URL url;
	public static AndroidDriver<WebElement> driver;
	
	public TestBase()
	{
		try 
		{
			property = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/appium/Configuration/Configuration.properties");
			property.load(ip);
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static AndroidDriver<WebElement> launchAndroidDriver(String appPackage, String appActivity) throws MalformedURLException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, property.getProperty("DeviceName"));
		capabilities.setCapability(MobileCapabilityType.UDID, property.getProperty("UDID"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, property.getProperty("PlatformName"));
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, property.getProperty("PlatformVersion"));
		
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		
		url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(TestUtility.Implicit_Wait, TimeUnit.SECONDS);
		
		return driver;
	}
}