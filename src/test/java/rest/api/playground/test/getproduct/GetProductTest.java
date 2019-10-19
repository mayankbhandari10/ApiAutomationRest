package rest.api.playground.test.getproduct;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import rest.api.playground.testbase.TestBase;
public class GetProductTest extends TestBase {

	public GetProductTest() throws Exception {
		super();

	}

	@Test(priority=1, description="verify the login")
	public void fn_verify_login() throws Exception{
		int id=43900;
		log.info("*****************id is*******************"+id);
		String baseuri=prep.getProperty("uri");
		try
		{
		
		RestAssured.baseURI=baseuri;
		log.info("**********************log started***************************");
		log.info("Base uri is"+baseuri);
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

	@Test(priority=2, description="verify the get request")
	public void fn_verify_getRequest() throws Exception{
		int id=43900;
		
		log.info("*****************id is*******************"+id);
		String baseuri=prep.getProperty("uri");
		try
		{
		
			RequestSpecification httpRequest = RestAssured.given();
			Response response = httpRequest.request(Method.GET, "/products");
			String responseBody = response.getBody().asString();
			log.info("************respone**************"+responseBody);
		
		
		}
		catch(Exception e)
		{
			throw e;	
		}
	}


}



