
package seliPro1;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gsmirena1 {

	public static void main(String[] args) {
		// set required browser driver executable path using System.setProperty(key,value)
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// create instance of required browser class
		WebDriver driver = new ChromeDriver();
		// Maximize browser
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// enter the required URL
		driver.get("https://www.gsmarena.com");
	
		List<WebElement> links=driver.findElements(By.cssSelector(".brandmenu-v2>ul>li>a"));
		System.out.println("Links count: "+links.size());
		List<WebElement> MenuList=driver.findElements(By.cssSelector(".brandmenu-v2>ul>li>a"));
		System.out.println("inputFields count: "+MenuList.size());
        for(int i=0;i<MenuList.size();i++) {
				System.out.println(MenuList.get(i).getText());
			}
	}
}