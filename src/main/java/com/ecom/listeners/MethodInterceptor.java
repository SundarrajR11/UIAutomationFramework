package com.ecom.listeners;

import com.ecom.constants.FrameConstants;
import com.ecom.utils.ExcelReader;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Custom method interceptor for TestNG to control test method execution.
 *
 * <p>This class implements the {@link IMethodInterceptor} interface to provide custom
 * filtering and configuration of test methods before they are executed. The configuration
 * is driven by data from an Excel sheet.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 * {@code
 * @Listeners(MethodInterceptor.class)
 * public class YourTestClass {
 *     // Test methods...
 * }
 * }
 * </pre>
 */
public class MethodInterceptor implements IMethodInterceptor {

    /**
     * Intercepts the test methods to modify their execution based on data from an Excel sheet.
     *
     * @param methods the list of test methods to be executed.
     * @param context the test context containing all the test-related information.
     * @return the modified list of test methods to be executed.
     */
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<Map<String, String>> list = ExcelReader.getSheetData(FrameConstants.getRunnerSheet());
        List<IMethodInstance> result = new ArrayList<>();

        for (IMethodInstance method : methods) {
            for (Map<String, String> stringStringMap : list) {
                if (method.getMethod().getMethodName().equalsIgnoreCase(stringStringMap.get("Test name"))
                        && stringStringMap.get("Execute").equalsIgnoreCase("yes")) {
                    method.getMethod().setDescription(stringStringMap.get("Test description"));
                    method.getMethod().setInvocationCount(Integer.parseInt(stringStringMap.get("Count")));
                    method.getMethod().setPriority(Integer.parseInt(stringStringMap.get("Priority")));
                    result.add(method);
                }
            }
        }
        return result;
    }
}