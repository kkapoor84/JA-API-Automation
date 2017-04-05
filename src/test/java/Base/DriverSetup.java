package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {
	
	public static WebDriver driver;
	
	public DriverSetup()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://182.71.201.58:7800/Home/Index");		
		driver.manage().window().maximize();		
		System.out.println("Welcome To JA Application");
		
	}

}
