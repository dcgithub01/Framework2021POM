package com.qa.box.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.box.pages.AllPages;
import com.qa.box.pages.LoginPage;
import com.qa.box.utils.Constants;
import com.qa.box.utils.ExcelUtils;

public class AllPagesTest extends BasePageTest {

	AllPages ap;
	

	@BeforeClass
	public void Homesetup() throws InterruptedException {
ap=lp.doLogIn(prop.getProperty("email"), prop.getProperty("password"));
		Thread.sleep(8000);

	}

	@Test(priority = 1)
	public void verifyAllPageHeader() {
		String actualvalue = ap.doGetPageHeader();
		Assert.assertEquals(actualvalue, Constants.ALL_FILES_HEADER_, "****Incorrect title for allfiles header....");
	}

	@Test(priority = 2)
	public void verifyNewBtnIsDisplayed() {
		Boolean newButton = ap.NewBtnIsDisplayed();
		Assert.assertTrue(newButton);
	}

	@DataProvider
	public Object[][] getdatafromexcelfile() {
		Object[][] data= ExcelUtils.getDataFromExcel(Constants.SHEET_MAME);
		return data;
	}

	@Test(priority = 3, dataProvider = "getdatafromexcelfile")
	public void doCreateNewFolder(String folder, String email, String permission) {
		ap.createNewFolder(folder, email, permission);

	}

}
