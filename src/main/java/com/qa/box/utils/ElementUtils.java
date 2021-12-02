package com.qa.box.utils;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	JavaScriptUtil js;
	

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		 js = new JavaScriptUtil(this.driver);
	}
	
	public List<WebElement> doGetAllElements(By locator )
	{
		return driver.findElements(locator);
	}
	
	public int doGetListSize(By locator )
	{
		
		return driver.findElements(locator).size();
		
	}

	public WebElement doGetElement(By locator) {
		WebElement element = null;
		try {
			
			element = driver.findElement(locator);
			js.flash(element);
			
		} catch (Exception e) {
			System.out.println("issue while finding element");
			e.printStackTrace();
		}

		return element;
	}

	public void doSendKeys(By locator, String text) {
		doGetElement(locator).sendKeys(text);
	}

	public void doClick(By locator) {
		doGetElement(locator).click();
	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();
	}
	
	public boolean isDisplayed(By locator) {
		return doGetElement(locator).isDisplayed();
	}
	public boolean isEnabled(By locator) {
		return doGetElement(locator).isEnabled();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	//*******************************************WebDriverWait******************************************************
		public WebElement waitforPresenceofElement(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}

		
		public WebElement waitforVisibilityOfElement(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.visibilityOf(doGetElement(locator)));
		}

		public WebElement waitforElementToBeClickable(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		
		public Boolean waitforElementToBeSelected(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.elementToBeSelected(locator));
		}
		
		public Boolean waitforElementtillAttributeToBe(By locator, int timeout,String attribute,String value) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.attributeToBe(locator, attribute, value));
		}
		
		public Boolean waitforPageTitleIs(String title, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.titleIs(title));
		}
		
		public Boolean waitforPageTitleContains(String title, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.titleContains(title));
		}
		
		public Boolean waitforInvisiblityOfElement(By locator, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		}
		
		public Boolean waitforVerificationOfUrl(String url, int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.urlToBe(url));
		}
		
		public Boolean waitforTextToBePresentinElement(By locator, String text,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
		}
		
	
		public List<WebElement> waitforPresenceOfAllElements(By locator,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}
		public Boolean waitforElementSelectionStateToBe(By locator,int timeout,boolean selected) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, selected));
		}
		
		public List<WebElement> waitforVisiblityOfAllElements(By locator,int timeout) {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}
//Select ---->Dropdowns

	public void doSelectDropdownUsingSelectByIndex(By locator, int index) {
		Select se = new Select(doGetElement(locator));
		se.selectByIndex(index);

	}

	public void doSelectDropdownUsingSelectByText(By locator, String value) {
		Select se = new Select(doGetElement(locator));
		se.selectByVisibleText(value);

	}

	public void doSelectDropdownUsingSelectByValue(By locator, String value) {
		Select se = new Select(doGetElement(locator));
		se.selectByValue(value);

	}
//***********************SelectDrodownValue without using Select Class******************************************8

	public void doSelectValueFromTheDropdown(By locator, String value)

	{
		List<WebElement> listOfElements = driver.findElements(locator);
		for (int i = 0; i < listOfElements.size(); i++) {
			String text = listOfElements.get(i).getText();
			if (text.equalsIgnoreCase(value)) {
				listOfElements.get(i).click();
				break;
			}
		}

	}
//****************************ActionsClass*****************************************************

	public void doDragAndDrop(By src, By dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(doGetElement(src), doGetElement(dest)).build().perform();

	}

	public void doMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(doGetElement(locator)).build().perform();

	}

	public void doRightClick(By locator) {
		Actions act = new Actions(driver);
		act.contextClick(doGetElement(locator)).build().perform();

	}

	public void doSendKeysUsingActions(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(doGetElement(locator), value).build().perform();

	}

	public void doClickUsingActions(By locator) {
		Actions act = new Actions(driver);
		act.click(doGetElement(locator)).build().perform();

	}

	public void doClickAndHoldUsingActions(By locator) {
		Actions act = new Actions(driver);
		act.clickAndHold(doGetElement(locator)).build().perform();

	}



//***********************************FluentWait******************************************************
	public WebElement fluentWait(By locator,int timeout) {
	    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	            .withTimeout(Duration.ofSeconds(timeout))
	            .pollingEvery(Duration.ofSeconds(3))
	            .ignoring(NoSuchElementException.class);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

//****************************************SelectMultipleVallues from dropdown*************************************
	public void selectMultipleOptions(By locator, String... value) {
		List<WebElement> dropdownlist = driver.findElements(locator);
		if (!value[0].equalsIgnoreCase("all")) {

			int length = dropdownlist.size();
			for (int i = 0; i < length; i++) {
				System.out.println((dropdownlist.get(i).getText()));
				String text = dropdownlist.get(i).getText();
				for (int k = 0; k < value.length; k++)
					if (text.equals(value[k])) {
						dropdownlist.get(i).click();
						break;
					}
			}
		}

		else {
			try {

				for (int j = 0; j < dropdownlist.size(); j++) {
					dropdownlist.get(j).click();
				}
			} catch (Exception e) {

			}
		}
	}
}
