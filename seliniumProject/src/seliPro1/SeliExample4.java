package seliPro1;

import org.openqa.selenium.firefox.FirefoxDriver;

public class SeliExample4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		FirefoxDriver fdriver=new FirefoxDriver();
		fdriver.get("https://www.google.co.in/");
		String url=fdriver.getCurrentUrl();
		
		String sourceCode=fdriver.getPageSource();
		System.out.println("Page source code is: "+sourceCode);
		System.out.println("***************");
		System.out.println("Current url is :"+url);
		System.out.println("***************");
        fdriver.close();
	}

}
