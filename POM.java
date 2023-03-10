package com.projects.POMclasses;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.projects.generic.Baseclasses.Base1;

public class POM extends Base1
{
	//DECLARATION
	@FindBy(name = "username")
	private WebElement userbox;
	
	@FindBy(name = "password")
	private WebElement pwdbox;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement lgbnbox;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")
	private WebElement lgbout;
	
	@FindBy(xpath = "//a[.='Logout']")
	private WebElement lgbt;
	
	@FindBy(xpath = "//span[.='Admin']")
	private WebElement admin;
	
	@FindBy(xpath = "//span[.='User Management ']")
	private WebElement usermgmt;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[1]/ul")
	private WebElement users;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement search;
		
	//INITIALIZATION
	public POM(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//UTILIZATION
	public void setLogin() 
	{
		userbox.sendKeys("Admin");
		pwdbox.sendKeys("admin123");
		lgbnbox.click();
		admin.click();
		usermgmt.click();
		users.click();
	}
	public void dart()
	{
		search.click();
	}
	public void setLogout()
	{
		lgbout.click();
		lgbt.click();
	}
}
