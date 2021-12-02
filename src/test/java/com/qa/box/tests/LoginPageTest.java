package com.qa.box.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.box.utils.Constants;				

public class LoginPageTest extends BasePageTest {
	
	  
	 
@Test(priority=1)
public void getLoginPageTitleTest()
{
	String pagetitle=lp.dogetLoginPagetitle();
	Assert.assertEquals(pagetitle, Constants.LOGIN_PAGE_TITLE);
}

@Test(priority=2)
public void getPageHeaderTitleTest()
{
	String headerTitle=lp.dogetLoginHeadertitle();
	Assert.assertEquals(headerTitle, Constants.LOGIN_HEADER_TITLE);
}

@Test(priority=3)
public void dologinTest()
{
	lp.doLogIn(prop.getProperty("email"), prop.getProperty("password"));
}



}
