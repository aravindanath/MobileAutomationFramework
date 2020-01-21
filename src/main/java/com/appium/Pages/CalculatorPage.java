package com.appium.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CalculatorPage 
{
	@AndroidFindBy(id = "com.android.calculator2:id/digit_5")
	public WebElement numberFive;
	
	@AndroidFindBy(id = "com.android.calculator2:id/digit_8")
	public WebElement numberEight;
	
	@AndroidFindBy(id = "com.android.calculator2:id/op_add")
	public WebElement addButton;
	
	@AndroidFindBy(id = "com.android.calculator2:id/op_mul")
	public WebElement multiplyButton;
	
	@AndroidFindBy(id = "com.android.calculator2:id/eq")
	public WebElement equalsButton;
	
	public CalculatorPage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void additionOfTwoNumbers()
	{
		numberFive.click();
		addButton.click();
		numberFive.click();
		equalsButton.click();
	}
	
	public void multiplicationOfTwoNumbers()
	{
		numberFive.click();
		multiplyButton.click();
		numberEight.click();
		equalsButton.click();
	}
}
