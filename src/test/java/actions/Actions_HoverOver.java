package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actions_HoverOver {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
    @Ignore
	@Test
	public void action() {
		driver.get("https://www.amazon.com");

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//span[@class='nav-line-2'])[3]"));
		action.moveToElement(element).perform();
		WebElement element2 = driver.findElement(By.xpath("(//span[@class='nav-action-inner'])[1]"));
		action.moveToElement(element2).click().perform();
	}
    @Ignore
	@Test
	public void scrollDown() {
		driver.get("https://www.amazon.com");

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[.='Back to top']"));
		//action.moveToElement(element).perform();
	//	action.sendKeys(Keys.PAGE_DOWN).perform();//biraz kaydiriyor
		//action.sendKeys(Keys.ARROW_DOWN).perform();//daha da az kaydiriyor NE ISIME YARIYCAZ TIRTTTT
		
		// DAHA IYISINI BULANA KADAR EN IYISI BU !! 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	@Test
	public void dragAndDrop() {
		driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
		Actions action = new Actions(driver);
		WebElement el1 = driver.findElement(By.id("draggable"));
		WebElement el2 = driver.findElement(By.id("droptarget"));
		//action.moveToElement(el1).clickAndHold().moveToElement(el2).click().build().perform();
		action.dragAndDrop(el1, el2).perform();
		
		
	}

}
