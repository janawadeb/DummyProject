package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
/*
 create campaign button
 dropdown campaign
 search campaign
 
 methods,
 getter, setter,
 encapsualtion
 */
	
	WebDriver driver;
	
	public CampaignsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//span[text()='Create Campaign']")
	private WebElement CreateCampaignBtn;
	
	@FindBy(xpath ="//option[value='campaignId']")
	private WebElement campaignIdField;
	
	@FindBy(xpath ="//input[placeholder='Search by Campaign Id']")
	private WebElement searchCampaignIdField;
	
	@FindBy(xpath ="//div[@role='alert']")
	private WebElement ConfMsg;

	public WebElement getConfMsg() {
		return ConfMsg;
	}

	public WebElement getCreateCampaignBtn() {
		return CreateCampaignBtn;
	}

	public WebElement getCampaignIdField() {
		return campaignIdField;
	}

	public WebElement getSearchCampaignIdField() {
		return searchCampaignIdField;
	}
	
	
}
