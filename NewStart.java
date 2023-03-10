package automation_Testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class NewStart 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driverExe/chromedriver.exe");
	}
	public static void main(String[] args) throws AWTException, InterruptedException 
	{
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		driver.findElement(By.xpath("//span[.='Admin']")).click();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys("Sivabalaji");
		driver.findElement(By.xpath("(//div[@class='oxd-select-text--after'])[1]")).click();
		Robot rd = new Robot();
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyRelease(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_TAB);
		rd.keyRelease(KeyEvent.VK_TAB);
		driver.findElement(By.xpath("//input[@placeholder='Type for hints...']")).sendKeys("P");
		Thread.sleep(3000);
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyRelease(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_ENTER);
		rd.keyRelease(KeyEvent.VK_ENTER);
		rd.keyPress(KeyEvent.VK_TAB);
		rd.keyRelease(KeyEvent.VK_TAB);
		rd.keyPress(KeyEvent.VK_DOWN);
		rd.keyRelease(KeyEvent.VK_DOWN);
		rd.keyPress(KeyEvent.VK_TAB);
		rd.keyRelease(KeyEvent.VK_TAB);		
		
		//*[@id='app']/div[1]/div[1]/aside/nav/div[2]
		//div[@class='oxd-toast-container oxd-toast-container--bottom']
	}

}
