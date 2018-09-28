package webtables;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeWork {
	/*
	 * 1) goto https://forms.zohopublic.com/murodil/report/Applicants/reportperma/
	 * DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8 2) Create a HashMap 3) change row
	 * number to 100, read all data on first page and put uniquID as a KEY and
	 * Applicant info as a Value to a map.
	 * 
	 * applicants.put(29,"Amer, Sal-all@dsfdsf.com-554-434-4324-130000")
	 * 
	 * 4) Click on next page , repeat step 3 5) Repeat step 4 for all pages 6) print
	 * count of items in a map. and assert it is matching with a number at the
	 * buttom
	 * 
	 * 
	 */
	
		String url = "https://forms.zohopublic.com/murodil/report/Applicants/reportperma/DibkrcDh27GWoPQ9krhiTdlSN4_34rKc8ngubKgIMy8";
		
		WebDriver driver;
		Map<Integer, String> map = new HashMap();
		
		@BeforeClass
		public void setUp() {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().fullscreen();
			driver.get(url);
			
		}
		@Test
		public void hashMap() throws InterruptedException {
			driver.findElement(By.id("recPerPage")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//option[.='100']")).click();
			
			ls("reportTab");
			
			driver.findElement(By.xpath("//a[@class='nxtArrow']")).click();
			
			ls("reportTab");

			
			}
	public void ls(String id) {
		String st = "";
		String[] str = new String[100];
		
		for(int rowNum = 1; rowNum <= 100; rowNum++) {
			
			for(int col = 1; col <= 5; col++) {
				
				String xpath = "//table[@id='"+id+"']/tbody/tr["+rowNum+"]/td["+col+"]";
				String tdData = driver.findElement(By.xpath(xpath)).getText();
				//System.out.print(tdData +"  \t");
			//	System.out.print(tdData + " ");
				st +=( tdData + " ");
				str = st.split(" ");
				System.out.println(str[0]);
				String value = str[1] + "-" + str[2] + "-" + str[3] + "-" +  str[4] + "-" + str[5];
				
				map.put(Integer.parseInt(str[0]), value);
				
				System.out.println(map);
			
				System.out.println();

			}
		
			//System.out.println(str.length);
			
			
		}
		
	}
	
	}
		
		
		
		
		
		
	






