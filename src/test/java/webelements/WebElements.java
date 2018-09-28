package webelements;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElements {
	
WebDriver driver ;
	
	@BeforeClass /// runs once for all test
	public void setUp() {
//		driver =  new ChromeDriver();
		System.out.println("Setting up WebDriver in beforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
	}
	@Ignore
	@Test
	public void myLinks() {
		driver.get("https://github.com");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		//how many links on github home page
		int numberOfLinksOnGitHub = links.size();
		System.out.println("number of links :" + numberOfLinksOnGitHub);
		//print text of each link
		
		for(WebElement each : links) {
			if(!each.getText().isEmpty()) {
				System.out.println(each.getText());
			}
		}
		//add each link text into a list of Strings
		List<String> linkNames = new ArrayList<>();
		
		for(int i = 0; i < links.size(); i++) {
			if(!links.get(i).getText().isEmpty()) {
				linkNames.add(links.get(i).getText());
			}
		}
		System.out.println(linkNames);
	}
	/*
	 * navigate to https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg
	 * then find all input boxes and assign to List of webelements -> 2
	 * then find all drop down boxes and assign to List of webelements -> 3
	 * then find all chat boxes and assign to List of webelements -> 9
	 * then find all radios and assign to List of webelements -> 9
	 * then find all buttons and assign to List of webelements -> 1
	 * assert each one's count

	 */
	@Test
	public void SeleniumWebElementsForm() {
		driver.get("https://forms.zohopublic.com/murodil/form/SeleniumWebElements/formperma/eCecYgX4WMcmjxvXVq6UdhA2ABXIoqPAxnAF8H8CCJg");
		List<WebElement> inputBox = driver.findElements(By.xpath("//input[@type='text']"));
		List<WebElement> dropDown = driver.findElements(By.tagName("select"));
		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
		List<WebElement> button = driver.findElements(By.tagName("button"));
		
		assertEquals(inputBox.size(),2);
		assertEquals(dropDown.size(),3);
		assertEquals(checkBox.size(),9);
		assertEquals(radios.size(),9,"message will show if it fails");
		assertEquals(button.size(),1,"message will show if it fails");
		
		/*
		 * Homework:
		 * 	Loop through each inputbox and enter random names
		 *  Loop through each dropDown and randomly select by index
		 *  Loop through each checkBoxes and select each one
		 *  Loop through each radioButton and click one by one by waiting one second intervals
		 *  click all buttons
		 */
		
	}
//	@Test
//	public void slideShow() throws InterruptedException {
//		driver.get("https://www.hbloom.com/Gifts/birthday-flowers");
//		List<WebElement> images = driver.findElements(By.tagName("img"));
//		List<String> srcs = new ArrayList<>();
//		
//		for(WebElement flower: images) {
//			srcs.add(flower.getAttribute("src"));
//		}
//		
//		for (String link : srcs) {
//			driver.get(link);
//			Thread.sleep(1234);
//		}
//		
//	}
	
	@Test
	public void randomly() throws InterruptedException {
		
		Faker fake = new Faker();
		
		//Loop through each inputbox and enter random names

		List<WebElement> inputBox = driver.findElements(By.xpath("//input[@type='text']"));
		for(WebElement each :  inputBox) {
			each.sendKeys(fake.name().firstName());
			
		}
		// Loop through each dropDown and randomly select by index

		List<WebElement> dropDown = driver.findElements(By.tagName("select"));
		Select select ;
		
		for(WebElement each : dropDown) {
			
		 select = new Select(each);

			select.selectByIndex(fake.number().numberBetween(1, 4));
		}
		// Loop through each checkBoxes and select each one
		
		List<WebElement> checkBox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		
		int n = 0;
	 for(WebElement each : checkBox) {
		 if(fake.number().numberBetween(0, 2) == 1) each.click();
		 }
	 
	 //	Loop through each radioButton and click one by one by waiting one second intervals
	 
		List<WebElement> radios = driver.findElements(By.xpath("//input[@type='radio']"));
		for(WebElement each : radios) {
			each.click();
			Thread.sleep(2000);}
		
	//	click all buttons
		
		List<WebElement> button = driver.findElements(By.tagName("button"));
		for(WebElement each : button) {
			each.click();
		}
		
		

		
		
		
		
		
	}}
		

		
	
		

