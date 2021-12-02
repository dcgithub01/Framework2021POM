package com.qa.box.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.box.basepage.BasePage;
import com.qa.box.utils.Constants;
import com.qa.box.utils.ElementUtils;

public class MyCollectionPage extends BasePage {
	private ElementUtils elementUtil;
	
	private WebDriver driver;
	
	By collectionPageHeader = By.cssSelector("h1[class='page-title']");
	By createCollectionBtn= By.cssSelector("button[class*='createButton'] span[class='btn-content']");
	By createCollectionPopup= By.cssSelector("h2[class='modal-title']");
	By collectionNameInput= By.xpath("(//input[@type='text'])[last()]");
	By collectionCancelBtn = By.cssSelector("button[data-resin-target='cancelcollection']");
	By CreateBtnOnPopup=By.cssSelector("button[data-resin-target='primarybutton']");
	By collectionCloseIcon= By.cssSelector("button[class='modal-close-button']");
	By CollectionconfirmationMessage= By.xpath("//span[contains(text(),'Created:')]");
	
	

	
	
	public MyCollectionPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil= new ElementUtils(this.driver);
		
	}
	
	
	public String verifyCollectionHeader()
	{
		
		elementUtil.waitforPresenceofElement(collectionPageHeader, 10);
		return elementUtil.doGetText(collectionPageHeader);
	
	}
	
	public boolean isCreateCollectionBtnDisplayed()
	{
		return elementUtil.isDisplayed(createCollectionBtn);
		
		
	}
	
	public boolean isCreateCollectionBtnEnabled(){
		return elementUtil.isEnabled(createCollectionBtn);
		
		
	}
	
	public void doCreateCollection(String collectionname) {
		//Thread.sleep(3000);
		//elementUtil.waitforTextToBePresentinElement(createCollectionPopup, Constants.COLLECTION_POPUP_HEADER, 10);
		elementUtil.waitforPresenceofElement(collectionNameInput, 10).sendKeys(collectionname);
		elementUtil.doClick(CreateBtnOnPopup);
	}
	
	public String getCollectionPopUpHeader()
	{
		elementUtil.waitforPresenceofElement(createCollectionBtn, 10).click();
		return elementUtil.doGetText(createCollectionPopup);
	}
	
	public boolean doVerifyConfirmationMessage() {
		
		return elementUtil.isDisplayed(CollectionconfirmationMessage);
	}
	
	

}
