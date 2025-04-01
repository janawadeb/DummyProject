package genericBaseClassUtility;

import org.openqa.selenium.WebDriver;

import GenericUtility.DatabaseUtility;
import GenericUtility.PropertiesFileUtility;
import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public WebDriver driver = null;
	public static WebDriver sdriver=null;
	DatabaseUtility dUtil = new DatabaseUtility();
	PropertiesFileUtility pro = new PropertiesFileUtility();
	
	@BeforeSuite
	public void beforeSuite() throws SQLException
	{
		System.out.println("Established database connection");
		dUtil.getDBConnection("jdbc:mysql://localhost:3306/Ninza_E18", "root", "Mar@29");
	}
	
	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Pre configuration set up");
	}
	
	@BeforeClass
	public void beforeClass() throws IOException
	{
		System.out.println("Launch the browser");
		String BROWSER = pro.readingDataFromProperties("browser");
		/*ChromeOptions Coption=new ChromeOptions();
		FirefoxOptions Foption=new FirefoxOptions();
		EdgeOptions Eoption=new EdgeOptions();
		Coption.addArguments("--headless");
		Foption.addArguments("--headless");
		Eoption.addArguments("--headless");*/
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new ChromeDriver();
		}
		sdriver=driver;
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		System.out.println("Login");
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Logout");
	}
	
	
	public void afterClass()
	{
		System.out.println("Close the browser");
	}
	
	public void afterTest()
	{
		System.out.println("Post configuration set up");
	}
	
	public void afterSuite()
	{
		System.out.println("Close database connection");
	}
}
