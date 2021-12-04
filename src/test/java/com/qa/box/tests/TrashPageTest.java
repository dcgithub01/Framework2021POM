package com.qa.box.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.box.pages.AllPages;
import com.qa.box.pages.TrashPage;
import com.qa.box.utils.Constants;
import com.qa.box.utils.ElementUtils;

public class TrashPageTest extends BasePageTest {

	TrashPage tp;
	AllPages ap;
	
	
	@BeforeClass
	public void TrashSetUp()
	{
		ap=lp.doLogIn(prop.getProperty("email"), prop.getProperty("password"));
		tp=ap.navigateToTrashPage();
	}
	
	@Test(priority=1)
	public void getTrashPageTitleTest()
	{
		
	String pageTitle=tp.getPageTitle();
	Assert.assertEquals(pageTitle, Constants.TRASH_PAGE_TITLE);
		//Assert.assertTrue(Constants.TRASH_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void getPageHeaderTitleTest()
	{
		String headerTitle=tp.getPageHeader();
		Assert.assertEquals(headerTitle, Constants.TRASH_HEADER_TITLE);
	}
	
	@Test(priority =3)
	public void dodeleteAllFolder()
	{
		tp.deleteAllItems();
	}
	
	@Test(priority =4)
	public void verifyDeletionconfirmationMsg()
	{
		String deleteText=tp.deletionConfirmationMsg();
		System.out.println(deleteText);
		Assert.assertEquals(deleteText, Constants.TRASH_DELETE_CNFRM);
	}
	
	
	
		
	}
