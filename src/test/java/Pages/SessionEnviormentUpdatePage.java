package Pages;
import static Base.DriverSetup.driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SessionEnviormentUpdatePage {
	
	
	public void verifyUpdateEnvDetails (int random) throws InterruptedException 
	{
	driver.navigate().refresh();
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[18]/div[1]/div/span[1]")).click(); // Explore Drawer
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/div[1]/div[2]/input")).sendKeys("Class_BCRM_KK_"+random);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
	String ExpStartDate = "03-26-2017";
	String ActualStartDate = driver.findElement(By.xpath(".//div[@id='notRunningCourses']/div[18]//tbody/tr[1]/td[4]")).getText();
	
	Assert.assertEquals(ActualStartDate, ExpStartDate);
	System.out.println("StartDate is updated");
	
	String ExpEndDate = "08-02-2017";
	String ActualEndDate = driver.findElement(By.xpath(".//div[@id='notRunningCourses']/div[18]//tbody/tr[1]/td[5]")).getText();
	
	Assert.assertEquals(ActualStartDate, ExpStartDate);
	System.out.println("EndDate is updated");
	
    Thread.sleep(2000);
    driver.findElement(By.xpath("html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/table/tbody/tr/td[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='dvEnrolledUser']/div[1]/div[1]/div[1]/span[1]")).click(); //Location section
    Thread.sleep(2000);
    String ExpSchoolLocation = "DIOCESE OF BIRMINGHAM ED OFF , 2121 3RD AVE N , BIRMINGHAM , AL - 35203";
    String ActSchoolLocation = driver.findElement(By.xpath(".//*[@id='dvEnrolledUser']/div[1]/div[2]/div/div/div[1]/div[1]")).getText(); 
	Assert.assertEquals(ActSchoolLocation, ExpSchoolLocation);
	System.out.println("SchoolLocartion is updated");
	Thread.sleep(2000);
	WebElement Radiobutton = driver.findElement(By.xpath(".//*[@id='dvEnrolledUser']//div[@id='sessionMetadataDiv']//div[6]//span[@id='spanDeliveryModel']//div/label[2]/input"));
    Assert.assertEquals(Radiobutton.isSelected(), true);   
	System.out.println("JAID is selected");
	Thread.sleep(2000);

	
	}}
