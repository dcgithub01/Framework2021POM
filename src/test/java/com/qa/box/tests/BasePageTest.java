package com.qa.box.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.box.basepage.BasePage;
import com.qa.box.pages.LoginPage;

public class BasePageTest {
	
	public WebDriver driver;
	public Properties prop;
	public LoginPage lp;
	public BasePage bp;

	@BeforeTest()
	public void setup() {
	      bp= new BasePage();
		 prop=bp.init_prop();
		 driver=bp.init_driver(prop);
		 lp = new LoginPage(driver);		
	} 	 
	
	@AfterTest()
	public void tear_down()
	{
		driver.quit();
	}

}
