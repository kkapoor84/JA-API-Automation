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

public class AP3SessionUpdate {
	
	@Test
	public void httpPost3(String classId,int random) throws JSONException,InterruptedException {
			
		//Initializing Rest API's URL
		String APIUrl = "http://182.71.201.58:7800/bcrm/api/SessionRequest/update?api_key=YWRtaW4ta2V5";
			
		//Initializing payload or API bod
		String APIBody ="{\"ProgramName\":\"JA It's My Future\",\"ProgramGuid\":\"39926A3C-F8E6-DDED-B098-3377CFB91321\",\"ClassID\":"+"\""+classId+"\""+",\"ClassName\":\"Class_BCRM_KK_"+random+"\",\"StartDate\":\"2017-03-26\",\"EndDate\":\"2017-08-02\",\"SchoolID\":\"22\",\"DeliveryModel\":\"JAID\",\"LastUpdatedBY\":{ \"AreaId\":\"100603\", \"FirstName\":\"super\", \"LastName\":\"admin\", \"EmailAddress\":\"lata.wadhwa@3pillarglobal.com\", \"LookupID\":\"super123admin\"}}";
				System.out.println(APIBody);
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
		Assert.assertEquals(result, expResult);

		}
	


}
