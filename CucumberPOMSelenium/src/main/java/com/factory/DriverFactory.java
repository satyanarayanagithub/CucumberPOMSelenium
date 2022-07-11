package com.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/*
	 * This methods used to initialize thread local driver on the bases of given browser
	 * This will return web driver
	 * */
	
	public WebDriver init_driver(String browser) {
		
		switch(browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();;
			tlDriver.set(new EdgeDriver());
			break;
			default:
				System.out.println("Provide valid browser name we support Chrome & FF & Edge");
						
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	//This is used to get webdriver
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}


}
