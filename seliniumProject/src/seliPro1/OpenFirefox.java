package seliPro1;

import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenFirefox {

	public static void main(String[] args) {
		
		//set the driver executable path using System.setproperty(String key,String value)
		System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
		
		//create an instance of required browser class
		FirefoxDriver cdriver=new FirefoxDriver();
	}
}