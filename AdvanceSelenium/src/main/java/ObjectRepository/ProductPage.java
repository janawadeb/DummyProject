package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

	WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[text()='Products']")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//option[value='productId']")
	private WebElement searchProductIDdropDown;
	
	@FindBy(xpath="//input[class='form-control' and placeholder='Search by product Id']")
	private WebElement searchProductIDField;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement AddProductBtn;

	@FindBy(xpath ="//div[@role='alert']")
	private WebElement confMsgField;
	
	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getSearchProductIDdropDown() {
		return searchProductIDdropDown;
	}

	public WebElement getSearchProductIDField() {
		return searchProductIDField;
	}

	public WebElement getAddProductBtn() {
		return AddProductBtn;
	}

	public WebElement getConfMsg() {

		return confMsgField;
	}
	
	
}
