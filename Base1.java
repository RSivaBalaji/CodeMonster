package com.projects.generic.Baseclasses;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import com.projects.POMclasses.POM;

public class Base1
{
	static
	{
		System.setProperty("webdriver.chrome.driver", "./driverExe/chromedriver.exe");
	}
	WebDriver driver;
	HashMap<String, String> hmap;
	String code;
	String expectedresult;
	String actualresult;
	SoftAssert sft;
	String urlcheck;
	FileInputStream fis;
	Workbook wb;
	String getdta;
	String lctdata;
	String slctdata;
	String path;
	String sndkeys;
	Robot rd;
	JavascriptExecutor ref;
	TakesScreenshot ref2;
	File source;
	File target;
	String adx;
	String actrest;
	String excted;
	@BeforeClass
	public void start() 
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(3));
	}
	@BeforeMethod()
	public void Ase()
	{
		hmap = new HashMap<String,String>();
		hmap.put("url ", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		code = hmap.get("url ");
	}
	@AfterMethod()
	public void Ace() throws EncryptedDocumentException, IOException, AWTException, InterruptedException
	{	
		driver.get(code);
		POM dase = new POM(driver);
		dase.setLogin();
		expectedresult="OrangeHRM";
		actualresult = driver.getTitle();
		sft = new SoftAssert();
		sft.assertEquals(actualresult, expectedresult);	
		urlcheck = driver.getCurrentUrl();
		sft.assertTrue(true, urlcheck);
		//sft.assertFalse(false);
		fis = new FileInputStream("./dataDrivers/Firsre.xlsx");
		wb = WorkbookFactory.create(fis);
		getdta = wb.getSheet("Sheet1").getRow(0).getCell(0).toString();
		lctdata = wb.getSheet("Sheet1").getRow(2).getCell(0).toString();
		slctdata = wb.getSheet("Sheet1").getRow(6).getCell(0).toString();
		driver.findElement(By.xpath(lctdata)).sendKeys(getdta);
		driver.findElement(By.xpath(slctdata)).click();
		rd = new Robot();
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyRelease(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_TAB);
		rd.keyRelease(KeyEvent.VK_TAB);
		path = wb.getSheet("Sheet1").getRow(8).getCell(0).toString();
		sndkeys = wb.getSheet("Sheet1").getRow(8).getCell(1).toString();
		driver.findElement(By.xpath(path)).sendKeys(sndkeys);
		Thread.sleep(3000);
		for(int i=0;i<4;i++)
		{
		rd.keyPress(KeyEvent.VK_DOWN);
		}
		rd.keyRelease(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_ENTER);
		rd.keyRelease(KeyEvent.VK_ENTER);
		rd.keyPress(KeyEvent.VK_TAB);
		rd.keyRelease(KeyEvent.VK_TAB);
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyRelease(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_TAB);
		rd.keyRelease(KeyEvent.VK_TAB);		
		dase.dart();
		ref = (JavascriptExecutor)driver;
		ref.executeScript("window.scrollTo('0','300');");
		Thread.sleep(2000);
		ref2 = (TakesScreenshot)driver;
		source = ref2.getScreenshotAs(OutputType.FILE);
		target = new File("./screenshots/Image.jpeg");
		FileUtils.copyFileToDirectory(source, target);
		adx = wb.getSheet("Sheet1").getRow(13).getCell(0).toString();
		excted="No Recors Found";
		actrest = driver.findElement(By.xpath(adx)).getText();
		sft.assertEquals(actrest, excted);
	}
	@AfterClass
	public void last() throws InterruptedException 
	{
		Thread.sleep(4000);
		POM dase = new POM(driver);
		dase.setLogout();
		Thread.sleep(5000);
		Reporter.log("Logged Out Successfully From OrangeHRM",true);
		driver.manage().window().minimize();
		driver.close();
		sft.assertAll();
	}
}
