package seliPro1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class seliExample2 {

		public static void main(String[] args) {
			// setup the required driver executable path using - System.setProperty(String
			// key, String value)
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			// create an instance of required browser driver class
			//example for runtime poly- Inheritance, upcasting & overriding 
			WebDriver driver = new ChromeDriver();
			//enter the required URL
			driver.get("https://demo.automationtesting.in/Register.html");
			//get page title and print in the console
			//System.out.println("Page title is: "+driver.getTitle());
				//or
			String pageTitle=driver.getTitle();
			System.out.println("Page title is: "+pageTitle);
			System.out.println("Page title validation: "+pageTitle.equals("Register"));
			
			//get current page url
			System.out.println("Page url is: "+driver.getCurrentUrl() );
			
			//get page source code
			String sourceCode=driver.getPageSource();
			System.out.println("Page source code is: "+sourceCode);
			System.out.println("Source code lenght: "+sourceCode.length());
			//close current browser instance opened by webdriver
			driver.close();
		}
	
	}


