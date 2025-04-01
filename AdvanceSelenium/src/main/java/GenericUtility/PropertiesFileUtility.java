package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {

	public String readingDataFromProperties(String Key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonFile.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(Key);
		return data;
	}
}
