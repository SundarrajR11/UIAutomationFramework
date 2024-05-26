package com.ecom.utils;

import com.ecom.constants.FrameConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderLocal {
    private DataProviderLocal(){}

    private static List<Map<String, String>> credentialData =new ArrayList<>();
    @DataProvider
    public static Object[] getData(Method m){
        String testName = m.getName();
        if(credentialData.isEmpty()){
            credentialData =ExcelReader.getSheetData(FrameConstants.getCredentialSheet());
        }
        List<Map<String,String>>executableData=new ArrayList<>();

        for (Map<String, String> credentialData : DataProviderLocal.credentialData) {
            if (credentialData.get("testname").equalsIgnoreCase(testName) && credentialData.get("execute").equalsIgnoreCase("yes")) {
                executableData.add(credentialData);
            }
        }
        return executableData.toArray();
    }
}
