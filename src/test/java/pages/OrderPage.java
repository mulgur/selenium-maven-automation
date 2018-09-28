package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {
	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//ul[@id='ctl00_menu']/li[3]/a")
	public WebElement orderButton;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement quantity;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
	public WebElement customerName;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement street;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement city;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement zip;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
	public WebElement card1;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
	public WebElement card2;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
	public WebElement card3;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement cardNo;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement expireDate;
	
	@FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement process;
	
	@FindBy(xpath = "//ul[@id='ctl00_menu']/li/a[.='View all orders']")
	public WebElement viewAllOrders;
	
	@FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[2]/td")
	public List<WebElement> rows;
	
	
	
	
	

}
