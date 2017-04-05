package Pages;

import static org.testng.Assert.assertEquals;
import static Base.DriverSetup.driver;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;

public class ApproveRequestPage {
	

public void CourseApprove() throws InterruptedException, IOException
{
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/nav/div/div[2]/ul/li[4]/a")).click(); // Approve request main page
	Thread.sleep(1000);
	File ApproveCourse1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(ApproveCourse1, new File("D:\\SuccesssfulResult\\9ApproveCourse1.jpg"));
	//*[@id='pendingApproval']/div[30]/div[1]/div[1]/span[1]
	Thread.sleep(1000);
	driver.navigate().refresh();
	Thread.sleep(5000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div/div[30]/div[1]/div[1]/span[1]")).click(); // Expand drawer
	Thread.sleep(7000);	
	
	String act = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div/div[30]/div[2]/div/div/table/tbody/tr[1]/td[5]")).getText();
	System.out.println("actual date is :" + act);
	
	// Create object of SimpleDateFormat class and decide the format
	 DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	 
	 //get current date time with Date()
	 Date date = new Date();
	 
	 // Now format the date
	 String Expdate1= dateFormat.format(date);
	 
	 System.out.println("Expected date is :" + Expdate1);
	Assert.assertEquals(act, Expdate1);
		
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div/div[30]/div[2]/div/div/table/tbody/tr[1]/td[1]")).click(); // Select Courses
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div/div[30]/div[2]/div/div/div[1]/div[1]/span/button")).click(); // Approve Courses.
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[2]/button[2]")).click(); // Yes button
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[5]/div/div/div[1]/button")).click();
	Thread.sleep(2000);
	File ApproveCourse2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(ApproveCourse2, new File("D:\\SuccesssfulResult\\10ApproveCourse2.jpg"));
	System.out.println("\n Course Request Approved");
}
	

}
