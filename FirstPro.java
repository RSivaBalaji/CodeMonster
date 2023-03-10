package testNG;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FirstPro
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driverExe/chromedriver.exe");
	}
	@Test
	public void name() throws IOException 
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		driver.get("https://www.youtube.com/");
		TakesScreenshot ref = (TakesScreenshot)driver;
		File source = ref.getScreenshotAs(OutputType.FILE);
		File target = new File("./screenshots/Image.png");
		FileUtils.copyFileToDirectory(source, target);
		driver.manage().window().minimize();
		driver.quit();
	}
}
