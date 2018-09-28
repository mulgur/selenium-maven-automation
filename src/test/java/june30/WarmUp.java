package june30;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WarmUp {
	WebDriver driver;

	@Test
 	public void getAllProductsV1() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
 		driver.get("https://www.amazon.com/s/ref=nb_sb_noss_1?url=search-alias%3Daps&field-keywords=wooden+spoon");
 		driver.manage().window().fullscreen();
		List<WebElement> descriptions = driver.findElements(By.xpath("//h2"));
		for (WebElement item : descriptions) {
			System.out.println(item.getText());
		}
//		List<WebElement> descriptions = driver.findElements(By.xpath("//h2"));
//		for (WebElement item : descriptions) {
//			System.out.println(item.getText());
//		}
//		
//		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='sx-price sx-price-large']"));
//		for (WebElement price : prices) {
//			System.out.println(price.getText());
//		}
//		
//		for(int i = 0; i < descriptions.size(); i++) {
//			System.out.println(descriptions.get(i).getText());
//			System.out.println(prices.get(i).getText());
//			System.out.println("---------------");
//		}
//		
//		
		List<WebElement> wholeItems = driver.findElements(By.xpath("//div[@class='s-item-container']"));
 		
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='sx-price sx-price-large']"));
		for (WebElement price : prices) {
			System.out.println(price.getText());
		}
		System.out.println("wholeItems.size():" + wholeItems.size());
 		
 		
		for (int i = 0; i < wholeItems.size(); i++) {
			if(wholeItems.get(i).getText().isEmpty()) continue;
			
			String desXpath = "(//div[@class='s-item-container'])[" + (i+1) + "]//h2";
			String priceXpath = "(//div[@class='s-item-container'])[" + (i+1) + "]//span[@class='sx-price sx-price-large']";
			
			System.out.println(driver.findElement(By.xpath(desXpath)).getText());
			System.out.println(driver.findElement(By.xpath(priceXpath)).getText());
			System.out.println("------------");
			
		}
	
 		
 	}

}
