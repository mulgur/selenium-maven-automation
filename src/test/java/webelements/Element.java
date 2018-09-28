package webelements;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Element {
	
	WebDriver driver ;
	
	@BeforeClass /// runs once for all test
	public void setUp() {
//		driver =  new ChromeDriver();
		System.out.println("Setting up WebDriver in beforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();}
	@Test
	public void WebElement() {
		
		driver.get("https://forms.zohopublic.com/murodil/form/JobApplicationForm/formperma/kOqgtfkv1dMJ4Df6k4_mekBNfNLIconAHvfdIk3CJSQ");
		WebElement email = driver.findElement(By.name("Email"));
		
		String value = email.getAttribute("value");
		String maxLength = email.getAttribute("maxLength");
		String type = email.getAttribute("type");
		String tag = email.getTagName();
		boolean b = email.isEnabled();
		
		
		System.out.println("value: " + value + "\n" +
		                    "maxLength: " + maxLength + "\n" +
				            "type: " + type + "\n" +
		                     "tag: " + tag + "\n" +
				            "isEnabled: " + b);
		
		assertEquals(value, "youremail@mail.com");
		
		email.clear();
		email.sendKeys("anotheremail@mail.com");
		
		WebElement country = driver.findElement(By.id("Address_Country"));
		Select selectCountry = new Select(country);
		
		System.out.println(selectCountry.getFirstSelectedOption().getText());
		
		String d = selectCountry.getFirstSelectedOption().getText();
		System.out.println(d);
		selectCountry.selectByIndex(67);
		
		//lets try to generate StateElementException
		
		WebElement cSalary = driver.findElement(By.name("Number"));
		assertEquals(cSalary.isDisplayed(),true);
		
		driver.findElement(By.xpath("//em[.=' Next ']" )).click();
		cSalary.sendKeys("12345");
		
		
				
		
			
		
	}

}
