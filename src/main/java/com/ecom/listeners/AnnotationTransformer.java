package com.ecom.listeners;

import com.ecom.constants.FrameConstants;
import com.ecom.utils.DataProviderLocal;
import com.ecom.utils.ExcelReader;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * Annotation transformer for TestNG annotations.
 *
 * <p>This class implements the {@link IAnnotationTransformer} interface to provide
 * custom transformation of TestNG annotations. It is used to modify annotations
 * dynamically before they are applied to test methods.</p>
 */
public class AnnotationTransformer implements IAnnotationTransformer {

    /**
     * Modifies the TestNG annotation dynamically before it is applied.
     *
     * @param annotation the TestNG annotation to be modified.
     * @param testClass the test class where the annotation is applied.
     * @param testConstructor the test constructor.
     * @param testMethod the test method where the annotation is applied.
     * @param occurringClazz the class where the annotation occurs.
     */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderLocal.class);
        annotation.setRetryAnalyzer(RetryFailedTests.class);
        List<Map<String,String>> m=ExcelReader.getSheetData(FrameConstants.getRunnerSheet());
        for (int i = 0; i < m.size(); i++) {
            annotation.setDescription(ExcelReader.getSheetData(FrameConstants.getRunnerSheet()).get(i).get("Test description"));
        }
    }
}
