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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AP2SessionEnv {
	
	@Test
	public void httpPost2(String classId) throws JSONException,InterruptedException {
			
		//Initializing Rest API's URL
		String APIUrl = "http://182.71.201.58:7800/bcrm/api/UserEnrollment?api_key=YmNybS1rZXk=";
			
		//Initializing payload or API bod
		String APIBody = "{\"ClassID\":"+"\""+classId+"\""+",\"UpdatedBY\":{ \"AreaId\": \"100603\", \"LookupID\": \"super123admin\", \"FirstName\": \"super\", \"LastName\": \"admin\", \"EmailAddress\": \"lata.wadhwa@3pillarglobal.com\"},\"Users\":[{ \"Action\":\"ADD\", \"RoleID\":\"Teacher\", \"FirstName\":\"BCRMTeacherOne\", \"LastName\":\"BCRMTeacherOne\", \"AreaId\":\"100301\", \"EmailAddress\":\"lata.wadhwa@3pillarglobal.com\",\"LookupID\":\"BCRMTeacherOn\"},{\"Action\":\"ADD\", \"RoleID\":\"Volunteer\", \"FirstName\":\"BCRMVolunteerOne\", \"LastName\":\"BCRMVolunteerOne\", \"AreaId\":\"100703\", \"EmailAddress\":\"lata.wadhwa@3pillarglobal.com\", \"LookupID\":\"BCRMVolunteerOne\"}]}"; 
																																																				
		//"{\"key1\":\"value1\",\"key2\":\"value2\"}";
		
					
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
	    String exp = "\"User enrollment done successfully\"";
	    
		//Asserting that result of Norway is Oslo
		Assert.assertEquals(result, exp);

		}
	


}
