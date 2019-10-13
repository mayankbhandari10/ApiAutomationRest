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
			RestAssured.baseURI="";
			 
	        
	
	       
		}
		catch(Exception e)
		{
		  throw e;	
		}
	}

	
	}
	
	

