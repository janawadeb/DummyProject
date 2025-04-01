package Project;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Login {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://49.249.28.218:8098/");
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("rmgyantra");
		Thread.sleep(3000);
		WebElement passWord = driver.findElement(By.id("inputPassword"));
		passWord.sendKeys("rmgy@9999");
		Thread.sleep(3000);
		WebElement signIn = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signIn.click();
		Thread.sleep(5000);
		
		
		WebElement DashboardPage = driver.findElement(By.linkText("Products"));
		/*Assert.assertTrue(DashboardPage.isDisplayed());
		*/
		
		/*
		String expectedUrl = "http://49.249.28.218:8098/dashboard";
		@Nullable
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEqual(currentUrl, expectedUrl);
		*/
		Thread.sleep(5000);
		
		if(DashboardPage.isDisplayed())
		{
			System.out.println("Dashboard displayed");
		}
		else
		{
			System.out.println("Dashboard not displayed");
		}
		
		WebElement userIcon = driver.findElement(By.xpath("//div[@class='user-icon-container']"));
		userIcon.click();
		Thread.sleep(3000);
		
		Select profileDropDown = new Select(userIcon);
		profileDropDown.selectByVisibleText("Logout");
		
		/*WebElement logOut = driver.findElement(By.linkText("Logout"));
		logOut.click();
		Thread.sleep(3000);
		*/
		driver.quit();
		
		
	}
}
