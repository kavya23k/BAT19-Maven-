package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	Properties properties;
	String path = "config.properties";
	
	public ReadConfig() throws Exception 
{
		properties = new Properties();
		FileInputStream fis = new FileInputStream(path);
		properties.load(fis);
   		
}
	// User defined method
	public String getBrowser() {
		String value = properties.getProperty("browser");
		
		if(value!=null) {
			return value;
		}
		else {
			throw new RuntimeException ("URL is not found in config file");
		}
	}
	
}
