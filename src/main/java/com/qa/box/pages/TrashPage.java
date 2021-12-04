package com.qa.box.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.box.basepage.BasePage;
import com.qa.box.utils.Constants;
import com.qa.box.utils.ElementUtils;

public class TrashPage extends BasePage {

	
	private WebDriver driver;
	
	
By pageHeader= By.xpath("//h1/span[text()='Trash']");
By deleteAllBtn= By.cssSelector("button[data-resin-target='deleteall']");
By restoreAllBtn= By.cssSelector("button[data-resin-target='restoreall']");
By deleteAllPopUpHeader = By.xpath("//span[text()='Delete All Items']");
By restoreAllPopUpHeader = By.xpath("//span[text()='Restore All Items']");
By cancelBtnOnPopUp = By.cssSelector("button[data-resin-target='cancel']");
By closeIconOnPopUp= By.cssSelector(".modal-close-button");
By OkBtnOnPopUp= By.cssSelector("button[data-resin-target='primarybutton']");
By deletionConfirmationMsg= By.xpath("//span[text()='All the items in the Trash have been deleted.']");
By deleteConfirmationIcon =By.cssSelector("button[aria-label='Clear Notification']");

//By deepak =By.xpath("//span[text()='The item was deleted.']");

	public TrashPage(WebDriver driver) {
		
		this.driver = driver;
		elementUtil= new ElementUtils(this.driver);
		
	}
	
	
	
	public String getPageTitle()
	{
		//elementUtil.waitforPresenceofElement(locator, timeout)
	 elementUtil.waitforPageTitleIs(Constants.TRASH_PAGE_TITLE, 10);
	 //driver.findElement(deepak);
	return elementUtil.getPageTitle();
	
	}
	
	public String getPageHeader()
	{
		return elementUtil.doGetText(pageHeader);
		
	}
	
	
	public void deleteAllItems()
	{
		elementUtil.waitforVisibilityOfElement(deleteAllBtn, 5);
		elementUtil.doClick(deleteAllBtn);
		elementUtil.doGetText(deleteAllPopUpHeader);
		elementUtil.doClick(OkBtnOnPopUp);
		
	
	}
	
	public void CanceldeleteAllItems()
	{
		elementUtil.doClick(deleteAllBtn);
		elementUtil.doGetText(deleteAllPopUpHeader);
		elementUtil.doClick(cancelBtnOnPopUp);
	}
	
	public void restoreAllItems()
	{
		elementUtil.doClick(restoreAllBtn);
		elementUtil.doGetText(restoreAllPopUpHeader);
		elementUtil.doClick(OkBtnOnPopUp);
	}
	public String deletionConfirmationMsg()
	{
		return elementUtil.doGetText(deletionConfirmationMsg);
	}
	
	public void closeDeleteConfirmationIcon()
	{
		elementUtil.doClick(deleteConfirmationIcon);
	}
	}
	

