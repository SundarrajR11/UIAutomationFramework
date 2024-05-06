package com.ecom.utils;

import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import com.ecom.enums.Econfig;

public final class ConfigReader {

	private ConfigReader(){
		
	}

	public static String getValue(Econfig key) throws Exception  {
		String keys=key.toString();
		Properties prop=new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/config/config.properties");
		prop.load(file);	
		String value=prop.getProperty(keys);
		if(Objects.isNull(value)) {
			throw new Exception("Propery name "+key+" is not found. Please check the config.properties");
		}
		return value;
}

}
