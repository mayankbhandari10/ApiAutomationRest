package rest.api.playground.test.addproduct.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest.api.playground.test.addproduct.AddProductPayload;
import rest.api.playground.testbase.TestBase;

public class AddProductTest extends TestBase {
	
	public AddProductTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	AddProductPayload Ad=new AddProductPayload("mayank", "mayank", "mayank", "mayank", "mayank", "mayank", "mayank", "mayank", "mayank", "mayank");

	
	 
	
	
	@Test(priority=3, description="verify the get request with query parametrs ")
	public void fn_verify_post_Request() throws Exception{
		
		String baseuri=prep.getProperty("uri");
		try
		{
			RestAssured.baseURI=baseuri;
		
				
			 Response res= given().
             contentType("application/json").
             body(Ad).
             when().
             post("/products").then().extract().response();
			String responseData= res.prettyPrint();
			System.out.println(responseData);
		
     
		}
		catch(Exception e)
		{
			throw e;	
		}
  	}
	
	
}
