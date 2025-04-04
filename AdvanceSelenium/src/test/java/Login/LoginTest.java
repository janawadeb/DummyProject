package Login;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import ObjectRepository.DashboardPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;
@Listeners(ListenerImp.class)

public class LoginTest extends BaseClass {

		@Test(retryAnalyzer = genericListenerUtility.RetryListenerImp.class )
		//@Parameters("browser")
		//@Test(groups= {"Regression Test"})
		public void loginTest() throws IOException, InterruptedException
		{
		
		String expectedURL="http://49.249.28.218:8098/dashboard";
		//Assert.assertEquals(expectedURL, actualURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigating to ninza CRM 
		
		//verification of dashboard
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		Reporter.log("Validation is pass", true);

		DashboardPage dp = new DashboardPage(driver);		
		
	}

}
