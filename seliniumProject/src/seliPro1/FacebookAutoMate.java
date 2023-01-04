package seliPro1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookAutoMate {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver cdriver=new ChromeDriver();
		cdriver.get("https://www.facebook.com/");
		String pageTitle=cdriver.getTitle();
		System.out.println("Page Title is :"+pageTitle);
		System.out.println("Page title validation: "+pageTitle.equals("Facebook – log in or sign up"));
		cdriver.close();
	}

}
