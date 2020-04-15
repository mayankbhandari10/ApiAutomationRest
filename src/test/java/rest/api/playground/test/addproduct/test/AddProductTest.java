package rest.api.playground.test.addproduct.test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import rest.api.playground.genericclass.GenericClass;
import rest.api.playground.test.addproduct.AddProductPayload;
import rest.api.playground.testbase.TestBase;
import com.fasterxml.jackson.databind.ObjectMapper;
public class AddProductTest extends TestBase {

	public AddProductTest() throws Exception {
		super();

	}

	ObjectMapper Obj = new ObjectMapper(); 
	@Test(priority=1, description="Add a new Product and verify it")
	public void fn_verify_post_Request() throws Exception{
		AddProductPayload Ad=new AddProductPayload("string", "string", 50, 5, "string", "string", "string", "string", "string", "string");
		String json = Obj.writeValueAsString(Ad);
		System.out.println(json);

		String baseuri=prep.getProperty("uri");
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
}
