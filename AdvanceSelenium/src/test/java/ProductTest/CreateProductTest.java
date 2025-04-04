package ProductTest;

import java.io.IOException;
import java.time.Duration;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import ObjectRepository.CreateProductPage;
import ObjectRepository.DashboardPage;
import ObjectRepository.ProductPage;
import genericBaseClassUtility.BaseClass;
import genericListenerUtility.ListenerImp;
@Listeners(ListenerImp.class)

public class CreateProductTest extends BaseClass {

		@Test()
		//@Parameters("browser")
		//@Test(groups= {"Functional Test"})
		public void createProductTest() throws IOException, InterruptedException
		{
			
			JavaUtility jutil=new JavaUtility();
			int randNum = jutil.getRandomNum(10000);
			ExcelFileUtility excelUtil=new ExcelFileUtility();
			String prdName = excelUtil.readingDataFromExcel("Product", 1, 2)+randNum;
			String quant = excelUtil.readingDataFromExcel("Product", 1, 3);
			String price = excelUtil.readingDataFromExcel("Product", 1, 4);
			String expectedURL="http://49.249.28.218:8098/dashboard";
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//navigating to ninza CRM
		Thread.sleep(2000);

		DashboardPage dp = new DashboardPage(driver);
		Thread.sleep(5000);
		
		//verification of dashboard
		String actualURL=driver.getCurrentUrl();
		if(actualURL.equals(expectedURL))
		{
			Reporter.log("Validation is pass");
		}
		else
		{
			Reporter.log("validation is failed");
		}
		
		dp.getProductsLink().click();
		//Product
		ProductPage pp = new ProductPage(driver);
		pp.getAddProductBtn().click();
		
		CreateProductPage cpsp = new CreateProductPage(driver);
		cpsp.createProduct(prdName, quant, price);
		Thread.sleep(5000);
		
		String confMsg = pp.getConfMsg().getText();
		boolean status = confMsg.contains(prdName);
		Assert.assertEquals(status, true, "Product name not added");
		Reporter.log("Product name"+prdName+" added successfully", true);
		
		//Assert.assertTrue(status);
		Thread.sleep(5000);
		
	}

}
