package seliPro1;

import org.openqa.selenium.chrome.ChromeDriver;

public class SeliExample3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		ChromeDriver cdriver=new ChromeDriver(); 
		
		cdriver.get("https://demo.actitime.com/");
		String pageTitle=cdriver.getTitle();
		System.out.println("Page title is: "+pageTitle);
		System.out.println("Page title validation: "+pageTitle.equals("actiTIME - Login"));
		System.out.println("page length is "+pageTitle.length());
		
		System.out.println("Page url is: "+cdriver.getCurrentUrl() );
		
	
		String sourceCode=cdriver.getPageSource();
		System.out.println("Page source code is: "+sourceCode);
		System.out.println("Source code lenght: "+sourceCode.length());
		cdriver.close();
		

	}

}
