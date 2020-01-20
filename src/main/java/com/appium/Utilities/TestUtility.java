package com.appium.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.appium.BaseClass.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class TestUtility extends TestBase
{	
	public static TouchAction touchAction;
	public static LongPressOptions longPressOptions;
	
	public final static int timeOut = 30;
	public final static String additionOfTwoNumbers = "10";
	public final static String multiplicationOfTwoNumbers = "40";
	
	//Function to Scroll Down Vertically.
	public static void verticalScroll(String value)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + value + "\").instance(0))").click();
	}
	
	//Function to Long Press on an Element.
	public static void longPress(WebElement element)
	{
		 try 
		 {
			 touchAction = new TouchAction(driver);
			 longPressOptions = new LongPressOptions();
			 
			 longPressOptions.withElement(ElementOption.element(element)).withDuration(ofSeconds(2));
			 touchAction.longPress(longPressOptions).release().perform();
		 } 
		 catch (NoSuchElementException excetion) 
		 {
			 excetion.printStackTrace();
		 }
	}
	
	//Function to Tap on Element.
	public static void tapOnElement(WebElement element)
	{
		try 
		{
			touchAction = new TouchAction(driver);
			touchAction.tap(tapOptions().withElement(element(element))).perform();
		} 
		catch (NoSuchElementException exception) 
		{
			exception.printStackTrace();
		}
	}
	
	//Function to Verify, Element is Present Or No.
	public static Boolean isElementPresent(WebElement element) throws InterruptedException 
	{
		try 
		{
			boolean elementPresent = element.isDisplayed();
			System.out.println("The " + element + " is Present ::: " +elementPresent);
			return elementPresent;
		} 
		catch (NoSuchElementException excetion) 
		{
			excetion.printStackTrace();
		}
		return null;
    }
	
	//Function to Wait for an Element to be Visible for Specific Time.
	public static boolean waitForVisibility(By targetElement) 
	{
        try 
        {
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.visibilityOfElementLocated(targetElement));
            return true;
        } 
        catch (TimeoutException exception) 
        {
            System.out.println("Element is Not Visible ::: " +targetElement);
            throw exception;
        }
    }
	
	//Function to Drag and Drop from Source Element to Destination Element.
	public static void dragAndDrop(WebElement sourceElement, WebElement destinationElement)
	{
		try 
		{
			touchAction = new TouchAction(driver);
			longPressOptions = new LongPressOptions();
			
			longPressOptions.withElement(ElementOption.element(sourceElement));
			touchAction.longPress(longPressOptions).moveTo(element(destinationElement)).release().perform();
		} 
		catch (ArrayIndexOutOfBoundsException exception) 
		{
			exception.printStackTrace();
		}
	}
	
	//Function to Go Back by Android Native Click.
    public static void andriodBackClick() 
    {
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
    
    //Function to Swipe from Source Element to Destination Element.
    public static void swipe(WebElement sourceElement, WebElement destinationElement)
    {
		try 
		{
			touchAction = new TouchAction(driver);
			longPressOptions = new LongPressOptions();
			
			longPressOptions.withElement(ElementOption.element(sourceElement)).withDuration(ofSeconds(2));
			touchAction.longPress(longPressOptions).moveTo(element(destinationElement)).release().perform();
		} 
		catch (NoSuchElementException exception) 
		{
			exception.printStackTrace();
		}
    }
}
