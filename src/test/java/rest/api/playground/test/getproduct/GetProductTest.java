package rest.api.playground.test.getproduct;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import rest.api.playground.testbase.TestBase;
public class GetProductTest extends TestBase {

	public GetProductTest() throws Exception {
		super();
		
	}

	@Test(priority=1, description="verify the login")
	public void fn_verify_login() throws Exception{
		try
		{
			int id=43900;
			String baseuri=prep.getProperty("uri");
			RestAssured.baseURI=baseuri;
			given().
			when().get("/products").then().assertThat().statusCode(200).and().
			body("data[0].id".trim(),equalTo(id)).and().
			body("data[0].name",equalTo("Duracell - AAA Batteries (4-Pack)"));
	        
	
	       
		}
		catch(Exception e)
		{
		  throw e;	
		}
	}

	
	}
	
	

