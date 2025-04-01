package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Campaigns")
	private WebElement CampaignsLink;
	
	@FindBy(linkText="Contacts")
	private WebElement ContactsLink;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//*[name()='svg' and @role='img']")
	private WebElement ProfileIcon;
	
	@FindBy(xpath="//div[text()='Logout ']")
	private WebElement LogoutBtn;

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getContactsLink() {
		return ContactsLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getProfileIcon() {
		return ProfileIcon;
	}

	public WebElement getLogoutBtn() {
		return LogoutBtn;
	}
	
	public void logout()
	{
		ProfileIcon.click();
		Actions action = new Actions(driver);
		action.moveToElement(LogoutBtn).click();
		
	}
	
	
}
