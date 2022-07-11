package com.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesReader {
	
private Properties prop;
	
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream fo;
		try {
			fo = new FileInputStream("src\\test\\java\\com\\config\\prop\\config.properties");
			prop.load(fo);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return prop;
	}
}
