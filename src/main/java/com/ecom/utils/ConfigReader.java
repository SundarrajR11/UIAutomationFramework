package com.ecom.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import com.ecom.enums.Econfig;
import com.ecom.frameconstants.FrameConstants;

public final class ConfigReader {

	private ConfigReader(){
		
	}
	private static final Properties prop=new Properties();
	private static final Map<String,String>CONFIG_MAP=new HashMap<>();
	
	// Eager Initialization using static whenever requires initial first never changed again.
	
	static {
		
		FileInputStream file;
		try {
			file = new FileInputStream(FrameConstants.getConfigFilePath());
			prop.load(file);
			for(Map.Entry<Object, Object> eMap: prop.entrySet()) {
				CONFIG_MAP.put(String.valueOf(eMap.getKey()),String.valueOf(eMap.getValue()));
			}
			//prop.entrySet().forEach((entry)->CONFIG_MAP.put(String.valueOf(entry.getKey()),String.valueOf(entry.getValue())));{Java 8 }
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static String getValue(Econfig k) throws RuntimeException  {
		String key=k.toString();
		String value=CONFIG_MAP.get(key);
		if(Objects.isNull(value)) {
			throw new RuntimeException("Propery name "+key+" is not found. Please check the config.properties");
		}
		return value;
}

}
