package ContactTest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.WebDriverUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.ContactsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.CreateContactPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;
@Listeners(ListenerImp.class)
public class CreateContactTest extends BaseClass {

		@Test()
		//@Parameters("browser")
		//@Test(groups= {"Smoke Test"})
		public void createContactTest() throws IOException, InterruptedException
		{
			
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(2000);
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("Sheet1", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("Sheet1", 1, 3);
		String organization = exUtil.readingDataFromExcel("Contact", 1, 2)+randomNum;
		String title = exUtil.readingDataFromExcel("Contact", 1, 3);
		String contactName = exUtil.readingDataFromExcel("Contact", 1, 2)+randomNum;
		String mobile = exUtil.readingDataFromExcel("Contact", 1, 3);
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(Campaign, targetSize);
		Thread.sleep(3000);
		
		WebElement contactLink = dp.getContactsLink();
		WebDriverUtility Wutil = new WebDriverUtility();
		Wutil.waitForElementToBeClickable(driver, contactLink, 20);
		contactLink.click();
		Thread.sleep(5000);
		
		ContactsPage csp = new ContactsPage(driver);
		WebElement addContactBtn = csp.getCreateContactBtn();
		Wutil.waitForElementToBeClickable(driver, addContactBtn, 20);
		addContactBtn.click();
		
		CreateContactPage ccsp = new CreateContactPage(driver);
		ccsp.createContactwithCampaign(contactName, organization, title, mobile, "selectCampaign", "create-contact", Campaign);
        Thread.sleep(3000);
        
        String ConfirmationMsg = csp.getConfMsg().getText();
        boolean status = ConfirmationMsg.contains(contactName);
		Assert.assertEquals(status, true, "Contact name not added");
		Reporter.log("Contact name"+contactName+" added successfully", true);
        Thread.sleep(5000);
       
	}

}
