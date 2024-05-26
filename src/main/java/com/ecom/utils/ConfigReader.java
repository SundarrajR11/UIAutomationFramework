package com.ecom.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.ecom.enums.Econfig;
import com.ecom.constants.FrameConstants;
import com.ecom.exceptions.InValidPropertyKeyException;

public final class ConfigReader {

	private ConfigReader(){
		
	}
	private static final Properties prop=new Properties();
	private static final Map<String,String>CONFIG_MAP=new HashMap<>();
	
	// Eager Initialization using static whenever requires initial first never changed again.
	
	static {
		// Use Try with resources when variable class implements AutoCloseable interface
		// Hence need to close using finally block
		try(FileInputStream file = new FileInputStream(FrameConstants.getConfigFilePath());) {
			prop.load(file);
			for(Map.Entry<Object, Object> eMap: prop.entrySet()) {
				CONFIG_MAP.put(String.valueOf(eMap.getKey()),String.valueOf(eMap.getValue()).trim());// To remove trailing spaces and leading spaces using trim()
			}
			//prop.entrySet().forEach((entry)->CONFIG_MAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));{Java 8 }
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}

	public static String getValue(Econfig key){
		String k =key.toString();
		String value=CONFIG_MAP.get(k);
		if(Objects.isNull(value)) {
			throw new InValidPropertyKeyException("Property name "+key+" is not found. Please check the config.properties and/or Verify whether all the associated keys are correctly added in Econfig enum");
		}
		return value;
}

}
