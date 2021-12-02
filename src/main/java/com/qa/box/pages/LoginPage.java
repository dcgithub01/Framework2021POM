package com.qa.box.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.box.basepage.BasePage;
import com.qa.box.utils.ElementUtils;

public class LoginPage extends BasePage{
	private WebDriver driver;
	private ElementUtils elementUtil;
	//Properties prop;
	
	By emailaddress = By.id("login-email");
	By nextBtn = By.id("login-submit");
	By passwrd = By.id("password-login");
	By loginBtn= By.id("login-submit-password");
	By resetBtn= By.id("reset-password-password");
	By loginHeader = By.xpath("//h1[text()='Sign In to Your Account']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil= new ElementUtils(this.driver);
		
	}
	
	public String dogetLoginPagetitle()
	{
		//return driver.getTitle();
		return elementUtil.getPageTitle();
		
		
	}
	
	public String dogetLoginHeadertitle()
	{
		//return driver.findElement(loginHeader).getText();
		return elementUtil.waitforPresenceofElement(loginHeader, 5).getText();
	}
	public AllPages doLogIn(String email, String password)
	{
		//driver.findElement(emailaddress).sendKeys(email);
		//driver.findElement(nextBtn).click();
		//driver.findElement(passwrd).sendKeys(password);
		//driver.findElement(loginBtn).click();
		elementUtil.waitforVisibilityOfElement(emailaddress, 10);
		elementUtil.doSendKeys(emailaddress, email);
		elementUtil.doClick(nextBtn);
		elementUtil.doSendKeys(passwrd, password);
		elementUtil.doClick(loginBtn);
		return new AllPages(driver);
	}

}
