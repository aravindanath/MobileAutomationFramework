package com.appium.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PhoneCallPage 
{
	@AndroidFindBy(id = "com.google.android.dialer:id/fab")
	public WebElement dialButton;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/nine")
	public WebElement numberNine;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/one")
	public WebElement numberone;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/six")
	public WebElement numberSix;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/four")
	public WebElement numberFour;

	@AndroidFindBy(id = "com.google.android.dialer:id/five")
	public WebElement numberFive;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/zero")
	public WebElement numberZero;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/dialpad_floating_action_button")
	public WebElement clickOnCallerButton;
	
	@AndroidFindBy(id = "com.google.android.dialer:id/incall_end_call")
	public WebElement clickOnEndCallButton;
	
	public PhoneCallPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void makeCall() throws InterruptedException
	{
		dialButton.click();
		
		numberNine.click();
		numberone.click();
		numberSix.click();
		numberFour.click();
		numberFive.click();
		numberFour.click();
		numberSix.click();
		numberZero.click();
		numberZero.click();
		numberZero.click();
		
		clickOnCallerButton.click();
		Thread.sleep(5000);
		
		clickOnEndCallButton.click();
	}	
}
