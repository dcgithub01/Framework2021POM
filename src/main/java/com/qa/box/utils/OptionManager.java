package com.qa.box.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
 public ChromeOptions co;
public  FirefoxOptions fo;
 public Properties prop;
 
 
 public OptionManager(Properties prop) {
	
	this.prop = prop;
}

public ChromeOptions getChromeOptions()
 {
	 co= new ChromeOptions();
	 if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
	 if(Boolean.parseBoolean(System.getProperty("incognito"))) co.addArguments("--congnito");
	 return co;
	 
 }
 
 public FirefoxOptions getFireFoxOptions()
 {
	 fo= new FirefoxOptions();
	 if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--congnito");
	 return fo;
	 
	 
 }
}
