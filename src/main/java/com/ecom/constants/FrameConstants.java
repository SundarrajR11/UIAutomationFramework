package com.ecom.constants;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;

public final class FrameConstants {
	
	private FrameConstants() {
		
	}
	private static final String USER_DIR=System.getProperty("user.dir");
	private static final String CONFIG_PATH= USER_DIR+ "/src/test/resources/config/config.properties";
	private static final int EXPLICIT_WAIT=20;
	private static final String SPARK_CONFIG_XML_PATH = USER_DIR+"/src/test/resources/reports_resource/spark-config.xml";
	private static final String SPARK_CONFIG_JSON_PATH=USER_DIR+"/src/test/resources/reports_resource/spark-config.json";
	private static final String EXTENT_FOLDER_PATH= USER_DIR+"/extent-test-output/";
	private static String excelFilePath ="";
	private static final String EXCEL_PATH=USER_DIR+"/src/test/resources/excel/testdata.xlsx";
	private static final String RUNNER_SHEET="Runner";
	private static final String CREDENTIAL_SHEET="CredentialData";


	public static String getConfigFilePath() {
		return CONFIG_PATH;
	}
	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}
	public static String getSparkConfigXMLPath(){
		return SPARK_CONFIG_XML_PATH;
	}
	public static String getSparkConfigJsonPath(){
		return SPARK_CONFIG_JSON_PATH;
	}

	public static String getTargetPath(){
		if (excelFilePath.isEmpty()){
			excelFilePath =createTargetPath();
		}
		return excelFilePath;
	}

	private static String createTargetPath(){
		if(ConfigReader.getValue(Econfig.OVERRIDE_REPORTS).equalsIgnoreCase("NO")){
			return EXTENT_FOLDER_PATH+System.currentTimeMillis()+"index.html";
		}else {
			return EXTENT_FOLDER_PATH+"index.html";
		}
	}

	public static String getExcelPath(){
		return EXCEL_PATH;
	}

	public static String getRunnerSheet(){
		return RUNNER_SHEET;
	}
	public static String getCredentialSheet(){
		return CREDENTIAL_SHEET;
	}

}
