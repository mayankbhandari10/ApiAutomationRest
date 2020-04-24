package rest.api.playground.test.addproduct.test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
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
	String created;
	String ok;
	AddProductPayload Ad=new AddProductPayload();
	//AddProductPayload Ad=new AddProductPayload("string", "string", 50, 5, "string", "string", "string", "string", "string", "string");
	String baseuri=prep.getProperty("uri");


	public AddProductTest() throws Exception {
		super();

	}

	@BeforeTest
	private void fn_load_Status_codes() throws Exception
	{
		JSONArray arri=GenericClass.fn_Read_TestDataStatusCode(FinalTestDat);
		int size=arri.size();
		for (int i=0;i<size;i++)
		{
			JSONObject code = (JSONObject) arri.get(i);
			JSONObject Status = (JSONObject) code.get("Status");
			ok = (String) Status.get("OK");
			created = (String) Status.get("Created");
			System.out.println(Status); //This prints each data in the block
		}	
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

			RestAssured.baseURI=baseuri;
			RequestSpecification request = RestAssured.given().contentType("application/json");
			String request_body=Ad.fn_Create_Add_product();
			log.info("Request body for add new project is *****************"+request_body );
			request.body(request_body);
			Response response = request.post("/products");
			int statusCode = response.getStatusCode();
			log.info("*************The status code recieved:**************" + statusCode);
			log.info("**********************Response body:******************* " + response.body().asString());
			String responsestring= response.body().asString();
			System.out.println(responsestring);
			JsonPath js=new JsonPath(responsestring);
			log.debug("*********************Extracting the Product is*******************");
			int product_id=js.get("id");
			//Assert.assertEquals(statusCode, created);
			
			
			System.out.println(product_id);



		}
		catch(Exception e)
		{
			throw e; 	
		}
	}
}
