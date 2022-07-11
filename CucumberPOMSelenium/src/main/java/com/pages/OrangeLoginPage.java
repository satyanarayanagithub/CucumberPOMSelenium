package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeLoginPage {
	
	
private WebDriver driver;
	
	//Element by locators
	private By Loginusername = By.id("txtUsername");
	private By Loginpassword = By.id("txtPassword");
	private By loginbtn = By.id("btnLogin");
	private By forgotpassword = By.linkText("Forgot your password?");
	private By  welcomemsg = By.id("welcome");
	
	
	
	//2. Construtor
	public OrangeLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//page actions
	public String getLoginPagetitle() {
		
		return driver.getTitle();
	}
	
	public boolean validateForgotPassword() {
		
		return driver.findElement(forgotpassword).isDisplayed();
	}
	
	public void enterUsername(String username) {
		driver.findElement(Loginusername).sendKeys(username);
	}
	public void enterPassword(String password) {
		driver.findElement(Loginpassword).sendKeys(password);
	}
	public void clickloginbtn() {
		driver.findElement(loginbtn).click();
	}
	public String validateLogin() {
		return driver.findElement(welcomemsg).getText();
	}
	/*
	 * public DashBoardPage LoginwithCred(String un, String pwd) {
	 * 
	 * driver.findElement(Loginusername).sendKeys(un);
	 * driver.findElement(Loginpassword).sendKeys(pwd);
	 * driver.findElement(loginbtn).click(); return new DashBoardPage(driver); }
	 */

}
