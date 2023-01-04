package seliPro1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocateElements {

	public static void main(String[] args) {
		// setup the required driver executable path using - System.setProperty(String
		// key, String value)
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		// create an instance of required browser driver class
		// example for runtime poly- Inheritance, upcasting & overriding
		WebDriver driver = new ChromeDriver();
		// enter the required URL
		driver.get("https://demo.actitime.com/login.do");
		//type user name as admin
		/**Identify username input field by using findElement method of WebDiver which
		 * returns: WebElement
		 * parameter: By --> predefined class having several static methods to locate the element from application
		 * 					 these method are logically know as Locators in selenium
		 * */
		WebElement usernameInputField=driver.findElement(By.id("username"));
		/**
		 * Once you identify the WebElement perform required action on it
		 * click ----> click()
		 * type  ----> sendKeys("");
		 * delete existing text ---> clear();
		 */ 
		usernameInputField.sendKeys("admin");
		/*Identify password field */
		WebElement passwordInputField=driver.findElement(By.name("pwd"));
		/*type password*/
		passwordInputField.sendKeys("manager");
		
		/*identify login button*/
		WebElement loginBtn=driver.findElement(By.id("loginButton"));
		/*click on login button*/
		loginBtn.click();
		
		//close the browser
		driver.close();
	}
}
/**
Open chrome browser
Enter actitime url
type user name as admin
type password as manager
click on login button

*/