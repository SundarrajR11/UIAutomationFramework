package com.ecom.listeners;

import com.ecom.frameconstants.FrameConstants;
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

        for (int i = 0; i < methods.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("Test name"))){
                    if(list.get(j).get("Execute").equalsIgnoreCase("yes")){
                        methods.get(i).getMethod().setDescription(list.get(j).get("Test description"));
                        methods.get(i).getMethod().setInvocationCount( Integer.parseInt(list.get(j).get("Count")));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
                        result.add(methods.get(i));
                    }
                }
            }
        }
        return result;
    }
}
