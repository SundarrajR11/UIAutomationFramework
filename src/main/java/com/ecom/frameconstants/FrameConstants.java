package com.ecom.frameconstants;

public final class FrameConstants {
	
	private FrameConstants() {
		
	}
	
	private static final String CONFIG_PATH=System.getProperty("user.dir")+ "/src/test/resources/config/config.properties";


	public static String getConfigFilePath() {
		return CONFIG_PATH;
	}
	
}
