package CreateCampaign;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CampaignsPage;
import ObjectRepository.CreateCampaignsPage;
import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;
@Listeners(ListenerImp.class)

public class CreateCampaignTest extends BaseClass {

		//@Parameters("browser")
		//@Test(groups= {"Smoke Test"})
	
	    @Test()
		public void createCampaignTest() throws IOException, InterruptedException
		{
		
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(2000);
		
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("Sheet1", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("Sheet1", 1, 3);
		
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigating to ninza CRM
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithMandatoryFields(Campaign, targetSize);
		Thread.sleep(2000);
		
		String ConfMsg = ccp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true, "Campaign not added");
		Reporter.log("Campaign"+Campaign+" added successfully", true);
		Thread.sleep(4000);
		
	}
	    @Test()
	    
		//@Parameters("browser")
		//@Test(groups= {"Regression Test"})
		  
		public void createCampaignWithDateTest() throws InterruptedException, IOException
		{
			
		JavaUtility jUtil = new JavaUtility();
		int randomNum = jUtil.getRandomNum(2000);
			
		ExcelFileUtility exUtil = new ExcelFileUtility();
		String Campaign = exUtil.readingDataFromExcel("Sheet1", 1, 2)+randomNum;
		String targetSize = exUtil.readingDataFromExcel("Sheet1", 1, 3);
		
		String closeDate = jUtil.generateReqDate(30);
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Launching the browser
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigating to ninza CRM
		
		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(2000);
		dp.getCampaignsLink().click();
		
		CampaignsPage cp = new CampaignsPage(driver);
		cp.getCreateCampaignBtn().click();
		
		CreateCampaignsPage ccp = new CreateCampaignsPage(driver);
		ccp.createCampaignWithCloseDate(Campaign, targetSize, closeDate);
		Thread.sleep(2000);
		
		String ConfMsg = ccp.getConfMsg().getText();
		boolean status = ConfMsg.contains(Campaign);
		Assert.assertEquals(status, true, "Campaign not added");
		//Assert.assertTrue(status, "Campaign not added");
	    Reporter.log("campaign "+Campaign+" added successfully",true);
		Thread.sleep(5000);
		}

}
