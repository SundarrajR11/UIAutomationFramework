package com.ecom.utils;

import com.ecom.constants.FrameConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * DatProviderLocal class for providing test data to TestNG test methods.
 *
 * <p>This class includes a data provider method for TestNG, which supplies test data
 * based on the test method name. The data is read from an Excel sheet and filtered
 * to include only the executable test cases for the specified test method.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @Test(dataProvider = "getData", dataProviderClass = DataProviderLocal.class)
 * public void yourTestMethod(Map<String, String> testData) {
 *     // Test logic using testData...
 * }
 * }
 * </pre>
 */
public final class DataProviderLocal {

    /**
     * Private constructor to prevent instantiation.
     */
    private DataProviderLocal() {
    }

    /**
     * List to hold the credential data read from the Excel sheet.
     */
    private static List<Map<String, String>> credentialData = new ArrayList<>();

    /**
     * Data provider method to supply test data to TestNG test methods.
     *
     * <p>This method reads data from the Excel sheet specified by {@link FrameConstants#getCredentialSheet()},
     * filters the data based on the test method name and the 'execute' flag, and provides the filtered data
     * to the test method.</p>
     *
     * @param m the test method for which the data is being provided.
     * @return an array of objects, each representing a set of test data for the specified test method.
     */
    @DataProvider
    public static Object[] getData(Method m) {
        String testName = m.getName();
        if (credentialData.isEmpty()) {
            credentialData = ExcelReader.getSheetData(FrameConstants.getCredentialSheet());
        }
        List<Map<String, String>> executableData = new ArrayList<>();

        for (Map<String, String> credentialData : DataProviderLocal.credentialData) {
            if (credentialData.get("testname").equalsIgnoreCase(testName) && credentialData.get("execute").equalsIgnoreCase("yes")) {
                executableData.add(credentialData);
            }
        }
        return executableData.toArray();
    }
}