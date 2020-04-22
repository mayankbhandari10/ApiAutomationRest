package rest.api.playground.genericclass;
import java.io.File;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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

	@SuppressWarnings({ "unused", "unchecked" })
	public
	static void fn_Read_data_from_json(String filename) throws Exception
	{
		try
		{
			JSONParser jsonParser = new JSONParser();
			FileReader reader = new FileReader(filename);
			//Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONArray array = new JSONArray();
			array.add(obj);
			int size=array.size();
			System.out.println(size);
			System.out.println(obj); //This prints the entire json file
			for (int i=0;i<size;i++)
			{
				JSONObject code = (JSONObject) array.get(i);
				JSONObject Status = (JSONObject) code.get("Status");
				String Unauthorized = (String) Status.get("Unauthorized");
				String Forbidden = (String) Status.get("Forbidden");
				System.out.println(Status); //This prints each data in the block


			}

		}
		catch(Exception e)
		{
			throw e;
		}
	}


}
