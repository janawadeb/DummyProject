package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;

public class CreateContactPage {

	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name ="contactName")
	private WebElement ContactsNameField;
	
	@FindBy(name="organizationName")
	private WebElement OrganizationNameField;
	
	@FindBy(name="mobile")
	private WebElement MobileField;
	
	@FindBy(name="title")
	private WebElement TitleField;
	
	@FindBy(id="search-input")
	private WebElement SearchInput;
	
	@FindBy(name="search-criteria")
	private WebElement SearchDD;
	
	@FindBy(xpath="(//*[name()='svg' and @role='img'])[2]")
	private WebElement SelectCampBtn;
	
	@FindBy(xpath ="//button[@class='select-btn']")
	private WebElement SelectBtn;
	
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement addContactBtn;

	@FindBy(xpath ="//div[@role='alert']")
	private WebElement ConfMsg;

	@FindBy(name ="campaignName")
	private WebElement CampaignNameField;
	
	public WebElement getCampaignNameField(String CampaignName ) {
		return CampaignNameField;
	} 
	public WebElement getConfMsg() {
		return ConfMsg;
	}
	
	public WebElement getContactsNameField() {
		return ContactsNameField;
	}

	public WebElement getOrganizationNameField() {
		return OrganizationNameField;
	}

	public WebElement getMobileField() {
		return MobileField;
	}

	public WebElement getTitleField() {
		return TitleField;
	}
	
	public WebElement getAddContactBtn() {
		return addContactBtn;
	}
	
	public WebElement getSearchInput() {
		return SearchInput;
	}

	public WebElement getSearchDD() {
		return SearchDD;
	}

	public WebElement getSelectCampBtn() {
		return SelectCampBtn;
	}

	public WebElement getSelectBtn() {
		return SelectBtn;
	}

	public void createContactwithCampaign(String contactsName, String orgName, String mobile, String title, String childUrl, String parentUrl, String CampaignName) {

		ContactsNameField.sendKeys(contactsName);
		OrganizationNameField.sendKeys(orgName);
		MobileField.sendKeys(mobile);
		TitleField.sendKeys(title);
		SelectCampBtn.click();
		WebDriverUtility wUtil = new WebDriverUtility();
		wUtil.switchToWindow(driver, childUrl);
		wUtil.select(SearchDD, 1);
		SearchInput.sendKeys(CampaignName);
		SelectBtn.click();
		wUtil.switchToWindow(driver, parentUrl);
		addContactBtn.click();
		
		
	}

	

	
	
}
