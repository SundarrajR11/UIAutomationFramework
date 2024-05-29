package com.ecom.listeners;

import com.ecom.constants.FrameConstants;
import com.ecom.utils.ExcelReader;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptor implements IMethodInterceptor {


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {

        List<Map<String,String>>list=ExcelReader.getSheetData(FrameConstants.getRunnerSheet());
        List<IMethodInstance> result =new ArrayList<>();

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
