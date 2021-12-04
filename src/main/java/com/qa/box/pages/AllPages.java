package com.qa.box.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.box.basepage.BasePage;
import com.qa.box.utils.Constants;
import com.qa.box.utils.ElementUtils;

public class AllPages extends BasePage {
	
	private WebDriver driver;
	//MyCollectionPage mc;
	//Properties prop;
	private ElementUtils elementUtil;
	
	By allfilesHeader= By.xpath("(//h1[text()='All Files'])[last()-1]");
	By newBtn= By.cssSelector("button[class*='create-dropdown-menu-toggle-button']:not([class*='btn-is-disabled'])");
	By searchInputBox= By.name("query");
	By newFolderBtn= By.cssSelector("li[aria-label='Create a new Folder']");
	By PopUpTitle = By.cssSelector(".modal-title");
	By folderName= By.name("folder-name");
	By invitePeople= By.xpath("//textarea[@placeholder='Enter email addresses to invite users']");
	By permissionDropdown= By.cssSelector("select[name='invite-permission']");
	By createBtn= By.cssSelector("button[data-resin-target='primarybutton']");
	By closeConfirmationMsgIcon= By.xpath("//button[@class='close-btn']"); 
	By CollectionsHyperlink=By.cssSelector(".MyCollectionsNavItem-label");
	By trashHyerlink = By.cssSelector("a[data-resin-target='trash']");
	
	
	public AllPages(WebDriver driver) {
		this.driver = driver;
		elementUtil= new ElementUtils(this.driver);
	}
	
	
	public String doGetPageHeader()
	{
		//return driver.findElement(allfilesHeader).getText();
	   elementUtil.waitforPresenceofElement(allfilesHeader, 15);
	   return elementUtil.doGetText(allfilesHeader);
	
	}
	
	public Boolean NewBtnIsDisplayed()
	{
		//return driver.findElement(newBtn).isDisplayed();
		elementUtil.waitforVisibilityOfElement(newBtn, 15);
		return elementUtil.isDisplayed(newBtn);
	}
	
	
	public void createNewFolder(String folderName1,String inviteppl,String permission)
	{
	   //elementUtil.waitforPageTitleContains(Constants.HOME_PAGE, 30);
	  // elementUtil.doGetText(newBtn);
	   //driver.findElement(By.xpath("(//div[contains(@class,'icon-bell-badge')])[1]")).click();
	   //driver.findElement(By.cssSelector(".modal-close-button")).click();
		elementUtil.waitforElementtillAttributeToBe(newBtn, 15, "class", "btn create-dropdown-menu-toggle-button");
	   elementUtil.waitforPresenceofElement(newBtn, 15).click();
		elementUtil.doClick(newFolderBtn);
		elementUtil.waitforPresenceofElement(folderName, 10).sendKeys(folderName1);
		elementUtil.doSendKeys(invitePeople, inviteppl);
		elementUtil.doSelectDropdownUsingSelectByText(permissionDropdown, permission);
		elementUtil.doClick(createBtn);
		elementUtil.isDisplayed(closeConfirmationMsgIcon);
		elementUtil.doClick(closeConfirmationMsgIcon);
		
		
	}
	
	public String getPopUpTitle()
	{
		//return driver.findElement(PopUpTitle).getText();
		return elementUtil.waitforPresenceofElement(PopUpTitle, 5).getText();
		
		
	}
	
	public MyCollectionPage navigateToCollectionsPage()
	{   
		elementUtil.waitforVisibilityOfElement(CollectionsHyperlink, 10);
		elementUtil.doClick(CollectionsHyperlink);
		return new MyCollectionPage(driver);
	}
	
	
	public TrashPage navigateToTrashPage()
	{   
		elementUtil.waitforVisibilityOfElement(trashHyerlink, 10);
		elementUtil.doClick(trashHyerlink);
		return new TrashPage(driver);
	}
	


}
