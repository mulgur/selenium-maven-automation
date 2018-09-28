package pomdesign;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AllOrdersPage;
import pages.OrderPage;
import pages.ProductsPage;
import pages.WebOrdersLoginPage;

public class WebOrderTests {
	WebDriver driver;
	WebOrdersLoginPage loginPage;
	AllOrdersPage allOrdersPage;
	ProductsPage productsPage;
	OrderPage orderPage;
	String userId = "Tester";
	String password = "test";
	Faker fake = new Faker();
	int monthNum ;
	
	
	
	@BeforeClass /// runs once for all test
	public void setUp() {
		System.out.println("Setting up WebDriver in beforeClass...");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().fullscreen();
		}
	
	@BeforeMethod
	public void setUpApplication() {
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		loginPage = new WebOrdersLoginPage(driver);
	}
	@Test(description="Verify labels and tab links are displayed",priority=1)
	public void labelsVerification() {
		assertEquals(driver.getTitle(),"Web Orders Login","LoginPage is not displayed.");
		/*
		 * loginPage.userName.sendKeys("Tester");
		 * loginPage.password.sendKeys("test");
		   loginPage.loginButton.click();
		 */
		loginPage.login(userId, password);
		allOrdersPage = new AllOrdersPage(driver);
		assertTrue(allOrdersPage.webOrders.isDisplayed(),"Web Orders is not displayed");
		assertTrue(allOrdersPage.listOfAllOrders.isDisplayed(),"List of All Orders label is not displayed");
		assertEquals(allOrdersPage.welcomeMsg.getText().replace(" | Logout", ""),"Welcome, " + userId + "!");
		assertTrue(allOrdersPage.viewAllOrders.isDisplayed(),"View all Orders is not displayed");
		assertTrue(allOrdersPage.orderTab.isDisplayed()," OrdersPage is not displayed");
	}
	
	@Test(description= "verify default products and prices",priority=2)
	public void availableProductTest() {
		assertEquals(driver.getTitle(),"Web Orders Login", "LoginPage is not displayed.");
		loginPage.login(userId, password);
		allOrdersPage = new AllOrdersPage(driver);
		allOrdersPage.viewAllProducts.click();
		productsPage = new ProductsPage(driver);
		List<String> expProducts = Arrays.asList("MyMoney","FamilyAlbum", "ScreenSaver");
		List<String> actProducts = new ArrayList<>();
		
		
	//	productsPage.productNames.forEach(elem -> actProducts.add(elem.getText()));
		
		for(WebElement prod : productsPage.productNames) {
			actProducts.add(prod.getText());
			
		}
		AssertJUnit.assertEquals(actProducts, expProducts);
		
		for(WebElement row : productsPage.productRows) {
			String[] prodData = row.getText().split(" ");
			switch(prodData[0]) {
			case "MyMoney":
				AssertJUnit.assertEquals(prodData[1], "$100");
				AssertJUnit.assertEquals(prodData[2],"8%");
				break;
			case "FamilyAlbum":
				AssertJUnit.assertEquals(prodData[1], "$80");
				AssertJUnit.assertEquals(prodData[2],"15%");
				break;
			case "ScreenSaver":
				AssertJUnit.assertEquals(prodData[1], "$20");
				AssertJUnit.assertEquals(prodData[2],"10%");
				break;
			}
			}
		
	}
	
	@Test(priority=3)
	public void orderPage() {
		loginPage.login(userId, password);
		orderPage = new OrderPage(driver);
		orderPage.orderButton.click();
		orderPage.quantity.sendKeys("1");
		String cName = fake.name().firstName();
		String cStreet = fake.address().streetAddress();
		String cCity = fake.address().city();
		String cZip = fake.address().zipCode().substring(0, 5);
		String cardType = ""+fake.number().numberBetween(1, 3);
		String cardNo = fake.number().digits(15);
		int monthNum = fake.number().numberBetween(10, 12);
		String yearNum = fake.number().numberBetween(18,30)+"";
		
		orderPage.customerName.sendKeys(cName);
		orderPage.street.sendKeys(cStreet);
		orderPage.city.sendKeys(cCity);
		orderPage.zip.sendKeys(cZip);
		String str = "";
		switch(cardType) {
		case "1": orderPage.card1.click(); str = "Visa";
		break;
		case "2": orderPage.card2.click(); str = "MasterCard";
		break;
		case "3": orderPage.card3.click(); str = "American Express";
		break;
		}
		orderPage.cardNo.sendKeys(cardNo);
		
		

		orderPage.expireDate.sendKeys(monthNum+"/"+ yearNum);
		orderPage.process.click();
		orderPage.viewAllOrders.click();
		List<String> expRow = new ArrayList<>();
		for(WebElement each : orderPage.rows) {
			expRow.add(each.getText());
		}
		List<String> actRow = Arrays.asList("", cName , "MyMoney", "1", "07/10/2018", cStreet, cCity," ", cZip, str, cardNo, monthNum+"/"+yearNum,"");
		assertEquals(expRow, actRow);
//		System.out.println(expRow);
//		System.out.println(actRow);
		
		
		
		
		
		
		
	}
	
		
	
	@AfterMethod
	public void logout() {
		//allOrdersPage.logout();
		//		allOrdersPage.logout().click();
}
	
	@AfterClass
	public void tearDown() {
		//driver.close();
	}
	

}
