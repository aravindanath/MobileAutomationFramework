package com.appium.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.appium.BaseClass.TestBase;
import com.appium.Utilities.TestUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ViewsPage extends TestBase
{
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Views']")
	public WebElement viewsButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Expandable Lists']")
	public WebElement expandableList;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = '1. Custom Adapter']")
	public WebElement customAdapterButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'People Names']")
	public WebElement peopleNames;
	
	@AndroidFindBy(id = "android:id/title")
	public WebElement sampleMenuTitle;
	
	public ViewsPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickOnViewsButton()
	{
		viewsButton.click();
	}
	
	public void clickOnCustomAdapterButton()
	{
		customAdapterButton.click();
	}
	
	public void longPressOnPeopleNames()
	{
		TestUtility.longPress(peopleNames);
	}
	
	public void sampleMenuPresent() throws InterruptedException
	{
		TestUtility.isElementPresent(sampleMenuTitle);
	}
	
	public void tapOnExpandableList()
	{
		TestUtility.tapOnElement(expandableList);
	}
}
