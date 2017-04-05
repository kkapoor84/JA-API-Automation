package Pages;
import static Base.DriverSetup.driver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SessionEnviormentAddPage {
	
	
	public void verifyAddEnvDetails(List<String> e,List<String> f,int random) throws InterruptedException
	{
	driver.navigate().refresh();
	System.out.println("\n\n****Test for Teacher/ Volunteer/ Student******");
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/nav/div/div[2]/ul/li[6]/a")).click(); // My Courses
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/ul/li[2]/a")).click(); //Not Runnign Course
	Thread.sleep(2000);
	driver.findElement(By.xpath(".//*[@id='notRunningCourses']/div[18]/div[1]/div/span[1]")).click(); // Explore Drawer
	Thread.sleep(2000);
	driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/div[1]/div[2]/input")).sendKeys("Class_BCRM_KK_"+random);
	Thread.sleep(5000);
	//driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/div[1]/div[2]/span/button")).click();
    driver.findElement(By.xpath("//html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/div[1]/div[2]/input")).sendKeys(Keys.ENTER);
    Thread.sleep(8000);
    driver.findElement(By.xpath("html/body/div[3]/div[2]/div[3]/div/div[18]/div[2]/div/div/table/tbody/tr/td[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]/div[1]/div/div[2]/div/form/div/div[3]/div[1]/div/span[1]")).click(); // Delete Teacher
	Thread.sleep(5000);
	
	List<WebElement> teacher = driver.findElements(By.xpath("//div[@id='teacher']//table[@class='table table-bordered table-custom']//tr/td/span"));
	Thread.sleep(2000);
	for (int i= 0 ; i<teacher.size() ; i++)
 {
	System.out.println(teacher.get(i).getText());
	System.out.println(e.get(i));
	Assert.assertEquals(teacher.get(i).getText(),e.get(i));
	
 }
	
	driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[1]/div[1]/div/div[2]/div/form/div/div[4]/div[1]/div/span[1]")).click(); // Volunteer section arrow
	Thread.sleep(2000);
	List<WebElement> Volunteer = driver.findElements(By.xpath("//div[@id='volunteer']//table[@class='table table-bordered table-custom']//tr/td/span"));
	
	for (int j= 0 ; j<Volunteer.size() ;j++)
	
	{
	System.out.println(Volunteer.get(j).getText());	
	System.out.println(f.get(j));
	Assert.assertEquals(Volunteer.get(j).getText(),f.get(j));

	}
		
	driver.findElement(By.xpath("//*[@id='enrollmentDiv']/div/div[1]/button")).click();
	}}
