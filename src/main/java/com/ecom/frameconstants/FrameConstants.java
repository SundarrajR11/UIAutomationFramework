package com.ecom.frameconstants;

public final class FrameConstants {
	
	private FrameConstants() {
		
	}
	
	private static final String CONFIG_PATH=System.getProperty("user.dir")+ "/src/test/resources/config/config.properties";
	private static final int EXPLICITWAIT=10;

	public static String getConfigFilePath() {
		return CONFIG_PATH;
	}
	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}
	
}
