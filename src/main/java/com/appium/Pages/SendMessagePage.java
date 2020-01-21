package com.appium.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SendMessagePage 
{
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = 'Messages']")
	public WebElement clickOnMessageButton;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/start_new_conversation_button")
	public WebElement clickOnConversationButton;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/recipient_text_view")
	public WebElement clickOnViewButton;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/contact_picker_create_group")
	public WebElement clickOnGroupButton;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/action_confirm_participants")
	public WebElement clickOnParticipantsButton;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/compose_message_text")
	public WebElement clickOnMessageText;
	
	@AndroidFindBy(id = "com.google.android.apps.messaging:id/send_message_button_container")
	public WebElement clickOnMessageSend;
	
	public SendMessagePage(AppiumDriver driver)
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void sendMessage()
	{
		clickOnMessageButton.click();
		clickOnConversationButton.click();
		
		clickOnViewButton.sendKeys("9164546000");
		
		clickOnGroupButton.click();
		clickOnParticipantsButton.click();
		clickOnMessageText.sendKeys("Hi, Pavan KrishnanReddy..!!");
		clickOnMessageSend.click();
	}
}
