package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateProductPage {

	WebDriver driver;
	
	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name ="productName")
	private WebElement ProductNameField;
	
	@FindBy(name="productCategory")
	private WebElement ProductCategoryDropDown;
	
	@FindBy(name="quantity")
	private WebElement QuantityField;
	
	@FindBy(name="price")
	private WebElement PriceField;

	@FindBy(name="vendorId")
	private WebElement VendorIdDropDown;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement addProductBtn;

	@FindBy(xpath ="//div[@role='alert']")
	private WebElement ConfMsg;
	
	
	public WebElement getConfMsg() {
		return ConfMsg;
	}
	
	public WebElement getProductNameField() {
		return ProductNameField;
	}

	public WebElement getProductCategoryDropDown() {
		return ProductCategoryDropDown;
	}

	public WebElement getQuantityField() {
		return QuantityField;
	}

	public WebElement getPriceField() {
		return PriceField;
	}

	public WebElement getVendorIdDropDown() {
		return VendorIdDropDown;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public void createProduct(String prdName, String quant, String price) {
		
		ProductNameField.sendKeys(prdName);
		QuantityField.clear();
		QuantityField.sendKeys(quant);
		PriceField.clear();
		PriceField.sendKeys(price);
		
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.select(ProductCategoryDropDown, 1);
		wUtil.select(VendorIdDropDown, "VID_00");
		addProductBtn.click();
	}

	
	
}
