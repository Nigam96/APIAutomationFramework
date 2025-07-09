package com.api.util;
import java.util.Properties;

import java.io.FileInputStream;
public class ConfigLoaderUtility {
	private static final Properties properties=new Properties();
	
	static {
		try {
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
			properties.load(fis);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	      }
	public static String get(String key) {
		return properties.getProperty(key);
	}
	

}
