package rest.api.playground.testbase;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.*;

import rest.api.playground.genericclass.GenericClass;

public class TestBase {
	
	public static Properties prep;
	String path1 = System.getProperty("user.dir");
	private final String ProperfilePath= path1+"\\src\\main\\java\\rest\\api\\playground\\config\\config.properties";

	public 	Logger log = Logger.getLogger("devpinoyLogger");

	public TestBase() throws Exception 
	{
		try
		{
			//getClass().getResource("config.properties"); // you get an URL, then openStream it
			System.out.println(ProperfilePath);
			prep= new Properties();
			FileInputStream ip = new FileInputStream(ProperfilePath);
			prep.load(ip);

		}

		catch(Exception e)
		{
			throw e;	
		}

	}
	
}
