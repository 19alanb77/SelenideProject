package selenideConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigKeys {

public static String getConfigKey(String key) {
		
		Properties prop = new Properties();
		InputStream input = null;
		String result = "";
		
		try {
			
			input = new FileInputStream("config.properties");
			prop.load(input);
			result = prop.getProperty(key);	
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
}
