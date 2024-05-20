package com.ecom.utils;

import com.ecom.frameconstants.FrameConstants;
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
        String testname = m.getName();
        if(credentialData.isEmpty()){
            credentialData =ExcelReader.getSheetData(FrameConstants.getCredentialSheet());
        }
        List<Map<String,String>>executableData=new ArrayList<>();

        for (int i = 0; i < credentialData.size(); i++) {
            if(credentialData.get(i).get("testname").equalsIgnoreCase(testname) && credentialData.get(i).get("execute").equalsIgnoreCase("yes")){
                    executableData.add(credentialData.get(i));
                }
            }
        return executableData.toArray();
    }
}
