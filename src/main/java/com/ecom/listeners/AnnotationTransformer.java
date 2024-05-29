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

public class AnnotationTransformer implements IAnnotationTransformer {
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
