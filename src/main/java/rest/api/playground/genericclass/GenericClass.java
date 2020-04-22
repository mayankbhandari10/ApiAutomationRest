package rest.api.playground.genericclass;
import org.json.simple.JSONObject;

import io.restassured.path.json.JsonPath;



public class GenericClass {


	public static JsonPath jsonPathVariable;
	public static void fn_convert_string_to_jason(String response) throws Exception 
	{
		try
		{
			jsonPathVariable=new JsonPath(response);
			System.out.println(jsonPathVariable);
		}
		catch(Exception e)
		{
			throw e;
		}

	}


}
