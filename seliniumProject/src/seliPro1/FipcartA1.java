
package seliPro1;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FipcartA1 {

	public static void main(String[] args) {
		// set required browser driver executable path using System.setProperty(key,value)
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// create instance of required browser class
		WebDriver driver = new ChromeDriver();
		// Maximize browser
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/**
		 * Use findElements(By)- this will help us to identify multiple element from Application and 
		 * returns List<WebElement>
		 * ONce you get a List<WebElement> use	
		 * 			size()- method of Java Collection to get identified element count
		 * 			get(index) - to get specific element from he list
		 */
		// enter the required URL
		driver.get("https://www.flipkart.com");
	//	driver.findElement(By.className("_2KpZ6l ")).click();
		//links present in page
		List<WebElement> links=driver.findElements(By.cssSelector("div[class=\"_331-kn _2tvxW\"]>div>div"));
		System.out.println("Links count: "+links.size());
		List<WebElement> MenuList=driver.findElements(By.cssSelector("div[class=\"_331-kn _2tvxW\"]>div>div"));
		System.out.println("inputFields count: "+MenuList.size());
for(int i=0;i<MenuList.size();i++) {
			
			System.out.println(MenuList.get(i).getText());
			}
	}
}
/**
 * if locator used in findElement(By) gives you multiple matching dn it won't throw any error instead it will
 * perform operation on the first element only
 * 
 * If used locator matching with multiple elements dn its recommended to use findElements(By), which will return 
 * List<WebElement).
 * once you get a list, use get(index) of collection for specific element
 */