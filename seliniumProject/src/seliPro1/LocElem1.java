package seliPro1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocElem1 {

	public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		FirefoxDriver xdriver=new FirefoxDriver();
		xdriver.get("https://demosite.executeautomation.com/Login.html");
		String pageTitle=xdriver.getTitle();
		System.out.println("Page title is: "+pageTitle);
		System.out.println("page length is "+pageTitle.length());
		System.out.println("Page url is: "+xdriver.getCurrentUrl());
		String url = xdriver.getCurrentUrl();
		System.out.println("Url Validation"+url.equals("https:demosite.executeautomation.com/Login.html"));
		WebElement usernameInputField=xdriver.findElement(By.id("UserName"));
		usernameInputField.sendKeys("excution");
		WebElement passwordInputField=xdriver.findElement(By.name("Password"));
		passwordInputField.sendKeys("admin");
		WebElement loginBtn=xdriver.findElement(By.id("loginButton"));
		//loginBtn.click();
		
	}

}
