package rest.api.playground.test.getproduct;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import rest.api.playground.testbase.TestBase;
public class GetProductTest extends TestBase {
	String baseuri=prep.getProperty("uri");


	public GetProductTest() throws Exception {
		super();


	}

	//@Test(priority=1, description="verify the Duracell batteries")
	public void fn_verify_login() throws Exception{
		int id=43900;
		log.info("*****************id is*******************"+id);
		Response response = null;
		try
		{

			RestAssured.baseURI=baseuri;
			log.info("**********************log started***************************");
			log.info("Base uri is"+baseuri);
			given().
			when().get("/products").then().assertThat().statusCode(200).and().
			body("data[0].id".trim(),equalTo(id)).and().
			body("data[0].name",equalTo("Duracell - AAA Batteries (4-Pack)"));
			//		log.info("************respone**************"+responseBody);

		}
		catch(Exception e)
		{
			throw e;	
		}
	}

	//@Test(priority=2, description="verify the get request and printing the response ") //Need to be modified this...
	public void fn_verify_getRequest() throws Exception{
		int id=43900;

		log.info("*****************id is*******************"+id);
		try
		{
			RestAssured.baseURI=baseuri;
			//Get the RequestSpecification of the request that you want to sent
			// to the server. The server is specified by the BaseURI that we have
			// specified in the above step.
			RequestSpecification httpRequest = RestAssured.given();
			// Make a request to the server by specifying the method Type and the method URL.
			// This will return the Response from the server. Store the response in a variable.
			Response response = httpRequest.request(Method.GET, "/products");
			// Now let us print the body of the message to see what response
			// we have recieved from the server
			response.then().assertThat().statusCode(200).and().contentType("application/json");
			int status=response.statusCode();
			System.out.println(status);
			String responseBody = response.getBody().prettyPrint();
			log.info("************respone**************"+responseBody);
		} 
		catch(Exception e)
		{
			throw e;	
		}
	}
	//@Test(priority=3, description="verify the get request with query parametrs ")
	public void fn_verify_getRequest_with_query_parameters() throws Exception{
		int limit=3;
		int id=43900;
		log.info("*****************id is*******************"+id);
		try
		{
			RestAssured.baseURI=baseuri;
			RequestSpecification httpRequest= RestAssured.given().queryParam("$limit", 3);
			Response response = httpRequest.request(Method.GET, "/products");
			String responseBody = response.getBody().prettyPrint();
			System.out.println(responseBody);
			log.info("************respone**************"+responseBody);
			Assert.assertEquals(responseBody.contains("43900") /*Expected value*/, true);
			Headers allHeaders = response.headers();
		}
		catch(Exception e)
		{
			throw e;	
		}
	}

	@Test(priority=3, description="verify the status code of the GETPRODUCT API")
	public void fn_verify_the_statusCode_of_getProduct() throws Exception
	{

		int limit=3;
		int id=43900;
		log.info("*****************id is*******************"+id);
		try
		{
			RestAssured.baseURI=baseuri;
			RequestSpecification httpRequest= RestAssured.given().queryParam("$limit", 3);
			Response response = httpRequest.request(Method.GET, "/products");
			String responseBody = response.getBody().prettyPrint();
			log.info("************respone**************"+responseBody);
			int status_code=response.getStatusCode();
			String statusline= response.getStatusLine();
			//Assert the Status code.
			Assert.assertEquals(status_code /*actual value*/, 200 /*expected value*/, "200");
			//Assert status line
			Assert.assertEquals(statusline /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");

		}
		catch(Exception e)
		{
			throw e;  
		}
	}

	private void fn_validate_the_headers_of_getProductAPI() throws Exception
	{
		try
		{
			RestAssured.baseURI=baseuri;
			RequestSpecification httpRequest= RestAssured.given().queryParam("$limit", 3);
			Response response = httpRequest.request(Method.GET, "/products");
			String responseBody = response.getBody().prettyPrint();
			System.out.println(responseBody);
			log.info("************respone**************"+responseBody);
			Assert.assertEquals(responseBody.contains("43900") /*Expected value*/, true);
			Headers allHeaders = response.headers(); 
			// Iterate over all the Headers
			for(Header header : allHeaders)
			{
				System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}



