package rest.api.playground.test.addproduct.test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest.api.playground.genericclass.GenericClass;
import rest.api.playground.test.addproduct.AddProductPayload;
import rest.api.playground.testbase.TestBase;
import com.fasterxml.jackson.databind.ObjectMapper;
@SuppressWarnings("unused")
public class AddProductTest extends TestBase {
	String path = System.getProperty("user.dir");
	String FinalTestDat=path+"\\TestData\\Statuscode.json";



	AddProductPayload Ad=new AddProductPayload();
	//AddProductPayload Ad=new AddProductPayload("string", "string", 50, 5, "string", "string", "string", "string", "string", "string");
	String baseuri=prep.getProperty("uri");
	public AddProductTest() throws Exception {
		super();

	}

	//ObjectMapper Obj = new ObjectMapper(); 
	/*@Test(priority=1, description="Add a new Product and verify it")
	public void fn_verify_post_Request() throws Exception{
		String json = Obj.writeValueAsString(Ad);
		System.out.println(json);
		;
		try
		{
			RestAssured.baseURI=baseuri;
			Response res= given().
					contentType("application/json").
					body(Ad).
					when().                                                                                      
					post("/products").then().extract().response();
			String responseData= res.asString(); 
			log.info("*********************************Added the Product success************************************"+res);

			GenericClass.fn_convert_string_to_jason(responseData);
			int id=GenericClass.jsonPathVariable.get("id");
			log.info("The Id of the Added product is*********************"+ id);
		}
		catch(Exception e)
		{
			throw e;	
		}
	}
	 */ 	
	@Test(priority=2, description="Add a new Product and verify it using json simple libraray")
	private void fn_verify_postRequest_using_json_simple_lib() throws Exception
	{
		try
		{
			GenericClass.fn_Read_data_from_json(FinalTestDat);
			RestAssured.baseURI=baseuri;
			RequestSpecification request = RestAssured.given().contentType("application/json");
			String request_body=Ad.fn_Create_Add_product();
			System.out.println(request_body);
			request.body(request_body);
			Response response = request.post("/products");
			int statusCode = response.getStatusCode();
			log.info("*************The status code recieved:**************" + statusCode);
			log.info("**********************Response body:******************* " + response.body().asString());
			GenericClass.fn_Read_data_from_json(FinalTestDat);			 
		}
		catch(Exception e)
		{
			throw e; 	
		}
	}
}
