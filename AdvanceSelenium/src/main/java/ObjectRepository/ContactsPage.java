package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	WebDriver driver;
	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//a[text()='Contacts']")
	private WebElement ContactsLink;
	
	@FindBy(xpath="//option[value='contactId']")
	private WebElement searchContactIDdropDown;
	
	@FindBy(xpath="//input[class='form-control' and placeholder='Search by Contact Id']")
	private WebElement searchContactIDField;
	
	@FindBy(xpath="//span[text()='Create Contact']")
	private WebElement CreateContactBtn;

	@FindBy(xpath ="//div[@role='alert']")
	private WebElement ConfMsg;

	public WebElement getConfMsg() {
		return ConfMsg;
	}
	
	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getSearchContactIDdropDown() {
		return searchContactIDdropDown;
	}

	public WebElement getSearchContactIDField() {
		return searchContactIDField;
	}

	public WebElement getCreateContactBtn() {
		return CreateContactBtn;
	}
	


}
