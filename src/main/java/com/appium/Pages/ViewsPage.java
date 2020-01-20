package com.appium.Pages;

import java.util.List;

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
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Drag and Drop']")
	public WebElement dragAndDrop;
	
	@AndroidFindBy(className = "android.view.View")
	public List<WebElement> dragAndDropSourceElement;
	
	@AndroidFindBy(className = "android.view.View")
	public List<WebElement> dragAndDropDestinationElement;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Date Widgets']")
	public WebElement dateWidgets;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = '2. Inline']")
	public WebElement inline;
	
	@AndroidFindBy(xpath = "//*[@content-desc = '9']")
	public WebElement clickOnNineForSwipe;
	
	@AndroidFindBy(xpath = "//*[@content-desc = '15']")
	public WebElement sourceSwipe;
	
	@AndroidFindBy(xpath = "//*[@content-desc = '30']")
	public WebElement destinationSwipe;
	
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
	
	public void dragAndDrop()
	{
		dragAndDrop.click();
		
		WebElement source = dragAndDropSourceElement.get(0);
		WebElement destination = dragAndDropDestinationElement.get(1);
		TestUtility.dragAndDrop(source, destination);
	}
	
	public void swipe()
	{
		dateWidgets.click();
		inline.click();
		clickOnNineForSwipe.click();
		
		TestUtility.swipe(sourceSwipe, destinationSwipe);
	}
}

