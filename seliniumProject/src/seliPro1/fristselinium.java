package seliPro1;

import org.openqa.selenium.chrome.ChromeDriver;

public class fristselinium {

public static void main(String[] args) {
		
		//set the driver executable path using System.setproperty(String key,String value)
		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		
		//create an instance of required browser class
		ChromeDriver cdriver=new ChromeDriver();

	}

}
