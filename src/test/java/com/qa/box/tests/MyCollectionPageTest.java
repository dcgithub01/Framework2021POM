package com.qa.box.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.box.pages.AllPages;
import com.qa.box.pages.LoginPage;
import com.qa.box.pages.MyCollectionPage;
import com.qa.box.utils.Constants;

public class MyCollectionPageTest extends BasePageTest {
	
	AllPages ap;
	MyCollectionPage cp;
	
	@BeforeClass()
	public void CollectionSetup() throws InterruptedException
	{
 		Thread.sleep(4000);
 		ap=lp.doLogIn(prop.getProperty("email"), prop.getProperty("password"));
 		Thread.sleep(4000);
		cp=ap.navigateToCollectionsPage();
		
		
	}
	
	@Test(priority=1)
	public void verifyCollectionHeader()
	{
		String header=cp.verifyCollectionHeader();
		Assert.assertEquals(header, Constants.COLLECTION_HEADER);
		
	}
	
	@Test(priority=2)
	public void isCollectionBtnDisplay() {
	
	Assert.assertTrue(cp.isCreateCollectionBtnDisplayed());

}
	@Test(priority=3)
	public void isCollectionBtnEnable()
	{
		Assert.assertTrue(cp.isCreateCollectionBtnEnabled());
	}
	
	@Test(priority=4)
	public void doVerifyCollectionPopupHeader() {
		String headertext=cp.getCollectionPopUpHeader();
		Assert.assertEquals(headertext, Constants.COLLECTION_POPUP_HEADER);
	}
	
	@Test(priority=5)
	public void doCreateNewCollection() throws InterruptedException
	{
		cp.doCreateCollection(prop.getProperty("CollectionName"));
	}
	
	@Test(priority=6)
	public void doVerifyConfirmationMessage()
	{
		Assert.assertTrue(cp.doVerifyConfirmationMessage());
		
	}
}
