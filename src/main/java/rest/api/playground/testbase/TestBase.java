package rest.api.playground.testbase;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {
	public static Properties prep;
	String path = System.getProperty("user.dir");
	private final String ProperfilePath= path+"\\src\\main\\java\\com\\automation\\prac\\qa\\config\\config.properties";
	
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
