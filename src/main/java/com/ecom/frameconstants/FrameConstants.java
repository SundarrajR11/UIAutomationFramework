package com.ecom.frameconstants;

public final class FrameConstants {
	
	private FrameConstants() {
		
	}
	
	private static final String CONFIG_PATH=System.getProperty("user.dir")+ "/src/test/resources/config/config.properties";
	private static final int EXPLICIT_WAIT=10;
	private static final String SPARK_CONFIG_XML_PATH =System.getProperty("user.dir")+"/src/main/java/com/ecom/reports/xmlConfigFile.xml";

	public static String getSparkConfigXMLPath(){
		return SPARK_CONFIG_XML_PATH;
	}

	public static String getConfigFilePath() {
		return CONFIG_PATH;
	}
	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}
	
}
