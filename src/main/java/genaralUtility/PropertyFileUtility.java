package genaralUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {
	FileInputStream fis;
	Properties p;
	public String readDataFromProperyFile(String key) throws IOException
	{
		fis=new FileInputStream(".\\src\\test\\resources\\vtigercommondata.properties");
		Properties p=new Properties();
		p.load(fis);
		String keyvalue = p.getProperty(key);
		return keyvalue;

		
	}

}
