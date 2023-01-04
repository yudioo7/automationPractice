package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	public static WebDriver driver = null;
	public static Actions action = null;
	public WebDriverWait wait;

	public WebDriver setUp(String browserName, String appUrl) {

		if (browserName.equalsIgnoreCase("Chrome")) {
			// use setup method of WebDriverManager
			// WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			// step2: create an instance of Chrome Browser
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("ie")) {
			// use setup method of WebDriverManager
			// WebDriverManager.iedriver().setup();
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			// step2: create an instance of Chrome Browser
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			// use setup method of WebDriverManager
			// WebDriverManager.firefoxdriver().setup();
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			// step2: create an instance of Chrome Browser
			driver = new FirefoxDriver();
		}
		
		// maximize browser
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		driver.get(appUrl);
		action = new Actions(driver);
		return driver;
	}

	public void performClick(WebElement element) {
		element.click();
	}

	public void typeInput(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public String getCurrentWorkingDir() {
		//String currentDir = System.getProperty("user.dir");
		return System.getProperty("user.dir");
	}

	public void copyTextFromField(WebElement element) {
		action.doubleClick(element).perform();
		element.sendKeys(Keys.chord(Keys.CONTROL, "c"));
	}

	public void pasteTextInToField(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}
	
	public void copyPasteText(WebElement textToBeCopied,WebElement textToBePasted) {
		action.doubleClick(textToBeCopied).perform();
		textToBeCopied.sendKeys(Keys.chord(Keys.CONTROL, "c"));
		textToBePasted.sendKeys(Keys.chord(Keys.CONTROL, "v"));
	}

	public void waitTillElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

//	public List<WebElement> getAllElements(String locatorType,String locatorValue){
//		//switch  case
//	}

	public String getValueFromPropertyFile(String fileName, String key) {
		Properties prop = getPropertyFile(fileName);
		return prop.getProperty(key);
	}

	public Properties getPropertyFile(String fileName) {
		String filePath = getCurrentWorkingDir() + fileName;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

	public void takeScreenshot(String fileLocation) {
		TakesScreenshot ts = (TakesScreenshot) driver;

		File screenShot = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShot, new File(fileLocation));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void performDranAndDrop(WebElement src, WebElement target) {
		action.moveToElement(src).dragAndDrop(src, target).build().perform();
	}

	public void cleanUp() {
		driver.close();
	}

	public void rightClick(WebElement option) {
		action.moveToElement(option).contextClick().build().perform();
	}

	public void mouseHoverWithCords(WebElement option, int x, int y) {
		action.moveToElement(option, x, y).perform();
	}

	public void mouseHover(WebElement element) {
		action.moveToElement(element).perform();
	}

	public void doubleClick(WebElement element) {
		action.moveToElement(element).doubleClick().perform();
	}

	public void switchToRequiredFrameUsingName(String name) {
		driver.switchTo().frame(name);
	}

	public void switchToRequiredFrameUsingWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}

	public void switchToRequiredFrameUsingIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchControlBackToMainPage() {
		driver.switchTo().defaultContent();
	}
	
	public WebElement getActiveElement() {
		return driver.switchTo().activeElement();
	}
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	public String getPageTitle(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return driver.getTitle();
	}
	
	
	
	
	
	// method to find or identify web element
	public static WebElement IndElement(By locator1 ) {
		return driver.findElement(locator1);
	}
	// methods for select dropdown
	public static void dropdown(By locator1) {
		
		WebElement skillDropdown = IndElement(locator1);
		Select selectSkill = new Select(skillDropdown);
	}
   public static void SelectVisibletext(By locator1,String value ){
	Select select=new Select(IndElement(locator1));
	select.selectByVisibleText(value);
}

   public static void SelectIndex(By locator1,int index ){
		Select select=new Select(IndElement(locator1));
		select.selectByIndex(index);
  }
   
   public static void SelectValue(By locator1,String value )
   {
		Select select=new Select(IndElement(locator1));
		select.selectByValue(value);
   }
	// title
	// currentUrl
   public String currenturl() {
		
		return driver.getCurrentUrl();
	}
   
   
public void SelectValue1(By locator1,String type,String Value)
{
	Select select = new Select(IndElement(locator1));
	switch(type) {
	case"index":
		select.selectByIndex(Integer.parseInt(Value));
		break;
		case"value":
			select.selectByValue(Value);
			break;
		case"visibletext":
			select.selectByVisibleText(Value);
			break;
			default:
				System.out.println("pass correct parameter");
				break;
	}
			}


	public Select getDropdownObject(WebElement element) {
		Select select=new Select(element);
		return select;
	}
   public String getDefaultValueFromDropdown(WebElement element) {
		Select select=getDropdownObject(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public List<WebElement> getDropdownOptionList(WebElement element) {
		Select select=getDropdownObject(element);
		return select.getOptions();
	}
   

   public String getAttributeValue(WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	public String getInnerTextValue(WebElement element) {
		return element.getText();
	}
	public String getCurrentPageURL() {
		return driver.getCurrentUrl();
	}
	public void selectDateFromCalender(WebElement celendarField,WebElement elementForCelendarMonth,WebElement elementForDate) {
		waitTillElementIsClickable(celendarField);
		celendarField.click();
		elementForCelendarMonth.click();
		elementForDate.click();
	}
  }

// attribute
	// inner text
	// Window handling ---> not now
	// Alert Handling ---> not now
	// calendar handling
