package selenideConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Class that allows to set values of variables directly from config.properties file.
 * 
 * @author Alan Buda
 */
public class ConfigKeys {

	/**
	 * Find value of given property name.
	 * 
	 * @param key
	 *          name of the property searched in the file 
	 *          
	 * @return value of the property searched in the file
	 */  
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
