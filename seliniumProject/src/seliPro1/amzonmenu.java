package seliPro1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class amzonmenu {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		System.out.println("Login page title: "+driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//set required window size
		driver.manage().window().setSize(new Dimension(450, 600));
		// maximize browser window
		driver.manage().window().maximize();
		driver.findElement(By.linkText("/b/32702030031?node=32702030031&ld=AZINSOANavDesktop_T2&ref_=nav_cs_sell_T2")).click();
		Thread.sleep(1500);
		System.out.println("Page title: "+driver.getTitle());
		//to come back to the previous page
				driver.navigate().back();
				Thread.sleep(1500);
		System.out.println("Home page title: "+driver.getTitle());
		//driver.findElement(By.id("logoutLink")).click();
		//driver.close();

	}

}
