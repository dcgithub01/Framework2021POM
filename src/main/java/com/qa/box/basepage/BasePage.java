package com.qa.box.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.box.utils.ElementUtils;
import com.qa.box.utils.OptionManager;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
 WebDriver driver;
//public ElementUtils elementUtil;
	public Properties prop;
	public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<WebDriver>();
	
	public static synchronized WebDriver getDriver()
	{
		return tldriver.get();
	}

	public WebDriver init_driver(Properties prop)
	{
		
		
		String browserName=prop.getProperty("browser");
		
		//OptionManager om= new OptionManager(prop);
		
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver= new ChromeDriver();
			tldriver.set(new ChromeDriver());
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver= new FirefoxDriver();
			tldriver.set(new FirefoxDriver());
			
		}
		else if(browserName.equalsIgnoreCase("safari"))
		{
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver= new SafariDriver();
			tldriver.set(new SafariDriver());
			
		}
		
		getDriver().manage().deleteAllCookies();

		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getDriver().get("https://account.box.com/login");
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public Properties init_prop()
	{
		
		//String env=null;
		prop= new Properties();
		//String envValue= null;
		//String path= null;
		try {
			
			
			/* envValue=System.getProperty("env");
			
				switch (envValue) {
				case "prod":
					path="../Framework2021POM/src/main/java/com/qa/box/configurations/config.properties";
					break;
				case "qa":
					path="../Framework2021POM/src/main/java/com/qa/box/configurations/qa.config.properties";
					break;
				case "dev":
					path="../Framework2021POM/src/main/java/com/qa/box/configurations/dev.config.properties";
					break;
				default:
					System.out.println("*********please enter valid value of your environment   " + envValue);
					break;
				}*/
				
			
			FileInputStream ip = new FileInputStream("../Framework2021POM/src/main/java/com/qa/box/configurations/config.properties");
		       prop.load(ip);
		     
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	public String getScreenshot()
	
	{
		String path=null;
		
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  path = System.getProperty("user.dir"+ "/Screenshots/"+System.currentTimeMillis()+".png");
		 File destination = new File(path);
		 try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return path;
	}
}
