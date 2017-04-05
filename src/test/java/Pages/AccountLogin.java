package Pages;

import java.io.File;
import static Base.DriverSetup.driver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AccountLogin 
{

	public String username = "super.admin";
	public String userpassword = "Tpg@123";
	
	public void LoginSetup() throws IOException, InterruptedException
	{
		driver.findElement(By.xpath("/html/body/div/div[5]/div/form/div[2]/input")).sendKeys(username);  // Provide User Name
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[5]/div/form/div[3]/input")).sendKeys(userpassword); // Provide Password
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[5]/div/form/div[4]/input")).click(); // Click Login button.
		Thread.sleep(2000);
		System.out.println("\nLogin as super admin is successfull\n");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().forward();					
		File screenshot2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot2, new File("D:\\SuccesssfulResult\\2HomePage.jpg"));
	}

}
