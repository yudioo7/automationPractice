package seliPro1;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleElemnets {

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
		driver.get("https://www.facebook.com");
		//links present in page
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Links count: "+links.size());
		List<WebElement> inputFields=driver.findElements(By.tagName("input"));
		System.out.println("inputFields count: "+inputFields.size());
		
		List<WebElement> classObject=driver.findElements(By.cssSelector(".ng-pristine"));
		System.out.println("classObject count: "+classObject.size());
		//in order to get specific element from the List use get(index)
		classObject.get(1).sendKeys("admin");
		classObject.get(2).sendKeys("manager");
		classObject.get(3).sendKeys("Deccan Pune");
		classObject.get(4).sendKeys("abc@gmail.com");
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