package seliPro1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selivtiger {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.get("https://demo.vtiger.com/vtigercrm/index.php");
         WebElement username=driver.findElement(By.id("username"));
         username.clear();
         username.sendKeys("admin");
         WebElement pwd=driver.findElement(By.id("password"));
         pwd.clear();
         pwd.sendKeys("Test@123");
         driver.findElement(By.className("buttonBlue")).click();
	}

}
