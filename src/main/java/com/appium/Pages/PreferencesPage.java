package com.appium.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferencesPage 
{
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Preference']")
	public WebElement preferenceButton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = '3. Preference dependencies']")
	public WebElement preferenceDependenciesButton;
	
	@AndroidFindBy(id = "android:id/checkbox")
	public WebElement clickOnCheckBox;
	
	@AndroidFindBy(xpath = "(//android.widget.RelativeLayout)[2]")
	public WebElement relativeLayout;
	
	@AndroidFindBy(className = "android.widget.EditText")
	public WebElement enterMessage;
	
	@AndroidFindBy(className = "android.widget.Button")
	public List<WebElement> clickOnOKButton;
	
	public PreferencesPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void performLocatorsStrategy(String enterInput)
	{
		preferenceButton.click();
		preferenceDependenciesButton.click();
		clickOnCheckBox.click();
		relativeLayout.click();
		enterMessage.sendKeys(enterInput);
		clickOnOKButton.get(1).click();
	}
}