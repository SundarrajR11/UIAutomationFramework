/**
 *This package contains various utility classes that provide common
 *  functionalities such as reading configuration properties, reading Excel files,
 *  taking screenshots, and handling dynamic XPaths etc.
 */
package com.ecom.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.function.Consumer;

import com.ecom.enums.Econfig;
import com.ecom.constants.FrameConstants;
import com.ecom.exceptions.InValidPropertyKeyException;

/**
 * ConfigReader class for reading configuration properties.
 *
 * <p>This class provides methods to read key-value pairs from a configuration file. The properties
 * are loaded into a map at the time of class loading, and the values can be retrieved using the
 * {@link Econfig} enum keys.</p>
 *
 * <p>The class employs eager initialization to load the properties file when the class is first
 * loaded into the JVM.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * String url = ConfigReader.getValue(Econfig.URL);
 * }
 * </pre>
 */
public final class ConfigReader {

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ConfigReader() {
	}
	/**
	 * Properties object to hold the properties loaded from the configuration file.
	 */
	private static final Properties prop = new Properties();

	/**
	 * Map to store the configuration key-value pairs.
	 */
	private static final Map<String, String> CONFIG_MAP = new HashMap<>();

	/**
	 * Static block to load the configuration properties file.
	 *
	 * <p>This block is executed when the class is loaded into the JVM. It loads the properties
	 * from the file specified in {@link FrameConstants#getConfigFilePath()}, and stores them
	 * in the {@link #CONFIG_MAP}.</p>
	 */
	static {
		try (FileInputStream file = new FileInputStream(FrameConstants.getConfigFilePath())) {
			prop.load(file);
			/*for (Map.Entry<Object, Object> eMap : prop.entrySet()) {
				CONFIG_MAP.put(String.valueOf(eMap.getKey()), String.valueOf(eMap.getValue()).trim());
			}*/
			prop.forEach((key, value) -> CONFIG_MAP.put((String) key, (String) value));

		} catch (IOException e) {

			e.printStackTrace();
			System.exit(0);
		}
	}

	/**
	 * Retrieves the value associated with the specified key from the configuration.
	 *
	 * @param key the key whose associated value is to be returned.
	 * @return the value associated with the specified key.
	 * @throws InValidPropertyKeyException if the specified key is not found in the configuration.
	 */
	public static String getValue(Econfig key) {
		String k = key.toString();
		String value = CONFIG_MAP.get(k);
		if (Objects.isNull(value)) {
			throw new InValidPropertyKeyException("Property name " + key + " is not found. Please check the config.properties and/or verify whether all the associated keys are correctly added in Econfig enum");
		}
		return value;
	}
}