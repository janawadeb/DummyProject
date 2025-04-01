package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignsPage {

	/*
	 campaign name
	 date
	  campaign btn
	 
	 methods,
	 getter, setter,
	 encapsualtion
	 */
	
WebDriver driver;
	
	public CreateCampaignsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name ="campaignName")
	private WebElement CampaignNameField;
	
	@FindBy(name ="targetSize")
	private WebElement targetSizeField;
	
	@FindBy(name ="expectedCloseDate")
	private WebElement expectedCloseDateField;

	@FindBy(xpath ="//button[text()='Create Campaign']")
	private WebElement createCampaignBtn;

	@FindBy(xpath ="//div[@role='alert']")
	private WebElement ConfMsg;

	public WebElement getConfMsg() {
		return ConfMsg;
	}
	
	public WebElement getCampaignNameField(String CampaignName ) {
		return CampaignNameField;
	}

	public WebElement getTargetSizeField(String TargetSize) {
		return targetSizeField;
	}

	public WebElement getexpectedCloseDateField(String closeDate) {
		return expectedCloseDateField;
	}

	public WebElement getCreateCampaignBtn() {
		return createCampaignBtn;
	}


	public void createCampaignWithMandatoryFields(String CampaignName, String TargetSize) {

		CampaignNameField.sendKeys(CampaignName);
		targetSizeField.clear();
		targetSizeField.sendKeys(TargetSize);
		createCampaignBtn.click();
	}

	public void createCampaignWithCloseDate(String CampaignName, String TargetSize, String closeDate) {

		CampaignNameField.sendKeys(CampaignName);
		targetSizeField.clear();
		targetSizeField.sendKeys(TargetSize);
		expectedCloseDateField.sendKeys(closeDate);
		createCampaignBtn.click();
	}
	
	
}
