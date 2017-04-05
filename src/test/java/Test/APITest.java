package Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.DriverSetup;
import Pages.AP2SessionEnv;
import Pages.AP3SessionUpdate;
import Pages.API1PostMethod;
import Pages.AccountLogin;
import Pages.ApproveRequestPage;
import Pages.DatabasePage;
import Pages.SessionEnviormentAddPage;
import Pages.SessionEnviormentUpdatePage;

public class APITest {
	public API1PostMethod PMObject;
	public ApproveRequestPage  ARObject1;
	public DriverSetup  DSObject ;
	public  AccountLogin ALObject;
	public DatabasePage  dbobject;
	public AP2SessionEnv SEobject;
	public AP3SessionUpdate SUobject;
	public SessionEnviormentAddPage SEPObject;
	public SessionEnviormentUpdatePage SEUObject;
	String classId;
	int random;
	
	
	@BeforeClass
	public void initDriver(){
		PMObject = new API1PostMethod();
		DSObject =  new DriverSetup();
		 ALObject = new AccountLogin();
		 ARObject1 = new ApproveRequestPage();
		 dbobject =  new DatabasePage();
		 SEobject = new AP2SessionEnv();
		 SUobject = new AP3SessionUpdate();
		 SEPObject =new SessionEnviormentAddPage();
		 SEUObject = new SessionEnviormentUpdatePage();
		 classId = dbobject.getClassID();
		 random = dbobject.generateRandomNumber();
	}
	
	@AfterClass(alwaysRun = true)
	public void deleteRecord()
	{	
	dbobject.DeleteRecord(classId);
	DSObject.driver.quit();
	}

		
	@Test (priority=1)
	 
	public void courseRequestAPI() throws InterruptedException
	{
		PMObject.httpPost(classId);
		
	}

	@Test (priority=2)
	
	public void openURL() throws IOException, InterruptedException
	{
		ALObject.LoginSetup();
	}

	@Test (priority=3)
	
	public void requestApprovalpage() throws InterruptedException, IOException
	{
		ARObject1.CourseApprove();
	}
	
	@Test (priority=4)
	
	public void dbQuery() throws SQLException
	{
	
		dbobject.dbConnection(random);
	}
	
	@Test (priority=5)
	public void runApiUerEnv() throws JSONException, InterruptedException
	{
		
		SEobject.httpPost2(classId);
	}
	
	@Test (priority=6)
	public void verifyAddEnv() throws JSONException, InterruptedException
	{
		
		List<String> ExpectedResultEducator = Arrays.asList("BCRMTeacherOne","BCRMTeacherOne","lata.wadhwa@3pillarglobal.com","bcrmteacherone.bcrmteacherone");
		List<String> ExpectedResultVolunteer = Arrays.asList("BCRMVolunteerOne","BCRMVolunteerOne","lata.wadhwa@3pillarglobal.com","bcrmvolunteerone.bcrmvolunteerone");
		SEPObject.verifyAddEnvDetails(ExpectedResultEducator,ExpectedResultVolunteer,random);
	}
	
	
	
	@Test (priority=7)
	public void runApiSessionUpdate() throws JSONException, InterruptedException
	{
		
		SUobject.httpPost3(classId,random);
	}
	
	@Test (priority=8)
	public void verifyUpdateEnv() throws JSONException, InterruptedException
	{
		SEUObject.verifyUpdateEnvDetails(random);
	}
	

}
