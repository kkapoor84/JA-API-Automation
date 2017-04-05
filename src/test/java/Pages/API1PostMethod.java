package Pages;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import static com.jayway.restassured.RestAssured.*;
import static com.jayway.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class API1PostMethod {
	
	
	@Test
	public void httpPost(String classId) throws JSONException,InterruptedException {
			
		//Initializing Rest API's URL
		String APIUrl = "http://182.71.201.58:7800/bcrm/api/sessionrequest/add?api_key=YmNybS1rZXk=";
			
		//Initializing payload or API body
		String APIBody = "[{\"ProgramName\": \"JA It's My Future\",\"ProgramGuid\": \"39926A3C-F8E6-DDED-B098-3377CFB91321\",\"ClassID\":"+"\""+classId+"\""+",\"RequestedSessions\": 1,\"SubmittedBy\": {\"AreaId\": \"100603\", \"LookupID\": \"super123admin\", \"FirstName\": \"super\", \"LastName\": \"admin\", \"EmailAddress\": \"khushboo.kapoor@3pillarglobal.com\" } }]";
		
		System.out.println("Apibody " + APIBody);
					
		// Building request usng requestSpecBuilder
		RequestSpecBuilder builder = new RequestSpecBuilder();
			
		//Setting API's body
		builder.setBody(APIBody.getBytes());
			
		//Setting content type as application/json or application/xml
		builder.setContentType("application/json; charset=UTF-8");
			
		RequestSpecification requestSpec = builder.build();	

		//Making post request with authentication, leave blank in case there are no credentials- basic("","")
		Response response = given().authentication().preemptive().basic("", "").spec(requestSpec).when().post(APIUrl);
		//JSONObject JSONResponseBody = new JSONObject(response.body().asString());

		//Fetching the desired value of a parameter
		
		String result = response.body().asString();
	    String expResult = "\"Thank you! Your request will be processed in the next 3-5 business days.\"";
	    	    
		//Asserting that result of Norway is Oslo
		Assert.assertEquals(result ,expResult);
		
//		       try{
//                URL url = new URL(APIUrl);
//                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
//                connection.setRequestMethod("GET");
//                connection.connect();
//                System.out.println("response code= "+connection.getResponseCode());
//            }
//            catch(Exception e){}
        
	
		

		}
	


}
