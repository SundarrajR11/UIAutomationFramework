package com.ecom.listeners;



import com.ecom.utils.DataProviderLocal;
import org.testng.annotations.IFactoryAnnotation;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod, Class<?> occurringClazz) {
        annotation.setDataProvider("getData");
        annotation.setDataProviderClass(DataProviderLocal.class);
        annotation.setRetryAnalyzer(RetryFailedTests.class);
    }
}
