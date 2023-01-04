package seliPro1;

    import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class LocElem2 {

		public static void main(String[] args) {
			// setup the required driver executable path using - System.setProperty(String
			// key, String value)
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			// create an instance of required browser driver class
			// example for runtime poly- Inheritance, upcasting & overriding
			WebDriver driver = new ChromeDriver();
			//implicit wait -- Browser instance will get time to wait for element after this
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// enter the required URL
			driver.get("https://demo.actitime.com/login.do");
			System.out.println("Login page title: "+driver.getTitle());
			//type user name as admin ---> 0-30 sec, 
			driver.findElement(By.id("username")).sendKeys("admin");
			/*type password as manager */ //0-30 sec
			driver.findElement(By.name("pwd")).sendKeys("manager");
			/*click on login button, 0-30 sec*/
			driver.findElement(By.id("loginButton")).click();
			System.out.println("Home page title: "+driver.getTitle());//it will get Login page title only
			//click on logout link, 0-30 sec
			driver.findElement(By.id("logoutLink")).click();
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