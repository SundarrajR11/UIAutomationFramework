package com.ecom.constants;

import com.ecom.enums.Econfig;
import com.ecom.utils.ConfigReader;

/**
 * Provides constant values and utility methods for the framework configuration.
 *
 * <p>This class holds various constants such as file paths, sheet names, and
 * configuration settings used throughout the framework. It also provides
 * methods to retrieve these constants.</p>
 *
 * <p>This class is designed to be non-instantiable and all its members are
 * static.</p>
 */
public final class FrameConstants {

	// Prevents instantiation
	private FrameConstants() {

	}

	/**
	 * The user's current working directory.
	 */
	private static final String USER_DIR = System.getProperty("user.dir");

	/**
	 * Path to the configuration properties file.
	 */
	private static final String CONFIG_PATH = USER_DIR + "/src/test/resources/config/config.properties";

	/**
	 * The default explicit wait time in seconds.
	 */
	private static final int EXPLICIT_WAIT = 20;

	/**
	 * Path to the Spark configuration XML file.
	 */
	private static final String SPARK_CONFIG_XML_PATH = USER_DIR + "/src/main/resources/reports_config/spark-config.xml";

	/**
	 * Path to the Spark configuration JSON file.
	 */
	private static final String SPARK_CONFIG_JSON_PATH = USER_DIR + "/src/main/resources/reports_config/spark-config.json";

	/**
	 * Path to the folder where Extent reports will be stored.
	 */
	private static final String EXTENT_FOLDER_PATH = USER_DIR + "/extent-test-output/";

	/**
	 * Path to the Excel file used for test data.
	 */
	private static final String EXCEL_PATH = USER_DIR + "/src/test/resources/excel/testdata.xlsx";

	/**
	 * Name of the sheet containing runner data in the Excel file.
	 */
	private static final String RUNNER_SHEET = "Runner";

	/**
	 * Name of the sheet containing credential data in the Excel file.
	 */
	private static final String CREDENTIAL_SHEET = "CredentialData";

	/**
	 * Path to the Excel file. Initialized dynamically if not already set.
	 */
	private static String excelFilePath = "";

	/**
	 * URL of the remote host.
	 */
	private static final String RUN_MODE_URL = "http://localhost:4444/wd/hub";


	/**
	 * Retrieves the path to the configuration properties file.
	 *
	 * @return the configuration file path as a string.
	 */
	public static String getConfigFilePath() {
		return CONFIG_PATH;
	}

	/**
	 * Retrieves the default explicit wait time.
	 *
	 * @return the explicit wait time in seconds.
	 */
	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	/**
	 * Retrieves the path to the Spark configuration XML file.
	 *
	 * @return the Spark configuration XML file path as a string.
	 */
	public static String getSparkConfigXMLPath() {
		return SPARK_CONFIG_XML_PATH;
	}

	/**
	 * Retrieves the path to the Spark configuration JSON file.
	 *
	 * @return the Spark configuration JSON file path as a string.
	 */
	public static String getSparkConfigJsonPath() {
		return SPARK_CONFIG_JSON_PATH;
	}

	/**
	 * Retrieves the path to the folder where Extent reports will be stored.
	 *
	 * <p>If the path is not already set, it will be created based on the
	 * {@link Econfig#OVERRIDE_REPORTS} setting.</p>
	 *
	 * @return the Extent report folder path as a string.
	 */
	public static String getTargetPath() {
		if (excelFilePath.isEmpty()) {
			excelFilePath = createTargetPath();
		}
		return excelFilePath;
	}

	/**
	 * Creates the target path for the Extent report based on the
	 * {@link Econfig#OVERRIDE_REPORTS} setting.
	 *
	 * @return the created target path as a string.
	 */
	private static String createTargetPath() {
		if (ConfigReader.getValue(Econfig.OVERRIDE_REPORTS).equalsIgnoreCase("NO")) {
			return EXTENT_FOLDER_PATH + System.currentTimeMillis() + "index.html";
		} else {
			return EXTENT_FOLDER_PATH + "index.html";
		}
	}

	/**
	 * Retrieves the path to the Excel file used for test data.
	 *
	 * @return the Excel file path as a string.
	 */
	public static String getExcelPath() {
		return EXCEL_PATH;
	}

	/**
	 * Retrieves the name of the sheet containing runner data in the Excel file.
	 *
	 * @return the runner sheet name as a string.
	 */
	public static String getRunnerSheet() {
		return RUNNER_SHEET;
	}

	/**
	 * Retrieves the name of the sheet containing credential data in the Excel file.
	 *
	 * @return the credential sheet name as a string.
	 */
	public static String getCredentialSheet() {
		return CREDENTIAL_SHEET;
	}

	/**
	 * Retrieves the URL of th the remote host.
	 *
	 * @return the URL of the remote host as a string.
	 */
	public static String getRunModeUrl() {
		return RUN_MODE_URL;
	}
}