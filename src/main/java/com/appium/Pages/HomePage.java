package com.appium.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage 
{
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Phone']")
	public WebElement phoneButton;
	
	public HomePage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnPhoneButton()
	{
		phoneButton.click();
	}		
}
